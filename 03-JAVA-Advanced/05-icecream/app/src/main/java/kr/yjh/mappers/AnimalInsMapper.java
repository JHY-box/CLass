package kr.yjh.mappers;

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

import kr.yjh.models.AnimalIns;

@Mapper
public interface AnimalInsMapper {
    //////////////////////////////////////////////////////////////////// I n s e r t (입력)///////////////////////////////////////////
    @Insert("INSERT INTO animal_ins (" +
            "animal_id, animal_type, datetime, intake_condition, name, sex_upon_intake" +
            " ) VALUES (" + 
            " #{animalId}, #{animalType}, #{datetime}, #{intakeCondition}, #{name}, #{sexUponIntake}" +
            " )")
    @Options(useGeneratedKeys = true, keyProperty =  "animalId", keyColumn = "ANIMAL_ID")
    public int insert(AnimalIns input);

    //////////////////////////////////////////////////////////////////// U p d a t e (수정)///////////////////////////////////////////
    @Update("UPDATE ANIMAL_INS SET " +
            " ANIMAL_TYPE= #{animalType}, " +
            "DATETIME = #{datetime}, " +
            "INTAKE_CONDITION = #{intakeCondition}" +
            "NAME = #{name}" + 
            "SEX_UPON_INTAKE = #{sexUponIntake} " +
            "WHERE ANIMAL_ID = #{animalId}")
    public int update(AnimalIns input);  //❌❌❌❌❌ Update --> update (수정)

    //////////////////////////////////////////////////////////////////// D e l e t e (삭제)///////////////////////////////////////////
    @Delete("DELETE FROM ANIMAL_INS WHERE ANIMAL_ID=#{animalId}")
    public int delete(AnimalIns input);   //❌❌❌❌❌ Delete --> delete(대소문자) 수정

    ////////////////////////////////////////////////////////////////////selectOne S e l e c t ()///////////////////////////////////////////
    @Select("SELECT ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE, FROM ANIMAL_INS " +
            "ANIMAL_ID=#{animalId}")
    @Results(id="resultMap", value={
        @Result(property = "animalId", column = "ANIMAL_ID"),
        @Result(property = "animalType", column = "ANIMAL_TYPE"),
        @Result(property = "datetime", column = "DATETIME"),
        @Result(property = "intakeCondition", column = "INTAKE_CONDITION"),
        @Result(property = "name", column = "NAME"),
        @Result(property = "sexUponIntake", column = "SEX_UPON_INTAKE"),
    })        
    public AnimalIns selectOne(AnimalIns input);  //❌❌❌❌❌ int --> AnimalIns(오타 수정) --> 오타 에러

    ////////////////////////////////////////////////////////////////////List S e l e c t ///////////////////////////////////////////
    @Select("<script>" +
            "SELECT ANIMAL_ID,ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE FROM ANIMAL_INS" +
            "<where>" +
            "     <if test=\"name != null and name != ''\">name LIKE CONCAT('%', #{name}, '%')</if>" +
                 "</where>" +
                "</script>")
    @ResultMap("resultMap")
    public List<AnimalIns> selectList(AnimalIns input);    //❌❌❌❌❌ select(t) 오타 ---에러였던곳

    ////////////////////////////////////////////////////////////////// S e l e c t /////////////////////////////////////////////
    @Select("<script>" +
            "SELECT COUNT(*) FROM ANIMAL_INS" +
            "<where>" +
            "     <if test=\"name != null and name != ''\">name LIKE CONCAT('%', #{name}, '%')</if>" +
                 "</where>" +
            "</script>")
    public int selectCount(AnimalIns input);
    public List<AnimalIns> getList(AnimalInsMapper input);



}
