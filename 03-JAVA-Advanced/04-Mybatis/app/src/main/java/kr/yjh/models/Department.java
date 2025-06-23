package kr.yjh.models;

import lombok.Data;
//▲▲▲▲ @Data ▲▲▲▲
// Lombokdml @Data 애너테이션을 사용하여 getter, setter, toString 메서드를 자동 생성
/** 학과 정보를 저장하는 클래스  */
@Data
public class Department {
   

    /** ▼학과번호▼ */
    private int id;

    /** ▼학과명▼ */
    private String dname;

    /** ▼위치▼ */
    private String loc;
    
    /** ▼전화번호▼ */
    private String phone;

    /** ▼이메일 주소▼ */
    private String email;

    /** ▼설립 연도▼ */
    private int established;

    /** ▼홈페이지 주소▼ */
    private String homepage;


}
