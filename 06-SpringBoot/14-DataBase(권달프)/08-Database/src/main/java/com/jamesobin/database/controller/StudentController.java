package com.jamesobin.database.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jamesobin.database.helpers.PageHelper;
import com.jamesobin.database.helpers.WebHelper;
import com.jamesobin.database.models.Department;
import com.jamesobin.database.models.Student;
import com.jamesobin.database.services.DepartmentService;
import com.jamesobin.database.services.StudentService;

@Controller
public class StudentController {
    /** 학생 관리 서비스 객체 주입 */
    @Autowired
    private StudentService studentService;

    /** 학과 관리 서비스 객체 주입 */
    @Autowired
    private DepartmentService departmentService;

    /** WebHelper 주입 */
    @Autowired
    private WebHelper webHelper;

    /** 환경 설정값 가져오기 */
    @Value("${myschool.page.listCount}")
    private int listCount;

    @Value("${myschool.page.groupCount}")
    private int groupCount;

    /**
     * 학생 목록 화면
     *
     * @param model 모델
     * @return 학생 목록 화면을 구현한 View 경로
     */
    @GetMapping("/student")
    public String index(Model model
    // 검색어 파라미터(페이지가 처음 열릴 때는 값 없음. 필수(required)가 아님)
    , @RequestParam(value="keyword", required=false) String keyword
    // 페이지 구현에서 사용할 현재 페이지 번호
    , @RequestParam(value="page", defaultValue="1") int nowPage
    // 학과 번호 파라미터(페이지가 처음 열릴 때는 값 없음. 필수(required)가 아님)
    // 기본값 설정시 데이터 타입에 상관 없이 문자열로 지정해야 함
    , @RequestParam(value="department_id", required=false, defaultValue="0") int departmentId
    , @RequestParam(value="grade", required=false, defaultValue="0") int grade
    // 체크박스에 대한 처리
    // --> 같은 이름의 <input>이 여러 개 있을 때는 배열로 처리
    // --> 체크된 항목이 없으면 빈 배열로 처리하기 위해서 defaultValue를 빈 문자열로 지정해야 함
    , @RequestParam(value="status", required=false, defaultValue="") String[] status) {

        int totalCount = 0;     // 전체 데이터 수 (DB에서 조회해야 함)
        // int listCount = 10;      // 한 페이지당 표시할 목록 수
        // int groupCount = 5;     // 한 그룹당 표시할 페이지 번호 수

        // 페이지 번호를 계산한 결과가 저장될 객체
        PageHelper pageHelper = null;

        // 검색 조건에 사용할 객체
        Student input = new Student();
        input.setName(keyword);
        input.setUserId(keyword);
        input.setDepartmentId(departmentId);
        input.setGrade(grade);
        input.setStatusArray(status);   // status는 배열로 처리

        List<Student> output = null;
        List<Department> departmentList = null;

        try {
            // 전체 데이터 수 조회
            totalCount = studentService.getCount(input);
            // 페이지 번호 계산 --> 계산결과를 로그로 출력 예정
            pageHelper = new PageHelper(nowPage, totalCount, listCount, groupCount);

            // SQL의 LIMIT 절에서 사용될 값을 Beans의 static 변수에 저장
            Student.setOffset(pageHelper.getOffset());
            Student.setListCount(pageHelper.getListCount());

            output = studentService.getList(input);

            // 전체 학과 목록 조회
            departmentList = departmentService.getList(null);
        } catch (Exception e) {
            webHelper.serverError(e);
        }

        model.addAttribute("students", output);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageHelper", pageHelper);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("grade", grade);
        model.addAttribute("status", status);

        return "student/index";
    }
}
