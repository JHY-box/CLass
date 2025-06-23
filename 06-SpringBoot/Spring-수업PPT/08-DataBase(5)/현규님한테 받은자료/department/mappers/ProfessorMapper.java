package kr.hyungyu.department.mappers;

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

import kr.hyungyu.department.models.Professor;


@Mapper
public interface ProfessorMapper {
    @Insert("INSERT INTO professors (" +
           "id, name, user_id, position, sal, hiredate, comm, email, phone, photo_url, status, department_id " +
           ") VALUES (" +
           "#{id}, #{name}, #{userId}, #{position}, #{sal}, #{hiredate}, #{comm}, #{email}, #{phone}, #{photoUrl}, #{status}, #{departmentId} " +
           ")")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Professor input);

    @Update("UPDATE professors SET " +
           " name = #{name}, user_id = #{userId}, position = #{position}, sal =  #{sal}, hiredate = #{hiredate}, comm = #{comm}, email = #{email}, "
            + " phone = #{phone}, photo_url = #{photoUrl}, status = #{status}, department_id = #{departmentId} "
            + " where id = #{id}")
    public int update(Professor input);

    @Delete("DELETE FROM professors WHERE id = #{id}")
    public int delete(Professor input);

    @Select("SELECT id, name, user_id, position, sal, hiredate, comm, email, phone, photo_url, status, department_id FROM professors " +
           "WHERE id = #{id}")
           @Results(id = "resultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "position", column = "position"),
            @Result(property = "sal", column = "sal"),
            @Result(property = "hiredate", column = "hiredate"),
            @Result(property = "comm", column = "comm"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "photoUrl", column = "photo_url"),
            @Result(property = "status", column = "status"),
            @Result(property = "departmentId", column = "department_id")
        })
    public Professor selectOne(Professor input);

    @Select("<script>"+
           "SELECT id, name, user_id, position, sal, hiredate, comm, email, phone, photo_url, status, department_id FROM professors" +
           "<where>" +
           "    <if test=\"id != null and id != ''\"> id = #{id} </if>" +
           "</where>" +
           "</script>")
    @ResultMap("resultMap")
    public List<Professor> selectList(Professor input);

    @Select("SELECT COUNT(*) FROM professors")
    public int selectCount(Professor input);

    /**
     *  특정 학과에 소속 되어 있는 교수 일괄 삭제
     * @param input - 학과 번호를 저장하고 있는 Professor 객체
     * @return - 삭제된 데이터 수
     */
    @Delete("DELETE FROM professors WHERE department_id = #{departmentId}")
    public int deleteByDepartmentId(Professor input);
}
