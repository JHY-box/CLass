package com.jamesobin.database.mappers;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.models.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StudentMapperTest {
    // 테스트 클래스에서는 객체 주입을 사용해야 함
    @Autowired
    private StudentMapper studentMapper;

    @Test
    @DisplayName("학생 추가 테스트")
    void insertStudent() {
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

        int output = studentMapper.insert(input);

        log.debug("저장된 데이터의 수: " + output);
        log.debug("생성된 Primary Key: " + input.getId());
    }

    @Test
    @DisplayName("학생 수정 테스트")
    void updateStudent() {
        Student input = new Student();
        input.setId(10178);
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

        int output = studentMapper.update(input);
        log.debug("수정된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("학생 삭제 테스트")
    void deleteStudent() {
        Student input = new Student();
        input.setId(10178);

        int output = studentMapper.delete(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("하나의 학생 조회 테스트")
    void selectOneStudent() {
        Student input = new Student();
        input.setId(10177);

        Student output = studentMapper.selectOne(input);
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("학생 목록 조회 테스트")
    void selectListStudent() {
        Student input = new Student();
        List<Student> output = studentMapper.selectList(input);
        
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("학생 목록 카운트 테스트")
    void selectCountStudent() {
        Student input = new Student();
        
        int output = studentMapper.selectCount(input);
        log.debug("조회된 데이터 수: " + output);
    }

    @Test
    @DisplayName("특정 학과 학생 일괄 삭제 테스트")
    void deleteByDepartmentId() {
        // 참조키 제약조건 때문에 교수 데이터 삭제 없이 학생 삭제는 불가
        Student input = new Student();
        input.setDepartmentId(405);

        int output = studentMapper.deleteByDepartmentId(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("특정 교수 담당 학생의 교수번호 NULL 처리 테스트")
    void updateProfessorIdToNull() {
        Student input = new Student();
        input.setProfessorId(9931);

        int output = studentMapper.updateProfessorIdToNull(input);
        log.debug("변경된 데이터의 수: " + output);
    }
}
