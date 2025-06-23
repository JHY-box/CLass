package kr.hyungyu.department.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hyungyu.department.exceptions.ServiceNoResultException;
import kr.hyungyu.department.mappers.EnrollmentMapper;
import kr.hyungyu.department.mappers.ProfessorMapper;
import kr.hyungyu.department.mappers.StudentMapper;
import kr.hyungyu.department.mappers.SubjectMapper;
import kr.hyungyu.department.models.Professor;
import kr.hyungyu.department.models.Student;
import kr.hyungyu.department.models.Subject;
import kr.hyungyu.department.services.ProfessorService;

@Service
public class ProfessorServiceimpl implements ProfessorService {
    @Autowired
    ProfessorMapper professorMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    EnrollmentMapper enrollmentMapper;
    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public Professor editItem(Professor params) throws ServiceNoResultException, Exception {
        if (professorMapper.update(params) == 0){
            throw new ServiceNoResultException("정상적으로 처리되지 않았습니다.");
        }
        return professorMapper.selectOne(params);
    }

    @Override
    public int getCount(Professor params) throws ServiceNoResultException, Exception {
        return professorMapper.selectCount(params);
    }

    @Override
    public Professor getItem(Professor params) throws ServiceNoResultException, Exception {
        Professor ouput = professorMapper.selectOne(params);
        if (ouput == null){
            throw new ServiceNoResultException("정상적으로 처리되지 않았습니다.");
        }
        return ouput;
    }

    @Override
    public List<Professor> getList(Professor params) throws ServiceNoResultException, Exception {
        return professorMapper.selectList(params);
    }

    @Override
    public int deleteItem(Professor params) throws ServiceNoResultException, Exception {
        int professorskey = params.getId();

        Student student1 = new Student();
        student1.setProfessorId(professorskey);

        Subject subject1 = new Subject();
        subject1.setProfessorId(professorskey);
        
        
        // 교수의 지도학생의 지도교수 명단을 null로 바꿈
        studentMapper.updateByprofessorId(student1);
        // 교수가 담당하는 과목의 교수명을 null로 변경
        subjectMapper.updateByprofessor(subject1);
        // 교수 삭제
        int output = professorMapper.delete(params);

        if (output == 0){
            throw new ServiceNoResultException("정상적으로 처리되지 않았습니다.");
        }

        return output;
    }

    @Override
    public int addItem(Professor params) throws ServiceNoResultException, Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }
}