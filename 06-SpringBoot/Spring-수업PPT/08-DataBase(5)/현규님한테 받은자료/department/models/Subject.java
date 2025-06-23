package kr.hyungyu.department.models;

import lombok.Data;

@Data
public class Subject {
    private int id;
    private String name;
    private int credit;
    private int departmentId;
    private int professorId;
}
