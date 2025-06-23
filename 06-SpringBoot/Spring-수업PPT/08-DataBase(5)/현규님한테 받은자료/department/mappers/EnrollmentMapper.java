package kr.hyungyu.department.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.hyungyu.department.models.Enrollment;
import kr.hyungyu.department.models.Professor;
import kr.hyungyu.department.models.Student;

@Mapper
public interface EnrollmentMapper{

        /**
     *  특정 학과에 소속된 학생 혹은 특정 학과의 교수에게 지도를 받는 학생 이거나 수강신청 과목을 가르치는 교수가 삭제하려는 학과 교수였던 경우 신청한 수강 내역을 삭제
     * @param input - 삭제하려는 학과 번호가 저장된 student 클래스의 객체
     * @return - 삭제된 데이터의 수
     */
        @Delete("DELETE FROM enrollments WHERE student_id IN (" +
                "   SELECT id FROM students " +
                "   WHERE department_id=#{departmentId} OR " +
                "         professor_id IN (" +
                "           SELECT id FROM professors WHERE department_id=#{departmentId}" +
                "         )" +
                ") OR subject_id IN (" +
                "   SELECT id FROM subjects WHERE professor_id IN (" +
                "       SELECT id FROM professors WHERE department_id=#{departmentId}" +
                "   )"+
                ")")
        public int deleteByStudentId(Student input);

        /**
         * 학생을 삭제하기 위해서 우선 그 학생이 수강신청한 내역을 지우기 위해 필요한 함수
         * @param input
         * @return
         */
        @Delete ( "<script>"
                  + "delete from enrollments"
                  + "<where>"
                  + "<if test = \" id != null and id != '' \"> student_id = #{id} </if>"
                  + "</where>"
                  + "</script>"
        )
        public int deleteByStudentIdOnly(Student input);

           /** 특정 교수가 지도교수인 학생이 수강하는 내역 삭제, 특정 교수의 담당 과목의 수강신청 내역 삭제
     *  
     * @param input - 삭제하려는 학과 번호가 저장된 student 클래스의 객체
     * @return - 삭제된 데이터의 수
     */
    @Delete("DELETE FROM enrollments WHERE student_id IN (select id from students where professor_id = #{professorId}) "
           + "or subject_id in (select id from subjects where professor_id in (select id from students where professor_id = #{professorId}))" ) 
public int deleteByStudentIdForProfessor(Student input);

/** 특정 과목에 해당하는 수강내역 삭제
     *  
     * @param input - 삭제하려는 과목 번호가 저장된 enrollment 클래스의 객체
     * @return - 삭제된 데이터의 수
     */
    @Delete("DELETE FROM enrollments WHERE subject_id = #{subjectId}") 
public int deleteBySubject(Enrollment enrollment);

        /**
     *  모든 목록 조회
     * @param enrollment - null
     * @return - 모든 수강신청 목록
     */
        @Select("select student_id, subject_id, enroll_date, score from enrollments")
        public List<Enrollment> selectList (Enrollment enrollment);

        /**
     *  특정 학생의 모든 목록 조회
     * @param enrollment - null
     * @return - 모든 수강신청 목록
     */
        @Select("select student_id, subject_id, enroll_date, score from enrollments where student_id = #{id}")
        public List<Enrollment> selectListByOne (Student student);


        /**
        * 상세 조회
        * @param enrollment - 특정 목록 정보
        * @return - 수강신청 목록
        */
        @Select("select student_id, subject_id, enroll_date, score from enrollments where student_id = #{student_id} and subject_id = #{subjectId}")
        public Enrollment selectOne (Enrollment enrollment);

        /**
        * 수강신청 내역 등록하기
        * @param enrollment - 수강신청 내역의 정보
        * @return - 추가된 내역의 건수
        */
        @Insert("INSERT INTO enrollments (student_id, subject_id, enroll_date, score) VALUES (#{student_id}, #{subjectId}, #{enrollDate}, #{score})")
        public int insert (Enrollment enrollment);


        /**
      * 수강신청 내역 정보를 수정한다.
      * 
      * @param input - 수정할 데이터에 대한 정보를 담고 있는 객체
      * @return 수정된 데이터의 건수
      */
        @Update("UPDATE enrollments SET " +
                "enroll_date=#{enrollDate}, score=#{score} "
                + "where student_id=#{student_id} AND subject_id=#{subjectId}")
        public int update(Enrollment enrollment);

        /**
      * 수강신청 내역 정보를 삭제한다.
      * 
      * @param input - 삭제할 대상의 정보를 담고 있는 객체
      * @return 삭제된 데이터의 건수
      */
        @Delete("DELETE FROM enrollments WHERE student_id = #{student_id} and subject_id = #{subjectId}")
        public int delete(Enrollment enrollment);

        /**
      * 한 학생의수강신청 내역 정보를 삭제한다.
      * 
      * @param input - 삭제할 한 학생의 정보를 담고 있는 객체
      * @return 삭제된 데이터의 건수
      */
        @Delete("DELETE FROM enrollments WHERE student_id = #{id}")
        public int deleteByOne(Student student);




}
