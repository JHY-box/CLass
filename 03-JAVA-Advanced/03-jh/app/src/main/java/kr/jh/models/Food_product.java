package kr.jh.models;

import lombok.Data;
 //▲▲▲▲ @Data ▲▲▲▲
@Data // Lombokdml @Data 애너테이션을 사용하여 getter, setter, toString 메서드를 자동 생성

/** 학과 정보를 저장하는 클래스  */
public class Food_product {

    private String product_id;

    private String product_name;
    
    private String product_cd;
    
    private String category;

    private int price;

}
