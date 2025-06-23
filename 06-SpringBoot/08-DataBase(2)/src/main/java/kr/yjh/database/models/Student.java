package kr.yjh.database.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/** 학생 테이블 */
@Data
public class Student {
    private int id;
    private String name;
    private String userId;
    private int grade;
    private String idnum;
    private String birthdate;
    private String phone;
    private int height;
    private int weight;
    private String email;
    private String gender;
    private String status;
    private String photoUrl;
    private String admissionDate;
    private String graduationDate;
    private int departmentId;
    
    private String dname;
    private String pname;

    private int professorId; 
    private String professorName;  //셀렉트 리스트 에서 
    private String[] statusArray;  // 재학, 졸업, 휴학 체크박스 

    private String[] positionArray; // 학년 체크박스
  
    private String departmentName;

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
