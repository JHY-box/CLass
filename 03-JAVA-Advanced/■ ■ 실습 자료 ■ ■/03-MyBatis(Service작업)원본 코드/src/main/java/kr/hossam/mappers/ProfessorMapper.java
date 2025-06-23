package kr.hossam.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import kr.hossam.models.Professor;

@Mapper
public interface ProfessorMapper {
    /**
     * 특정 학과에 소속되어 있는 교수 일괄 삭제
     * @param input - 학과 번호를 저장하고 있는 Professor 객체
     * @return 삭제된 데이터 수
     */
    @Delete("DELETE FROM professors WHERE department_id=#{departmentId}")
    public int deleteByDepartmentId(Professor input);
}
