package kr.yjh.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.mappers.AnimalInsMapper;
import kr.yjh.models.AnimalIns;
import kr.yjh.services.AnimalInsService;

public class AnimalInsServiceImpl implements AnimalInsService {

    private AnimalInsMapper animalInsMapper;

    public AnimalInsServiceImpl(SqlSession sqlSession) {
        this.animalInsMapper = sqlSession.getMapper(AnimalInsMapper.class);
    }

    @Override
    public AnimalIns addItem(AnimalIns input) throws Exception {
        int row = animalInsMapper.insert(input);

        if (row == 0) {
            throw new Exception("저장된 AnimalIns 데이터가 없습니다.");
        }

        return animalInsMapper.selectOne(input);
    }

    @Override
    public AnimalIns editItem(AnimalIns input) throws Exception {
        int rows = animalInsMapper.update(input);

        if (rows == 0) {
            throw new Exception("수정된 데이터가 없습니다.");
        }

        return animalInsMapper.selectOne(input);
    }

    @Override
    public int deleteItem(AnimalIns input) throws Exception {
        int rows = animalInsMapper.delete(input);

        if (rows == 0) {
            throw new Exception("AnimalIns 삭제된 데이터가 없습니다.");
        }

        return rows;
    }

    @Override
    public AnimalIns getItem(AnimalIns input) throws Exception {
        AnimalIns output = animalInsMapper.selectOne(input);

        if (output == null) {
            throw new ServiceNoResultException("AnimalIns 조회된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public List<AnimalIns> getList(AnimalIns input) throws Exception {
        List<AnimalIns> output = animalInsMapper.selectList(input);
        return output;
    }

    @Override
    public int getCount(AnimalIns input) throws Exception {
        return animalInsMapper.selectCount(input);
    }
}
