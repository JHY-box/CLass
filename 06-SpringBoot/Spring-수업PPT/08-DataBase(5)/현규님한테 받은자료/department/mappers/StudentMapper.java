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

import kr.hyungyu.department.models.Student;

@Mapper
public interface StudentMapper {

    /**
     *  특정 학과에 소속되어 있거나 특정 학과에 소속된 교수의 지도 학생인 학생을 삭제
     * @param input - 학과 번호를 저장하고 있는 student 객체
     * @return - 삭제된 데이터의 수
     */
    
    @Delete("DELETE FROM students WHERE department_id = #{departmentId} OR "
    + "PROFESSOR_ID IN (SELECT ID FROM PROFESSORS WHERE department_id = #{departmentId})")
    public int deleteByDepartmentId(Student input);

    /**
     * <모든 테이블의 정보를 리스트로 받음>
     * @param input - Student 객체
     * @return - 열 값이 저장된 리스트 
     */
    @Results ( id = "StudentMap", value = {
        @Result (column = "id", property = "id" ),
        @Result (column = "name", property = "name"),
        @Result (column = "user_id", property = "userId"),
        @Result (column = "grade", property = "grade"),
        @Result (column = "idnum", property = "idnum"),
        @Result (column = "birthdate", property = "birthdate"),
        @Result (column = "phone", property = "phone"),
        @Result (column = "height", property = "height"),
        @Result (column = "weight", property = "weight" ),
        @Result (column = "email", property = "email"),
        @Result (column = "gender", property = "gender"),
        @Result (column = "status", property = "status"),
        @Result (column = "photo_url", property = "photoUrl"),
        @Result (column = "admission_date", property = "admissionDate"),
        @Result (column = "graduation_date", property = "graduationDate"),
        @Result (column = "department_id", property = "departmentId"),
        @Result (column = "professor_id", property = "professorId")
    })
    @Select (
            "select id, name, user_id, grade, idnum, birthdate, phone, height, weight, email, "
            + "gender, status, photo_url, admission_date, graduation_date, department_id, professor_id "
            + "from students"
    )
    public List<Student> selectList (Student input);


    /**
     * <고유한 아이디를 입력하여 해당 행을 전달받음.>
     * @param input - 아이디가 포함된 Student 객체
     * @return - 정보를 담은 Student 객체
     */
    @Select ( "<script>"
                + "select id, name, user_id, grade, idnum, birthdate, phone, height, weight, email, "
                + "gender, status, photo_url, admission_date, graduation_date, department_id, professor_id "
                + "from students"
                + "<where>"
                + "<if test = \"id != null or id = ''\"> id = #{id} </if>" 
                + "</where>"
                + "</script>"
    )
    @ResultMap ("StudentMap")
    public Student selectOne (Student input);


    /**
     * <객체를 이용하여 해당 데이터를 삽입함>
     * @param input - 넣은 자료의 값이 들어있는 Student 객체
     * @return - 추가된 정보의 개수
     */
    @Insert( "insert into students (id, name, user_id, grade, idnum, birthdate, phone, height, weight, email,"
            + "gender, status, photo_url, admission_date, graduation_date, department_id, professor_id) "
            + "values (#{id}, #{name}, #{userId}, #{grade}, #{idnum}, #{birthdate}, #{phone}, #{height}, #{weight}, #{email}, #{gender}, #{status}, #{photoUrl}, #{admissionDate}, #{graduationDate}, #{departmentId}, #{professorId})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert (Student input);

    /**
     * <객체를 이용하여 정보를 수정함>
     * @param input - 수정할 정보가 담긴 Student 객체
     * @return - 수정한 정보의 수가 담긴 데이터
     */
    @Update("<script>"
        + "UPDATE students "
        + "<set>"
        + "<if test='name != null'>name = #{name},</if>"
        + "<if test='userId != null'>user_id = #{userId},</if>"
        + "<if test='grade != null'>grade = #{grade},</if>"
        + "<if test='idnum != null'>idnum = #{idnum},</if>"
        + "<if test='birthdate != null'>birthdate = #{birthdate},</if>"
        + "<if test='phone != null'>phone = #{phone},</if>"
        + "<if test='height != null'>height = #{height},</if>"
        + "<if test='weight != null'>weight = #{weight},</if>"
        + "<if test='email != null'>email = #{email},</if>"
        + "<if test='gender != null'>gender = #{gender},</if>"
        + "<if test='status != null'>status = #{status},</if>"
        + "<if test='photoUrl != null'>photo_url = #{photoUrl},</if>"
        + "<if test='admissionDate != null'>admission_date = #{admissionDate},</if>"
        + "<if test='graduationDate != null'>graduation_date = #{graduationDate},</if>"
        + "<if test='departmentId != null'>department_id = #{departmentId},</if>"
        + "<if test='professorId != null'>professor_id = #{professorId},</if>"
        + "</set> "
        + "WHERE id = #{id}"
        + "</script>")
        @Options (useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int update(Student input);

    /**
     * <특정 아이디의 정보를 삭제함>
     * @param input - 삭제할 아이디가 포함된 객체
     * @return - 처리된 삭제의 수
     */
    @Delete( "<script>"
            + "delete from Students"
            + "<where>"
            + "<if test = \" id != null and id != ''\"> id = #{id} </if>"
            + "</where>"
            + "</script>"
    )
    public int delete(Student input);

    /**
      * 검색 조건에 따른 데이터 기록 조회
      * 
      * @param input - 사용자에게 입력받은 조회 조건을 담고 있는 객체
      * @return 조회된 데이터의 수
      */
      @Select("<script>" 
      + "select count(*) "
      + "from students "
      + "<where>"
      + "<if test = \"id != null and id != '' \">id like concat ('%', #{id}, '%')</if>"
      + "</where>"
      + "</script>"
  )
    public int selectCount(Student input);

    /**
     *  특정 교수가 지도교수인 학생 삭제, 특정 교수가 가르치는 과목을 수강하는 학생 삭제
     *  학생이 멤버변수로 삭제하고자 하는 교수의 정보를 들고 있어야함.
     * @param input - 학과 번호를 저장하고 있는 student 객체
     * @return - 삭제된 데이터의 수
     */
    
     @Delete("DELETE FROM students WHERE professor_id = #{professorId} OR "
     + "id IN (SELECT student_id FROM enrollments WHERE subject_id in (select id from subjects where professor_id = #{professorId}))")
     public int deleteByProfessorId(Student input);

    // 특정 교수가 지도교수인 학생의 지도교수를 null로 바꾸기
    @Update("update students set "+
            "professor_id = NULL " + 
            "where professor_id = #{professorId}")
    public int updateByprofessorId(Student student);
}