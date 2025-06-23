package kr.yjh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App07 {
    
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
        
        //✅ INSERT, UPDATE, DELETE는 변경된 데이터를 반환받는다.
        int result = 0;
        

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
        int student_id = 10175; // <-- 자신의 DB에 존재하는 값이어야함
        int subject_id = 1044;

        // sql문
        String sql = "DELETE FROM enrollments WHERE student_id = ? AND subject_id = ?";

        // 4)MariaDB에게 SQL문을 전달하고 결과를 반환받기
        try {
            // AUTO_INCREMENT 조회 옵션 사용함 -->INSERT문에서만 사용
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student_id);
            pstmt.setInt(2, subject_id);
    
            // SQL문 실행 --> INSEET, UPDATE, DELETE는 executeUpdate() 메서드 사용
            //리턴되는 값은 반영된 데이터 수 (int)
            result = pstmt.executeUpdate();

            //✅ SQL문 실행 --> INSERT, UPDATE, DELETE는 executeUpdate() 메서드 사용
            //리턴되는 값은 반영된 데이터 수 (int)
            } catch (SQLException e) {
                log.error("SQL문 준비 실패", e);
                return;
            }
    


            // 5) SQL 결과 출력하기
            log.debug("삭제된 데이터의 수: " + result);
    
            // 6) 데이터 베스이 접속 해제
            try {
                conn.close();
            } catch (SQLException e) {
                log.error("DB 접속 해제 실패", e);
            }
    }
}
