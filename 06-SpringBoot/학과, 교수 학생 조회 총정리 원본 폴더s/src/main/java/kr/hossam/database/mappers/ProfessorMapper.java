package kr.hossam.database.mappers;

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
import kr.hossam.database.models.Professor;

@Mapper
public interface ProfessorMapper {
    /**
     * 특정 학과에 소속되어 있는 교수 일괄 삭제
     * @param input - 학과 번호를 저장하고 있는 Professor 객체
     * @return 삭제된 데이터 수
     */
    @Delete("DELETE FROM professors WHERE department_id=#{departmentId}")
    public int deleteByDepartmentId(Professor input);

    /** 교수 추가 */
    @Insert("INSERT INTO professors (" +
            "name, user_id, position, sal, hiredate, comm, " +
            "email, phone, photo_url, status, department_id" +
            ") VALUES (" +
            "#{name}, #{userId}, #{position}, #{sal}, #{hiredate}, #{comm}, " +
            "#{email}, #{phone}, #{photoUrl}, #{status}, #{departmentId}" +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Professor input);

    /** 교수 수정 */
    @Update("UPDATE professors SET " +
            "name=#{name}, user_id=#{userId}, position=#{position}, " +
            "sal=#{sal}, hiredate=#{hiredate}, comm=#{comm}, " +
            "email=#{email}, phone=#{phone}, photo_url=#{photoUrl}, " +
            "status=#{status}, department_id=#{departmentId} " +
            "WHERE id=#{id}")
    int update(Professor input);

    /** 교수 삭제 */
    @Delete("DELETE FROM professors WHERE id=#{id}")
    int delete(Professor input);

    /** 교수 단건 조회 */
    @Select("SELECT p.id, name, user_id, position, sal, hiredate, comm, p.email, " +
            "p.phone, photo_url, status, department_id, dname " +
            "FROM professors AS p " +
            "INNER JOIN departments AS d ON p.department_id = d.id " +
            "WHERE p.id = #{id}")
    @Results(id="resultMap", value={
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
        @Result(property = "departmentId", column = "department_id"),
        @Result(property = "dname", column = "dname") // 조인된 학과명
    })
    Professor selectOne(Professor input);

    /** 교수 목록 조회 */
    @Select("<script>" +
            "SELECT p.id, name, user_id, position, sal, hiredate, comm, p.email, " +
            "p.phone, photo_url, status, department_id, dname " +
            "FROM professors AS p " +
            "INNER JOIN departments AS d ON p.department_id = d.id " +
            "<where> " +
            // 괄호로 묶으면서 불필요한 AND,OR 키워드 제거 --> "AND |OR" 공백 주의!!!
            "   <trim prefix='(' suffix=')' prefixOverrides='AND |OR'> " +
            "       <if test='name != null and name != \"\"'>OR name LIKE CONCAT('%', #{name}, '%')</if> " +
            "       <if test='userId != null and userId != \"\"'>OR user_id LIKE CONCAT('%', #{userId}, '%')</if> " +
            "   </trim> " +
            "   <if test='departmentId != 0'>AND department_id = #{departmentId}</if> " +
            "</where>" +
            "ORDER BY p.id DESC " +
            "<if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>" +
            "</script>")
    @ResultMap("resultMap")
    List<Professor> selectList(Professor input);

    /** 교수 목록 카운트 */
    @Select("<script>" +
            "SELECT COUNT(*) FROM professors AS p " +
            "INNER JOIN departments AS d ON p.department_id = d.id " +
            "<where> " +
            "   <trim prefix='(' suffix=')' prefixOverrides='OR'> " +
            "       <if test='name != null and name != \"\"'>OR name LIKE CONCAT('%', #{name}, '%')</if> " +
            "       <if test='userId != null and userId != \"\"'>OR user_id LIKE CONCAT('%', #{userId}, '%')</if> " +
            "   </trim> " +
            "   <if test='departmentId != 0'>AND department_id = #{departmentId}</if> " +
            "</where>" +
            "</script>")
    int selectCount(Professor input);
}