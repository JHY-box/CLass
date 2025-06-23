package kr.hossam.database.services;

import java.util.List;
import kr.hossam.database.exceptions.ServiceNoResultException;
import kr.hossam.database.models.Professor;

/**
 * 교수 관리에 필요한 기능 정의
 *
 * 교수 관리 기능과 관련된 MyBatis Mapper를 간접적으로 호출하는 역할
 * 이 인터페이스의 구현체(Impl)을 통해서 처리한다.
 */
public interface ProfessorService {

    /**
     * 교수 목록을 조회한다.
     *
     * @param input - 조회할 교수의 검색 조건을 담고 있는 Professor 객체
     * @return List<Professor> - 조회된 교수 목록
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL 처리 실패 등 기타 예외
     */
    public List<Professor> getList(Professor input) throws ServiceNoResultException, Exception;

    /**
     * 교수 목록에 대한 데이터 수를 조회한다. 검색 조건이 없는 경우 전체 데이터 수를 조회한다.
     *
     * @param input - 조회할 교수의 검색 조건을 담고 있는 Professor 객체
     * @return int - 조회된 데이터 수
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL 처리 실패 등 기타 예외
     */
    public int getCount(Professor input) throws ServiceNoResultException, Exception;

    /**
     * 교수의 상세 정보를 조회한다.
     *
     * @param input - 조회할 교수의 PK(id)를 담고 있는 Professor 객체
     * @return Professor - 조회된 교수 정보
     * @throws ServiceNoResultException - 조회된 데이터가 없는 경우
     * @throws Exception - SQL 처리 실패 등 기타 예외
     */
    public Professor getItem(Professor input) throws ServiceNoResultException, Exception;

    /**
     * 교수를 추가하고 저장된 정보를 조회하여 리턴한다.
     *
     * @param input - 추가할 교수 정보를 담고 있는 Professor 객체
     * @return Professor - 추가된 교수 정보(생성된 PK 포함)
     * @throws ServiceNoResultException - 저장된 데이터가 없는 경우
     * @throws Exception - SQL 처리 실패 등 기타 예외
     */
    public Professor addItem(Professor input) throws ServiceNoResultException, Exception;

    /**
     * 교수 정보를 수정하고 수정된 정보를 조회하여 리턴한다.
     *
     * @param input - 수정할 교수 정보를 담고 있는 Professor 객체
     * @return Professor - 수정된 교수 정보
     * @throws ServiceNoResultException - 수정된 데이터가 없는 경우
     * @throws Exception - SQL 처리 실패 등 기타 예외
     */
    public Professor editItem(Professor input) throws ServiceNoResultException, Exception;

    /**
     * 교수를 삭제한다. 삭제된 데이터의 수가 리턴된다.
     *
     * @param input - 삭제할 교수의 PK(id)를 담고 있는 Professor 객체
     * @return int - 삭제된 데이터의 수
     * @throws ServiceNoResultException - 삭제된 데이터가 없는 경우
     * @throws Exception - SQL 처리 실패 등 기타 예외
     */
    public int deleteItem(Professor input) throws ServiceNoResultException, Exception;
}