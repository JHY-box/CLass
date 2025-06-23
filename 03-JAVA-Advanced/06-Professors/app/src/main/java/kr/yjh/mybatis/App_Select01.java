
package kr.yjh.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.Professors;
import kr.yjh.services.ProfessorsService;
import kr.yjh.services.impl.ProfessorsServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App_Select01 {
    public static void main(String[] args) {
        
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        
        ProfessorsService professorsService = new ProfessorsServiceImpl(sqlSession);


        Professors input = new Professors();
        input.setDepartmentId(402);
        

        List<Professors> output = null;


        try {
            output = professorsService.getList(input); 
            
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }
        
        if (output != null) {
            log.error("조회결과 --->> ", output.toString());
            
        }
        
        
        sqlSession.close();
    }
}
