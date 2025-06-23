package kr.hossam.mybatis;

import org.apache.ibatis.session.SqlSession;
import kr.hossam.MyBatisConnectionFactory;
import kr.hossam.mappers.DepartmentMapper;
import kr.hossam.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App04 {
    public static void main(String[] args) {
        /** 1) MyBatis 설정 파일의 내용을 로드하는 접속 세션 생성 및 Mapper로드 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        /** 2) 조회할 데이터를 Beans클래스의 객체로 준비 */
        Department input = new Department();
        input.setId(510);   // ✅ WHERE절에 사용할 PK값만 준비

        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        Department output = departmentMapper.selectOne(input);

        /** 4) 결과판별 */
        log.debug("조회결과: " + output.toString());

        /** 5) 데이터베이스 접속 해제 */
        // ✅ 데이터 조회이므로 트렌젝션이 발생하지 않음 --> commit 처리 불필요
        sqlSession.close();
    }
}
