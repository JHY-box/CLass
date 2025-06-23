package kr.hossam.database.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import kr.hossam.database.helpers.WebHelper;
import kr.hossam.database.models.Student;
import kr.hossam.database.services.StudentService;

@Controller
public class StudentController {
    /** 학생 관리 서비스 객체 주입 */
    @Autowired
    private StudentService studentService;

    /** WebHelper 주입 */
    @Autowired
    private WebHelper webHelper;

    /**
     * 학생 목록 화면
     *
     * @param model 모델
     * @return 학생 목록 화면을 구현한 View 경로
     */
    @GetMapping("/student")
    public String index(Model model) {

        List<Student> output = null;

        try {
            output = studentService.getList(new Student());
        } catch (Exception e) {
            webHelper.serverError(e);
        }

        model.addAttribute("students", output);

        return "student/index";
    }
}
