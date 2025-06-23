package kr.hossam.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import kr.hossam.models.Student;

@Mapper
public interface StudentMapper {
    /**
     * 특정 학과에 소속되어 있거나, 특정 학과에 소속된 교수의 지도를 받는 학생 일괄 삭제
     * @param input - 학과 번호를 저장하고 있는 Student 객체
     * @return 삭제된 데이터 수
     */
    @Delete("DELETE FROM students WHERE department_id=#{departmentId} OR " +
            "professor_id IN (SELECT id FROM professors WHERE department_id=#{departmentId})")
    public int deleteByDepartmentId(Student input);
}
