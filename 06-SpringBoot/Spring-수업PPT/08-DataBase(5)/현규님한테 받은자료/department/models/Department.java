package kr.hyungyu.department.models;

import lombok.Data;

@Data //getter, setter, toString 자동생성
public class Department {
    private int id;
    private String dname;
    private String loc;
    private String phone;
    private String email;
    private int established;
    private String homepage;
}
