package kr.yjh.mybatis;



import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.mappers.DepartmentMapper;
import kr.yjh.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App01 {
   
    public static void main(String[] args) {
        /** 1) MyBatis 설정 파일의 내용을 로드하는 접속 세션 생성 및 Mapper 로드 */
        // --> import kr.yjh.MyBatisConnectionFactory;
        // --> import org.apache.ibatis.session.SqlSession;
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        
        // -->import kr.yjh.mappers.DepartmentMapper;
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);


        /** 2) 저장할 데이터를 Beans 클래스의 객체로 준비  */
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

        /** 5) 데이터베이스 접속 해제 */
        //페이지 종료 전에 데이터의 변경사항을 저장(commit)하고 데이터베이스 접속 해제하기
        sqlSession.commit();
        sqlSession.close();
    }
}
