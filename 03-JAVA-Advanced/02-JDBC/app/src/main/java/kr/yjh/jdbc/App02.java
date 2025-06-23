
package kr.yjh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import kr.yjh.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App02 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("조회할 학과번호를 입력하세요: ");
        int departmentId = scanner.nextInt();
        scanner.close();


        // 1) 데이터베이스에 접속하기 위한 정보를 변수로 구성
        String host = "127.0.0.1";
        int port =9090;
        String username = "root";
        String password = "1234";
        String database = "myschool";

        // 2)데이터베이스에 접속
        Connection conn = null;          // DB 접속 객체
        PreparedStatement pstmt = null;  // SQL문을 MariaDB에 전당하는 객체
        ResultSet rs = null;             //SELECT문 실행 결과를 저장하는 객체

        //접속주소 구성
        // jdbc:mariadb://127.0.0.1:3306/mtschool?characterEncoding=utf8&serverTimezone=UTC
        String urlFormat = "jdbc:log4jdbc:mariadb://%s:%d/%s?characterEncoding=utf8&serverTimezone=UTC";
        String url = String.format(urlFormat, host, port, database);
        log.debug("접속 주소: " + url);

        
        try {
            // MariaDB JDBC 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");
            log.debug("MariaDB JDBC 드라이버 로드 성공");

            // DB 접속 --> Mariadb -uroot -p --port=9090
            conn = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            log.error("MariaDB JDBC 드라이버 로드 실패", e);
            return;
        } catch (SQLException e) {
            log.error("MariaDB 접속 실패", e);
            return;
        }

        // 3) 수행할 SQL문을 문자열 변수로 준비
        String sql = "SELECT id, dname, loc, phone, email, established, homepage FROM departments WHERE id=?";

        // 4) MySQL에게 SQL문을 전달하고 결과를 반환받기
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, departmentId);

            // SQL문 실행
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            log.error("SQL문 준비 실패", e);
            return;
        }

        // 5) SQL 경과 출력하기
        try {
            boolean ok = rs.next();
            if(!ok){
                // 강제로 SQLException 발생하여 catch
                throw new SQLException("조회된 데이터가 없습니다.");
            }

            //rs.get|Int|String|("컬럼명") : 컬럼명으로 데이터 꺼내기
            int id = rs.getInt("id");
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            int established = rs.getInt("established");
            String homepage = rs.getString("homepage");

            // 꺼낸 데이터를 로그에 기록
            log.debug("학과 ID: " + id);
            log.debug("학과명: "+dname);
            log.debug("위치: "+loc);
            log.debug("전화번호: "+phone);
            log.debug("이메일: "+email);
            log.debug("설립연도: "+established);
            log.debug("홈페이지: "+homepage);

            // Beans객체에 담기
            Department dept = new Department();
            dept.setId(id);
            dept.setDname(dname);
            dept.setLoc(loc);
            dept.setPhone(phone);
            dept.setEmail(email);
            dept.setEstablished(established);
            dept.setHomepage(homepage);
            
        } catch (SQLException e) {
            log.error("SQL문 실행 실패",e);
            return;
        }

        // 6) 데이터베이스 접속 해제
        try{
            conn.close();
        }catch(SQLException e){
            log.error("DB접속 해제 실패", e);
        }
    }
}