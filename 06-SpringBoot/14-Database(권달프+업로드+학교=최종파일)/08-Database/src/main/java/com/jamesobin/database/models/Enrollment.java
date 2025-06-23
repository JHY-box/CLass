package com.jamesobin.database.models;

import lombok.Data;

@Data
public class Enrollment {
    private int studentId;
    private int subjectId;
    private String enrollDate;
    private int score;
}
