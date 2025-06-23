package kr.hossam.database.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import kr.hossam.database.models.Subject;

@Mapper
public interface SubjectMapper {
    /**
     * 특정 학과에서 개설된 과목이거나, 특정 학과에 소속된 교수가 담당하는 과목 일괄 삭제
     * @param input - 학과 번호를 저장하고 있는 Subject 객체
     * @return 삭제된 데이터 수
     */
    @Delete("DELETE FROM subjects WHERE department_id=#{departmentId} OR professor_id IN (" +
            "    SELECT id FROM professors WHERE department_id=#{departmentId}" +
            ")")
    public int deleteByProfessorId(Subject input);

    /**
     * 특정 교수의 담당 과목에 대해 담당교수 번호를 NULL로 변경
     * @param input - 교수 번호를 저장하고 있는 Subject 객체
     * @return 변경된 데이터 수
     */
    @Update("UPDATE subjects SET professor_id = NULL WHERE professor_id = #{professorId}")
    public int updateProfessorIdToNull(Subject input);
}