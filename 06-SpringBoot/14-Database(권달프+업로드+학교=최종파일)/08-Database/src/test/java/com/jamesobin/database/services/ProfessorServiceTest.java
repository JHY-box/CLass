package com.jamesobin.database.services;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Professor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ProfessorServiceTest {

    @Autowired
    private ProfessorService professorService;

    @Test
    @DisplayName("학과 추가 서비스 테스트")
    void addProfessor() {
        Professor input = new Professor();
        input.setName("권오빈");
        input.setUserId("jamesobin");
        input.setPosition("교수");
        input.setSal(500);
        input.setHiredate("2025-04-24 11:18:00");
        // input.setComm();
        input.setEmail("jamesobin@khu.ac.kr");
        input.setPhone("010-1234-1234");
        input.setPhotoUrl("http://khu.ac.kr/photos/jamesobin.jpg");
        input.setStatus("재직");
        input.setDepartmentId(302);

        Professor output = null;

        try {
            output = professorService.addItem(input);
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
    void editProfessor() {
        Professor input = new Professor();
        input.setId(9933);
        input.setName("권오빈(수정)");
        input.setUserId("jamesobin(수정)");
        input.setPosition("조교수");
        input.setSal(500);
        input.setHiredate("2025-04-24 11:18:00");
        input.setComm(22);
        input.setEmail("jamesobin@khu.ac.kr");
        input.setPhone("010-1234-1234");
        input.setPhotoUrl("http://khu.ac.kr/photos/jamesobin.jpg(수정)");
        input.setStatus("재직");
        input.setDepartmentId(302);

        Professor output = null;

        try {
            output = professorService.editItem(input);
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
    void removeProfessor() {
        Professor input = new Professor();
        input.setId(9933);   // WHERE절에 사용할 PK값만 준비
        
        int output = 0;

        try {
            output = professorService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        log.debug("삭제된 데이터 수 ---> " + output);
    }

    @Test
    @DisplayName("하나의 학과 조회 서비스 테스트")
    void getProfessor() {
        Professor input = new Professor();
        input.setId(9931);   // WHERE절에 사용할 PK값만 준비

        Professor output = null;

        try {
            output = professorService.getItem(input);
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
    void getProfessorList() {
        Professor input = new Professor();
        
        List<Professor> output = null;
        int count = 0;

        try {
            output = professorService.getList(input);
            count = professorService.getCount(input);
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
