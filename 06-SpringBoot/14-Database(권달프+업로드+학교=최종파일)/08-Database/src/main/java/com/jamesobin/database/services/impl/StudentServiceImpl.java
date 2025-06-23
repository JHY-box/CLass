package com.jamesobin.database.services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.mappers.EnrollmentMapper;
import com.jamesobin.database.mappers.StudentMapper;
import com.jamesobin.database.models.Enrollment;
import com.jamesobin.database.models.Student;
import com.jamesobin.database.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    public StudentServiceImpl(SqlSession sqlSession) {
        this.studentMapper = sqlSession.getMapper(StudentMapper.class);
        this.enrollmentMapper = sqlSession.getMapper(EnrollmentMapper.class);
    }

    @Override
    public Student addItem(Student input) throws Exception {
        int rows = studentMapper.insert(input);

        if (rows == 0) {
            throw new ServiceNoResultException("저장된 Student 데이터가 없습니다.");
        }

        return studentMapper.selectOne(input);
    }

    @Override
    public Student editItem(Student input) throws Exception {
        int rows = studentMapper.update(input);

        if (rows == 0) {
            throw new ServiceNoResultException("수정된 Student 데이터가 없습니다.");
        }

        return studentMapper.selectOne(input);
    }

    @Override
    public int deleteItem(Student input) throws Exception {
        int output = 0;

        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(input.getId());
        enrollmentMapper.deleteByStudentId(enrollment);

        output = studentMapper.delete(input);

        if (output == 0) {
            throw new ServiceNoResultException("Student 삭제된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public Student getItem(Student input) throws Exception {
        Student output = studentMapper.selectOne(input);

        if (output == null) {
            throw new ServiceNoResultException("Student 조회된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public List<Student> getList(Student input) throws Exception {
        return studentMapper.selectList(input);
    }

    @Override
    public int getCount(Student input) throws Exception {
        return studentMapper.selectCount(input);
    }
}
