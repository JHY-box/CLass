package kr.yjh.database.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kr.yjh.database.exceptions.ServiceNoResultException;
import kr.yjh.database.models.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    @DisplayName("학생 추가 서비스 테스트")
    void addStudent() {
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

        Student output = null;

        try {
            output = studentService.addItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        log.debug("저장된 데이터 : " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("학생 수정 서비스 테스트")
    void editStudent() {
        Student input = new Student();
        input.setId(10179); // 실제 존재하는 PK로 변경 필요
        input.setName("홍길동(수정)");
        input.setUserId("hong1234");
        input.setGrade(2);
        input.setIdnum("990101-1234567");
        input.setBirthdate("1999-01-01");
        input.setPhone("010-1234-5678");
        input.setHeight(176);
        input.setWeight(72);
        input.setEmail("hong2@myschool.ac.kr");
        input.setGender("남");
        input.setStatus("휴학");
        input.setPhotoUrl("https://photo.myschool.ac.kr/hong2.jpg");
        input.setAdmissionDate("2018-03-01");
        input.setGraduationDate(null);
        input.setDepartmentId(101);
        input.setProfessorId(9931);

        Student output = null;

        try {
            output = studentService.editItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        log.debug("수정된 데이터 : " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("학생 삭제 서비스 테스트")
    @Transactional
    void removeStudent()  {
        Student input = new Student();
        input.setId(10179); // 실제 존재하는 PK로 변경 필요

        int output = 0;

        try {
            output = studentService.deleteItem(input);

            if (output == 0) {
            throw new ServiceNoResultException("처리된 데이터 없음 >> WHERE절을 확인하세요");
        }
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }
        log.debug("삭제된 데이터 수 ---> " + output);
    }

    @Test
    @DisplayName("하나의 학생 조회 서비스 테스트")
    void getStudent() {
        Student input = new Student();
        input.setId(10001); // 실제 존재하는 PK로 변경 필요

        Student output = null;

        try {
            output = studentService.getItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }


        log.debug("조회된 데이터 : " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("학생 목록 조회 서비스 테스트")
    @Transactional
    void getStudentList() {
        Student input = new Student();
        input.setName("홍");
        List<Student> output = null;
        int count = 0;

        try {
            output = studentService.getList(input);
            count = studentService.getCount(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        log.debug("조회된 데이터 수 : " + count);
        log.debug("조회된 데이터 목록 : " + (output != null ? output.toString() : "null"));
    }
}