package kr.yjh.database.mappers;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.yjh.database.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentMapperTest {
    
    @Autowired
    private DepartmentMapper departmentMapper;

/*➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖*/

    @Test
    @DisplayName("학과 추가 테스트")
    void insertDepartment() {
        // --> import kr.yjh.models.Department;
        Department input = new Department();
        input.setDname("새로운학과");
        input.setLoc("B-1");
        input.setPhone("010-1234-1234");
        input.setEmail("megastudy@hello.com");
        input.setEstablished(2020);
        input.setHomepage("https://megastudy.com");

        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        int output = departmentMapper.insert(input);

        /** 4) 결과판별 */
        log.debug("저장된 데이터의 수: " + output);
        //생성된 Primary Key는 입력 파라미터 객체에 셋팅된다.
        log.debug("생성된 Primary Key: " + input.getId());
    }
//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("학과 수정 테스트")
    void updateDepartment() {
        
        Department input = new Department();
        input.setId(511);  //✅ WHERE절에 사용할 PK값도 함께 설정해야 함
        input.setDname("수정된학과");
        input.setLoc("B-2");
        input.setPhone("010-1234-1234");
        input.setEmail("megastudy@hello.com");
        input.setEstablished(2020);
        input.setHomepage("https://megastudy.com");

        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        int output = departmentMapper.update(input);

        /** 4) 결과판별 */
        log.debug("수정된 데이터의 수: " + output);
    }

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("학과 삭제 테스트")
    void deleteDepartment() {
        
        Department input = new Department();
        input.setId(511);  //✅ WHERE절에 사용할 PK값만 준비
        
        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        int output = departmentMapper.delete(input);

        /** 4) 결과판별 */
        log.debug("삭제된 데이터의 수: " + output);
    }

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("하나의 학과 조회 테스트")
    void selectOneDepartment() {
        
        Department input = new Department();
        input.setId(101);  //✅ WHERE절에 사용할 PK값만 준비
        Department output = departmentMapper.selectOne(input);
        /** 4) 결과판별 */
        log.debug("조회결과: " + output.toString());
    }


    @Test
    @DisplayName("학과 목록 조회 테스트")
    void selectListDepartment() {
        
        Department input = new Department();
        //input.setDname("수정된학과"); //✅  LIKE 검색에 사용할 키워드
        //input.setLoc("B-2");          //✅  LIKE 검색에 사용할 키워드
        List<Department> output = departmentMapper.selectList(input);

        /** 4) 결과판별 */
        log.debug("조회결과: " + output.toString());
    }

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

    @Test
    @DisplayName("학과 목록 카운트 테스트")
    void selectCountDepartment() {
        
        Department input = new Department();
        //input.setDname("수정된학과"); //✅  LIKE 검색에 사용할 키워드
        //input.setLoc("B-2");          //✅  LIKE 검색에 사용할 키워드
        int output = departmentMapper.selectCount(input);

        /** 4) 결과판별 */
        log.debug("조회된 데이터 수: " + output);

    }
}
