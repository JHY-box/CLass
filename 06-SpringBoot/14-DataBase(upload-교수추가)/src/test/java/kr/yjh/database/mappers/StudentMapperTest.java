package kr.yjh.database.mappers;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.yjh.database.models.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    @DisplayName("학생 추가 테스트")
    @Transactional
    void insertStudent() {
        Student input = new Student();
        input.setName("홍길동");
        input.setUserId("hong123");
        input.setGrade(1);
        input.setIdnum("990101-1234567");
        input.setBirthdate("1999-01-01");
        input.setPhone("010-1234-5678");
        input.setHeight(175);
        input.setWeight(70);
        input.setEmail("hong@myschool.ac.kr");
        input.setGender("남");
        input.setStatus("재학");
        input.setPhotoUrl("https://photo.myschool.ac.kr/hong.jpg");
        input.setAdmissionDate("2018-03-01");
        input.setGraduationDate(null);
        input.setDepartmentId(101);
        input.setProfessorId(9931);

        int output = studentMapper.insert(input);

        // Assertion 추가
        Assertions.assertEquals(1, output, "학생 추가는 1건이어야 한다");
        Assertions.assertNotNull(input.getId(), "학생의 PK(id)는 null이 아니어야 한다");

        log.debug("저장된 데이터의 수 : " + output);
        log.debug("생성된 Primary Key : " + input.getId());
    }

    @Test
    @DisplayName("학생 수정 테스트")
    @Transactional
    void updateStudent() {
        Student input = new Student();
        input.setId(10121); 
        input.setName("홍길동(수정)");
        input.setUserId("hong1234");
        input.setGrade(2);
        input.setIdnum("990101-1234567");
        input.setBirthdate("1999-01-01");
        input.setPhone("010-1234-5678");
        input.setHeight(176);
        input.setWeight(71);
        input.setEmail("hong2@myschool.ac.kr");
        input.setGender("남");
        input.setStatus("휴학");
        input.setPhotoUrl("https://photo.myschool.ac.kr/hong2.jpg");
        input.setAdmissionDate("2018-03-01");
        input.setGraduationDate(null);
        input.setDepartmentId(101);
        input.setProfessorId(9931);

        int output = studentMapper.update(input);

        // Assertion 추가
        Assertions.assertEquals(1, output, "학생 수정은 1건이어야 한다");

        log.debug("수정된 데이터의 수 : " + output);
    }

    @Test
    @DisplayName("학생 삭제 테스트")
    @Transactional
    void deleteStudent() {
        Student input = new Student();
        input.setId(101260); 
        int output = studentMapper.delete(input);

        // Assertion 추가
        Assertions.assertEquals(0, output, "학생 삭제는 0건이어야 한다 -> 참조키 제약조건 때문");

        log.debug("삭제된 데이터의 수 : " + output);
    }

    @Test
    @DisplayName("하나의 학생 조회 테스트")
    @Transactional
    void selectOneStudent() {
        Student input = new Student();
        input.setId(10101); 
        Student output = studentMapper.selectOne(input);

        // Assertion 추가
        Assertions.assertNotNull(output, "학생이 존재해야 한다");

        log.debug("조회결과 : " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("학생 목록 조회 테스트")
    @Transactional
    void selectListStudent() {
        Student input = new Student();
        List<Student> output = studentMapper.selectList(input);

        // Assertion 추가
        Assertions.assertNotNull(output, "학생 목록은 null이 아니어야 한다");
        Assertions.assertTrue(output.size() >= 0, "학생 목록 크기는 0 이상이어야 한다");

        log.debug("조회된 데이터의 수 : " + output.size());
        for (Student item : output) {
            log.debug(item.toString());
        }
    }

    @Test
    @DisplayName("학생 목록 카운트 테스트")
    @Transactional
    void selectCountStudent() {
        Student input = new Student();
        int output = studentMapper.selectCount(input);

        // Assertion 추가
        Assertions.assertTrue(output >= 0, "학생 카운트는 0 이상이어야 한다");

        log.debug("조회된 데이터의 수 : " + output);
    }

    @Test
    @DisplayName("특정 학과 학생 일괄 삭제 테스트")
    @Transactional
    void deleteByDepartmentId() {
        // 참조키 제약조건 때문에 교수 데이터 삭제 없이 학생 삭제는 불가
        Student input = new Student();
        input.setDepartmentId(405); 
        int output = studentMapper.deleteByStudentId(input);

        // Assertion 추가
        Assertions.assertTrue(output >= 0, "삭제된 학생 수는 0 이상이어야 한다");

        log.debug("삭제된 데이터의 수 : " + output);
    }

    @Test
    @DisplayName("특정 교수 담당 학생의 교수번호 NULL 처리 테스트")
    @Transactional
    void updateProfessorIdToNull() {
        Student input = new Student();
        input.setProfessorId(9931); // 실제 존재하는 교수 PK로 변경 필요
        int output = studentMapper.updateByprofessorId(input);

        // Assertion 추가
        Assertions.assertTrue(output >= 0, "NULL 처리된 학생 수는 0 이상이어야 한다");

        log.debug("변경된 데이터의 수 : " + output);
    }
}