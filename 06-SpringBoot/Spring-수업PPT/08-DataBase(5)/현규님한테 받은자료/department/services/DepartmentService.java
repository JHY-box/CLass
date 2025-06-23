package kr.hyungyu.department.services;

import java.util.List;

import kr.hyungyu.department.exceptions.ServiceNoResultException;
import kr.hyungyu.department.models.Department;

public interface DepartmentService {
    /**
     * <학과의 목록을 조회>
     * 
     * @param input - 조회할 학과의 검색어를 담고있는 beans
     * @return - List<Department> 조회된 데이터
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - sql 처리에 실패한 경우 (프로그램적인 에러)
     */
    public List<Department> getList(Department input) throws ServiceNoResultException, Exception;

    /**
     * <학과의 목록을 조회>
     * 
     * @param input - 조회할 학과의 검색어를 담고있는 beans
     * @return - int 검색 조건에 맞는 데이터의 수
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - sql 처리에 실패한 경우 (프로그램적인 에러)
     */
    public int getCount(Department input) throws ServiceNoResultException, Exception;

    /**
     * <학과의 상세정보를 조회>
     * 
     * @param input - 조회할 학과의 일련번호를 담고있는 beans 
     * @return - 조회된 데이터
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - sql처리에 실패한 경우
     */
    public Department getItem(Department input) throws ServiceNoResultException, Exception;

    /**
     * <학과 데이터를 추가하고 저장된 정보를 바로 리턴하여 확인시킴>
     * 
     * @param input - 저장할 정보를 담고있는 beans
     * @return - 조회된 데이터
     * @throws ServiceNoResultException - 저장된 데이터가 없는경우
     * @throws Exception - sql 처리에 실패한 경우 (프로그램적인 에러)
     */
    public Department addItem(Department input) throws ServiceNoResultException, Exception;

    /**
     * <학과 정보를 수정하고 수정한 내역을 리턴한다.>
     * 
     * @param input - 수정할 정보를 담고 있는 beans
     * @return - 수정된 데이터
     * @throws ServiceNoResultException - 수정된 데이터가 없는 경우
     * @throws Exception  - sql문이 처리되지 않았을 경우
     */
    public Department editItem(Department input) throws ServiceNoResultException, Exception;

    /**
     * <학과 정보를 삭제한다.>
     * 
     * @param input - 삭제할 정보가 담겨있는 beans
     * @return - 삭제한 정보의 수
     * @throws ServiceNoResultException - 삭제된 데이터가 없는 경우
     * @throws Exception - sql문이 정상 처리되지 않은 경우
     */
    public int deleteItem(Department input) throws ServiceNoResultException, Exception;
} 

