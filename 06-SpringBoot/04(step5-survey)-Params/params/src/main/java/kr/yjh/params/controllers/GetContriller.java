package kr.yjh.params.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class GetContriller {
    @GetMapping("/get/home")
    public String home() {
        return "get/home";
    }
    
}
