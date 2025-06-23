
package kr.yjh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import kr.yjh.models.Department;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App04 {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("검색어를 입력하세요: ");
        String keyword = scanner.nextLine();
        scanner.close();

        String host = "127.0.0.1";
        int port =9090;
        String username = "root";
        String password = "1234";
        String database = "myschool";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Department> list = null;

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

        String sql = "SELECT id, dname, loc, phone, email, established, homepage FROM departments WHERE dname LIKE concat('%', ?, '%')";

        log.debug(sql);
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, keyword);

            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            log.error("SQL문 준비 실패", e);
            return;
        }

        try {
            list = new ArrayList<Department>();
            
            while(rs.next()) {
                
                int id = rs.getInt("id");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int established = rs.getInt("established");
                String homepage = rs.getString("homepage");
            
                Department dept = new Department();
                dept.setId(id);
                dept.setDname(dname);
                dept.setLoc(loc);
                dept.setPhone(phone);
                dept.setEmail(email);
                dept.setEstablished(established);
                dept.setHomepage(homepage);

                list.add(dept);
            }

            for (Department d : list) {
                log.debug(d.toString());
            }
                
        } catch (SQLException e) {
            log.error("SQL문 실행 실패",e);
            return;
        }

        try{
            conn.close();
        }catch(SQLException e){
            log.error("DB접속 해제 실패", e);
        }
    }
}