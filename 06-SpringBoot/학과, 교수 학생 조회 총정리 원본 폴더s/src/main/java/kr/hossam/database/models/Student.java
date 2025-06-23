package kr.hossam.database.models;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private String userId;
    private int grade;
    private String idnum;
    private String birthdate;
    private String phone;
    private int height;
    private int weight;
    private String email;
    private String gender;
    private String status;
    private String photoUrl;
    private String admissionDate;
    private String graduationDate;
    private int departmentId;
    private int professorId;
}