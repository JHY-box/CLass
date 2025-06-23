package kr.hossam.database.services;

import kr.hossam.database.exceptions.ServiceNoResultException;
import kr.hossam.database.models.Professor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ProfessorServiceTest {

    @Autowired
    private ProfessorService professorService;

    @Test
    @DisplayName("교수 추가 서비스 테스트")
    void addProfessor() {
        Professor input = new Professor();
        input.setName("이광호");
        input.setUserId("leekh4232");
        input.setPosition("교수");
        input.setSal(500);
        input.setHiredate("2020-03-01");
        input.setComm(30);
        input.setEmail("leekh4232@myschool.ac.kr");
        input.setPhone("010-1234-5678");
        input.setPhotoUrl("https://photo.myschool.ac.kr/hong.jpg");
        input.setStatus("재직");
        input.setDepartmentId(101);

        Professor output = null;

        try {
            output = professorService.addItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        log.debug("저장된 데이터: " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("교수 수정 서비스 테스트")
    void editProfessor() {
        Professor input = new Professor();
        input.setId(9934); // 실제 존재하는 PK로 변경 필요
        input.setName("이광호(수정)");
        input.setUserId("leekwangho");
        input.setPosition("부교수");
        input.setSal(550);
        input.setHiredate("2021-03-01");
        input.setComm(35);
        input.setEmail("leekwangho@myschool.ac.kr");
        input.setPhone("010-1234-5678");
        input.setPhotoUrl("https://photo.myschool.ac.kr/hong.jpg");
        input.setStatus("휴직");
        input.setDepartmentId(402);

        Professor output = null;

        try {
            output = professorService.editItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        log.debug("수정된 데이터: " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("교수 삭제 서비스 테스트")
    void removeProfessor() {
        Professor input = new Professor();
        input.setId(9934); // 실제 존재하는 PK로 변경 필요

        int output = 0;

        try {
            output = professorService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        log.debug("삭제된 데이터 수 ---> " + output);
    }

    @Test
    @DisplayName("하나의 교수 조회 서비스 테스트")
    void getProfessor() {
        Professor input = new Professor();
        input.setId(9907); // 실제 존재하는 PK로 변경 필요

        Professor output = null;

        try {
            output = professorService.getItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        log.debug("조회된 데이터: " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("교수 목록 조회 서비스 테스트")
    void getProfessorList() {
        Professor input = new Professor();
        input.setName("박");

        List<Professor> output = null;
        int count = 0;

        try {
            output = professorService.getList(input);
            count = professorService.getCount(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        log.debug("조회된 데이터 수: " + count);
        log.debug("조회된 데이터 목록: " + (output != null ? output.toString() : "null"));
    }
}