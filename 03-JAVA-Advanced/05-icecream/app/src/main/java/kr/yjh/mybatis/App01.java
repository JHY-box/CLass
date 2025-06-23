package kr.yjh.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.AnimalIns;
import kr.yjh.services.AnimalInsService;
import kr.yjh.services.impl.AnimalInsServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App01 {
    public static void main(String[] args) {
        
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        
        AnimalInsService animalInsService = new AnimalInsServiceImpl(sqlSession);

        //AnimalInsMapper input = new AnimalIns();
        AnimalIns input = new AnimalIns();
        input.setName("ppy");


        List<AnimalIns> output = null;
        int count = 0;

        try {
            output = animalInsService.getList(input);
            count = animalInsService.getCount(input);
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
