package kr.yjh.aop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import kr.yjh.aop.services.MycalcService;

@Controller
public class HomeController {
    //MyCalcService를 주입받는다.
    @Autowired
    private MycalcService mycalcService;
    
    @GetMapping("/")
    public String home(Model model) {
        int value1 = mycalcService.plus(100, 200);
        int value2 = mycalcService.minus(200, 300);

        model.addAttribute("value1", value1);
        model.addAttribute("value2", value2);
        
        return "index";
    }
}
