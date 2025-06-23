package kr.hossam.database.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.hossam.database.exceptions.ServiceNoResultException;
import kr.hossam.database.mappers.ProfessorMapper;
import kr.hossam.database.mappers.StudentMapper;
import kr.hossam.database.mappers.SubjectMapper;
import kr.hossam.database.models.Professor;
import kr.hossam.database.models.Student;
import kr.hossam.database.models.Subject;
import kr.hossam.database.services.ProfessorService;

/**
 * 교수 관리에 대한 비즈니스 로직을 구현하는 클래스
 * 인터페이스에 정의된 업무 목록을 상세하게 구현한다.
 */
@Service
public class ProfessorServiceImpl implements ProfessorService {

    /** SQL문을 구현하고 있는 Mapper객체 자동 주입 */
    @Autowired
    private ProfessorMapper professorMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Professor> getList(Professor input) throws ServiceNoResultException, Exception {
        return professorMapper.selectList(input);
    }

    @Override
    public int getCount(Professor input) throws ServiceNoResultException, Exception {
        return professorMapper.selectCount(input);
    }

    @Override
    public Professor getItem(Professor input) throws ServiceNoResultException, Exception {
        Professor output = professorMapper.selectOne(input);
        if (output == null) {
            throw new ServiceNoResultException("조회결과가 없습니다.");
        }
        return output;
    }

    @Override
    public Professor addItem(Professor input) throws ServiceNoResultException, Exception {
        int rows = professorMapper.insert(input);
        if (rows == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }
        Professor output = professorMapper.selectOne(input);
        return output;
    }

    @Override
    public Professor editItem(Professor input) throws ServiceNoResultException, Exception {
        int rows = professorMapper.update(input);
        if (rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다.");
        }
        Professor output = professorMapper.selectOne(input);
        return output;
    }

    @Override
    public int deleteItem(Professor input) throws ServiceNoResultException, Exception {
        // 교수 삭제를 위한 데이터 처리 순서
        // 1) 교수가 담당하는 학생에 대해 담당교수 제거
        Student studentInput = new Student();
        studentInput.setProfessorId(input.getId());
        studentMapper.updateProfessorIdToNull(studentInput);

        // 2) 교수의 수업을 삭제
        Subject subjectInput = new Subject();
        subjectInput.setProfessorId(input.getId());
        subjectMapper.updateProfessorIdToNull(subjectInput);

        // 3) 교수 정보를 삭제
        int output = professorMapper.delete(input);
        if (output == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
        }
        return output;
    }
}