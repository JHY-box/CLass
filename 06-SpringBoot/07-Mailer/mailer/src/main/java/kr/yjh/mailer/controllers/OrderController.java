package kr.yjh.mailer.controllers;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import kr.yjh.mailer.helpers.FileHelper;
import kr.yjh.mailer.helpers.MailHelper;
import kr.yjh.mailer.helpers.WebHelper;

@Controller
public class OrderController {
    
    // --> import kr.yjh.mailer.helpers.FileHelper;
    @Autowired
    private FileHelper fileHelper = null;

    // --> import kr.yjh.mailer.helpers.MailHelper;
    @Autowired
    private MailHelper mailHelper = null;

    // --> import kr.yjh.mailer.helpers.WebHelper;
    @Autowired
    private WebHelper webHelper = null;


    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @PostMapping("/order_ok")
    public void orderOk(
        HttpServletResponse response,
        @RequestParam("order-name") String orderName,
        @RequestParam("order-email") String orderEmail,
        @RequestParam("order-price") int orderPrice) {

            /** 1) DB에서 상품정보를 가져왔다고 가정 -> 상품명, 주문수량 */
            String productName = "내가 주문한 상품명";
            int qty = 1;

            /** 2) 결제 일자와 주문번호 생성 */
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int date = cal.get(Calendar.DATE);

            // 결제일자
            // --> $를 %로 바꿔서 실습하세요.
            String orderDate = String.format("%d년 %d월 %d일", year, month, date);

            // 주문번호 -> 년월일 + 그날 몇번째 주문인지에 대한 값 (예 : 202108010001)
            String orderNumber = String.format("%04d%02d%02d%04d", year, month, date, 78);

            /** 3) 주문정보에 따른 DB처리 */
            // 주문정보를 DB에 저장하는 로직은 생략

            /** 4) 주문정보를 메일로 발송 */
            // 메일 템플릿 파일 경로
            ClassPathResource resource = new ClassPathResource("mail_templates/order_result.html");
            String mailTemplatePath = null;
            try {
                mailTemplatePath = resource.getFile().getAbsolutePath();
            } catch (IOException e) {
                webHelper.redirect(500, null, "메일 템플릿을 찾을 수 없습니다.");
                return;
            }

            // 메일 템플릿 파일 가져오기
            String template = null;

            try {
                template = fileHelper.readString(mailTemplatePath);
            } catch (Exception e) {
                // 에러 발생 시 에러 발생 여부를 사용자에게 알리고 전 페이지로 이동
                webHelper.redirect(500, null, "메일 템플릿을 찾을 수 없습니다.");
                return;
            }

            // 메일 템플릿 안의 치환자 처리
            template = template.replace("{{userName}}", orderName);
            template = template.replace("{{orderNumber}}", orderNumber);
            template = template.replace("{{productName}}", productName);
            template = template.replace("{{qty}}", String.valueOf(qty));   // (꼼수) ( qty + "" ) 문자열은 전염성이 강함(전염됨)
            template = template.replace("{{orderDate}}", orderDate);
            template = template.replace("{{orderPrice}}", String.valueOf(orderPrice));

            // 메일 제목
            String subject = orderName + "님의 주문이 완료되었습니다.";

            try {
                mailHelper.sendMail(orderEmail, subject, template);
            } catch (Exception e) {
                // 에러 발생 시 에러 발생 여부를 사용자에게 알리고 전 페이지로 이동
                webHelper.redirect(500, null, "메일 발송에 실패했습니다.");
                return;
            }

            // 주문 결과 페이지로 이동
            webHelper.redirect(200, "/order_result");
        }

        @GetMapping("/order_result")
        public String orderResult() {
            return "order_result";
        }
    }
