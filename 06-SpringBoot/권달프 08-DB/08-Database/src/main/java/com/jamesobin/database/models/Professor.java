package com.jamesobin.database.models;

import lombok.Data;

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
}
