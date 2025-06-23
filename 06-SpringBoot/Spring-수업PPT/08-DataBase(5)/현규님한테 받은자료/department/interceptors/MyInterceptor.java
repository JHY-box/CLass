package kr.hyungyu.department.interceptors;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.hyungyu.department.helpers.WebHelper;
import lombok.extern.slf4j.Slf4j;
import ua_parser.Client;
import ua_parser.Parser;

@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    // 시간이 찍힐 때마다 저장해둘 전역변수
    long startTime = 0;
    long endTime = 0;

    @Autowired
    private WebHelper webHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        log.info("---------- new client connect ------------");

        startTime = System.currentTimeMillis(); // 현재 시간을 기록 

        // 접속한 클라이언트 정보 확인
        String ua = request.getHeader("user-agent");
        Parser uaParser = new Parser();
        Client c = uaParser.parse(ua);

        String fmt = "[Client] %s, %s, %s %s, %s %s";

        String ipAddr = webHelper.getClientIp();
        String osVersion = c.os.major + (c.os.minor != null ? "." + c.os.minor : "");
        String uaVersion = c.userAgent.major + (c.userAgent.minor != null ? "." + c.userAgent.minor : "");
        String clientInfo = String.format(fmt, ipAddr, c.device.family, c.os.family, osVersion, c.userAgent.family, uaVersion);

        log.info(clientInfo);
        
        // 클라이언트가 전달한 모든 파라미터 확인하기
        Map<String, String[]> params = request.getParameterMap(); // HTTP 요청에서 전달된 파라미터들을 한 번에 다 가져올 수 있는 방법

        for (String key : params.keySet()){
            String [] value = params.get(key);
            log.info(String.format("(param) <- %s = %s", key, String.join(" ,", value))); // 배열 내부를 ,로 이은 문자열로 출력
        }

        // 클라이언트가 머물렀던 이전 페이지 확인하기
        String referer = request.getHeader("referer"); // 지금 요청이 오기 직전에 사용자가 머물렀던 웹페이지의 주소를 의미한다.

        if (referer != null && endTime > 0){ // 이전에 방문했던 페이지가 존재하고 이전에 컨트롤러가 실행했다가 종료한 적이 있다면
            log.info(String.format("- REFERER : time=%d, url=%s", startTime - endTime, referer)); 
        }

        return HandlerInterceptor.super.preHandle(request, response, handler); // return이 boolean인데 만약 false이면 controller도 실행시키지 않고 요청을 중단한다.
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        endTime = System.currentTimeMillis();
        log.info(String.format("running time: %d(ms)", endTime - startTime));
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
