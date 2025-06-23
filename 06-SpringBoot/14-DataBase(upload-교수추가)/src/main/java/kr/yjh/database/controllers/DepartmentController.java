package kr.yjh.database.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.yjh.database.exceptions.StringFormatException;
import kr.yjh.database.helpers.PageHelper;
import kr.yjh.database.helpers.RegexHelper;
import kr.yjh.database.helpers.WebHelper;
import kr.yjh.database.models.Department;
import kr.yjh.database.services.DepartmentService;


@Controller
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

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
    public String index(Model model,
        // 검색어 파라미터 ( 페이지가 처음 열릴 떄는 값 없음. 필수(required)가 아님 )
        @RequestParam(value = "keyword", required = false) String keyword,
        //페이지 구현에서 사용할 현재 페이지 번호
        @RequestParam(value = "page", defaultValue = "1") int nowPage) {

            int totalCount = 0;
            // 전체 데이터 수 (DB에서 조회해야 함)                                               <---------변수 3개
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
            
            // 페이지 번호 계산 --> 계산결과를 로그로 출력될 것이다
            pageHelper = new PageHelper(nowPage, totalCount, listCount, groupCount);

            // SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
            Department.setOffset(pageHelper.getOffset());
            Department.setListCount(pageHelper.getListCount());



            output = departmentService.getList(input);
        } catch (Exception e) {
            webHelper.serverError(e);
        }

        // 조회 결과를 view에 전달하기 위해 모델에 추가
        model.addAttribute("departments", output);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageHelper", pageHelper);

        return "department/index";

        /** 
         * 바구니.addAttribute("departments", output);
         * 바구니.addAttribute("keyword", keyword);
         * 바구니.addAttribute("pageHelper", pageHelper);
         * 
         * 이걸 가지고 
         * 
         * turn "department/index"; 여기로 가라 라는뜻
         * 
         */

     }
//🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰
     /**
      * 등록 페이지를 표시하기 위한 컨트롤러
      *
      * @param 뷰 페이지 경로
      */

      @GetMapping("/department/add")
      public String add() {
          return  "department/add";
      }

      @PostMapping("department/add")
      public String addOk(Model model,
          // 입력내용 파라미터 받기
          @RequestParam(value = "dname", required = false) String dname,
          @RequestParam(value = "loc", required = false) String loc,
          @RequestParam(value = "phone", required = false) String phone,
          @RequestParam(value = "email", required = false) String email,
          @RequestParam(value = "established", required = false) String established,
          @RequestParam(value = "homepage", required = false) String homepage) {

            // [중요] 파라미터로 받은 입력값이 적절한지 유효성 검사
          try {
              regexHelper.isValue(dname, "학과 이름이 없습니다.");
              regexHelper.isValue(dname, "이름은 한글만 입력하세요.");
              
              regexHelper.isValue(loc, "학과 위치가 없습니다.");

              regexHelper.isValue(phone, "연락처를 입력하세요.");
              regexHelper.isValue(phone, "연락처 형식이 잘못되었습니다.");

              regexHelper.isValue(email, "이메일을 입력하세요.");
              regexHelper.isValue(email, "이메일 형식이 잘못되었습니다.");

              regexHelper.isValue(established, "설립연도를 입력하세요.");
              regexHelper.isValue(established, "설립 년도 형식이 잘못되었습니다.");

              regexHelper.isValue(homepage, "홈페이지 주소를 입력하세요.");
              regexHelper.isValue(homepage, "홈페이지 주소 형식이 잘못되었습니다.");
          } catch (StringFormatException e) {
            webHelper.serverError(e);
            return null;
          }

          // 파라미터를 service 객체에 전달하기 위해 Model객체에 저장
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
          } catch (Exception e) {
            webHelper.serverError(e);
            return null;
          }

          return "redirect:/department/view/" + output.getId();  
      }


//🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰
      /**
       * 학과 조회
       * 
       * @param model 모델
       * @param id 학과 ID
       *  @return 뷰 페이지 경로
       */
      @GetMapping("/department/view/{id}")
        public String view(Model model, @PathVariable(value="id", required = true) int id) {
            Department input = new Department();
            input.setId(id);

            Department output = null;

            try {
                // 조회 처리
                output = departmentService.getItem(input);
            } catch (Exception e) {
                webHelper.serverError(e);
                return null;
            }

            model.addAttribute("department", output);

            return "department/view";
        }

    
//🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰


      /**
       * 학과 삭제 처리
       * 
       *  @param model 모델
       *  @param id 학과 ID
       *  @return 삭제 후 목록 페이지로 리다이렉트
       
      
      @DeleteMapping("/department/delete/{id}")
      public String delete(Model model, @PathVariable(value="id") int id) {
          Department input = new Department();
          input.setId(id);
          
          try {
              departmentService.deleteItem(input);
          } catch (Exception e) {
              // error 페이지로 이동 (error/customError.html이 반드시 존재해야 함)
              model.addAttribute("errorMessage", e.getMessage());
              return "error/customError";
          }
          // 삭제 후 목록으로 리다이렉트
          return "redirect:/department";
      }
    */
   
      /**
       * 학과 삭제 처리
       * 
       *  @param model 모델
       *  @param id 학과 ID
       *  @return 삭제 후 목록 페이지로 리다이렉트 
       */
       @DeleteMapping("/department/delete/{id}")
        public void delete(Model model, @PathVariable(value="id", required = true) int id) {
            Department input = new Department();
            input.setId(id);

            try {
                // 삭제 처리
                departmentService.deleteItem(input);
            } catch (Exception e) {
                webHelper.serverError(e);
                return;
            }

            // 삭제 후 목록 페이지로 리다이렉트
            webHelper.redirect("/department", "삭제되었습니다.");
        }

    

//🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰🟰 
        /**
         * 학과 수정 페이지를 표시하기 위한 컨트롤러
         * 
         *  @param model 모델
         *  @param id 학과 ID
         *  @return 뷰 페이지 경로
         */
        @GetMapping("/department/edit_ok/{id}")
        public String edit(Model model, @PathVariable(value = "id", required = true) int id) {
            Department input = new Department();
            input.setId(id);

            Department output = null;

            try {
                // 조회 처리
                output = departmentService.getItem(input);
            } catch (Exception e) {
                webHelper.serverError(e);
                return null;
            }

            // 조회된 데이터를 뷰에 전달하기 위해 모델에 추가
            model.addAttribute("department", output);

            return "department/edit";
        }

        
        

        

    }

        

    



