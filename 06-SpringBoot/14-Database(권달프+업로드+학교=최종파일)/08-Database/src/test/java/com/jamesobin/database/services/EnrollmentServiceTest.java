package com.jamesobin.database.services;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.models.Enrollment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EnrollmentServiceTest {

    @Autowired
    private EnrollmentService enrollmentService;

    @Test
    @DisplayName("수강신청 추가 서비스 테스트")
    void addEnrollment() {
        Enrollment input = new Enrollment();
        input.setStudentId(10176);
        input.setSubjectId(1005);
        input.setEnrollDate("2025-04-23");
        input.setScore(100);

        Enrollment output = null;

        try {
            output = enrollmentService.addItem(input);
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
    @DisplayName("수강신청 수정 서비스 테스트")
    void editEnrollment() {
        Enrollment input = new Enrollment();
        input.setStudentId(10176);
        input.setSubjectId(1005);
        input.setEnrollDate("2025-04-20");
        input.setScore(80);

        Enrollment output = null;

        try {
            output = enrollmentService.editItem(input);
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
    @DisplayName("수강신청 삭제 서비스 테스트")
    void removeEnrollment() {
        Enrollment input = new Enrollment();
        input.setStudentId(10176);
        input.setSubjectId(1005);
        
        int output = 0;

        try {
            output = enrollmentService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요.", e);
        }

        log.debug("삭제된 데이터 수 ---> " + output);
    }

    @Test
    @DisplayName("하나의 수강신청 조회 서비스 테스트")
    void getEnrollment() {
        Enrollment input = new Enrollment();
        input.setStudentId(10101);
        input.setSubjectId(1005);

        Enrollment output = null;

        try {
            output = enrollmentService.getItem(input);
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
    @DisplayName("수강신청 목록 조회 서비스 테스트")
    void getEnrollmentList() {
        Enrollment input = new Enrollment();
        
        List<Enrollment> output = null;
        int count = 0;

        try {
            output = enrollmentService.getList(input);
            count = enrollmentService.getCount(input);
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
