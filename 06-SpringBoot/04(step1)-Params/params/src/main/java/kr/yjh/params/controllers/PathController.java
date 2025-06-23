package kr.yjh.params.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PathController {
    @GetMapping("/path/home")
    public String home() {
        return "path/home";
    }
    
}
