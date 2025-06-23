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

import kr.hossam.database.models.Student;

@Mapper
public interface StudentMapper {

    /**
     * 데이터를 입력한다.
     *
     * INSERT문에서 필요한 PK에 대한 옵션 정의
     * --> useGeneratedKeys: AUTO_INCREMENT가 적용된 테이블인 경우 사용
     * --> keyProperty: 파라미터로 전달되는 MODEL 객체에서 PK에 대응되는 멤버변수
     * --> keyColumn: 테이블의 Primary Key 컬럼명
     *
     * @param input - 입력할 데이터에 대한 모델 객체
     * @return 입력된 데이터 수
     */
    @Insert("INSERT INTO students (" +
           "name, user_id, grade, idnum, birthdate, phone, height, weight, email, " +
           "gender, status, photo_url, admission_date, graduation_date, department_id, professor_id" +
           ") VALUES (" +
           "#{name}, #{userId}, #{grade}, #{idnum}, #{birthdate}, #{phone}, #{height}, #{weight}, #{email}, " +
           "#{gender}, #{status}, #{photoUrl}, #{admissionDate}, #{graduationDate}, #{departmentId}, #{professorId}" +
           ")")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Student input);


    /**
     * 데이터를 수정한다.
     * @param input - 수정할 데이터에 대한 모델 객체
     * @return 수정된 데이터 수
     */
    @Update("UPDATE students SET " +
           "name=#{name}," +
           "user_id=#{userId}," +
           "grade=#{grade}," +
           "idnum=#{idnum}," +
           "birthdate=#{birthdate}," +
           "phone=#{phone}," +
           "height=#{height}," +
           "weight=#{weight}," +
           "email=#{email}," +
           "gender=#{gender}," +
           "status=#{status}," +
           "photo_url=#{photoUrl}," +
           "admission_date=#{admissionDate}," +
           "graduation_date=#{graduationDate}," +
           "department_id=#{departmentId}," +
           "professor_id=#{professorId} " +
           "WHERE id=#{id}")
    public int update(Student input);


    /**
     * 데이터를 삭제한다.
     * @param input - 삭제할 데이터에 대한 모델 객체
     * @return 삭제된 데이터 수
     */
    @Delete("DELETE FROM students WHERE id=#{id}")
    public int delete(Student input);


    /**
     * 특정 데이터의 상세정보를 조회한다.
     * @param input - 조회할 데이터에 PK값을 담고 있는 모델 객체
     * @return 조회된 데이터를 담고 있는 모델 객체
     */
    @Select("SELECT id, name, user_id, grade, idnum, birthdate, phone, height, weight, email, " +
            "gender, status, photo_url, admission_date, graduation_date, department_id, professor_id " +
            "FROM students " +
            "WHERE id=#{id}")
    @Results(id="resultMap", value={
        @Result(property="id", column="id"),
        @Result(property="name", column="name"),
        @Result(property="userId", column="user_id"),
        @Result(property="grade", column="grade"),
        @Result(property="idnum", column="idnum"),
        @Result(property="birthdate", column="birthdate"),
        @Result(property="phone", column="phone"),
        @Result(property="height", column="height"),
        @Result(property="weight", column="weight"),
        @Result(property="email", column="email"),
        @Result(property="gender", column="gender"),
        @Result(property="status", column="status"),
        @Result(property="photoUrl", column="photo_url"),
        @Result(property="admissionDate", column="admission_date"),
        @Result(property="graduationDate", column="graduation_date"),
        @Result(property="departmentId", column="department_id"),
        @Result(property="professorId", column="professor_id")
    })
    public Student selectOne(Student input);

    /**
     * 데이터 목록을 조회한다. 필요한 경우 검색기능을 수행한다.
     * @param input - 조회할 데이터에 검색조건을 담고 있는 모델 객체
     * @return 조회된 데이터를 담고 있는 List
     */
    @Select("<script>"+
           "SELECT id, name, user_id, grade, idnum, birthdate, phone, height, weight, email," +
           "gender, status, photo_url, admission_date, graduation_date, department_id, professor_id " +
           "FROM students" +
           "<where>" +
           "   <if test='name != null and name != \"\"'>AND name LIKE CONCAT('%', #{name}, '%')</if> " +
           "   <if test='userId != null and userId != \"\"'>AND user_id LIKE CONCAT('%', #{userId}, '%')</if> " +
           "   <if test='departmentId != 0'>AND department_id = #{departmentId}</if> " +
           "</where>" +
           "</script>")
    @ResultMap("resultMap")
    public List<Student> selectList(Student input);


    /**
     * 검색조건에 따른 데이터 수를 조회한다.
     * @param input - 조회할 데이터에 검색조건을 담고 있는 모델 객체
     * @return 데이터 수 - 검색조건에 해당하는 데이터가 없을 경우 0을 리턴
     */
    @Select("<script>" +
           "SELECT COUNT(*) FROM students" +
           "<where>" +
           "   <if test='name != null and name != \"\"'>AND name LIKE CONCAT('%', #{name}, '%')</if> " +
           "   <if test='userId != null and userId != \"\"'>AND user_id LIKE CONCAT('%', #{userId}, '%')</if> " +
           "   <if test='departmentId != 0'>AND department_id = #{departmentId}</if> " +
           "</where>" +
           "</script>")
    public int selectCount(Student input);

    /**
     * 특정 학과에 소속되어 있거나, 특정 학과에 소속된 교수의 지도를 받는 학생 일괄 삭제
     * @param input - 학과 번호를 저장하고 있는 Student 객체
     * @return 삭제된 데이터 수
     */
    @Delete("DELETE FROM students WHERE department_id=#{departmentId} OR " +
            "professor_id IN (SELECT id FROM professors WHERE department_id=#{departmentId})")
    public int deleteByDepartmentId(Student input);

    /**
     * 특정 교수의 지도를 받는 학생에 대해 담당교수 번호를 NULL로 변경
     * @param input - 교수 번호를 저장하고 있는 Student 객체
     * @return 변경된 데이터 수
     */
    @Update("UPDATE students SET professor_id = NULL WHERE professor_id = #{professorId}")
    public int updateProfessorIdToNull(Student input);
}
