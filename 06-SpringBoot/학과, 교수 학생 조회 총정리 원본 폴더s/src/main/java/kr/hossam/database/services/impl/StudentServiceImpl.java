package kr.hossam.database.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hossam.database.exceptions.ServiceNoResultException;
import kr.hossam.database.mappers.StudentMapper;
import kr.hossam.database.models.Student;
import kr.hossam.database.services.StudentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<Student> getList(Student input) throws ServiceNoResultException, Exception {
        return studentMapper.selectList(input);
    }

    @Override
    public Student getItem(Student input) throws ServiceNoResultException, Exception {
        Student output = studentMapper.selectOne(input);

        if (output == null) {
            throw new ServiceNoResultException("Student 조회된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public Student addItem(Student input) throws ServiceNoResultException, Exception {
        int rows = studentMapper.insert(input);

        if (rows == 0) {
            throw new ServiceNoResultException("저장된 Student 데이터가 없습니다.");
        }

        return studentMapper.selectOne(input);
    }

    @Override
    public Student editItem(Student input) throws ServiceNoResultException, Exception {
        int rows = studentMapper.update(input);

        if (rows == 0) {
            throw new ServiceNoResultException("수정된 Student 데이터가 없습니다.");
        }

        return studentMapper.selectOne(input);
    }

    @Override
    public int deleteItem(Student input) throws ServiceNoResultException, Exception {
        int rows = studentMapper.delete(input);

        if (rows == 0) {
            throw new ServiceNoResultException("Student 삭제된 데이터가 없습니다.");
        }

        return rows;
    }

    @Override
    public int getCount(Student input) throws ServiceNoResultException, Exception {
        return studentMapper.selectCount(input);
    }
}