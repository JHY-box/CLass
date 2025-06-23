package com.jamesobin.database.services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.mappers.EnrollmentMapper;
import com.jamesobin.database.mappers.SubjectMapper;
import com.jamesobin.database.models.Enrollment;
import com.jamesobin.database.models.Subject;
import com.jamesobin.database.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    public SubjectServiceImpl(SqlSession sqlSession) {
        this.subjectMapper = sqlSession.getMapper(SubjectMapper.class);
        this.enrollmentMapper = sqlSession.getMapper(EnrollmentMapper.class);
    }

    @Override
    public Subject addItem(Subject input) throws Exception {
        int rows = subjectMapper.insert(input);

        if (rows == 0) {
            throw new ServiceNoResultException("저장된 Subject 데이터가 없습니다.");
        }

        return subjectMapper.selectOne(input);
    }

    @Override
    public Subject editItem(Subject input) throws Exception {
        int rows = subjectMapper.update(input);

        if (rows == 0) {
            throw new ServiceNoResultException("수정된 Subject 데이터가 없습니다.");
        }

        return subjectMapper.selectOne(input);
    }

    @Override
    public int deleteItem(Subject input) throws Exception {
        int output = 0;

        Enrollment enrollment = new Enrollment();
        enrollment.setSubjectId(input.getId());
        enrollmentMapper.deleteBySubjectId(enrollment);

        output = subjectMapper.delete(input);

        if (output == 0) {
            throw new ServiceNoResultException("Subject 삭제된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public Subject getItem(Subject input) throws Exception {
        Subject output = subjectMapper.selectOne(input);

        if (output == null) {
            throw new ServiceNoResultException("Subject 조회된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public List<Subject> getList(Subject input) throws Exception {
        return subjectMapper.selectList(input);
    }

    @Override
    public int getCount(Subject input) throws Exception {
        return subjectMapper.selectCount(input);
    }
}
