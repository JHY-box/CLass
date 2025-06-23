package kr.hossam.database.mappers;

import kr.hossam.database.models.Professor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ProfessorMapperTest {

    @Autowired
    private ProfessorMapper professorMapper;

    @Test
    @DisplayName("교수 추가 테스트")
    void insertProfessor() {
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

        int output = professorMapper.insert(input);

        log.debug("저장된 데이터의 수: " + output);
        log.debug("생성된 Primary Key: " + input.getId());
    }

    @Test
    @DisplayName("교수 수정 테스트")
    void updateProfessor() {
        Professor input = new Professor();
        input.setId(9932); // 실제 존재하는 PK로 변경 필요
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

        int output = professorMapper.update(input);
        log.debug("수정된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("교수 삭제 테스트")
    void deleteProfessor() {
        Professor input = new Professor();
        input.setId(9932); // 실제 존재하는 PK로 변경 필요
        int output = professorMapper.delete(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("하나의 교수 조회 테스트")
    void selectOneProfessor() {
        Professor input = new Professor();
        input.setId(9931); // 실제 존재하는 PK로 변경 필요
        Professor output = professorMapper.selectOne(input);
        log.debug("조회결과: " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("교수 목록 조회 테스트")
    void selectListProfessor() {
        Professor input = new Professor();
        //input.setName(""); // LIKE 검색에 사용할 키워드
        //input.setUserId("");
        //input.setPosition("");
        //input.setDepartmentId(0);
        List<Professor> output = professorMapper.selectList(input);
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("교수 목록 카운트 테스트")
    void selectCountProfessor() {
        Professor input = new Professor();
        //input.setName(""); // LIKE 검색에 사용할 키워드
        //input.setUserId("");
        //input.setPosition("");
        //input.setDepartmentId(0);
        int output = professorMapper.selectCount(input);
        log.debug("조회된 데이터 수: " + output);
    }

    @Test
    @DisplayName("특정 학과 교수 일괄 삭제 테스트")
    void deleteByDepartmentId() {
        Professor input = new Professor();
        input.setDepartmentId(403); // 실제 존재하는 학과 PK로 변경 필요
        int output = professorMapper.deleteByDepartmentId(input);
        log.debug("삭제된 데이터의 수: " + output);
    }
}