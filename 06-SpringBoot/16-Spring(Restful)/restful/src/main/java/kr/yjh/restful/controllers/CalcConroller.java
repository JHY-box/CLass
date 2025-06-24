package kr.yjh.restful.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalcConroller {
    @GetMapping("/calc")
    public String calc() {
        // 여기에 계산 로직을 추가할 수 있습니다.
        // 예를 들어, 모델에 데이터를 추가하고 뷰 이름을 반환할 수 있습니다.
        return "error/calc.html"; // calc.html 뷰를 반환
    }
}