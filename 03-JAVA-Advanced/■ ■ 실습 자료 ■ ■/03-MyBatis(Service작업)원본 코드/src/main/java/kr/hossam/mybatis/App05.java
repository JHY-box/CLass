package kr.hossam.mybatis;

import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.session.SqlSession;
import kr.hossam.MyBatisConnectionFactory;
import kr.hossam.mappers.DepartmentMapper;
import kr.hossam.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App05 {
    public static void main(String[] args) {
        // 검색어 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색할 학과이름을 입력하세요: ");
        String dname = scanner.nextLine();
        System.out.print("검색할 위치를 입력하세요: ");
        String loc = scanner.nextLine();
        scanner.close();

        /** 1) MyBatis 설정 파일의 내용을 로드하는 접속 세션 생성 및 Mapper로드 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        /** 2) 조회할 데이터를 Beans클래스의 객체로 준비 */
        // 검색어를 Beans객체에 담아서 Mapper에게 전달
        Department input = new Department();
        input.setDname(dname);
        input.setLoc(loc);

        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        // ✅ SQL문 내부에서 Beans의 변수를 사용하지 않으므로 객체 전달 필요 없음 --> null
        List<Department> output = departmentMapper.selectList(input);

        /** 4) 결과판별 */
        log.debug("조회결과: " + output.toString());

        /** 5) 조회된 데이터 수 확인 */
        int count = departmentMapper.selectCount(input);
        log.debug("조회된 데이터 수: " + count);

        /** 6) 데이터베이스 접속 해제 */
        // ✅ 데이터 조회이므로 트렌젝션이 발생하지 않음 --> commit 처리 불필요
        sqlSession.close();
    }
}
