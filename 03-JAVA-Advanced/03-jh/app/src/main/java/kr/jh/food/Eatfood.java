package kr.jh.food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.jh.models.Food_product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Eatfood {
    public static void main(String[] args) {
        
        String host = "127.0.0.1";
        int port =9090;
        String username = "root";
        String password = "1234";
        String database = "programmers";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String urlFormat = "jdbc:mariadb://%s:%d/%s?characterEncoding=utf8&serverTimezone=UTC";
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


        String sql = "SELECT product_id, product_name, product_cd, category, price from food_product";

        try {
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            log.error("SQL문 준비 실패");
            return;
        }

        try {
            boolean ok = rs.next();
            if (!ok) {
                throw new SQLException("조회된 데이터가 없습니다.");
            }
            String product_id = rs.getString("product_id");
            String product_name  = rs.getString("product_name");
            String product_cd   = rs.getString("product_cd");
            String category  = rs.getString("category");
            int price  =  rs.getInt("price");

    
            log.debug("ID: " + product_id);
            log.debug("이름: " + product_name);
            log.debug("코드: " + product_cd);
            log.debug("분류: " + category);
            log.debug("가격: " + price);
    
            Food_product product =new Food_product();
            product.setProduct_id(product_id);
            product.setProduct_name(product_name);
            product.setProduct_cd(product_cd);
            product.setCategory(category);
            product.setPrice(price);

            log.debug("학과 객체: " + product.toString());

        } catch (SQLException e) {
            log.debug("SQL문 실행 실패", e);
            return;
        }

        try {
            conn.close();
        } catch (SQLException e) {
            log.error("SQL문 실행 실패");
        }
    
    }
}
