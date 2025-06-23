package kr.hossam.models;

import lombok.Data;

/** 수강신청 테이블 구조 */
@Data
public class Enrollment {
    private int studentId;
    private int subjectId;
    private String enrollDate;
    private int score;
}
