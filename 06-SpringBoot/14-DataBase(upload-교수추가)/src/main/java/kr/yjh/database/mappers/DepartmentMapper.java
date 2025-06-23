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

import kr.yjh.database.models.Department;



/**
 * 특정 테이블(Departments)에 대한 CRUD 기능을 정의 하는 인터페이스
 * 
 * C - Create(생성) --> INSERT문 --> 글쓰기
 * R - Read(조회) --> SELECT문 --> 목록검색, 상세쓰기
 * U - Update(수정) --> UPDATE문 --> 글수정
 * D - Delete(삭제) --> DELETE문 --> 글삭제
 * 
 * 모든 메서드의 파라미터는 테이블 구조를 정의하는 Beans 클래스 타입
 * 
 * INSERT, UPDATE, DELETE의 경우 int형을 리턴 : 적용된 데이터 수
 * 
 * SELECT - 단일행 조회 - 는 Beans 클래스 타입을 리턴
 * SELECT - 다중행 조회 - 는 List<beans클래스> 타입을 리턴
 * 
 * 메서드 이름은 자유롭게 설정
 */

 @Mapper
public interface DepartmentMapper {
    /**
     * 학과 정보를 입력한다.
     * 
     * INSERT문에서 필요한 PK 에 대한 옵션 정의
     * --> useGeneratedKeys : AUTO_INCREMENT가 적용된 테이블인 경우 사용
     * --> keyProperty : 파라미터로 전달되는 MODEL 객체에서 PK에 대응되는 맴버변수
     * --> keyColumn : 테이블의 Primary Key 컬럼명
     * 
     * @param input - 입력한 데이터에 대한 모델 객체
     * @return 입력된 데이터 수
     */
     //                                                                              INSERT -
        
     @Insert("INSERT INTO departments (dname, loc, phone, email, established, homepage) VALUES (#{dname}, #{loc}, #{phone}, #{email}, #{established}, #{homepage})")
     @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
     public int insert(Department input);

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖
     
     /**                                                                             UPDATE - 
      * 학과 정보를 수정한다.
      * @param input - 수정할 데이터에 대한 모델 객체
      * @return 수정된 데이터 수
      */
      @Update ("UPDATE departments SET " + 
                "dname = #{dname}, loc = #{loc}, phone = #{phone}, email = #{email}, established = #{established}, homepage = #{homepage} " +
                "WHERE id = #{id}")
      public int update(Department input);

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖
     
      /**                                                                            DELETE -                               
       * 학과 정보를 삭제한다.
       * @param input - 삭제할 데이터에 대한 모델 객체
       * @return 삭제된 데이터 수
       */
      @Delete("DELETE FROM departments WHERE id = #{id}")
      public int delete(Department input);

//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

      /**                                                                             SELECT - 단일행
       * 특정 학과의 상세정보를 조회한다.
       * @param input - 조회할 데이터에 PK값을 담고 있는 모델 객체
       * @return 조회된 데이터를 담고 있는 모델 객체
       */
      @Select ("SELECT id, dname, loc, phone, email, established, homepage FROM departments WHERE id=#{id}")
      @Results(id = "resultMap", value = {
            @Result(property = "id", column = "id")
           , @Result(property = "dname", column = "dname")
           , @Result(property = "loc", column = "loc")
           , @Result(property = "phone", column = "phone")
           , @Result(property = "email", column = "email")
           , @Result(property = "established", column = "established")
           , @Result(property = "homepage", column = "homepage")
      })
      public Department selectOne(Department input);


      /**                                                                             SELECT - 다중
       * 특정 학과의 목록을 조회한다. 필요한 경우 검색기능을 수행한다.
       * @param input - 조회할 데이터에 검색조건을 담고 있는 모델 객체
       * @return 조회된 데이터를 담고 있는 List
       */
      @Select("<script>" + "SELECT id, dname, loc, phone, email, established, homepage "  + 
              "FROM departments " + 
              //Dynamic SQL
              // if문에 조건에 명시되는 것은 컬럼이름이 아닌 Beans의 변수
              "<where>" +
              "<if test=\"dname != null and dname != ''\">dname LIKE CONCAT('%', #{dname}, '%')</if>" +
              "<if test=\"loc != null and loc != ''\">OR loc LIKE CONCAT('%', #{loc}, '%')</if>" +
              "</where>" +
              "ORDER BY id DESC " +
              "<if test='listCount > 0 '>LIMIT #{offset}, #{listCount}</if>" +
              "</script>")
      @ResultMap("resultMap")
      public List<Department> selectList(Department input);

      
//➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖➖

      /**                                                                              C O U N T 
       * 검색조건에 따른 데이터 수를 조회한다.
       * @param input - 조회할 데이터에 검색조건을 담고 있는 모델 객체
       * @return - 데이터 수
       *          -검색조건에 해당하는 데이터가 없을 경우 0을 리턴
       */
      @Select("<script>" + 
              "SELECT COUNT(*) " + 
              "FROM departments " + 
              //Dynamic SQL
              // if문에 조건에 명시되는 것은 컬럼이름이 아닌 Beans의 변수
              "<where>" +
              "<if test=\"dname != null and dname != ''\">dname LIKE CONCAT('%', #{dname}, '%')</if>" +
              "<if test=\"loc != null and loc != ''\">OR loc LIKE CONCAT('%', #{loc}, '%')</if>" +
              "</where>" +
              "</script>")
      public int selectCount(Department input);
}