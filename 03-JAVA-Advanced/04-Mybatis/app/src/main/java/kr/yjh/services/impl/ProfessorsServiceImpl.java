package kr.yjh.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.mappers.ProfessorsMapper;
import kr.yjh.models.Professors;
import kr.yjh.services.ProfessorsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProfessorsServiceImpl implements ProfessorsService {

   private ProfessorsMapper professorsMapper;

    public ProfessorsServiceImpl(SqlSession sqlSession) {
        this.professorsMapper = sqlSession.getMapper(ProfessorsMapper.class);
    }


    @Override
    public Professors addItem(Professors input) throws ServiceNoResultException, Exception {
        int rows = professorsMapper.insert(input);

        if (rows == 0) {
            throw new Exception("저장된 Professors 데이터가 없습니다.");
        }

        return professorsMapper.selectOne(input);
    }

    @Override
    public Professors editItem(Professors input) throws ServiceNoResultException, Exception {
        int rows = professorsMapper.update(input);

        if (rows == 0) {
            throw new Exception("수정된 Professors 데이터가 없습니다.");
        }

        return professorsMapper.selectOne(input);
    }

    @Override
    public int deleteItem(Professors input) throws ServiceNoResultException, Exception {
        int rows = professorsMapper.delete(input);

        if (rows == 0) {
            throw new Exception("Professors 삭제된 데이터가 없습니다.");
        }

        return rows;
    }

    @Override
    public Professors getItem(Professors input) throws ServiceNoResultException, Exception {
        Professors output = professorsMapper.selectOne(input);

        if (output == null) {
            throw new Exception("Professors 조회된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public List<Professors> getList(Professors input) throws ServiceNoResultException, Exception {
        return professorsMapper.selectList(input);
    }

    @Override
    public int getCount(Professors input) throws ServiceNoResultException, Exception {
        return professorsMapper.selectCount(input);
    }
}