package kr.hossam.database.services;

import java.util.List;
import kr.hossam.database.exceptions.ServiceNoResultException;
import kr.hossam.database.models.Student;

public interface StudentService {
    /**
     * 데이터 목록을 조회한다.
     *
     * @param input - 조회할 데이터에 대한 검색조건을 담고 있는 Beans
     * @return List<Student> - 조회된 데이터
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL처리에 실패한 경우(프로그램적인 에러)
     */
    public List<Student> getList(Student input) throws ServiceNoResultException, Exception;


    /**
     * 검색조건에 대한 데이터 수를 조회한다. 검색조건이 없는 경우 전체 데이터 수를 조회한다.
     *
     * @param input - 조회할 데이터에 대한 검색조건을 담고 있는 Beans
     * @return int - 조회된 데이터 수
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL처리에 실패한 경우(프로그램적인 에러)
     */
    public Student getItem(Student input) throws ServiceNoResultException, Exception;

    /**
     * 데이터의 상세 정보를 조회한다. 조회된 데이터가 없는 경우 예외가 발생한다.
     *
     * @param input - 조회할 데이터의 일련번호를 담고 있는 Beans
     * @return Student - 조회된 데이터
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL처리에 실패한 경우
     */
    public Student addItem(Student input) throws ServiceNoResultException, Exception;

    /**
     * 데이터를 저장하고, 저장된 정보를 조회하여 리턴한다.
     *
     * @param input - 저장할 정보를 담고 있는 Beans
     * @return Student - 저장된 데이터
     * @throws ServiceNoResultException - 저장된 데이터가 없는 경우
     * @throws Exception - SQL 처리에 실패한 경우
     */
    public Student editItem(Student input) throws ServiceNoResultException, Exception;

    /**
     * 데이터를 수정하고, 수정된 정보를 조회하여 리턴한다.
     *
     * @param input - 수정할 정보를 담고 있는 Beans
     * @return Student - 수정된 데이터
     * @throws ServiceNoResultException - 수정된 데이터가 없는 경우
     * @throws Exception - SQL 처리에 실패한 경우
     */
    public int deleteItem(Student input) throws ServiceNoResultException, Exception;

    /**
     * 데이터를 삭제한다. 삭제된 데이터의 수가 리턴된다.
     *
     * @param input - 삭제할 조건을 담고 있는 Beans
     * @return int - 삭제된 데이터의 수
     * @throws ServiceNoResultException - 삭제된 데이터가 없는 경우
     * @throws Exception - SQL처리에 실패한 경우
     */
    public int getCount(Student input) throws ServiceNoResultException, Exception;
}