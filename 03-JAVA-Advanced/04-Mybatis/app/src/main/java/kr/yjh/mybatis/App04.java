package kr.yjh.mybatis;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.mappers.DepartmentMapper;
import kr.yjh.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App04 {
    public static void main(String[] args) {
        // 1. MyBatis 설정 파일의 내용을 로드하는 접속 세션 생성 및 Mapper 로드.
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);

        // 2. 저장할 데이터를 자바빈즈 클래스의 객체로 준비.
        Department input = new Department();
        input.setId(504);

        // 3. Mapper에 구현되어 있는 메서드를 호출해 SQL문 실행
        Department output = departmentMapper.selectOne(input);
        // 4. 결과 출력
        log.debug("조회결과: " + output.toString());
        // 5.데이터베이스 접속 해제
        
        sqlSession.close();
    }
}