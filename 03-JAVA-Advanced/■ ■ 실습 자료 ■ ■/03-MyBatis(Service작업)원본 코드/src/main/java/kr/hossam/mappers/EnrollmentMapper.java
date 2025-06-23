package kr.hossam.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import kr.hossam.models.Student;

@Mapper
public interface EnrollmentMapper {
    /**
     * 특정 학과에 소속된 학생 혹은 특정 학과의 교수에게 지도를 받는 학생이 신청한 수강 내역을 삭제
     * @param input - 삭제하려는 학과 번호가 저장된 Student 클래스의 객체
     * @return 삭제된 데이터 수
     */
    @Delete("DELETE FROM enrollments WHERE student_id IN (" +
            "   SELECT id FROM students " +
            "   WHERE department_id=#{departmentId} OR " +
            "         professor_id IN (" +
            "           SELECT id FROM professors WHERE department_id=#{departmentId}" +
            "         )" +
            ") OR subject_id IN (" +
            "   SELECT id FROM subjects WHERE professor_id IN (" +
            "       SELECT id FROM professors WHERE department_id=#{departmentId}" +
            "   )"+
            ")")
    public int deleteByStudentId(Student input);
}
