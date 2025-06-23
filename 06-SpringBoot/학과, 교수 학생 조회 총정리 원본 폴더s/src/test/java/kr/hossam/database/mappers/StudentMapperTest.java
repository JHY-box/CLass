package kr.hossam.database.mappers;

import kr.hossam.database.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    @DisplayName("학생 추가 테스트")
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

        log.debug("저장된 데이터의 수: " + output);
        log.debug("생성된 Primary Key: " + input.getId());
    }

    @Test
    @DisplayName("학생 수정 테스트")
    void updateStudent() {
        Student input = new Student();
        input.setId(10178); // 실제 존재하는 PK로 변경 필요
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

        int output = studentMapper.update(input);
        log.debug("수정된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("학생 삭제 테스트")
    void deleteStudent() {
        Student input = new Student();
        input.setId(10178); // 실제 존재하는 PK로 변경 필요
        int output = studentMapper.delete(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("하나의 학생 조회 테스트")
    void selectOneStudent() {
        Student input = new Student();
        input.setId(10001); // 실제 존재하는 PK로 변경 필요
        Student output = studentMapper.selectOne(input);
        log.debug("조회결과: " + (output != null ? output.toString() : "null"));
    }

    @Test
    @DisplayName("학생 목록 조회 테스트")
    void selectListStudent() {
        Student input = new Student();
        //input.setName(""); // LIKE 검색에 사용할 키워드
        //input.setUserId("");
        //input.setDepartmentId(0);
        List<Student> output = studentMapper.selectList(input);
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("학생 목록 카운트 테스트")
    void selectCountStudent() {
        Student input = new Student();
        //input.setName(""); // LIKE 검색에 사용할 키워드
        //input.setUserId("");
        //input.setDepartmentId(0);
        int output = studentMapper.selectCount(input);
        log.debug("조회된 데이터 수: " + output);
    }

    @Test
    @DisplayName("특정 학과 학생 일괄 삭제 테스트")
    void deleteByDepartmentId() {
        // 참조키 제약조건 때문에 교수 데이터 삭제 없이 학생 삭제는 불가
        Student input = new Student();
        input.setDepartmentId(405); // 실제 존재하는 학과 PK로 변경 필요
        int output = studentMapper.deleteByDepartmentId(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("특정 교수 담당 학생의 교수번호 NULL 처리 테스트")
    void updateProfessorIdToNull() {
        Student input = new Student();
        input.setProfessorId(9931); // 실제 존재하는 교수 PK로 변경 필요
        int output = studentMapper.updateProfessorIdToNull(input);
        log.debug("변경된 데이터의 수: " + output);
    }
}