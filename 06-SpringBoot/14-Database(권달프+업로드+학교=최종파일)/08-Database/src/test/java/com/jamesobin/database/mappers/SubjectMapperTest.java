package com.jamesobin.database.mappers;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.models.Subject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class SubjectMapperTest {
    // 테스트 클래스에서는 객체 주입을 사용해야 함
    @Autowired
    private SubjectMapper subjectMapper;

    @Test
    @DisplayName("과목 추가 테스트")
    void insertSubject() {
        Subject input = new Subject();
        input.setName("유체역학");
        input.setCredit(3);
        input.setDepartmentId(101);
        input.setProfessorId(9901);

        int output = subjectMapper.insert(input);

        log.debug("저장된 데이터의 수: " + output);
        log.debug("생성된 Primary Key: " + input.getId());
    }

    @Test
    @DisplayName("과목 수정 테스트")
    void updateSubject() {
        Subject input = new Subject();
        input.setId(1028);
        input.setName("html");
        input.setCredit(3);
        input.setDepartmentId(201);
        input.setProfessorId(9901);

        int output = subjectMapper.update(input);
        log.debug("수정된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("과목 삭제 테스트")
    void deleteSubject() {
        Subject input = new Subject();
        input.setId(1028);

        int output = subjectMapper.delete(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("하나의 과목 조회 테스트")
    void selectOneSubject() {
        Subject input = new Subject();
        input.setId(1027);

        Subject output = subjectMapper.selectOne(input);
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("과목 목록 조회 테스트")
    void selectListSubject() {
        Subject input = new Subject();
        List<Subject> output = subjectMapper.selectList(input);
        
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("과목 목록 카운트 테스트")
    void selectCountSubject() {
        Subject input = new Subject();
        
        int output = subjectMapper.selectCount(input);
        log.debug("조회된 데이터 수: " + output);
    }
}
