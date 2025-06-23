package kr.hossam.database.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import kr.hossam.database.helpers.PageHelper;
import kr.hossam.database.helpers.WebHelper;
import kr.hossam.database.models.Department;
import kr.hossam.database.services.DepartmentService;

@Controller
public class DepartmentController {
    /** 학과 관리 서비스 객체 주입 */
    @Autowired
    private DepartmentService departmentService;

    /** WebHelper 주입 */
    @Autowired
    private WebHelper webHelper;

    /**
     * 학과 목록 화면
     *
     * @param model 모델
     * @return 학과 목록 화면을 구현한 View 경로
     */
    @GetMapping("/department")
    public String index(Model model,
            // 검색어 파라미터 (페이지가 처음 열릴 때는 값 없음. 필수(required)가 아님)
            @RequestParam(value = "keyword", required = false) String keyword,
            // 페이지 구현에서 사용할 현재 페이지 번호
            @RequestParam(value = "page", defaultValue = "1") int nowPage) {

        int totalCount = 0; // 전체 데이터 수 (DB에서 조회해야 함)
        int listCount = 10; // 한 페이지당 표시할 목록 수
        int groupCount = 5; // 한 그룹당 표시할 페이지 번호 수

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
            // 페이지 번호 계산 --> 계산결과를 로그로 출력될 것이다.
            pageHelper = new PageHelper(nowPage, totalCount, listCount, groupCount);

            // SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
            Department.setOffset(pageHelper.getOffset());
            Department.setListCount(pageHelper.getListCount());

            output = departmentService.getList(input);
        } catch (Exception e) {
            webHelper.serverError(e);
        }

        // 조회 결과를 View에 전달하기 위해 모델에 추가
        model.addAttribute("departments", output);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageHelper", pageHelper);

        return "department/index";
    }
}
