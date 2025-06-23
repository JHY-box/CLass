package com.jamesobin.database.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Professor {
    private int id;
    private String name;
    private String userId;
    private String position;
    private int sal;
    private String hiredate;
    private Integer comm;
    private String email;
    private String phone;
    private String photoUrl;
    private String status;
    private int departmentId;
    private String dname;       // 학과명 <-- 조인 결과로 조회된 컬럼
    private String[] positionArray; // position을 배열로 처리하기 위한 필드

    /**
     * 한 페이지에 표시될 목록 수
     * MySQL의 Limit절에서 사용할 값이므로 Beans에 추가한다.
     * 
     * 1) static 변수로 선언하여 모든 객체가 공유한다.
     * 2) static 변수는 객체를 생성하지 않고도 사용할 수 있다.
     * 3) static 변수에 Lombok을 적용하려면 @Getter, @Setter를 개별적으로 적용한다.
     */
    @Getter
    @Setter
    private static int listCount = 0;

    /**
     * MySQL의 Limit절에 사용될 offset 값.
     * MySQL의 Limit절에서 사용할 값이므로 Beans에 추가한다.
     * 
     * offset위치부터 listCount만큼의 데이터를 가져온다.
     */
    @Getter
    @Setter
    private static int offset = 0;
}
