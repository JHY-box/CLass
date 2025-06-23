package com.jamesobin.database.services.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jamesobin.database.exceptions.AlreadyExistsException;
import com.jamesobin.database.exceptions.ServiceNoResultException;
import com.jamesobin.database.mappers.ProfessorMapper;
import com.jamesobin.database.mappers.StudentMapper;
import com.jamesobin.database.mappers.SubjectMapper;
import com.jamesobin.database.models.Professor;
import com.jamesobin.database.models.Student;
import com.jamesobin.database.models.Subject;
import com.jamesobin.database.services.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorMapper professorMapper;
    
    @Autowired
    private StudentMapper studentMapper;
    
    @Autowired
    private SubjectMapper subjectMapper;

    public ProfessorServiceImpl(SqlSession sqlSession) {
        this.professorMapper = sqlSession.getMapper(ProfessorMapper.class);
        this.studentMapper = sqlSession.getMapper(StudentMapper.class);
        this.subjectMapper = sqlSession.getMapper(SubjectMapper.class);
    }

    @Override
    public Professor addItem(Professor input) throws ServiceNoResultException, AlreadyExistsException, Exception {
        // 아이디 중복 검사 수행
        Professor temp = new Professor();
        temp.setUserId(input.getUserId());

        if(professorMapper.selectCountById(temp) > 0) {
            throw new AlreadyExistsException("이미 등록된 사용자 아이디입니다.");
        }
        
        int rows = professorMapper.insert(input);

        if (rows == 0) {
            throw new ServiceNoResultException("저장된 Professor 데이터가 없습니다.");
        }

        return professorMapper.selectOne(input);
    }

    @Override
    public Professor editItem(Professor input) throws Exception {
        int rows = professorMapper.update(input);

        if (rows == 0) {
            throw new ServiceNoResultException("수정된 Professor 데이터가 없습니다.");
        }

        return professorMapper.selectOne(input);
    }

    @Override
    public int deleteItem(Professor input) throws Exception {
        int output = 0;

        Student student = new Student();
        student.setProfessorId(input.getId());
        studentMapper.updateProfessorIdToNull(student);

        Subject subject = new Subject();
        subject.setProfessorId(input.getId());
        subjectMapper.updateProfessorIdToNull(subject);

        output = professorMapper.delete(input);

        if (output == 0) {
            throw new ServiceNoResultException("Professor 삭제된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public Professor getItem(Professor input) throws Exception {
        Professor output = professorMapper.selectOne(input);

        if (output == null) {
            throw new ServiceNoResultException("Professor 조회된 데이터가 없습니다.");
        }

        return output;
    }

    @Override
    public List<Professor> getList(Professor input) throws Exception {
        return professorMapper.selectList(input);
    }

    @Override
    public int getCount(Professor input) throws Exception {
        return professorMapper.selectCount(input);
    }
}
