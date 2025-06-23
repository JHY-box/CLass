package com.jamesobin.database.mappers;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jamesobin.database.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentMapperTest {
    // 테스트 클래스에서는 객체 주입을 사용해야 함
    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    @DisplayName("학과 추가 테스트")
    void insertDepartment() {
        Department input = new Department();
        input.setDname("새로운학과");
        input.setLoc("B-1");
        input.setPhone("010-1234-1234");
        input.setEmail("megastudy@hello.com");
        input.setEstablished(2020);
        input.setHomepage("https://megastudy.com");

        int output = departmentMapper.insert(input);

        log.debug("저장된 데이터의 수: " + output);
        log.debug("생성된 Primary Key: " + input.getId());
    }

    @Test
    @DisplayName("학과 수정 테스트")
    void updateDepartment() {
        Department input = new Department();
        input.setId(504);   // WHERE절에 사용할 PK값도 함께 설정해야 함
        input.setDname("수정된학과");
        input.setLoc("B-2");
        input.setPhone("010-1234-1234");
        input.setEmail("megastudy@hello.com");
        input.setEstablished(2020);
        input.setHomepage("https://megastudy.com");

        int output= departmentMapper.update(input);
        log.debug("수정된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("학과 삭제 테스트")
    void deleteDepartment() {
        Department input = new Department();
        input.setId(504);   // WHERE절에 사용할 PK값만 준비
        int output = departmentMapper.delete(input);
        log.debug("삭제된 데이터의 수: " + output);
    }

    @Test
    @DisplayName("하나의 학과 조회 테스트")
    void selectOneDepartment() {
        Department input = new Department();
        input.setId(101);   // WHERE절에 사용할 PK값만 준비
        Department output = departmentMapper.selectOne(input);
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("학과 목록 조회 테스트")
    void selectListDepartment() {
        Department input = new Department();
        List<Department> output = departmentMapper.selectList(input);
        log.debug("조회결과: " + output.toString());
    }

    @Test
    @DisplayName("학과 목록 카운트 테스트")
    void selectCountDepartment() {
        Department input = new Department();
        int output = departmentMapper.selectCount(input);
        log.debug("조회된 데이터 수: " + output);
    }
}
