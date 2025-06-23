package kr.yjh.mappers;

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

import kr.yjh.models.Professors;

@Mapper
public interface ProfessorsMapper {
    @Insert("INSERT INTO professors (" +
           "id, name, user_id, position, sal, hiredate, comm, email, phone, photo_url, status, department_id " +
           ") VALUES (" +
           " #{id}, #{name}, #{userId}, #{position}, #{sal}, #{hiredate}, #{comm}, #{email}, #{phone}, #{photoUrl}, #{status}, #{departmentId}" +
           ")")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Professors input);
    //⭕VALUES (#{멤버변수},#{멤버변수},......) / 멤버변수-> models 에서 가져옴
    ////////////////////////////////////////////////////////////////////////////////////////////
    @Update("UPDATE professors SET " +
           " id=#{id}, name=#{name}, user_id=#{userId}, position=#{position}, sal=#{sal}, hiredate=#{hiredate}, comm=#{comm}, " +
           "email=#{email}, phone=#{phone}, photo_url=#{photoUrl}, status=#{status}, department_id=#{departmentId} " +
           "WHERE id=#{id}")
    public int update(Professors input);

    ////////////////////////////////////////////////////////////////////////////////////////////
    @Delete("DELETE FROM professors WHERE id=#{id}")
    public int delete(Professors input);

    ////////////////////////////////////////////////////////////////////////////////////////////
    @Select("SELECT id, name, user_id, position, sal, hiredate, comm, email, phone, photo_url, status, department_id FROM professors " +
           "WHERE id=#{id}")
    @Results(id="resultMap", value={
        @Result(property="id", column="id"),
        @Result(property="name", column="name"),
        @Result(property="userId", column="user_id"),
        @Result(property="position", column="position"),
        @Result(property="sal", column="sal"),
        @Result(property="hiredate", column="hiredate"),
        @Result(property="comm", column="comm"),
        @Result(property="email", column="email"),
        @Result(property="phone", column="phone"),
        @Result(property="photoUrl", column="photo_url"),
        @Result(property="status", column="status"),
        @Result(property="departmentId", column="department_id")
    })
    public Professors selectOne(Professors input);

    ////////////////////////////////////////////////////////////////////////////////////////////
    @Select("<script>"+
           "SELECT id, name, user_id, position, sal, hiredate, comm, email, phone, photo_url, status, department_id FROM professors" +
           "<where>" +
           "    <if test=\"id != null and id != ''\">id LIKE CONCAT('%', #{id}, '%')</if>" +
           "</where>" +
           "</script>")
    @ResultMap("resultMap")
    public List<Professors> selectList(Professors input);
    //⭕id 로 테스트/  name 으로 테스트는 의미 없음/ PK로 테스트
    ////////////////////////////////////////////////////////////////////////////////////////////
    @Select("<script>" +
           "SELECT COUNT(*) FROM professors" +
           "<where>" +
           "    <if test=\"id != null and id != ''\">id LIKE CONCAT('%', #{id}, '%')</if>" +
           "</where>" +
           "</script>")
    public int selectCount(Professors input);
}

