package com.jamesobin.database.services;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    @DisplayName("학과 추가 서비스 테스트")
    void addDepartment() {
        Department input = new Department();
        input.setDname("새로운학과");
        input.setLoc("B-1");
        input.setPhone("010-1234-1234");
        input.setEmail("megastudy@hello.com");
        input.setEstablished(2020);
        input.setHomepage("https://megastudy.com");

        Department output = null;

        try {
            output = departmentService.addItem(input);
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
    @DisplayName("학과 수정 서비스 테스트")
    void editDepartment() {
        Department input = new Department();
        input.setId(505);   // WHERE절에 사용할 PK값도 함께 설정해야 함
        input.setDname("수정된학과");
        input.setLoc("B-2");
        input.setPhone("010-1234-1234");
        input.setEmail("megastudy@hello.com");
        input.setEstablished(2020);
        input.setHomepage("https://megastudy.com");

        Department output = null;

        try {
            output = departmentService.editItem(input);
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
    @DisplayName("학과 삭제 서비스 테스트")
    void removeDepartment() {
        Department input = new Department();
        input.setId(505);   // WHERE절에 사용할 PK값만 준비
        
        int output = 0;

        try {
            output = departmentService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        log.debug("삭제된 데이터 수 ---> " + output);
    }

    @Test
    @DisplayName("하나의 학과 조회 서비스 테스트")
    void getDepartment() {
        Department input = new Department();
        input.setId(101);   // WHERE절에 사용할 PK값만 준비

        Department output = null;

        try {
            output = departmentService.getItem(input);
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
    @DisplayName("학과 목록 조회 서비스 테스트")
    void getDepartmentList() {
        Department input = new Department();
        
        List<Department> output = null;
        int count = 0;

        try {
            output = departmentService.getList(input);
            count = departmentService.getCount(input);
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
