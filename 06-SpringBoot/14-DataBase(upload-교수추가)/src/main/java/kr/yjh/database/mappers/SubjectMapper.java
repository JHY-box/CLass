package kr.yjh.database.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.yjh.database.models.Subject;

@Mapper
public interface SubjectMapper {
    @Insert("INSERT INTO subjects (id, name, credit, department_id, professor_id)"
            + " VALUES (#{id}, #{name}, #{credit}, #{departmentId}, #{professorId})" )
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Subject input);

    @Update("UPDATE subjects SET " +
           "id = #{id}, name = #{name}, credit = #{credit}, department_id = #{departmentId}, professor_id = #{professorId} " +
           "WHERE id = #{id}")
    public int update(Subject input);

    @Delete("DELETE FROM subjects WHERE id = #{id}")
    public int delete(Subject input);

    
    @Results(id="resultMap", value={
        @Result(property="id", column="id"),
        @Result(property="name", column="name"),
        @Result(property="credit", column="credit"),
        @Result(property="department_id", column="departmentId"),
        @Result(property="professor_id", column="professorId")
    })
    @Select("SELECT * FROM subjects " +
        "WHERE id = #{id}")
    public Subject selectOne(Subject input);

    @Select(
           "SELECT id, name, credit, department_id, professor_id "
           + "from subjects")
    @ResultMap("resultMap")
    public List<Subject> selectList(Subject input);

    @Select(
           "SELECT COUNT(*) FROM subjects")
    public int selectCount(Subject input);
    


    /**
     * 특정 학과에서 개설된 과목이거나, 특정 학과에 소속된 교수가 담당하는 과목 일괄 삭제
     * @param input - 학과 번호를 저장하고 있는 Subject 객체
     * @return - 삭제된 데이터 수
     */
    @Delete("DELETE FROM subjects  WHERE department_id=#{departmentId} OR professor_id IN (" +
            " SELECT id FROM professors WHERE department_id=#{departmentId}" +
            ")" )
    public int deleteByProfessorId(Subject input);

    /**
     * 특정 교수가 가르치는 과목 일괄 삭제
     * @param subject - 학과 번호를 저장하고 있는 subject 객체 
     * @return - 삭제된 데이터의 수
     */
    @Delete ("DELETE FROM subjects WHERE professor_id = #{professorId}")
    public int deleteByProfessorIdForProfessor(Subject subject);

    // 특정 교수가 가르치는 과목 일괄 null처리
    @Update ("update subjects set " +
            "professor_id = NULL " +
            "where professor_id = #{professorId}")
    public int updateByProfessor(Subject subject);
}
