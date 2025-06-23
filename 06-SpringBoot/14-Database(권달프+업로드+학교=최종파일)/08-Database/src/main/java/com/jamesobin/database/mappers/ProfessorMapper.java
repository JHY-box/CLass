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
import com.jamesobin.database.models.Professor;

@Mapper
public interface ProfessorMapper {
    @Insert("INSERT INTO professors "
            + "(id, name, user_id, position, sal, hiredate, comm, email, phone, photo_url, status, department_id) "
            + "VALUES (#{id}, #{name}, #{userId}, #{position}, #{sal}, #{hiredate}, #{comm}, #{email}, #{phone}, #{photoUrl}, #{status}, #{departmentId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Professor input);

    @Update("UPDATE professors SET "
            + "name=#{name}, user_id=#{userId}, position=#{position}, sal=#{sal}, hiredate=#{hiredate}, comm=#{comm}, email=#{email}, phone=#{phone}, photo_url=#{photoUrl}, status=#{status}, department_id=#{departmentId} "
            + "WHERE id=#{id}")
    public int update(Professor input);

    @Select("SELECT p.id, name, user_id, position, sal, hiredate, comm, p.email, p.phone, photo_url, status, department_id, dname"
            + " FROM professors AS p"
            + " INNER JOIN departments AS d ON p.department_id = d.id"
            + " WHERE p.id=#{id}")
    @Results(id = "resultMap", value = {
        @Result(property = "id", column = "id")
        , @Result(property = "name", column = "name")
        , @Result(property = "userId", column = "user_id")
        , @Result(property = "position", column = "position")
        , @Result(property = "sal", column = "sal")
        , @Result(property = "hiredate", column = "hiredate")
        , @Result(property = "comm", column = "comm")
        , @Result(property = "email", column = "email")
        , @Result(property = "phone", column = "phone")
        , @Result(property = "photoUrl", column = "photo_url")
        , @Result(property = "status", column = "status")
        , @Result(property = "departmentId", column = "department_id")
        , @Result(property = "dname", column = "dname")         // 조인된 학과명
    })
    public Professor selectOne(Professor input);

    @Select("<script>"
            + "SELECT p.id, name, user_id, position, sal, hiredate, comm, p.email, p.phone, photo_url, status, department_id, dname FROM professors AS p"
            + " INNER JOIN departments AS d ON p.department_id = d.id"
            + " <where>"
            // 괄호를 묶으면서 불필요한 AND, OR 키워드 제거 --> "AND |OR" 공백 주의!!
            + " <trim prefix='(' suffix=')' prefixOverrides='AND |OR'>"
            + " <if test='name !=null and name != \"\"'>name LIKE CONCAT('%', #{name}, '%')</if>"
            + " <if test='userId != null and userId != \"\"'>OR user_id LIKE CONCAT('%', #{userId}, '%')</if>"
            + " </trim>"
            + " <if test='departmentId != 0'>AND department_id=#{departmentId}</if>"
            // 체크박스에 의해 선택된 직급배열이 존재하고 길이가 0보다 클 때
            + " <if test='positionArray != null and positionArray.length > 0'>"
            + " AND position IN"
            // MyBatis의 foreach 구문을 사용하여 positionArray의 값을 IN절로 처리
            + " <foreach item='item' index='index' collection='positionArray' open='(' separator=',' close=')'>"
            + " #{item}"
            + " </foreach>"
            + " </if>"
            + " </where>"
            + " ORDER BY p.id DESC"
            + " <if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>"
            + "</script>")
    @ResultMap("resultMap")
    public List<Professor> selectList(Professor input);

    @Select("<script>"
            + "SELECT COUNT(*) FROM professors AS p"
            + " INNER JOIN departments AS d ON p.department_id = d.id"
            // Dynamic SQL
            // if문에 조건이 명시되는 것은 컬럼이름이 아닌 Beans의 멤버변수!!!
            + " <where>"
            + " <trim prefix='(' suffix=')' prefixOverrides='AND |OR'>"
            + " <if test='name != null and name != \"\"'>name LIKE CONCAT('%', #{name}, '%')</if>"
            + " <if test='userId != null and userId != \"\"'>OR user_id LIKE CONCAT('%', #{userId}, '%')</if>"
            + " </trim>"
            + " <if test='departmentId != 0'>AND department_id=#{departmentId}</if>"
            // 체크박스에 의해 선택된 직급배열이 존재하고 길이가 0보다 클 때
            + " <if test='positionArray != null and positionArray.length > 0'>"
            + " AND position IN"
            // MyBatis의 foreach 구문을 사용하여 positionArray의 값을 IN절로 처리
            + " <foreach item='item' index='index' collection='positionArray' open='(' separator=',' close=')'>"
            + " #{item}"
            + " </foreach>"
            + " </if>"
            + " </where>"
            + "</script>")
    public int selectCount(Professor input);

    @Delete("DELETE FROM professors WHERE id=#{id}")
    public int delete(Professor input);

    @Delete("DELETE FROM professors WHERE department_id=#{departmentId}")
    public int deleteByDepartmentId(Professor input);

    /** 아이디가 일치하는 데이터 카운트 */
    @Select("SELECT COUNT(*) FROM professors WHERE user_id=#{userId}")
    int selectCountById(Professor input);
}
