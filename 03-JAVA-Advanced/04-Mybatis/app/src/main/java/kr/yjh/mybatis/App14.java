package kr.yjh.mybatis;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.Department;
import kr.yjh.services.DepartmentService;
import kr.yjh.services.impl.DepartmentServiceimpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App14 {
    public static void main(String[] args) {
       
        /** 1) 데이터베이스 접속 --> spring에서는 제거됨 */
        // spring은 데이터베이스 접속 처리가 자동화
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 2) 서비스 객체 생성 --> spring에서는 선언만 함 */
        DepartmentService departmentService = new DepartmentServiceimpl(sqlSession);


        /** 3) ✅ Mapper에 전달할 파라미터 구성 */
        Department input = new Department();
        input.setId(102); // ⭐WHERE절에 사용할 조건값


        /** 4) ✅ service객체에게 데이터 저장 요청  */
        int output = 0;


        try {
            output = departmentService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
            sqlSession.rollback();
        } catch (Exception e) {
            log.error("처리된 데이터 실패 >> SQL문을 확인하세요", e);
            sqlSession.rollback();
        }



        /** 5) 결과 출력 */
        log.debug("삭제된 데이터 수 --->  " + output );


        /** 6) DB접속 해체 */
        sqlSession.commit();
        sqlSession.close();
            
    }
}