package kr.yjh.database.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.yjh.database.exceptions.ServiceNoResultException;
import kr.yjh.database.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("학과 추가 서비스 테스트")
    void addDepartment() {
        Department input = new Department();
        input.setDname("자바학과");
        input.setLoc("공학관");
        input.setPhone("02-234-5678");
        input.setEmail("java@myschool.ac.kr");
        input.setHomepage("https://java.myschool.ac.kr");
        input.setEstablished(2025);

        Department output = null;

        try {
            output = departmentService.addItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.");
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL절을 확인하세요.");
        }

        log.debug("저장된 데이터: " + (output != null ? output.toString(): "null"));
    }

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("학과 수정 테스트")
    void updateDepartment() {
        
        Department input = new Department();
        input.setId(514);  //✅ WHERE절에 사용할 PK값도 함께 설정해야 함
        input.setDname("자바학과(수정)");
        input.setLoc("공학관(수정)");
        input.setPhone("02-234-5678");
        input.setEmail("java@myschool.ac.kr");
        input.setHomepage("https://java.myschool.ac.kr");
        input.setEstablished(2025);

        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        Department output = null;

        try {
            output = departmentService.addItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.");
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL절을 확인하세요.", e);
        }

        /** 4) 결과판별 */
        log.debug("수정된 데이터의 수: " + (output != null ? output.toString() : "null"));
    }

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("학과 삭제 테스트")
    void deleteDepartment() {
        
        Department input = new Department();
        input.setId(102);  //✅ WHERE절에 사용할 PK값만 준비
        
        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        int output = 0;

        try {
            output = departmentService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.");
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL절을 확인하세요.");
        }


        /** 4) 결과판별 */
        log.debug("삭제된 데이터의 수: " + output);
    }

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("하나의 학과 조회 테스트")
    void getDepartment() {
        
        Department input = new Department();
        input.setId(101);  //✅ WHERE절에 사용할 PK값만 준비

        Department output = null;

        try {
            output = departmentService.getItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL절을 확인하세요.", e);
        }

        /** 4) 결과판별 */
        log.debug("조회된 데이터: " + (output != null ? output.toString() : "null"));
    }

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("학과 목록 조회 서비스 테스트")
    void getDepartmentList() {
        Department input = new Department(); 
        input.setDname("공학");

        List<Department>output = null;
        int count = 0;

        try {
            output = departmentService.getList(input);
            count = departmentService.getCount(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요.", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL절을 확인하세요.", e);
        }

        log.debug("조회된 데이터 수: " + count );
        log.debug("조회된 데이터 목록: " + (output != null ? output.toString() : "null"));
    }
}