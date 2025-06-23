package kr.hyungyu.department.models;

import lombok.Data;

@Data
public class Enrollment {

    private int student_id;
    private int subjectId;
    private String enrollDate;
    private int score;
}