package com.jamesobin.database.mappers;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.models.Professor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class ProfessorMapperTest {
    // 테스트 클래스에서는 객체 주입을 사용해야 함
    @Autowired
    private ProfessorMapper professorMapper;

    @Test
    @DisplayName("교수 추가 테스트")
    void insertProfessor() {
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

        int output = professorMapper.insert(input);

        log.debug("저장된 데이터의 수: " + output);
        log.debug("생성된 Primary Key: " + input.getId());
    }

    @Test
    @DisplayName("교수 수정 테스트")
    void updateProfessor() {
        Professor input = new Professor();
        input.setId(9932);
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

        int output = professorMapper.update(input);
        log.debug("수정된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("교수 삭제 테스트")
    void deleteProfessor() {
        Professor input = new Professor();
        input.setId(9932);

        int output = professorMapper.delete(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("하나의 교수 조회 테스트")
    void selectOneProfessor() {
        Professor input = new Professor();
        input.setId(9931);

        Professor output = professorMapper.selectOne(input);
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("교수 목록 조회 테스트")
    void selectListProfessor() {
        Professor input = new Professor();
        List<Professor> output = professorMapper.selectList(input);
        
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("교수 목록 카운트 테스트")
    void selectCountProfessor() {
        Professor input = new Professor();
        
        int output = professorMapper.selectCount(input);
        log.debug("조회된 데이터 수: " + output);
    }
}
