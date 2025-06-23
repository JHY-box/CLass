package kr.hyungyu.department.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hyungyu.department.exceptions.ServiceNoResultException;
import kr.hyungyu.department.mappers.DepartmentMapper;
import kr.hyungyu.department.mappers.EnrollmentMapper;
import kr.hyungyu.department.mappers.ProfessorMapper;
import kr.hyungyu.department.mappers.StudentMapper;
import kr.hyungyu.department.mappers.SubjectMapper;
import kr.hyungyu.department.models.Department;
import kr.hyungyu.department.models.Professor;
import kr.hyungyu.department.models.Student;
import kr.hyungyu.department.models.Subject;
import kr.hyungyu.department.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{ // mapper 반환 대행

    @Autowired
    private DepartmentMapper mapper; 

    @Autowired
    private EnrollmentMapper enrollmentMapper;

    @Autowired
    private ProfessorMapper professorMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Department> getList(Department input) throws ServiceNoResultException, Exception {
        List<Department> output = null;
        output = mapper.selectList(input);
        return output;
    }

    @Override
    public int getCount(Department input) throws ServiceNoResultException, Exception {
        int output = 0;
        output = mapper.selectCount(input);
        return output;
    }

    @Override
    public Department getItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;
        output = mapper.selectOne(input);

        if (output == null){ // 단일행 조회는 값이 없는 것을 따로 에러로 처리해 주어야 한다.
            throw new ServiceNoResultException("조회결과가 없습니다.");
        }
        return output;
    }

    @Override
    public Department addItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        int row = mapper.insert(input); // 넣은 행의 개수 반환

        if (row == 0){
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }

        output = mapper.selectOne(input); // input에 저장된 pk를 이용해서 다시 select

        return output;
    }

    @Override
    public Department editItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        int row = mapper.update(input); // 수정한 행의 개수 반환

        if (row == 0){
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }

        output = mapper.selectOne(input); // input에 저장된 pk를 이용해서 다시 select

        return output;
    }

    @Override
    public int deleteItem(Department input) throws ServiceNoResultException, Exception {
        int output = 0;

        // 학과 삭제를 위한 데이터 처리 순서
        // 1) 수강 내역 삭제
        Student student = new Student();
        student.setDepartmentId(input.getId());

        enrollmentMapper.deleteByStudentId(student);

        // 2) 학생 일괄 삭제
        studentMapper.deleteByDepartmentId(student);

        // 3) 과목 일괄 삭제
        Subject subject = new Subject();
        subject.setDepartmentId(input.getId());
        subjectMapper.deleteByProfessorId(subject);

        // 4) 교수 일괄 삭제
        Professor professor = new Professor();
        professor.setDepartmentId(input.getId());
        professorMapper.deleteByDepartmentId(professor);

        // 5) 학과 삭제
        output = mapper.delete(input);

        if (output == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
        }


        return output;
    }
}
