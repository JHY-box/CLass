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

import kr.yjh.database.models.Student;

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
           "name=#{name}, " +
           "user_id=#{userId}, " +
           "grade=#{grade}, " +
           "idnum=#{idnum}, " +
           "birthdate=#{birthdate}, " +
           "phone=#{phone}, " +
           "height=#{height}, " +
           "weight=#{weight}, " +
           "email=#{email}, " +
           "gender=#{gender}, " +
           "status=#{status}, " +
           "photo_url=#{photoUrl}, " +
           "admission_date=#{admissionDate}, " +
           "graduation_date=#{graduationDate}, " +
           "department_id=#{departmentId}, " +
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
    @Select("SELECT s.id, s.name, s.user_id, s.grade, s.idnum, s.birthdate, s.phone, s.height, s.weight, s.email, "
            + "s.gender, s.status, s.photo_url, s.admission_date, s.graduation_date, s.department_id "
            + "FROM students "
            + "WHERE id=#{id}")
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
        @Result(property="professorId", column="professor_id"),

        @Result(property="professorName", column ="pname"),    // 교수 이름
        @Result(property = "departmentName", column = "departmentName")  // 학과 명
    })
    public Student selectOne(Student input);

    /**
     * 데이터 목록을 조회한다. 필요한 경우 검색기능을 수행한다.
     * @param input - 조회할 데이터에 검색조건을 담고 있는 모델 객체
     * @return 조회된 데이터를 담고 있는 List
     */
    @Select("<script>"
            + "SELECT s.id, s.name, s.user_id, s.grade, s.idnum, s.birthdate, s.phone, s.height, s.weight, s.email, "
            + "s.gender, s.status, s.photo_url, s.admission_date, s.graduation_date, s.department_id, p.name AS pname, d.dname "
            + "FROM students AS s "
            + "INNER JOIN departments AS d ON s.department_id = d.id "
            + "INNER JOIN professors AS p ON s.professor_id = p.id "
            + " <where>"
            // 괄호를 묶으면서 불필요한 AND, OR 키워드 제거 --> "AND |OR" 공백 주의!!
            + " <trim prefix='(' suffix=')' prefixOverrides='AND |OR'>" 
            + " <if test='name !=null and name != \"\"'>name LIKE CONCAT('%', #{name}, '%')</if>"
            + " <if test='userId != null and userId != \"\"'>OR user_id LIKE CONCAT('%', #{userId}, '%')</if>"
            + " </trim>"
            + " <if test='departmentId != null and departmentId != 0'>AND department_id=#{departmentId}</if>"
            
            // 체크박스에 의해 선택된 직급배열이 존재하고 길이가 0보다 클떄
            + " <if test='statusArray != null and statusArray.length > 0'> "
            + "    AND status IN " 
            // Mybatis의 foreach 구문을 사용하여 statusArray의 값을 IN절로 처리 
            + "    <foreach item='item' index='index' collection='statusArray' open='(' separator=',' close=')' >"
            + "       #{item} "
            + "    </foreach> "
            + " </if> "
            
            + " </where>"
            + " ORDER BY p.id DESC"
            + " <if test='listCount > 0'>LIMIT #{offset}, #{listCount}</if>"
            + "</script>")
    @ResultMap("resultMap")
    public List<Student> selectList(Student input);

    
    /**
     * 검색조건에 따른 데이터 수를 조회한다.
     * @param input - 조회할 데이터에 검색조건을 담고 있는 모델 객체
     * @return 데이터 수 - 검색조건에 해당하는 데이터가 없을 경우 0을 리턴
     */
    @Select("<script>" 
            +"SELECT COUNT(*) FROM students" 
            + " <where>"
            + " <trim prefix='(' suffix=')' prefixOverrides='AND |OR'>"
            + " <if test='name != null and name != \"\"'>name LIKE CONCAT('%', #{name}, '%')</if>"
            + " <if test='userId != null and userId != \"\"'>OR user_id LIKE CONCAT('%', #{userId}, '%')</if>"
            + " </trim>"
            + " <if test='departmentId != null and departmentId != 0'>AND department_id=#{departmentId}</if>"

            // 체크박스에 의해 선택된 직급배열이 존재하고 길이가 0보다 클떄
            + " <if test='statusArray != null and statusArray.length > 0'> "
            + "    AND status IN " 
            // Mybatis의 foreach 구문을 사용하여 statusArray의 값을 IN절로 처리 
            + "    <foreach item='item' index='index' collection='statusArray' open='(' separator=',' close=')' >"
            + "       #{item} "
            + "    </foreach> "
            + " </if> "

            + " </where>"
            + "</script>")
    public int selectCount(Student input);

    /**
     * 특정학과에 소속되어 있거나, 특정 학과에 소속된 교수의 지도를 받는 학생 일괄 삭제
     * @param input -학과 번호를 저장하고 있는 Student 객체
     * @return - 삭제된 데이터 수
     */
    @Delete("DELETE FROM students WHERE department_id=#{departmentId} OR " +
            "professor_id IN (SELECT id FROM professors WHERE department_id = #{departmentId})" ) 
    public int deleteByStudentId(Student input);

    /**
     * 특정 교수의 지도를 받는 학생에 대해 담당교수 번호를 NULL로 변경
     * @param input - 교수 번호를 저장하고 있는 Student rorcp
     * @return 변경된 데이터 수
     */
    @Update("update students set "+
            "professor_id = NULL " + 
            "where professor_id = #{professorId}")
    public int updateByProfessorId(Student student);
}



































/** 
디파 아이디
그레이드
학년array
*/
