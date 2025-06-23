package kr.yjh.database.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.yjh.database.exceptions.ServiceNoResultException;
import kr.yjh.database.mappers.EnrollmentMapper;
import kr.yjh.database.mappers.ProfessorMapper;
import kr.yjh.database.mappers.StudentMapper;
import kr.yjh.database.mappers.SubjectMapper;
import kr.yjh.database.models.Professor;
import kr.yjh.database.models.Student;
import kr.yjh.database.models.Subject;
import kr.yjh.database.services.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    
    @Autowired
    ProfessorMapper professorMapper;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    EnrollmentMapper enrollmentMapper;

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public Professor editItem(Professor input) throws ServiceNoResultException, Exception {
        if (professorMapper.update(input) == 0){
            throw new ServiceNoResultException("정상적으로 처리되지 않았습니다.");
        }
        return professorMapper.selectOne(input);
    }

    @Override
    public int getCount(Professor input) throws ServiceNoResultException, Exception {
        return professorMapper.selectCount(input);
    }

    @Override
    public Professor getItem(Professor input) throws ServiceNoResultException, Exception {
        Professor ouput = professorMapper.selectOne(input);
        if (ouput == null){
            throw new ServiceNoResultException("정상적으로 처리되지 않았습니다.");
        }
        return ouput;
    }

    @Override
    public List<Professor> getList(Professor input) throws ServiceNoResultException, Exception {
        return professorMapper.selectList(input);
    }

    @Override
    public int deleteItem(Professor input) throws ServiceNoResultException, Exception {
        int professorskey = input.getId();

        Student student1 = new Student();
        student1.setProfessorId(professorskey);

        Subject subject1 = new Subject();
        subject1.setProfessorId(professorskey);
        
        
        // 교수의 지도학생의 지도교수 명단을 null로 바꿈
        studentMapper.updateByProfessorId(student1);                ////////////////////////////////////////////////////////////////////////////////
        // 교수가 담당하는 과목의 교수명을 null로 변경
        subjectMapper.updateByProfessor(subject1);
        // 교수 삭제
        int output = professorMapper.delete(input);

        if (output == 0){
            throw new ServiceNoResultException("정상적으로 처리되지 않았습니다.");
        }

        return output;
    }

    @Override
    public int addItem(Professor input) throws ServiceNoResultException, Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }
}