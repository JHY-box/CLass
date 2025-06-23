package com.jamesobin.database.services;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Subject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SubjectServiceTest {

    @Autowired
    private SubjectService subjectService;

    @Test
    @DisplayName("과목 추가 서비스 테스트")
    void addSubject() {
        Subject input = new Subject();
        input.setName("유체역학");
        input.setCredit(3);
        input.setDepartmentId(101);
        input.setProfessorId(9901);

        Subject output = null;

        try {
            output = subjectService.addItem(input);
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
    @DisplayName("과목 수정 서비스 테스트")
    void editSubject() {
        Subject input = new Subject();
        input.setId(1029);
        input.setName("html");
        input.setCredit(3);
        input.setDepartmentId(201);
        input.setProfessorId(9901);

        Subject output = null;

        try {
            output = subjectService.editItem(input);
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
    @DisplayName("과목 삭제 서비스 테스트")
    void removeSubject() {
        Subject input = new Subject();
        input.setId(1029);   // WHERE절에 사용할 PK값만 준비
        
        int output = 0;

        try {
            output = subjectService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        log.debug("삭제된 데이터 수 ---> " + output);
    }

    @Test
    @DisplayName("하나의 과목 조회 서비스 테스트")
    void getSubject() {
        Subject input = new Subject();
        input.setId(1027);   // WHERE절에 사용할 PK값만 준비

        Subject output = null;

        try {
            output = subjectService.getItem(input);
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
    @DisplayName("과목 목록 조회 서비스 테스트")
    void getSubjectList() {
        Subject input = new Subject();
        
        List<Subject> output = null;
        int count = 0;

        try {
            output = subjectService.getList(input);
            count = subjectService.getCount(input);
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
