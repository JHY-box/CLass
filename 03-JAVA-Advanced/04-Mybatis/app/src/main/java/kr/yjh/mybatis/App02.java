package kr.yjh.mybatis;



import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.mappers.DepartmentMapper;
import kr.yjh.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App02 {
   
    public static void main(String[] args) {
        /** 1) MyBatis 설정 파일의 내용을 로드하는 접속 세션 생성 및 Mapper 로드 */
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);


        /** 2) 저장할 데이터를 Beans 클래스의 객체로 준비  */
        Department input = new Department();
        input.setId(511);  //✅ WHERE절에 사용할 PK값도 함께 설정해야 함
        input.setDname("수정된학과");
        input.setLoc("B-2");
        input.setPhone("010-1234-1234");
        input.setEmail("megastudy@hello.com");
        input.setEstablished(2020);
        input.setHomepage("https://megastudy.com");

        /** 3) Mapper에 구현되어 있는 메서드를 호출하여 SQL문 실행 */
        int output = departmentMapper.update(input);

        /** 4) 결과판별 */
        log.debug("수정된 데이터의 수: " + output);

        /** 5) 데이터베이스 접속 해제 */
        sqlSession.commit();
        sqlSession.close();
    }
}
