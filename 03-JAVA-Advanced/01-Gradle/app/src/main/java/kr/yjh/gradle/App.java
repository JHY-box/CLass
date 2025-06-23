package kr.yjh.gradle;

import kr.yjh.models.Department;
import lombok.extern.slf4j.Slf4j;

/** ▲▲▲ @Slf4j ▲▲▲ 임포트 소환 */
@Slf4j
public class App {
    public static void main(String[] args) {
        
        
        //TRACE< DEBUG<INFO<WARN<ERROR
        log.error("에러 발생");      //5레벨
        log.warn("경고 발생");       //4레벨
        log.info("정보 메시지");     //3레벨
        log.debug("디버그 메시지"); //2레벨
        log.trace("추적 메시지");   //1레벨

        /** ( CTRL + H ) = 단어 찾아서 한번에 여러개 다 바꾸기 ( )*/
        
        Department department = new Department();

        department.setId(101);
        department.setDname("컴퓨터공학과");
        department.setLoc("공학관");
        department.setPhone("051-123-4567");
        department.setEmail("cs@myschool.ac.kr");
        department.setEstablished(1998);
        department.setHomepage("http://sc.myschool.co.kr");

        System.out.println("[toString()] 메서드 호출 결과");
        System.out.println(department.toString());

        System.out.println("[getter 메서드 호출 결과]");
        System.out.println(String.format("학과번호: %d", department.getId()));
        System.out.println(String.format("학과명: %s", department.getDname()));
        System.out.println(String.format("위치: %s", department.getLoc()));
        System.out.println(String.format("전화번호: %s", department.getPhone()));
        System.out.println(String.format("이메일 주소: %s", department.getEmail()));
        System.out.println(String.format("설립 연도: %d", department.getEstablished()));
        System.out.println(String.format("홈페이지 주소: %s", department.getHomepage()));
    }
}
/** ( CTRL + H ) = 단어 찾아서 한번에 여러개 다 바꾸기 ( )*/
