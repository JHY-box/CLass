package kr.yjh.mybatis;

import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.Department;
import kr.yjh.services.DepartmentService;
import kr.yjh.services.impl.DepartmentServiceimpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App10 {
    public static void main(String[] args) {

        //검색어 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 학과이름을 입력하세요: ");
        String dname = scanner.nextLine();
        System.out.print("검색할 위치를 입력하세요: ");
        String loc = scanner.nextLine();
        scanner.close();
        
        /** 1) 데이터베이스 접속 --> spring에서는 제거됨 */
        //spring은 데이터베이스 접속 처리가 자동화
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        /** 2) 서비스 객체 생성 --> spring에서는 선언만 함 */
        DepartmentService departmentService = new DepartmentServiceimpl(sqlSession);

        /** 3) ✅ Mapper에 전달할 파라미터 구성 */
        //검색어를 Beans객체에 담아서 Mapper에게 전달
        Department input = new Department();
        input.setDname(dname);
        input.setLoc(loc);

        /** 4) ✅ service객체에게 데이터 목록 조회 요청 */
        List<Department> output = null;
        int count = 0;

        try {
            output = departmentService.getList(input);
            count = departmentService.getCount(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 테이터없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("처리된 테이터 실패 >> SQL문을 확인하세요", e);
        }

        /** 5) 결과 출력 */
        if (output != null) {
            log.debug("조회결화 --->  " + output.toString());
            log.debug("조회된 데이터 수 --->  " + count);
        }

        /** 6) DB접 해제 */
        //SELECT문의 경우 데이터 변경이 발생하지 않으므로 commit 처리는 제외
        sqlSession.close();
            
    }
}
