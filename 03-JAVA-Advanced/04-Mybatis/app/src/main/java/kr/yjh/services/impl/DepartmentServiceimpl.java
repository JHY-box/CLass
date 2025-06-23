package kr.yjh.services.impl;

import java.util.List;


import org.apache.ibatis.session.SqlSession;

import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.mappers.DepartmentMapper;
import kr.yjh.mappers.EnrollmentMapper;
import kr.yjh.mappers.ProfessorMapper;
import kr.yjh.mappers.StudentMapper;
import kr.yjh.mappers.SubjectMapper;
import kr.yjh.models.Department;
import kr.yjh.models.Professor;
import kr.yjh.models.Student;
import kr.yjh.models.Subject;
import kr.yjh.services.DepartmentService;



/**
 * 학과 관리에 대한 비즈니스 로직을 구현하는 클래스
 * 인터페이스에 정의된 업무 목록을 상세하게 구현한다.
 * 메서드 Override 후, 최우선적으로 각 메서드의 리턴값을 준비해야 한다.
 */
public class DepartmentServiceimpl implements DepartmentService {

    /** SQL문을 구현하고 있는 Mapper객체 생성 */
    private DepartmentMapper departmentMapper;
    private EnrollmentMapper enrollmentMapper;
    private ProfessorMapper professorMapper;
    private StudentMapper studentMapper;
    private SubjectMapper subjectMapper;
    

    // Mapper 객체는 모든 메서드에서 사용해야 하므로 멤버변수 형태로 선언
    //멤버변수는 생성자를 통해 초기화 한다.
    //Mapper객체를 할당하기 위해서는 Mybatis의 sqlSession객체가 필요하므로
    //생성자 파라미터로 sqlSession객체를 요구한다.
    // ✅String에서는 객체 할당이 자동화 되므로 생성자 코드는 제거된다.
    public DepartmentServiceimpl(SqlSession sqlSession) {
        this.departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        this.enrollmentMapper = sqlSession.getMapper(EnrollmentMapper.class);
        this.professorMapper = sqlSession.getMapper(ProfessorMapper.class);
        this.studentMapper = sqlSession.getMapper(StudentMapper.class);
        this.subjectMapper = sqlSession.getMapper(SubjectMapper.class);
    }

    @Override
    public List<Department> getList(Department input) throws ServiceNoResultException, Exception {
        List<Department> output = null;
      
        output = departmentMapper.selectList(input);

        return output;
    }

    @Override
    public int getCount(Department input) throws ServiceNoResultException, Exception {
        //조회된 데이터 수를 리턴
        return departmentMapper.selectCount(input);
    }

    @Override
    public Department getItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        output = departmentMapper.selectOne(input);
        
        //조회 결과가 없을 경우 에러 상황으로 처리
       if(output == null) {
        throw new ServiceNoResultException("조회결과가 없습니다. ");
       }

        return output;
    }


    @Override
    public Department addItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;
       
        //리턴되는 값은 저장된 데이터의 수
        //생성된 PK는 파라미터로 전달된 input 객체의 적절한 멤버변수에 설정된다.
        int row = departmentMapper.insert(input);

        if (row == 0) {
            throw new ServiceNoResultException("저장된 데이터가 없습니다. ");
        }

        //저장 결과를 확인하기 위해서 단일해 조회 수행
        output = departmentMapper.selectOne(input);

        return output;
    }


    @Override
    public Department editItem(Department input) throws ServiceNoResultException, Exception {
        Department output = null;

        //리턴되는 값은 수정된 데이터의 수
        int rows = departmentMapper.update(input);

        if (rows == 0) {
            throw new ServiceNoResultException("수정된 데이터가 없습니다. ");
        }

        //저장 결과를 확인하기 위해서 단일해 조회 수행
        output = departmentMapper.selectOne(input);
        
        return output;
    }

    @Override
    public int deleteItem(Department input) throws ServiceNoResultException, Exception {
        int output = 0;

        //학과 삭제를 위한 데이터 처리 순서
        // 1️⃣) 특정 학과에 소속된 학생 혹은 특정 학과의 교수에게 지도를 받는 학생이 신청한 수강 내열을 삭제
        Student student = new Student();
        student.setDepartmentId(input.getId());
        enrollmentMapper.deleteByStudentId(student);

        // 2️⃣) 특정 학과에 소속되어 있거나, 특정 학과에 소속된 교수의 지도를 받는 학생 일괄 삭제
        studentMapper.deleteByStudentId(student);

        // 3️⃣) 특정 학과에서 개설된 과목이거나, 특정 학과에 소속된 교수가 담당하는 과목 일괄 삭제
        Subject subject = new Subject();
        subject.setDepartmentId(input.getId());
        subjectMapper.deleteByProfessorId(subject);

        // 4️⃣) 특정 학과에 소속된 교수 일괄 삭제
        Professor professor = new Professor();
        professor.setDepartmentId(input.getId());
        professorMapper.deleteByDepartmentId(professor);

        // 5️⃣) 학과 삭제
        output = departmentMapper.delete(input);

        if (output == 0) {
            throw new ServiceNoResultException("삭제된 데이터가 없습니다. ");
        }
      
        return output;
    }
}
