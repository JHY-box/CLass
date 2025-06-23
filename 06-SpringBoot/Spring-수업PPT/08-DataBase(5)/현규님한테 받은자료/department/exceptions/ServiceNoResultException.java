package kr.hyungyu.department.exceptions;

public class ServiceNoResultException extends Exception{ // 서비스 상 발생하는 에러를 대처하기 위한 클래스 형성
    public ServiceNoResultException(String message) {
        super(message);
    }
}
