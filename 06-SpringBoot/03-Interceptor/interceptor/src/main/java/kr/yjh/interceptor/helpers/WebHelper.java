package kr.yjh.interceptor.helpers;

import jakarta.servlet.http.HttpServletRequest;

/*
 * 유틸리티 기능을 제공하는 클래스
 * 이전 수업에서 작성한 WebHelper 클래스 가져와서 사용
 */
public class WebHelper {
    /** 싱글톤 객체 */
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

    /** 
     * ip 를 리턴하는 메서드
     * 
     *  
     * 클라이언트의 IP 주소를 가져오는 메서드
     * 
     * @param request HttpservletRequest 객체
     * @return IP 주소
     */

     public String getClientIp (HttpServletRequest request) {

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
}
