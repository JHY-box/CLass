package kr.hossam.mybatis;

import org.apache.ibatis.session.SqlSession;
import kr.hossam.MyBatisConnectionFactory;
import kr.hossam.exceptions.ServiceNoResultException;
import kr.hossam.models.Department;
import kr.hossam.services.DepartmentService;
import kr.hossam.services.impl.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App13 {
    public static void main(String[] args) {
        /** 1) 데이터베이스 접속 --> spring에서는 제거됨 */
        // Spring은 데이터베이스 접속 처리가 자동화
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 2) 서비스 객체 생성 --> spring에서는 선언만 함 */
        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

        /** 3) ✅ Mapper에 전달할 파라미터 구성 */
        Department input = new Department();
        input.setId(514);  // ⭐ WHERE절에 사용할 조건값
        input.setDname("자바학과(수정)");
        input.setLoc("공학관(수정)");
        input.setPhone("02-234-5678");
        input.setEmail("java@myschool.ac.kr");
        input.setHomepage("https://java.myschool.ac.kr");
        input.setEstablished(2025);


        /** 4) ✅ service객체에게 데이터 저장 요청 */
        Department output = null;

        try {
            output = departmentService.editItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
            sqlSession.rollback();
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
            sqlSession.rollback();
        }

        /** 5) 결과 출력 */
        if (output != null) {
            log.debug("수정결과 ---> " + output.toString());
        }

        /** 6) DB접속 해제 */
        sqlSession.commit();
        sqlSession.close();
    }
}
