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
import com.jamesobin.database.models.Department;
import com.jamesobin.database.models.Enrollment;
import com.jamesobin.database.models.Professor;

@Mapper
public interface EnrollmentMapper {
    /**
     * 
     * INSERT문에서 필요한 PK에 대한 옵션 정의
     * --> useGeneratedKeys : AUTO_INCREMENT가 적용된 테이블인 경우 사용
     * --> keyProperty : 파라미터로 전달되는 MODEL 객체에서 PK에 대응되는 멤버변수
     * --> keyColumn : 테이블 Primary Key 컬럼명
     * 
     * @param input - 입력할 데이터에 대한 모델 객체
     * @return 입력된 데이터 수
     */
     @Insert("INSERT INTO enrollments (student_id, subject_id, enroll_date, score) VALUES (#{studentId}, #{subjectId}, #{enrollDate}, #{score})")
     @Options(useGeneratedKeys = true, keyProperty = "studentId, subjectId", keyColumn = "student_id, subject_id")
     public int insert(Enrollment input);

    /**
     * 수강신청 정보를 수정한다.
     * @param input - 수정할 데이터에 대한 모델 객체
     * @return 수정된 데이터 수
     */
    @Update("UPDATE enrollments SET "
            + "enroll_date=#{enrollDate}, score=#{score} "
            + "WHERE student_id=#{studentId} AND subject_id=#{subjectId}")
    public int update(Enrollment input);

    /**
     * 특정 수강신청의 상세정보를 조회한다.
     * @param input - 조회할 데이터에 PK값을 담고 있는 모델 객체
     * @return 조회된 데이터를 담고 있는 모델 객체
     */
    @Select("SELECT student_id, subject_id, enroll_date, score FROM enrollments "
            + "WHERE student_id=#{studentId} AND subject_id=#{subjectId}")
    @Results(id = "resultMap", value = {
        @Result(property = "studentId", column = "student_id")
        , @Result(property = "subjectId", column = "subject_id")
        , @Result(property = "enrollDate", column = "enroll_date")
        , @Result(property = "score", column = "score")
    })
    public Enrollment selectOne(Enrollment input);

    /**
     * 특정 수강신청의 목록을 studentId로 조회한다. 필요한 경우 검색기능을 수행한다.
     * @param input - 조회할 데이터에 검색 조건을 담고 있는 모델 객체
     * @return 조회된 데이터를 담고 있는 모델 List
     */
    @Select("SELECT student_id, subject_id, enroll_date, score FROM enrollments WHERE student_id=#{studentId}")
    public List<Enrollment> selectByStudentId(Enrollment input);

    /**
     * 특정 수강신청의 목록을 조회한다. 필요한 경우 검색기능을 수행한다.
     * @param input - 조회할 데이터에 검색 조건을 담고 있는 모델 객체
     * @return 조회된 데이터를 담고 있는 모델 List
     */
    @Select("SELECT student_id, subject_id, enroll_date, score FROM enrollments")
    @ResultMap("resultMap")
    public List<Enrollment> selectList(Enrollment input);

    /**
     * 수강신청 정보를 삭제한다.
     * @param input - 삭제할 데이터에 대한 모델 객체
     * @return 삭제된 데이터 수 
     */
    @Delete("DELETE FROM enrollments WHERE student_id=#{studentId} AND subject_id=#{subjectId}")
    public int delete(Enrollment input);

    /**
     * 특정 학생이 신청한 모든 수강신청 정보를 삭제한다.
     * @param input - 삭제할 데이터에 대한 모델 객체
     * @return 삭제된 데이터 수 
     */
    @Delete("DELETE FROM enrollments WHERE student_id=#{studentId}")
    public int deleteByStudentId(Enrollment input);

    /**
     * 특정 학과에 소속된 학생 혹은 특정 학과의 교수에게 지도를 받는 학생이 신청한 수강 내역을 삭제
     * @param input - 삭제하려는 학과 번호가 저장된 Student 클래스의 객체
     * @return 삭제된 데이터 수
     */
    @Delete("DELETE FROM enrollments "
            + "WHERE student_id IN ("
                + "SELECT id FROM students "
                + "WHERE department_id=#{id} OR professor_id IN ("
                    + "SELECT id FROM professors WHERE department_id=#{id}"
                    + ")"
            + ") OR subject_id IN ("
                + "SELECT id FROM subjects WHERE professor_id IN ("
                    + "SELECT id FROM professors WHERE department_id=#{id}"
                    + ")"
            + ")")
    public int deleteByDepartmentId(Department input);

    @Delete("DELETE FROM enrollments " 
            + "WHERE student_id IN ("
                + "SELECT id FROM students WHERE professor_id=#{id}"
            + ") OR subject_id IN ("
                + "SELECT id FROM subjects WHERE professor_id=#{id}"
            + ")")
    public int deleteByProfessorId(Professor input);

    @Delete("DELETE FROM enrollments WHERE subject_id=#{subjectId}")
    public int deleteBySubjectId(Enrollment input);

    @Select("SELECT COUNT(*) FROM enrollments")
    public int selectCount(Enrollment input);
}
