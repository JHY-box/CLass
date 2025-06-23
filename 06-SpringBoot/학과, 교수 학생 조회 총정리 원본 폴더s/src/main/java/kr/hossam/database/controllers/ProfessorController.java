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
import kr.hossam.database.models.Professor;
import kr.hossam.database.services.DepartmentService;
import kr.hossam.database.services.ProfessorService;

@Controller
public class ProfessorController {
    /** 교수 관리 서비스 객체 주입 */
    @Autowired
    private ProfessorService professorService;

    /** 학과 관리 서비스 객체 주입 */
    @Autowired
    private DepartmentService departmentService;

    /** WebHelper 주입 */
    @Autowired
    private WebHelper webHelper;

    /**
     * 교수 목록 화면
     *
     * @param model 모델
     * @return 교수 목록 화면을 구현한 View 경로
     */
    @GetMapping("/professor")
    public String index(Model model,
            // 검색어 파라미터 (페이지가 처음 열릴 때는 값 없음. 필수(required)가 아님)
            @RequestParam(value = "keyword", required = false) String keyword,
            // 학과 번호 파라미터 (페이지가 처음 열릴 때는 값이 0으로 설정됨)
            // 기본값 설정시 데이터 타입에 상관 없이 문자열로 지정해야 함
            @RequestParam(value = "department_id", required = false, defaultValue = "0") int departmentId,
            // 페이지 구현에서 사용할 현재 페이지 번호
            @RequestParam(value = "page", defaultValue = "1") int nowPage) {

        int totalCount = 0; // 전체 데이터 수 (DB에서 조회해야 함)
        int listCount = 10; // 한 페이지당 표시할 목록 수
        int groupCount = 5; // 한 그룹당 표시할 페이지 번호 수

        // 페이지 번호를 계산한 결과가 저장될 객체
        PageHelper pageHelper = null;

        // 검색 조건에 사용할 객체
        Professor input = new Professor();
        input.setName(keyword);
        input.setUserId(keyword);
        input.setDepartmentId(departmentId);

        List<Professor> output = null;
        List<Department> departmentList = null;

        try {
            // 전체 데이터 수 조회
            totalCount = professorService.getCount(input);
            // 페이지 번호 계산 --> 계산결과를 로그로 출력될 것이다.
            pageHelper = new PageHelper(nowPage, totalCount, listCount, groupCount);

            // SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
            Professor.setOffset(pageHelper.getOffset());
            Professor.setListCount(pageHelper.getListCount());

            output = professorService.getList(input);

            // 전체 학과 목록 조회
            departmentList = departmentService.getList(null);
        } catch (Exception e) {
            webHelper.serverError(e);
        }

        model.addAttribute("professors", output);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageHelper", pageHelper);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("departmentId", departmentId);

        return "professor/index";
    }
}
