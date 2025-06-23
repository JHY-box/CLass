package kr.hyungyu.department.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import kr.hyungyu.department.helpers.WebHelper;
import kr.hyungyu.department.models.Department;
import kr.hyungyu.department.services.DepartmentService;

public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private WebHelper webHelper;

    
    public String index(Model model) {

        List<Department> output = null;

        try {
            output = departmentService.getList(new Department());
        } catch (Exception e) {
            webHelper.serverError(e);
        }

        model.addAttribute("departments", output);

        return "department/index";
    }
}
