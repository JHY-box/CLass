package kr.yjh.mybatis;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.MyBatisConnectionFactory;
import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.AnimalIns;
import kr.yjh.services.AnimalInsService;
import kr.yjh.services.impl.AnimalInsServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App05 {
    public static void main(String[] args) {
        
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();
        
        AnimalInsService animalInsService = new AnimalInsServiceImpl(sqlSession);

        AnimalIns input = new AnimalIns();
        input.setAnimalId("A983298");



        int output = 0;

        try {
            output = animalInsService.deleteItem(input);
        } catch (ServiceNoResultException e) {
            log.error("처리된 데이터 없음 >> WHERE절을 확인하세요", e);
            sqlSession.rollback();
        } catch (Exception e) {
            log.error("데이터 처리 실패 >> SQL문을 확인하세요", e);
            sqlSession.rollback();
        }
        
            log.error("삭제된 데이터 수 ---> ", output);
        
        
        sqlSession.commit();
        sqlSession.close();
    }
}
