package kr.yjh.database.models;

import lombok.Data;

/** 수강신청 테이블 구조 */
@Data
public class Enrollment {
    private int studentId;
    private int subjectId;
    private String enrolldate;
    private int score;

}
