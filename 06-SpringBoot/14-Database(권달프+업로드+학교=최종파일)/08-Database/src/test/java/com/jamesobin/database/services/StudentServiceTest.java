package com.jamesobin.database.services;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    @DisplayName("학생 추가 서비스 테스트")
    void addStudent() {
        Student input = new Student();
        input.setName("권오빈");
        input.setUserId("jamesobin");
        input.setGrade(4);
        input.setIdnum("asdfasdfasdf");
        input.setBirthdate("1999-02-10 00:00:00");
        input.setPhone("010-1234-1234");
        input.setHeight(175);
        input.setWeight(65);
        input.setEmail("jamesobin@khu.ac.kr");
        input.setGender("남");
        input.setStatus("재학");
        input.setPhotoUrl("http://khu.ac.kr/photos/jamesobin.jpg");
        input.setAdmissionDate("2018-03-01");
        input.setGraduationDate("2025-02-19");
        input.setDepartmentId(101);
        input.setProfessorId(9901);

        Student output = null;

        try {
            output = studentService.addItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        if(output != null) {
            log.debug("저장결과 ---> " + output.toString());
        }
    }

    @Test
    @DisplayName("학생 수정 서비스 테스트")
    void editStudent() {
        Student input = new Student();
        input.setId(10179);
        input.setName("권오빈");
        input.setUserId("jamesobin(수정)");
        input.setGrade(4);
        input.setIdnum("asdfasdfasdf(수정)");
        input.setBirthdate("1999-02-10 00:00:00");
        input.setPhone("010-1234-1234");
        input.setHeight(175);
        input.setWeight(65);
        input.setEmail("jamesobin@khu.ac.kr(수정)");
        input.setGender("남");
        input.setStatus("재학");
        input.setPhotoUrl("http://khu.ac.kr/photos/jamesobin.jpg(수정)");
        input.setAdmissionDate("2018-03-01");
        input.setGraduationDate("2025-02-19");
        input.setDepartmentId(101);
        input.setProfessorId(9901);

        Student output = null;

        try {
            output = studentService.editItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        if(output != null) {
            log.debug("수정결과 ---> " + output.toString());
        }
    }

    @Test
    @DisplayName("학생 삭제 서비스 테스트")
    void removeStudent() {
        Student input = new Student();
        input.setId(10179);   // WHERE절에 사용할 PK값만 준비
        
        int output = 0;

        try {
            output = studentService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        log.debug("삭제된 데이터 수 ---> " + output);
    }

    @Test
    @DisplayName("하나의 학생 조회 서비스 테스트")
    void getStudent() {
        Student input = new Student();
        input.setId(10177);   // WHERE절에 사용할 PK값만 준비

        Student output = null;

        try {
            output = studentService.getItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        if(output != null) {
            log.debug("조회 결과 ---> " + output.toString());
        }
    }

    @Test
    @DisplayName("학생 목록 조회 서비스 테스트")
    void getStudentList() {
        Student input = new Student();
        
        List<Student> output = null;
        int count = 0;

        try {
            output = studentService.getList(input);
            count = studentService.getCount(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        if(output != null) {
            log.debug("조회 결과 ---> " + output.toString());
            log.debug("조회된 데이터 수 ---> " + count);
        }
    }
}
