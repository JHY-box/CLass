package com.jamesobin.database.models;

import lombok.Data;

/** 학과 정보를 저장하는 클래스 */
@Data // Lombok의 @Data 어노테어션을 사용하여 getter, setter, toString 메서드를 자동 생성
public class Department {
    private int id;
    private String dname;
    private String loc;
    private String phone;
    private String email;
    private int established;
    private String homepage;
}
