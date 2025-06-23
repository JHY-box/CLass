package kr.yjh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.yjh.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App05 {
    
    public static void main(String[] args) {
    
        String host = "127.0.0.1";
        int port =9090;
        String username = "root";
        String password = "1234";
        String database = "myschool";

        Connection conn = null;
        PreparedStatement pstmt = null;
        // ResultSet rs = null;
        // List<Department> list = null;
        
        int result = 0;
        
        ResultSet rs = null;
        int newpk = 0;

        String urlFormat = "jdbc:log4jdbc:mariadb://%s:%d/%s?characterEncoding=utf8&serverTimezone=UTC";
        String url = String.format(urlFormat, host, port, database);
        log.debug("접속 주소: " + url);

    
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            log.debug("MariaDB JDBC 드라이버 로드 성공");

            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            log.error("MariaDB JDBC 드라이버 로드 실패", e);
            return;
        } catch (SQLException e) {
            log.error("MariaDB 접속 실패", e);
            return;
        }

        // 3) 수행할 SQL문을 문자열 변수로 준비
        //사용자의 입력값을 가정한 변수
        String dname = "신규학과";
        String loc = "위치";
        String phone = "010-1234-1234";
        String email = "hell@gmail.com";
        int established = 2025;
        String homepage = null;

        // sql문
        String sql = "INSERT INTO departments (dname, loc, phone, email, established, homepage) VALUES (?, ?, ?, ?, ?, ?)";

        // 4)MariaDB에게 SQL문을 전달하고 결과를 반환받기
        try {
            // AUTO_INCREMENT 조회 옵션 사용함 -->INSERT문에서만 사용
            pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,dname);
            pstmt.setString(2,loc);
            pstmt.setString(3,phone);
            pstmt.setString(4,email);
            pstmt.setInt(5,established);
            pstmt.setString(6,homepage);
    
            
            // SQL문 실행 --> INSEET, UPDATE, DELETE는 executeUpdate() 메서드 사용
            //리턴되는 값은 반영된 데이터 수 (int)
            result = pstmt.executeUpdate();
    
            // INSERT문의 경우만 생성된 PK값을 추출
            rs = pstmt.getGeneratedKeys();
            rs.next();
            newpk = rs.getInt(1);
            } catch (SQLException e) {
                log.error("SQL문 준비 실패", e);
                return;
            }
    
            // 5) SQL 결과 출력하기
            log.debug("저장된 데이터의 수: " + result);
            log.debug("생성된 Promary Key: " + newpk);
    
            // 6) 데이터 베스이 접속 해제
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("DB 접속 해제 실패", e);
            }
        }
    }
    
            
