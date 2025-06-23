package com.jamesobin.database.services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.mappers.EnrollmentMapper;
import com.jamesobin.database.models.Enrollment;
import com.jamesobin.database.services.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    public EnrollmentServiceImpl(SqlSession sqlSession) {
        this.enrollmentMapper = sqlSession.getMapper(EnrollmentMapper.class);
    }

    @Override
    public Enrollment addItem(Enrollment input) throws ServiceNoResultException, Exception {
        Enrollment output = null;

        int rows = enrollmentMapper.insert(input);
        if(rows == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }

        output = enrollmentMapper.selectOne(input);

        return output;
    }

    @Override
    public int deleteItem(Enrollment input) throws ServiceNoResultException, Exception {
        int output = 0;

        output = enrollmentMapper.delete(input);

        if(output == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public Enrollment editItem(Enrollment input) throws ServiceNoResultException, Exception {
        Enrollment output = null;

        int rows = enrollmentMapper.update(input);
        if(rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다.");
        }

        output = enrollmentMapper.selectOne(input);

        return output;
    }

    @Override
    public Enrollment getItem(Enrollment input) throws ServiceNoResultException, Exception {
        Enrollment output = null;

        output = enrollmentMapper.selectOne(input);
        if(output == null) {
            throw new ServiceNoResultException("조회된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public List<Enrollment> getList(Enrollment input) throws ServiceNoResultException, Exception {
        List<Enrollment> output = null;

        output = enrollmentMapper.selectList(input);
        if(output == null) {
            throw new ServiceNoResultException("조회된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public int getCount(Enrollment input) throws ServiceNoResultException, Exception {
        int output = 0;

        output = enrollmentMapper.selectCount(input);

        return output;
    }
    
}
