package kr.yjh.database.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/** 교수 테이블 */
@Data
public class Professor {
    private int id;
    private String name;
    private String userId;
    private String position;   // <- insert, update 에서 쓰는 naming
    private int sal;
    private String hiredate;
    private int comm;
    private String email;
    private String phone;
    private String photoUrl;
    private String status;
    private int departmentId;

    private String dname;     // 학과명 <---- 조인 결과로 조회된 컬럼

    private String[] statusArray;

    private String[] positionArray;


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
