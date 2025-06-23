package kr.hyungyu.department.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.hyungyu.department.models.Department;

@Mapper
public interface DepartmentMapper {
    /**
      * 부서 정보를 저장한다.
      * 
      * --> INSERT 실행 + PK에 대한 값 추출
      * --> useGeneratedKeys : AUTO_INCREMENT가 적용된 컬럼이면 공유 사용
      * --> keyProperty : 리턴받을 결과값을 MODEL 객체에서 PK에 대응되는 '멤버변수'
      * --> keyColumn : 테이블의 Primary Key '컬럼명'
      * 
      * @param input - 저장할 데이터에 대한 정보를 담고 있는 객체
      * @return 저장된 데이터의 건수
      */
    @Insert("INSERT INTO departments (dname, loc, phone, email, established, homepage) VALUES (#{dname}, #{loc}, #{phone}, #{email}, #{established}, #{homepage})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // 자동 생성키(id)의 정보를 가지고 있음.
    public int insert(Department input);

    /**
      * 부서 정보를 수정한다.
      * 
      * @param input - 수정할 데이터에 대한 정보를 담고 있는 객체
      * @return 수정된 데이터의 건수
      */
    @Update("UPDATE departments SET " +
            "dname=#{dname}, loc=#{loc}, phone=#{phone}, email=#{email}, established=#{established}, homepage=#{homepage} " +
            "WHERE id=#{id}")
    public int update(Department input);

    /**
      * 부서 정보를 삭제한다.
      * 
      * @param input - 삭제할 대상의 정보를 담고 있는 객체
      * @return 삭제된 데이터의 건수
      */
    @Delete("DELETE FROM departments WHERE id=#{id}")
    public int delete(Department input);

    /**
      * 부서 정보 상세 조회 (1건)
      * 
      * @param input - 조회할 대상의 정보를 담고 있는 객체
      * @return 조회된 데이터
      */
    @Select("SELECT id, dname, loc, phone, email, established, homepage FROM departments WHERE id=#{id}")
    public Department selectOne(Department input);

    /**
      * 부서 정보 목록 조회 (다건)
      * 
      * @param input - 사용자에게 입력받은 조회 조건을 담고 있는 객체
      * @return 조회된 데이터 목록
      */
    @Select("<script>" 
            + "select id, dname, loc, phone, email, established, homepage "
            + "from departments "
            + "<where>"
            + "<if test = \"dname != null and dname != '' \">dname like concat ('%', #{dname}, '%')</if>"
            + "<if test = \"loc != null and loc != '' \">and loc like concat ('%', #{loc}, '%')</if>"
            + "</where>"
            + "</script>"
        )
    public List<Department> selectList(Department input);

    /**
      * 검색 조건에 따른 데이터 기록 조회
      * 
      * @param input - 사용자에게 입력받은 조회 조건을 담고 있는 객체
      * @return 조회된 데이터의 수
      */
      @Select("<script>" 
      + "select count(*) "
      + "from departments "
      + "<where>"
      + "<if test = \"dname != null and dname != '' \">dname like concat ('%', #{dname}, '%')</if>"
      + "<if test = \"loc != null and loc != '' \">and loc like concat ('%', #{loc}, '%')</if>"
      + "</where>"
      + "</script>"
  )
    public int selectCount(Department input);
}


