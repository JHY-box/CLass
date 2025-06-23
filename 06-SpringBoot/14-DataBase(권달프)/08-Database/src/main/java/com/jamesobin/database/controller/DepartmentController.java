package com.jamesobin.database.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jamesobin.database.exceptions.StringFormatException;
import com.jamesobin.database.helpers.PageHelper;
import com.jamesobin.database.helpers.RegexHelper;
import com.jamesobin.database.helpers.WebHelper;
import com.jamesobin.database.models.Department;
import com.jamesobin.database.services.DepartmentService;


@Controller
public class DepartmentController {
    /** 
     * 학과 관리 서비스 객체 주입 
     */
    @Autowired
    private DepartmentService departmentService;

    /** 
     * WebHelper 주입 
     */
    @Autowired
    private WebHelper webHelper;

    /**
     * RegexHelper 주입
     */
    @Autowired
    private RegexHelper regexHelper;

    /**
     * 학과 목록 화면
     * 
     * @param model 모델
     * @return 학과 목록 화면을 구현한 View 경로
     */
    @GetMapping("/department")
    public String index(Model model
    // 검색어 파라미터(페이지가 처음 열릴 때는 값 없음. 필수(required)가 아님)
    , @RequestParam(value="keyword", required=false) String keyword
    // 페이지 구현에서 사용할 현재 페이지 번호
    , @RequestParam(value="page", defaultValue="1") int nowPage) {

        int totalCount = 0;     // 전체 데이터 수 (DB에서 조회해야 함)
        int listCount = 10;      // 한 페이지당 표시할 목록 수
        int groupCount = 5;     // 한 그룹당 표시할 페이지 번호 수

        // 페이지 번호를 계산한 결과가 저장될 객체
        PageHelper pageHelper = null;

        // 검색 조건에 사용할 객체
        Department input = new Department();
        input.setDname(keyword);
        input.setLoc(keyword);

        List<Department> output = null;

        try {
            // 전체 데이터 수 조회
            totalCount = departmentService.getCount(input);
            // 페이지 번호 계산 --> 계산결과를 로그로 출력 예정
            pageHelper = new PageHelper(nowPage, totalCount, listCount, groupCount);

            // SQL의 LIMIT 절에서 사용될 값을 Beans의 static 변수에 저장
            Department.setOffset(pageHelper.getOffset());
            Department.setListCount(pageHelper.getListCount());

            output = departmentService.getList(input);
        }  catch (Exception e) {
            webHelper.serverError(e);
        }

        // 조회 결과를 View에 전달하기 위해 모델에 추가
        model.addAttribute("departments", output);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageHelper", pageHelper);

        return "department/index";
    }

    /**
     * 드옭 페이지를 표시하기 위한 컨트롤러
     * 
     * @return 뷰 페이지 경로
     */
    @GetMapping("/department/add")
    public String add() {
        return "department/add";
    }

    @PostMapping("/department/add_ok")
    public String addOk(
        Model model
        // 입력내용 파라미터 받기
        , @RequestParam(value="dname", required=true) String dname
        , @RequestParam(value="loc", required=true) String loc
        , @RequestParam(value="phone", required=true) String phone
        , @RequestParam(value="email", required=true) String email
        , @RequestParam(value="established", required=true) String established
        , @RequestParam(value="homepage", required=true) String homepage) {

        // [중요] 파라미터로 받은 입력값이 적절한지 유효성 검사
        try {
            regexHelper.isValue(dname, "학과 이름이 없습니다.");
            regexHelper.isKor(dname, "이름은 한글만 입력하세요.");

            regexHelper.isValue(loc, "학과 위치가 없습니다");

            regexHelper.isValue(phone, "연락처를 입력하세요.");
            regexHelper.isPhone(phone, "연락처 형식이 잘못되었습니다.");

            regexHelper.isValue(email, "이메일을 입력하세요.");
            regexHelper.isEmail(email, "이메일 형식이 잘못되었습니다.");

            regexHelper.isValue(established, "설립년도를 입력하세요.");
            regexHelper.isNum(established, "설립년도 형식이 잘못되었습니다.");

            regexHelper.isValue(homepage, "홈페이지를 입력하세요");
            regexHelper.isUrl(homepage, "홈페이지 형식이 잘못되었습니다.");
        } catch(StringFormatException e) {
            webHelper.serverError(e);
            return null;
        }

        // 파라미터를 SErvice 객체에 전달하기 위해 Model 객체에 저장
        Department input = new Department();
        input.setDname(dname);
        input.setLoc(loc);
        input.setPhone(phone);
        input.setEmail(email);
        input.setEstablished(Integer.parseInt(established));
        input.setHomepage(homepage);

        Department output = null;

        try {
            output = departmentService.addItem(input);
        } catch(Exception e) {
            webHelper.serverError(e);
            return null;
        }

        return "redirect:/department/view/" + output.getId();
    }
    
