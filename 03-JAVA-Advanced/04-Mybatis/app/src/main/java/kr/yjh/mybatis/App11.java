package kr.yjh.mybatis;


import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.Department;
import kr.yjh.services.DepartmentService;
import kr.yjh.services.impl.DepartmentServiceimpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App11 {
    public static void main(String[] args) {
       
        /** 1) 데이터베이스 접속 --> spring에서는 제거됨 */
        // spring은 데이터베이스 접속 처리가 자동화
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();


        /** 2) 서비스 객체 생성 --> spring에서는 선언만 함 */
        DepartmentService departmentService = new DepartmentServiceimpl(sqlSession);


        /** 3) ✅Mapper에 전달할 파라미터 구성 --> 현재 Mapper에서 목록조회시 별다른 파라미터를 요구하고 있지 않으므로 필요 없음 */
        Department input = new Department();
        input.setId(101);


        /** 4) ✅ service객체에게 데이터 목록 조회 요청 */
        Department output = null;

        try {
            output = departmentService.getItem(null);
        } catch (ServiceNoResultException e) {
            log.error("처리된 테이터없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("처리된 테이터 실패 >> SQL문을 확인하세요", e);
        }


        /** 5) 결과 출력 */
        if (output != null) {
            log.debug("조회결화 --->  " + output.toString());
        }


        /** 6) DB접속 해체 */
        // SELECT문의 경우 데이터 변경이 발생하지 않으므로 commit 처리는 제외
        sqlSession.close();
            
    }
}
