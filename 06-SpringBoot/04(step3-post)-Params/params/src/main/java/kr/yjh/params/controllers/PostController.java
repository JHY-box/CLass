package kr.yjh.params.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PostController {
    @GetMapping("/post/home")
    public String home() {
        return "post/home";
    }

    /** POST 방식의 파라미터를 전송받기 위한 컨트롤러 메서드 */
    @PostMapping("/post/answer")
    public String post(Model model,
            HttpServleRes response,
            @RequestAttribute
        
        return entity;
    }
    
    
}