    /**
     * 학과 조회
     * 
     * @param model 모델
     * @param id 학과 ID
     * @return 뷰 페이지 경로
     */
    @GetMapping("/department/view/{id}")
    public String view(Model model, @PathVariable(value="id", required=true) int id) {
        Department input = new Department();
        input.setId(id);

        Department output = null;

        try {
            output = departmentService.getItem(input);
        } catch(Exception e) {
            webHelper.serverError(e);
            return null;
        }

        model.addAttribute("department", output);

        return "department/view";
    }
    
    /**
     * 학과 삭제 처리
     * 
     * @param model 모델
     * @param id 학과 ID
     * @return 삭제 후 목록 페이지로 리다이렉트
     */
    @DeleteMapping("/department/delete/{id}")
    public void delete(Model model, @PathVariable(value="id", required=true) int id) {
        Department input = new Department();
        input. setId(id);

        try {
            departmentService.deleteItem(input);
        } catch(Exception e) {
            webHelper.serverError(e);
            return;
        }

        // 삭제 후 목록 페이지로 리다이렉트
        webHelper.redirect("/department", "삭제되었습니다.");
    }

    /**
     * 학과 수정 페이지를 표시하기 위한 컨트롤러
     * 
     * @param model 모델
     * @param id 학과 ID
     * @return 뷰 페이지 경로
     */
    @GetMapping("/department/edit/{id}")
    public String edit(Model model, @PathVariable(value="id", required=true) int id) {
        Department input = new Department();
        input.setId(id);

        Department output = null;

        try {
            output = departmentService.getItem(input);
        }  catch (Exception e) {
            webHelper.serverError(e);
            return null;
        }

        model.addAttribute("department", output);

        return "department/edit";
    }
    

    /**
     * 학과 수정 처리
     * 
     * @param model 모델
     * @param id 학과 ID
     * @param dname 학과 이름
     * @param loc 학과 위치
     * @param phone 연락처
     * @param email 이메일
     * @param established 설립년도
     * @param homepage 홈페이지 주소
     */
    @PutMapping("/department/edit_ok/{id}")
    public void editOk(
        Model model
        , @PathVariable(value="id", required=true) int id
        , @RequestParam(value="dname", required=true) String dname
        , @RequestParam(value="loc", required=true) String loc
        , @RequestParam(value="phone", required=true) String phone
        , @RequestParam(value="email", required=true) String email
        , @RequestParam(value="established", required=true) String established
        , @RequestParam(value="homepage", required=true) String homepage) {
        // 유효성 검사
        try {
            regexHelper.isValue(dname, "학과 이름이 없습니다.");
            regexHelper.isKor(dname, "이름은 한글만 입력하세요.");

            regexHelper.isValue(loc, "학과 위치가 없습니다");

            regexHelper.isValue(phone, "연락처를 입력하세요.");
            regexHelper.isPhone(phone, "연락처 형식이 잘못되었습니다.");

            regexHelper.isValue(email, "이메일을 입력하세요.");
            regexHelper.isEmail(email, "이메일 형식이 잘못되었습니다.");

            regexHelper.isValue(established, "설립년도를 입력하세요.");
            regexHelper.isNum(established, "설립년도 형식이 잘못되었습니다.");

            regexHelper.isValue(homepage, "홈페이지를 입력하세요");
            regexHelper.isUrl(homepage, "홈페이지 형식이 잘못되었습니다.");
        } catch(StringFormatException e) {
            webHelper.serverError(e);
            return;
        }

        // 파라미터를 Service 객체에 전달하기 위해 Model 객체에 저장
        Department input = new Department();
        input.setId(id);
        input.setDname(dname);
        input.setLoc(loc);
        input.setPhone(phone);
        input.setEmail(email);
        input.setEstablished(Integer.parseInt(established));
        input.setHomepage(homepage);

        Department output;

        try {
            output = departmentService.editItem(input);
        } catch(Exception e) {
            webHelper.serverError(e);
            return;
        }

        // 수정 후 상세 페이지로 리다이렉트
        webHelper.redirect("/department/view/" + output.getId(), "수정되었습니다.");
    }
}
