package kr.yjh.database.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.yjh.database.helpers.PageHelper;
import kr.yjh.database.helpers.WebHelper;
import kr.yjh.database.models.Department;
import kr.yjh.database.models.Student;
import kr.yjh.database.services.DepartmentService;
import kr.yjh.database.services.ProfessorService;
import kr.yjh.database.services.StudentService;

@Controller
public class StudentController {

    /** 학생 관리 서비스 객체 주입 */
    @Autowired
    private StudentService studentService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProfessorService professorService;

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
    public String index(Model model,
        
    
        // 검색어 파라미터 (페이지가 처음 열릴 때는 값 없음. 필수 (required)가 아님)
        @RequestParam(value = "keyword", required = false) String keyword,                 /** <====== keywored  eeeeeeeee 오타 오타 오타 오타 (박 <컴공> 검색시 박태수 , 차미경 동시에 나오는 에러였음)*/ 
        

        // 학과 번호 파라미터 (페이지가 처음 영릴 때는 값이 0으로 설정됨)
        // 기본값 설정시 데이터 타입에 상관 없이 문자열로 지정해야 함
        @RequestParam(value = "department_id", required = false, defaultValue = "0") int departmentId,
        
        // 처리박스에 대한 처리
        // --> 같은이름의 <input>이 여러 개 있을 떄는 배열로 처리
        // --> 체크된 항목이 없으면 빈 배열로 처리하기 위해서 defaultValue를 빈 문자열로 지정하야 함
        // @RequestParam(value = "position", required = false, defaultValue = "") String[] position,   ↓↓↓↓변경한거↓↓↓↓

        @RequestParam(value ="status", required = false, defaultValue = "") String[] statusArray,


        //페이지 구현에서 사용할 현재 페이지 번호
        @RequestParam(value = "page", defaultValue = "1") int nowPage) {

            
        int totalCount = 0;

        PageHelper pageHelper = null;

        Student input = new Student();
        input.setName(keyword);
        input.setUserId(keyword);
        

        List<Student> output = null;
        List<Department> departmentList = null;

        try {
            // 전체 데이터 수 조회
            totalCount = studentService.getCount(input);
            // 페이지 번호 계산 --> 계산결과를 로그로 출력될 것이다
            pageHelper = new PageHelper(nowPage, totalCount, listCount, groupCount);

            // SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
            Student.setOffset(pageHelper.getOffset());
            Student.setListCount(pageHelper.getListCount());
            

            output = studentService.getList(input);

            // 전체 학과 목록 조회
            departmentList = departmentService.getList(null);
        
            
            

        } catch (Exception e) {
            webHelper.serverError(e);
        }

        /**
        try {
            output = studentService.getList(new Student());
        } catch (Exception e) {
            webHelper.serverError(e);
        }
        */

        model.addAttribute("students", output);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageHelper", pageHelper);
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("status", statusArray);



        return "student/index";
    }
}
