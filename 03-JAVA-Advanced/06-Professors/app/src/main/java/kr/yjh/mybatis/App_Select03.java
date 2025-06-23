
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
public class App_Select03 {
    public static void main(String[] args) {
        
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        
        ProfessorsService professorsService = new ProfessorsServiceImpl(sqlSession);


        Professors input = new Professors();
        input.setId(9901);


        List<Professors> output = null;
        int count = 0;

        try {
            output = professorsService.getList(input);
            count = professorsService.getCount(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
        }
        
        if (output != null) {
            log.error("조회결과 --->> ", output.toString());
            log.error("조회된 데이터 수 --->> ",  + count);
        }
        
        
        sqlSession.close();
    }
}
