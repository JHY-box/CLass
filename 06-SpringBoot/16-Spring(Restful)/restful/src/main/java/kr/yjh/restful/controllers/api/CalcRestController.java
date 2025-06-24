package kr.yjh.restful.controllers.api;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * RESTFUL API 방식의 컨트롤러
 * X와 Y의 사칙연산을 수행한다.
 * 단, X와 Y는 모두 0보다 커야한다.
 */
@RestController
public class CalcRestController {

    @GetMapping("/api/my_calc")
    public Map<String, Object> plus(@RequestParam("x") int x, @RequestParam("y") int y) {
        /** 1) 파라미터 유효성 검사 */
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("X와 Y는 모두 0보다 커야합니다.");
        }

        /** 2) 처리해야할 로직 수행 (DB연동 등을 가정) */
        int z = x + y;

        /** 3) 응답 결과를 구성 */
        Map<String, Object> output = new LinkedHashMap<String, Object>();

        output.put("x", x);
        output.put("y", y);
        output.put("z", z);

        /** 4) 출력 형식 구성 */
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("status", 200);
        result.put("message", "OK");
        result.put("item", output);
        result.put("timestame", LocalDateTime.now().toString());

        return result;
    }


    @PostMapping("/api/my_calc")
    public Map<String, Object> minus(@RequestParam("x") int x, @RequestParam("y") int y) {
        /** 1) 파라미터 유효성 검사 */
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("X와 Y는 모두 0보다 커야합니다.");
        }

        /** 2) 처리해야할 로직 수행 (DB연동 등을 가정) */
        int z = x - y;

        /** 3) 응답 결과를 구성 */
        Map<String, Object> output = new LinkedHashMap<String, Object>();

        output.put("x", x);
        output.put("y", y);
        output.put("z", z);

        /** 4) 출력 형식 구성 */
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("status", 200);
        result.put("message", "OK");
        result.put("item", output);
        result.put("timestame", LocalDateTime.now().toString());

        return result;
    }


    @PutMapping("/api/my_calc")
    public Map<String, Object> times(@RequestParam("x") int x, @RequestParam("y") int y) {
        /** 1) 파라미터 유효성 검사 */
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("X와 Y는 모두 0보다 커야합니다.");
        }

        /** 2) 처리해야할 로직 수행 (DB연동 등을 가정) */
        int z = x * y;
        
        /** 3) 응답 결과를 구성 */
        Map<String, Object> output = new LinkedHashMap<String, Object>();

        output.put("x", x);
        output.put("y", y);
        output.put("z", z);

        /** 4) 출력 형식 구성 */
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("status", 200);
        result.put("message", "OK");
        result.put("item", output);
        result.put("timestame", LocalDateTime.now().toString());

        return result;
    }


    @DeleteMapping("/api/my_calc")
    public Map<String, Object> divide(@RequestParam("x") int x, @RequestParam("y") int y) {
        /** 1) 파라미터 유효성 검사 */
        if (x < 0 || y <= 0) {
            throw new IllegalArgumentException("X는 0보다 크고, Y는 0보다 커야합니다.");
        }

        /** 2) 처리해야할 로직 수행 (DB연동 등을 가정) */
        int z = x / y;

        /** 3) 응답 결과를 구성 */
        Map<String, Object> output = new LinkedHashMap<String, Object>();

        output.put("x", x);
        output.put("y", y);
        output.put("z", z);

        /** 4) 출력 형식 구성 */
        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("status", 200);
        result.put("message", "OK");
        result.put("item", output);
        result.put("timestame", LocalDateTime.now().toString());

        return result;
    }
        
}
