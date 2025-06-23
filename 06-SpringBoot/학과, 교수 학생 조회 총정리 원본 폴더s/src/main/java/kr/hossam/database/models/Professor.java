package kr.hossam.database.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/** 교수 테이블 */
@Data
public class Professor {
    private int id;
    private String name;
    private String userId;
    private String position;
    private int sal;
    private String hiredate;
    private int comm;
    private String email;
    private String phone;
    private String photoUrl;
    private String status;
    private int departmentId;
    private String dname; // 학과명 <-- 조인 결과로 조회된 컬럼

    /* 한 페이지에 표시될 목록 수 */
    @Getter
    @Setter
    private static int listCount = 0;

    /* MySQL의 Limit절에 사용될 offset값. */
    @Getter
    @Setter
    private static int offset = 0;
}