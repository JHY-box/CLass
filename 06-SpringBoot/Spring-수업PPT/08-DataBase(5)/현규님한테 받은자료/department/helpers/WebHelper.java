package kr.hyungyu.department.helpers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebHelper {
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private HttpServletResponse response;

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
     * 쿠키를 저장한다.
     *
     * @param response - HttpServletResponse 객체
     * @param name - 쿠키 명
     * @param value - 쿠키 값
     * @param maxAge - 쿠키 유지 시간 (0이면 저장 안함, 음수일 경우 즉시 삭제)
     * @param domain - 공유 도메인
     * @param path - 경로
     * @throws UnsupportedEncodingException 
     */
    public void writeCookie(String name, String value, int maxAge, String domain, String path) throws Exception {
        if (value != null && !value.equals("")) {
            try {
                value = URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                // 오류 처리
                log.error("쿠키값 인코딩 실패", e);
                throw e;
            }
        }
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);

        if (domain != null) {
            cookie.setDomain(domain);
        }
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }

        response.addCookie(cookie);
    }

    /**
     * 쿠키를 저장한다. path값은 "/"를 강제 설정한다.
     */
    public void writeCookie(String name, String value, int maxAge, String domain) throws Exception {
        this.writeCookie(name, value, maxAge, domain, "/");
    }

    /**
     * 쿠키를 저장한다. path값은 "/"를, domain값은 null로 강제 설정한다.
     */
    public void writeCookie(String name, String value, int maxAge) throws Exception {
        this.writeCookie(name, value, maxAge, null, "/");
    }

    /**
     * 쿠키를 저장한다. path값은 "/"를, domain값은 null, maxAge값은 0을 강제 설정한다.
     */
    public void writeCookie(String name, String value) throws Exception {
        this.writeCookie(name, value, 0, null, "/");
    }

    /**
     * 쿠키를 삭제한다.
     */
    public void deleteCookie(HttpServletResponse response, String name) throws Exception {
        this.writeCookie(name, null, -1, null, "/");
    }

        /**
     * HTTP 상태 코드와 성공/실패 메시지를 출력한 후, 지정된 페이지로 이동한다.
     * 이때 이동하기 위한 경우에만 이 함수를 사용한다.
     * @param response - HttpServletResponse 객체
     * @param statusCode - HTTP 상태코드 값 (ex: 404)
     * @param message - 출력 메시지
     * @param url - 이동할 URL. 값이 null이면 이전 페이지로 이동
     */
    public void sendRedirect(int statusCode, String url, String message) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            log.error("브라우저 출력 스트림 생성에 실패", e);
            return;
        }

        response.setStatus(statusCode);
        response.setContentType("text/html; charset=UTF-8");

        if (message != null && !message.equals("")) { // 메세지가 있을 때
            out.print("<script>");
            out.print("alert('" + message + "');");
            out.print("</script>");
        }

        if (url != null && !url.equals("")) { // url이 있을 때 url로 현재 위치를 바꿈
            out.print("<script>");
            out.print("location.replace('" + url + "');");
            out.print("</script>");
        } else {
            out.print("<script>"); // url이 없으면 뒤로가기 버튼
            out.print("history.back();");
            out.print("</script>");
        }
        out.flush();
    }

    /**
     * HTTP 상태 코드 200으로 성공과 메시지를 출력 후, 지정된 페이지로 이동한다.
     * @param response - HttpServletResponse 객체
     * @param message - 출력 메시지
     */
    public void sendRedirect(String url, String message) {
        this.sendRedirect(200, url, message);
    }

    /**
     * HTTP 상태 코드 200으로 성공과 메시지 출력 없이 지정된 페이지로 이동한다.
     * @param response - HttpServletResponse 객체
     */
    public void sendRedirect(String url) {
        this.sendRedirect(200, url, null);
    }

    /**
     * HTTP 상태 코드와 메시지를 신속하게 출력 후 이전 페이지로 이동한다.
     * @param statusCode - HTTP 상태코드 값 (ex: 404)
     * @param message - 출력 메시지
     */
    public void sendRedirect(int statusCode, String message) {
        this.sendRedirect(statusCode, null, message);
    }

    /*
    * 예외사항 발생시 공용의 메시지와 이전 페이지 이동 기능
    * @param e - 예외 객체
    */
    public void sendRedirect(Exception e) {
        this.sendRedirect(500, null, e.getMessage());
    }

    /*
    * 자바에서 SQL 오류가 발생한 경우 이전 페이지 이동 기능
    * @param message - 출력 메시지
    */
    public void sendRedirectSqlError(Exception e) {
        this.sendRedirect(500, null, e.getMessage());
    }

    public void sendServerError(Exception e) {
        this.sendRedirect(500, null, e.getMessage().replace("\r\n", "\\n").split(System.lineSeparator())[0]);
    }

    /**
     * Java 혹은 SQL쪽에서 잘못된 경우에 호출할 이전 페이지 이동 기능
     * @param response - HttpServletResponse 객체
     * @param e        - 에러정보를 담고 있는 객체
     *                   Exception으로 선언했으므로 어떤 하위 객체가 전달되더라도 형변환되어 받는다.
     */
    public void serverError(Exception e) {
        String message = e.getMessage().trim().replace("'", "\\'").split(System.lineSeparator())[0];
        this.sendRedirect(500, null, message);
    }


    /**
     * Java 혹은 SQL쪽에서 잘못된 경우에 호출할 이전 페이지 이동 기능
     * @param response - HttpServletResponse 객체
     * @param message  - 개발자가 직접 전달하는 에러 메시지지
     */
    public void serverError(String message) {
        this.sendRedirect(500, null, message);
    }

}

