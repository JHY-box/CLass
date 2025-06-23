package com.jamesobin.database.mappers;

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
import com.jamesobin.database.models.Subject;

@Mapper
public interface SubjectMapper {
    @Insert("INSERT INTO subjects"
            + " (id, name, credit, department_id, professor_id)"
            + " VALUES (#{id}, #{name}, #{credit}, #{departmentId}, #{professorId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Subject input);

    @Update("UPDATE subjects SET"
            + " name=#{name}, credit=#{credit}, department_id=#{departmentId}, professor_id=#{professorId}"
            + " WHERE id=#{id}")
    public int update(Subject input);

    @Select("SELECT id, name, credit, department_id, professor_id FROM subjects WHERE id=#{id}")
    @Results(id = "resultMap", value = {
        @Result(property = "id", column = "id")
        , @Result(property = "name", column = "name")
        , @Result(property = "credit", column = "credit")
        , @Result(property = "departmentId", column = "department_id")
        , @Result(property = "professorId", column = "professor_id")
    })
    public Subject selectOne(Subject input);

    @Select("SELECT id, name, credit, department_id, professor_id FROM subjects")
    @ResultMap("resultMap")
    public List<Subject> selectList(Subject input);

    @Select("SELECT COUNT(*) FROM subjects")
    public int selectCount(Subject input);

    @Delete("DELETE FROM subjects WHERE id=#{id}")
    public int delete(Subject input);

    @Delete("DELETE FROM subjects WHERE professor_id=#{professorId}")
    public int deleteByProfessorId(Subject input);
    
    @Delete("DELETE FROM subjects WHERE department_id=#{departmentId} OR professor_id IN ("
            + "SELECT id FROM professors WHERE department_id=#{departmentId}"
            + ")")
    public int deleteByDepartmentId(Subject input);

    @Update("UPDATE subjects SET professor_id = NULL WHERE professor_id = #{professorId}")
    public int updateProfessorIdToNull(Subject input);
}
