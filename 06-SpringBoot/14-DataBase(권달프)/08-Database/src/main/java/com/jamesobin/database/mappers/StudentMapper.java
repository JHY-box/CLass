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
import com.jamesobin.database.models.Student;

@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO students "
            + "(id, name, user_id, grade, idnum, birthdate, phone, height, weight, email, gender, status, photo_url, admission_date, graduation_date, department_id, professor_id) "
            + "VALUES (#{id}, #{name}, #{userId}, #{grade}, #{idnum}, #{birthdate}, #{phone}, #{height}, #{weight}, #{email}, #{gender}, #{status}, #{photoUrl}, #{admissionDate}, #{graduationDate}, #{departmentId}, #{professorId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Student input);

    @Update("UPDATE students SET"
            + " name=#{name}, user_id=#{userId}, grade=#{grade}, idnum=#{idnum}, birthdate=#{birthdate}, phone=#{phone}, height=#{height}, weight=#{weight}, email=#{email}"
            + ", gender=#{gender}, status=#{status}, photo_url=#{photoUrl}, admission_date=#{admissionDate}, graduation_date=#{graduationDate}, department_id=#{departmentId}, professor_id=#{professorId}"
            + " WHERE id=#{id}")
    public int update(Student input);

    @Select("SELECT s.id, s.name AS sname, s.user_id, s.grade, s.idnum, s.birthdate, s.phone, s.height, s.weight, s.email, s.gender, s.status, s.photo_url, s.admission_date, s.graduation_date, s.department_id, s.professor_id, d.dname, p.name AS pname"
            + " FROM students AS s"
            + " INNER JOIN departments AS d ON s.department_id = d.id"
            + " INNER JOIN professors AS p ON s.professor_id = p.id"
            + " WHERE s.id=#{id}")
    @Results(id = "resultMap", value = {
        @Result(property = "id", column = "id")
        , @Result(property = "name", column = "sname")
        , @Result(property = "userId", column = "user_id")
        , @Result(property = "grade", column = "grade")
        , @Result(property = "idnum", column = "idnum")
        , @Result(property = "birthdate", column = "birthdate")
        , @Result(property = "phone", column = "phone")
        , @Result(property = "height", column = "height")
        , @Result(property = "weight", column = "weight")
        , @Result(property = "email", column = "email")
        , @Result(property = "gender", column = "gender")
        , @Result(property = "status", column = "status")
        , @Result(property = "photoUrl", column = "photo_url")
        , @Result(property = "admissionDate", column = "admission_date")
        , @Result(property = "graduationDate", column = "graduation_date")
        , @Result(property = "departmentId", column = "department_id")
        , @Result(property = "professorId", column = "professor_id")
        , @Result(property = "dname", column = "dname") 
        , @Result(property = "professorName", column="pname")
    })
    public Student selectOne(Student input);

    @Select("<script>"
            + "SELECT s.id, s.name AS sname, s.user_id, s.grade, s.idnum, s.birthdate, s.phone, s.height, s.weight, s.email, s.gender, s.status, s.photo_url, s.admission_date, s.graduation_date, s.department_id, s.professor_id, d.dname, p.name AS pname FROM students AS s"
            + " INNER JOIN departments AS d ON s.department_id = d.id"
            + " INNER JOIN professors AS p ON s.professor_id = p.id"
            + " <where>"
            // 괄호를 묶으면서 불필요한 AND, OR 키워드 제거 --> "AND |OR" 공백 주의!!
            + " <trim prefix='(' suffix=')' prefixOverrides='AND |OR'>"
            + " <if test='name !=null and name != \"\"'>s.name LIKE CONCAT('%', #{name}, '%')</if>"
            + " <if test='userId != null and userId != \"\"'>OR s.user_id LIKE CONCAT('%', #{userId}, '%')</if>"
            + " </trim>"
            + " <if test='departmentId != 0'>AND s.department_id=#{departmentId}</if>"
            + " <if test='grade != 0'>AND s.grade=#{grade}</if>"
            // 체크박스에 의해 선택된 직급배열이 존재하고 길이가 0보다 클 때
            + " <if test='statusArray != null and statusArray.length > 0'>"
            + " AND s.status IN"
            // MyBatis의 foreach 구문을 사용하여 positionArray의 값을 IN절로 처리
            + " <foreach item='item' index='index' collection='statusArray' open='(' separator=',' close=')'>"
            + " #{item}"
            + " </foreach>"
            + " </if>"
            + " </where>"
            + " ORDER BY s.id DESC"
            + " <if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>"
            + "</script>")
    @ResultMap("resultMap")
    public List<Student> selectList(Student input);

    @Select("<script>"
            + "SELECT COUNT(*) FROM students AS s"
            + " INNER JOIN departments AS d ON s.department_id = d.id"
            + " INNER JOIN professors AS p ON s.professor_id = p.id"
            // Dynamic SQL
            // if문에 조건이 명시되는 것은 컬럼이름이 아닌 Beans의 멤버변수!!!
            + " <where>"
            + " <trim prefix='(' suffix=')' prefixOverrides='AND |OR'>"
            + " <if test='name != null and name != \"\"'>s.name LIKE CONCAT('%', #{name}, '%')</if>"
            + " <if test='userId != null and userId != \"\"'>OR s.user_id LIKE CONCAT('%', #{userId}, '%')</if>"
            + " </trim>"
            + " <if test='departmentId != 0'>AND s.department_id=#{departmentId}</if>"
            + " <if test='grade != 0'>AND s.grade=#{grade}</if>"
            // 체크박스에 의해 선택된 직급배열이 존재하고 길이가 0보다 클 때
            + " <if test='statusArray != null and statusArray.length > 0'>"
            + " AND s.status IN"
            // MyBatis의 foreach 구문을 사용하여 positionArray의 값을 IN절로 처리
            + " <foreach item='item' index='index' collection='statusArray' open='(' separator=',' close=')'>"
            + " #{item}"
            + " </foreach>"
            + " </if>"
            + " </where>"
            + "</script>")
    public int selectCount(Student input);

    @Delete("DELETE FROM students WHERE id=#{id}")
    public int delete(Student input);

    @Delete("DELETE FROM students WHERE professor_id=#{professorId}")
    public int deleteByProfessorId(Student input);

    @Delete("DELETE FROM students WHERE department_id=#{departmentId} OR "
            + "professor_id IN (SELECT id FROM professors WHERE department_id=#{departmentId})")
    public int deleteByDepartmentId(Student input);

    @Update("UPDATE students SET professor_id = NULL WHERE professor_id = #{professorId}")
    public int updateProfessorIdToNull(Student input);
}
