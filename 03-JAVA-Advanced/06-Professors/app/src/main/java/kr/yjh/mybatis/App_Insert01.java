package kr.yjh.mybatis;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.Professors;
import kr.yjh.services.ProfessorsService;
import kr.yjh.services.impl.ProfessorsServiceImpl;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class App_Insert01 {
    public static void main(String[] args) {
        
    SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        
    ProfessorsService professorsService = new ProfessorsServiceImpl(sqlSession);

        Professors input = new Professors();
        input.setId(9832);
        input.setName("곽춘배");
        input.setUserId("435");
        input.setPosition("교수");
        input.setSal(999);
        input.setHiredate("2000-02-02");
        input.setComm(20000);
        input.setEmail("eeee@mmmm.ail");
        input.setPhone("019-1919-1919");
        input.setPhotoUrl("http://myschoolbomb.ac.kr");
        input.setStatus("재직");
        input.setDepartmentId(101);


        Professors output = null;

        try {
            output = professorsService.addItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
            sqlSession.rollback();
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
            sqlSession.rollback();
        }
        
        if (output != null) {
            log.error("조회결과 --->> ", output.toString());
        }
        
        sqlSession.commit();
        sqlSession.close();
    }
}

