package kr.yjh.services;

import java.util.List;
import kr.yjh.exceptions.ServiceNoResultException;
import kr.yjh.models.Department;

public interface DepartmentService {
    
    /** 
     * 
     * 학과 목록을 조회한다.
     * 
     * @Param input -조회할 학과의 검색어를 담고 있는 Beans
     * @return List<Department> - 조회된 데이터
     * @throws ServiceNoresultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL처리에 실패한 경우(프로그램적인 에러)
     */
    public List<Department> getList(Department input) throws ServiceNoResultException, Exception;

/** 
     * 
     * 학과 목록에 대한 데이터 수를 조회한다. 검색어가 없는 경우 전체 데이터 수를 조회한다.
     * 
     * @Param input - 조회할 학과의 일련번호를 담고 있는 Beans
     * @return int - 조회된 데이터 수
     * @throws ServiceNoresultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL처리에 실패한 경우(프로그램적인 에러)
     */
    public int getCount(Department input) throws ServiceNoResultException, Exception;


    /** 
     * 
     * 학과의 상세 정보를 조회한다. 조회된 데이터가 없는 경우 예외가 발생한다.
     * 
     * @Param input - 조회할 학과의 일련번호를 담고 있는 Beans
     * @return Department - 조회된 데이터
     * @throws ServiceNoresultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL처리에 실패한 경우
     */
    public Department getItem(Department input) throws ServiceNoResultException, Exception;


    /** 
     * 
     * 학과 정보를 새로 저장하고 저장된 정보를 조회하여 리턴한다.
     * 
     * @Param input - 저장할 정보를 담고 있는 Beans
     * @return Department - 저장된 데이터
     * @throws ServiceNoresultException - 저장된 데이터가 없는 경우
     * @throws Exception - SQL 처리에 실패한 경우
     */
    public Department addItem(Department input) throws ServiceNoResultException, Exception;


    /** 
     * 
     * 학과 정보를 수정하고 수정된 정보를 조회하여 리턴한다.
     * 
     * @Param input -수정할 정보를 담고 있는 Beans
     * @return Department - 수정된 데이터
     * @throws ServiceNoresultException - 수정된 데이터가 없는 경우
     * @throws Exception - SQL 처리에 실패한 경우
     */
    public Department editItem(Department input) throws ServiceNoResultException, Exception;

    /** 
     * 
     * 학과 정보를 삭제한다. 삭제된 데이터의 수가 리턴된다.
     * 
     * @Param input - 삭제할 조건을 담고 있는 Beans
     * @return int - 삭제된 데이터의 수
     * @throws ServiceNoresultException - 삭제된 데이터가 없는 경우
     * @throws Exception - SQL 처리에 실패한 경우
     */
    public int deleteItem(Department input) throws ServiceNoResultException, Exception;
    

    

}
