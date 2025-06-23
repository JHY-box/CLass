package kr.yjh.params.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    @GetMapping("/post/home")
    public String home() {
        return "post/home";
    }
    
}
