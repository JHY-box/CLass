package com.jamesobin.database.mappers;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.models.Enrollment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EnrollmentMapperTest {
    // 테스트 클래스에서는 객체 주입을 사용해야 함
    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Test
    @DisplayName("수강신청 추가 테스트")
    void insertEnrollment() {
        Enrollment input = new Enrollment();
        input.setStudentId(10177);
        input.setSubjectId(1005);
        input.setEnrollDate("2025-04-23");
        input.setScore(100);

        int output = enrollmentMapper.insert(input);

        log.debug("저장된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("수강신청 수정 테스트")
    void updateEnrollment() {
        Enrollment input = new Enrollment();
        input.setStudentId(10177);
        input.setSubjectId(1005);
        input.setEnrollDate("2025-04-20");
        input.setScore(80);

        int output = enrollmentMapper.update(input);
        log.debug("수정된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("수강신청 삭제 테스트")
    void deleteEnrollment() {
        Enrollment input = new Enrollment();
        input.setStudentId(10177);
        input.setSubjectId(1001);

        int output = enrollmentMapper.delete(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("하나의 수강신청 조회 테스트")
    void selectOneEnrollment() {
        Enrollment input = new Enrollment();
        input.setStudentId(10101);
        input.setSubjectId(1005);

        Enrollment output = enrollmentMapper.selectOne(input);
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("수강신청 목록 조회 테스트")
    void selectListEnrollment() {
        Enrollment input = new Enrollment();
        List<Enrollment> output = enrollmentMapper.selectList(input);
        
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("수강신청 목록 카운트 테스트")
    void selectCountEnrollment() {
        Enrollment input = new Enrollment();
        
        int output = enrollmentMapper.selectCount(input);
        log.debug("조회된 데이터 수: " + output);
    }
}
