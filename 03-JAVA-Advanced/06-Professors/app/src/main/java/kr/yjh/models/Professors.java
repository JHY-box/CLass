package kr.yjh.models;

import lombok.Data;

@Data
public class Professors {
    
    
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
