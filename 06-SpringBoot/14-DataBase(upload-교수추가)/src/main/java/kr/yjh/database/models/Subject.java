package kr.yjh.database.models;

import lombok.Data;

/** 과목 테이블 */
@Data
public class Subject {
    private int id;
    private String name;
    private int credit;
    private int departmentId;
    private int professorId;

}
