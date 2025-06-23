package kr.hossam.mybatis;

import org.apache.ibatis.session.SqlSession;
import kr.hossam.MyBatisConnectionFactory;
import kr.hossam.exceptions.ServiceNoResultException;
import kr.hossam.models.Department;
import kr.hossam.services.DepartmentService;
import kr.hossam.services.impl.DepartmentServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App11 {
    public static void main(String[] args) {
        /** 1) 데이터베이스 접속 --> spring에서는 제거됨 */
        // Spring은 데이터베이스 접속 처리가 자동화
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 2) 서비스 객체 생성 --> spring에서는 선언만 함 */
        DepartmentService departmentService = new DepartmentServiceImpl(sqlSession);

        /** 3) ✅ Mapper에 전달할 파라미터 구성 --> 현재 Mapper에서 목록조회시 별다른 파라미터를 요구하고 있지 않으므로 필요 없음 */
        Department input = new Department();
        input.setId(101);


        /** 4) ✅ service객체에게 데이터 목록 조회 요청 */
        Department output = null;

        try {
            output = departmentService.getItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }

        /** 5) 결과 출력 */
        if (output != null) {
            log.debug("조회결과 ---> " + output.toString());
        }

        /** 6) DB접속 해제 */
        // SELECT문의 경우 데이터 변경이 발생하지 않으므로 commit 처리는 제외
        sqlSession.close();
    }
}
