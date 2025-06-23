package kr.yjh.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import kr.yjh.models.Subject;

@Mapper
public interface SubjectMapper {
    
    /**
     * 특정 학과에서 개설된 과목이거나, 특정 학과에 소속된 교수가 담당하는 과목 일괄 삭제
     * @param input - 학과 번호를 저장하고 있는 Subject 객체
     * @return - 삭제된 데이터 수
     */
    @Delete("DELETE FROM subjects  WHERE department_id=#{departmentId} OR professor_id IN (" +
            " SELECT id FROM professors WHERE department_id=#{departmentId}" +
            ")" )
    public int deleteByProfessorId(Subject input);
}
