package kr.yjh.mailer.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class MailController {
    
    @Autowired
    JavaMailSender javaMailSender;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/sendmail")
    public String sendmail(
        @RequestParam("Sender-name") String senderName,
        @RequestParam("Sender-email") String senderEmail,
        @RequestParam("Receiver-name") String receiverName,
        @RequestParam("Receiver-email") String receiverEmail,
        @RequestParam("Subject") String subject,
        @RequestParam("Content") String content
    ) {
        
        /** 1) 메일 발송 정보 로그 확인 */
        log.debug("------------------------------------------------");
        log.debug(String.format("senderName: %s", senderName));
        log.debug(String.format("senderEmail: %s", senderEmail));
        log.debug(String.format("RecvName: %s", receiverName));
        log.debug(String.format("RecvEmail: %s", receiverEmail));
        log.debug(String.format("Subject: %s", subject));
        log.debug(String.format("Content: %s", content));
        log.debug("------------------------------------------------");

        /** 2) Java Mail 라이브러리를 활용한 메일 발송 */
        // --> import jakarta.mail.internet.MimeMessage;
        MimeMessage message = javaMailSender.createMimeMessage();
        // --> import org.springframework.mail.javamail.MimeMessageHelper;
        MimeMessageHelper helper = new MimeMessageHelper(message);

        //제목, 내용, 수신자 설정
        try {
            helper.setSubject(subject);
            helper.setText(content, true);
            helper.setTo(new InternetAddress(receiverEmail, receiverName, "UTF-8"));
            helper.setFrom(new InternetAddress(senderEmail, senderName, "UTF-8"));
        } catch (MessagingException e) {
            //에러가 발생했음을 사용자에게 alert으로 알라고 전 페이지로 이동하는 처리가 필요.
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            //에러가 발생했음을 사용자에게 alert으로 알리고 전 페이지로 이동하는 처리가 필요. 
            e.printStackTrace();
        }

        // 메일 보내기
        javaMailSender.send(message);

        return "redirect:/";

        }
    }