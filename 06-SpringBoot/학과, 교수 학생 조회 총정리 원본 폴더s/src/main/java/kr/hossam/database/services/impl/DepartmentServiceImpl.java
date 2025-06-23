package kr.hossam.database.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.hossam.database.exceptions.ServiceNoResultException;
import kr.hossam.database.mappers.DepartmentMapper;
import kr.hossam.database.mappers.EnrollmentMapper;
import kr.hossam.database.mappers.ProfessorMapper;
import kr.hossam.database.mappers.StudentMapper;
import kr.hossam.database.mappers.SubjectMapper;
import kr.hossam.database.models.Department;
import kr.hossam.database.models.Professor;
import kr.hossam.database.models.Student;
import kr.hossam.database.models.Subject;
import kr.hossam.database.services.DepartmentService;

/**
 * 학과 관리에 대한 비즈니스 로직을 구현하는 클래스
 * 인터페이스에 정의된 업무 목록을 상세하게 구현한다.
 * 메서드 Override 후, 최우선적으로 각 메서드의 리턴값을 준비해야 한다.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    /** SQL문을 구현하고 있는 Mapper객체 자동 주입 */
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
    public List<Department> getList(Department input) throws ServiceNoResultException, Exception {
        List<Department> output = null;

        output = departmentMapper.selectList(input);

        return output;
    }

    @Override
    public int getCount(Department input) throws ServiceNoResultException, Exception {
        // 조회된 데이터 수를 리턴
        return departmentMapper.selectCount(input);
    }

    @Override
    public Department getItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        output = departmentMapper.selectOne(input);

        // 조회 결과가 없을 경우 에러 상황으로 처리
        if (output == null) {
            throw new ServiceNoResultException("조회결과가 없습니다.");
        }

        return output;
    }

    @Override
    public Department addItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        // 리턴되는 값은 저장된 데이터의 수
        // 생성된 PK는 파라미터로 전달된 input 객체의 적절한 멤버변수에 설정된다.
        int rows = departmentMapper.insert(input);

        if (rows == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다.");
        }

        // 저장 결과를 확인하기 위해서 단일행 조회 수행
        output = departmentMapper.selectOne(input);

        return output;
    }

    @Override
    public Department editItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        // 리턴되는 값은 수정된 데이터의 수
        int rows = departmentMapper.update(input);

        if (rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다.");
        }

        // 저장 결과를 확인하기 위해서 단일행 조회 수행
        output = departmentMapper.selectOne(input);

        return output;
    }

    @Override
    public int deleteItem(Department input) throws ServiceNoResultException, Exception {
        int output = 0;

        // 학과 삭제를 위한 데이터 처리 순서
        // 1) 특정 학과에 소속된 학생 혹은 특정 학과의 교수에게 지도를 받는 학생이 신청한 수강 내역을 삭제
        Student student = new Student();
        student.setDepartmentId(input.getId());
        enrollmentMapper.deleteByStudentId(student);

        // 2) 특정 학과에 소속되어 있거나, 특정 학과에 소속된 교수의 지도를 받는 학생 일괄 삭제
        studentMapper.deleteByDepartmentId(student);

        // 3) 특정 학과에서 개설된 과목이거나, 특정 학과에 소속된 교수가 담당하는 과목 일괄 삭제
        Subject subject = new Subject();
        subject.setDepartmentId(input.getId());
        subjectMapper.deleteByProfessorId(subject);

        // 4) 특정 학과에 소속된 교수 일괄 삭제
        Professor professor = new Professor();
        professor.setDepartmentId(input.getId());
        professorMapper.deleteByDepartmentId(professor);

        // 5) 학과 삭제
        output = departmentMapper.delete(input);

        if (output == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다.");
        }

        return output;
    }
}
