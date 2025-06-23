package kr.hossam.mybatis;

import org.apache.ibatis.session.SqlSession;
import kr.hossam.MyBatisConnectionFactory;
import kr.hossam.mappers.DepartmentMapper;
import kr.hossam.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App03 {
    public static void main(String[] args) {
        /** 1) MyBatis 설정 파일의 내용을 로드하는 접속 세션 생성 및 Mapper로드 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        /** 2) 삭제할 데이터를 Beans클래스의 객체로 준비 */
        Department input = new Department();
        input.setId(511);   // ✅ WHERE절에 사용할 PK값만 준비

        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        int output = departmentMapper.delete(input);

        /** 4) 결과판별 */
        log.debug("삭제된 데이터의 수: " + output);

        /** 5) 데이터베이스 접속 해제 */
        sqlSession.commit();
        sqlSession.close();
    }
}
