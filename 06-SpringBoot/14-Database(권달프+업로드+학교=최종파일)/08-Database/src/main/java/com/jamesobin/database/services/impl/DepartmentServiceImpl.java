package com.jamesobin.database.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.mappers.DepartmentMapper;
import com.jamesobin.database.mappers.EnrollmentMapper;
import com.jamesobin.database.mappers.ProfessorMapper;
import com.jamesobin.database.mappers.StudentMapper;
import com.jamesobin.database.mappers.SubjectMapper;
import com.jamesobin.database.models.Department;
import com.jamesobin.database.models.Professor;
import com.jamesobin.database.models.Student;
import com.jamesobin.database.models.Subject;
import com.jamesobin.database.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Autowired
    private ProfessorMapper professorMapper;

    @Autowired
    private StudentMapper studentMapper;
    
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public Department addItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        int rows = departmentMapper.insert(input);
        if (rows == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }

        output = departmentMapper.selectOne(input);

        return output;
    }

    @Override
    public int deleteItem(Department input) throws ServiceNoResultException, Exception {
        int output = 0;

        enrollmentMapper.deleteByDepartmentId(input);

        Student student = new Student();
        student.setDepartmentId(input.getId());
        studentMapper.deleteByDepartmentId(student);

        Subject subject = new Subject();
        subject.setDepartmentId(input.getId());
        subjectMapper.deleteByDepartmentId(subject);

        Professor professor = new Professor();
        professor.setDepartmentId(input.getId());
        professorMapper.deleteByDepartmentId(professor);

        output = departmentMapper.delete(input);

        if (output == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public Department editItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        int rows = departmentMapper.update(input);
        if (rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다.");
        }

        output = departmentMapper.selectOne(input);

        return output;
    }

    @Override
    public Department getItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        output = departmentMapper.selectOne(input);
        if (output == null) {
            throw new ServiceNoResultException("조회된 결과가 없습니다.");
        }

        return output;
    }

    @Override
    public List<Department> getList(Department input) throws ServiceNoResultException, Exception {
        List<Department> output = null;

        output = departmentMapper.selectList(input);
        if (output == null) {
            throw new ServiceNoResultException("조회된 결과가 없습니다.");
        }

        return output;
    }

    @Override
    public int getCount(Department input) throws ServiceNoResultException, Exception {
        int output = 0;

        output = departmentMapper.selectCount(input);

        return output;
    }

}
