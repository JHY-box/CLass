package kr.yjh.database.services;

import java.util.List;

import kr.yjh.database.exceptions.ServiceNoResultException;
import kr.yjh.database.models.Student;

public interface StudentService {
    // 전체 조회
    public List<Student> getList(Student student) throws ServiceNoResultException, Exception;

    // 단일 조회
    public Student getItem(Student student) throws ServiceNoResultException, Exception;

    // 추가
    public Student addItem(Student student) throws ServiceNoResultException, Exception;

    // 수정 
    public Student editItem(Student student) throws ServiceNoResultException, Exception;

    // 삭제
    public int deleteItem(Student student) throws ServiceNoResultException, Exception;

    // 전체 수 반환 
    public int getCount(Student student) throws ServiceNoResultException, Exception;
} 
