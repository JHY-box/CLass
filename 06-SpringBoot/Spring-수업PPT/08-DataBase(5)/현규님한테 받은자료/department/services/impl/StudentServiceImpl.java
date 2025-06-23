package kr.hyungyu.department.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hyungyu.department.exceptions.ServiceNoResultException;
import kr.hyungyu.department.mappers.EnrollmentMapper;
import kr.hyungyu.department.mappers.StudentMapper;
import kr.hyungyu.department.models.Student;
import kr.hyungyu.department.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper = null;

    @Autowired
    EnrollmentMapper enrollmentMapper = null;

    @Override
    public Student addItem(Student student) throws ServiceNoResultException, Exception {
        if (studentMapper.insert(student) == 0){
            throw new ServiceNoResultException("조회결과가 없습니다.");
        }
        return studentMapper.selectOne(student);
    }

    @Override
    public Student getItem(Student student) throws ServiceNoResultException, Exception {
        Student output = studentMapper.selectOne(student);
        if (output == null){
            throw new ServiceNoResultException("조회결과가 없습니다.");
        }
        return output;
    }

    @Override
    public List<Student> getList(Student student) throws ServiceNoResultException, Exception {
        return studentMapper.selectList(student);
    }

    @Override
    public Student editItem(Student student) throws ServiceNoResultException, Exception {
        if (studentMapper.update(student) == 0){
            throw new ServiceNoResultException("조회결과가 없습니다.");
        }
        return studentMapper.selectOne(student);
    }

    @Override
    public int deleteItem(Student student) throws ServiceNoResultException, Exception {
        // enrollment 삭제
        enrollmentMapper.deleteByStudentIdOnly(student);

        // student 삭제
        int output = studentMapper.delete(student);
        return output;
    }

    @Override
    public int getCount(Student student) throws ServiceNoResultException, Exception {
        return studentMapper.selectCount(student);
    }
}
