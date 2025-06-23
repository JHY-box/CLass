package kr.yjh.database.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
 //▲▲▲▲ @Data ▲▲▲▲
@Data // Lombokdml @Data 애너테이션을 사용하여 getter, setter, toString 메서드를 자동 생성

/** 학과 정보를 저장하는 클래스  */
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


    /** 
     * 한페이지에 표시될 목록 수
     * MySQL의 Limit절에서 사용할 값이므로 Beans에 추가한다.
     * 
     * 1) static 변수로 선언하여 모든 객체가 공유한다.
     * 2) static 변수는 객체를 생성하지 않고도 사용할 수 있다. 
     * 3) static 변수에 Lombok을 적용하려면
     *   @Getter, @setter를 개별적으로 적용한다.
     */

     @Getter
     @Setter
     private static int listCount = 0;

     
     /**
      * MySQL의 Limit절에 사용될 offset값.
      * MySQL의 Limit절에서 사용할 값이므로 Beans에 추가한다.
      * 
      * offset위치부터 listCount만큼의 데이터를 가져온다.
      */
      @Getter
      @Setter
      private static int offset = 0;
}
