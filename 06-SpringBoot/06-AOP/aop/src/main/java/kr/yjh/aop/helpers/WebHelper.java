package kr.yjh.aop.helpers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WebHelper {
    
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;
    
    /**
     * 싱글톤 객체
    private static WebHelper current;

    public static WebHelper getInstance() {
        if (current == null) {
            current = new WebHelper();
        }

        return current;
    }

    public static void freeInstance() {
        current = null;
    }

    private WebHelper() {
        super();
    }
    
    */

    /**
     * 클라이언트의 IP 주소를 가져오는 메서드
     *
     * @param request HttpservletRequest 객체
     * @return IP 주소
     */

    public String getClientIp() {

        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null) {
            ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
        }

        if (ip == null) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    /**
     * 쿠키값을 저장한다.
     *
     * @param response -HttpServletResponse 객체
     * @param name     - 쿠키 이름
     * @param value    - 쿠키 값
     * @param maxAge   -쿠키 유효 시간 (0이면 지정 안함, 음수일 경우 즉시 삭제)
     * @param domain   - 쿠키 도메인
     * @param path     -쿠키 경로
     */
    public void writeCookie(String name, String value, int maxAge, String domain, String path) throws Exception {
        if (value != null && !value.equals("")) {
            try {
                // --> import. java.net.URLEncoder;
                value = URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                log.error("쿠키값 인코딩 실패", e);
                throw e;
            }
        }

        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);

        if (domain != null) {
            cookie.setDomain(domain);
        }

        if (maxAge != 0) {
            cookie.setMaxAge(maxAge);
        }

        response.addCookie(cookie);
    }

    /**
     * 쿠키값을 저장한다. path값을 "/"로 강제 설정한다.
     *
     * @param response -HttpServletResponse 객체
     * @param name     - 쿠키 이름
     * @param value    - 쿠키 값
     * @param maxAge   -쿠키 유효 시간 (0이면 지정 안함, 음수일 경우 즉시 삭제)
     * @param domain   - 쿠키 도메인
     * 
     * @see #whiteCookie(String, String, int, String, String)
     */

    public void whiteCookie(String name, String value, int maxAge, String domain) throws Exception {
        this.writeCookie(name, value, maxAge, domain, "/");
    }

    /**
     * 쿠키값을 저장한다. path값을 "/"로, domain을 null로 강제 설정한다.
     *
     * @param name     - 쿠키 이름
     * @param value    - 쿠키 값
     * @param maxAge   -쿠키 유효 시간 (0이면 지정 안함, 음수일 경우 즉시 삭제)
     * @see #whiteCookie(String, String, int, String, String)
     */

    public void whiteCookie(String name, String value, int maxAge) throws Exception {
        this.writeCookie(name, value, maxAge, null, "/");
    }

    /**
     * 쿠키값을 저장한다. path값을 "/"로,  domain을 null로, maxAge를 0으로 강제 설정한다.
     *
     * @param name     - 쿠키 이름
     * @param value    - 쿠키 값
     * @param maxAge   -쿠키 유효 시간 (0이면 지정 안함, 음수일 경우 즉시 삭제)
     * @see #whiteCookie(String, String, int, String, String)
     */

    public void whiteCookie(String name, String value) throws Exception {
        this.writeCookie(name, value, 0, null, "/");
    }

//

    /**
     * 쿠키값을 삭제한다.
     * 
     * @param name  - 쿠키이름
     */

     public void deleteCookie(String name) throws Exception {
        this.writeCookie(name, null, -1, null, "/");
     }

}





