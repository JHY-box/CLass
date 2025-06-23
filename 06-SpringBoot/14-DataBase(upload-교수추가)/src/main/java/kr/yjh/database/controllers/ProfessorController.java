package kr.yjh.database.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import kr.yjh.database.DatabaseApplication;
import kr.yjh.database.exceptions.AlreadyExistsException;
import kr.yjh.database.exceptions.StringFormatException;
import kr.yjh.database.helpers.FileHelper;
import kr.yjh.database.helpers.PageHelper;
import kr.yjh.database.helpers.RegexHelper;
import kr.yjh.database.helpers.WebHelper;
import kr.yjh.database.models.Department;
import kr.yjh.database.models.Professor;
import kr.yjh.database.models.UploadItem;
import kr.yjh.database.services.DepartmentService;
import kr.yjh.database.services.ProfessorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;


@Slf4j
@Controller
public class ProfessorController {

    private final DatabaseApplication databaseApplication;
    /** 교수 관리 서비스 객체 주입 */
    @Autowired
    private ProfessorService professorService;

    /** 학과 관리 서비스 객체 주입 */
    @Autowired
    private DepartmentService departmentService;

    /** WebHelper 주입 */
    @Autowired
    private WebHelper webHelper;

    /** WebHelper 주입 */
    @Autowired
    private FileHelper fileHelper;

    /** RegexHelper 주입 */
    @Autowired
    private RegexHelper regexHelper;

    /** 환경 설정값 가져오기 */
    @Value("${myschool.page.listCount}")
    private int listCount;

    @Value("${myschool.page.groupCount}")
    private int groupCount;

    ProfessorController(DatabaseApplication databaseApplication) {
        this.databaseApplication = databaseApplication;
    }

    /**
     * 교수 목록 화면
     *
     * @param model 모델
     * @return 교수 목록 화면을 구현한 View 경로
     */
    @GetMapping("/professor")
    public String index(Model model
    // 검색어 파라미터(페이지가 처음 열릴 때는 값 없음. 필수(required)가 아님)
    , @RequestParam(value="keyword", required=false) String keyword
    // 페이지 구현에서 사용할 현재 페이지 번호
    , @RequestParam(value="page", defaultValue="1") int nowPage
    // 학과 번호 파라미터(페이지가 처음 열릴 때는 값 없음. 필수(required)가 아님)
    // 기본값 설정시 데이터 타입에 상관 없이 문자열로 지정해야 함
    , @RequestParam(value="department_id", required=false, defaultValue="0") int departmentId
    // 체크박스에 대한 처리
    // --> 같은 이름의 <input>이 여러 개 있을 때는 배열로 처리
    // --> 체크된 항목이 없으면 빈 배열로 처리하기 위해서 defaultValue를 빈 문자열로 지정해야 함
    , @RequestParam(value="position", required=false, defaultValue="") String[] position) {

        int totalCount = 0;     // 전체 데이터 수 (DB에서 조회해야 함)
        // int listCount = 10;      // 한 페이지당 표시할 목록 수
        // int groupCount = 5;     // 한 그룹당 표시할 페이지 번호 수

        // 페이지 번호를 계산한 결과가 저장될 객체
        PageHelper pageHelper = null;

        // 검색 조건에 사용할 객체
        Professor input = new Professor();
        input.setName(keyword);
        input.setUserId(keyword);
        input.setDepartmentId(departmentId);
        input.setPositionArray(position);   // postion은 배열로 처리

        List<Professor> output = null;
        List<Department> departmentList = null;

        try {
            // 전체 데이터 수 조회
            totalCount = professorService.getCount(input);
            // 페이지 번호 계산 --> 계산결과를 로그로 출력 예정
            pageHelper = new PageHelper(nowPage, totalCount, listCount, groupCount);

            // SQL의 LIMIT 절에서 사용될 값을 Beans의 static 변수에 저장
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
        model.addAttribute("position", position);

        return "professor/index";
    }

    /**
     * 교수 등록 화면
     * 
     * @param model - View에 전달할 데이터를 담는 객체
     * @return 교수 등록 화면을 구현한 View 경로
     */
    @GetMapping("/professor/add")
    public String add(Model model) {
        // 전체 학과 목록 조회
        List<Department> departmentList = null;

        try {
            departmentList = departmentService.getList(null);
        } catch (Exception e) {
            webHelper.serverError(e);
        }

        model.addAttribute("departmentList", departmentList);
        return "professor/add";
    }

    @PostMapping("/professor/add_ok")
    public void addOk(
        Model model
        // 입력내용 파라미터 받기
        , @RequestParam(value="name", required=false) String name
        , @RequestParam(value="user_id", required=false) String userId
        , @RequestParam(value="position", required=false) String position
        , @RequestParam(value="sal", required=false) String sal
        , @RequestParam(value="hiredate", required=false) String hiredate
        , @RequestParam(value="comm", required=false) String comm
        , @RequestParam(value="email", required=false) String email
        , @RequestParam(value="phone", required=false) String phone
        , @RequestParam(value="photo_url", required=false) MultipartFile photoUrl
        , @RequestParam(value="status", required=false) String status
        , @RequestParam(value="department_id", required=false) String departmentId) {

        // [중요] 파라미터로 받은 입력값이 적절한지 유효성 검사
        try {
            regexHelper.isValue(name, "교수 이름이 없습니다.");
            regexHelper.isKor(name, "교수 이름은 한글만 입력하세요.");

            regexHelper.isValue(userId, "교수 아이디가 없습니다.");
            regexHelper.isEngNum(userId, "교수 아이디는 영문자와 숫자만 입력하세요.");

            regexHelper.isValue(position, "교수 직급이 선택되지 않았습니다.");

            regexHelper.isValue(sal, "교수 급여가 입력되지 않았습니다.");
            regexHelper.isNum(sal, "교수 급여는 숫자만 입력해야 합니다.");

            regexHelper.isValue(hiredate, "교수의 입사일이 입력되지 않았습니다.");

            regexHelper.isValue(email, "교수 이메일이 입력되지 않았습니다.");
            regexHelper.isEmail(email, "교수 이메일 형식이 잘못되었습니다.");

            regexHelper.isValue(phone, "교수 연락처가 입력되지 않았습니다.");
            regexHelper.isPhone(phone, "교수 연락처 형식이 잘못되었습니다.");

            regexHelper.isValue(status, "교수 상태가 선택되지 않았습니다.");

            regexHelper.isValue(departmentId, "학과가 선택되지 않았습니다.");
            regexHelper.isNum(departmentId, "학과 번호는 숫자만 입력하세요.");
        } catch(StringFormatException e) {
            webHelper.badRequest(e);
            return;
        }

        // (2) 파일 업로드 처리
        UploadItem uploadItem = null;

        try {
            uploadItem = fileHelper.saveMultipartFile(photoUrl);
        } catch(Exception e) {
            // 이미지가 필수 항목인 경우 이 위치에서 예외 처리가 필요함
            // webHelper.badRequest(e);
        }

        // 파라미터를 SErvice 객체에 전달하기 위해 Model 객체에 저장
        Professor input = new Professor();
        input.setName(name);
        input.setUserId(userId);
        input.setPosition(position);
        input.setSal(Integer.parseInt(sal));
        input.setHiredate(hiredate);
        // DB에서 int 컬럼인데 null을 허용하는 경우, Beans에서는 Integer로 선언해야 함
        input.setComm(comm.isEmpty() ? null : Integer.parseInt(comm));  // comm이 비어있으면 null로 설정
        input.setEmail(email);
        input.setPhone(phone);
        input.setPhotoUrl(uploadItem == null ? null : uploadItem.getFilePath());    // 업로드된 파일의 경로
        input.setStatus(status);
        input.setDepartmentId(Integer.parseInt(departmentId));  // 학과 번호 설정

        try {
            // DB에 저장
            professorService.addItem(input);
        } catch (AlreadyExistsException e) {
            // 이미 존재하는 아이디인 경우 --> HTTP 에러코드 400을 반환
            webHelper.badRequest(e);
            return;
        } catch(Exception e) {
            // 그 외의 예외는 서버 에러로 처리 --> HTTP 에러코드 500을 반환
            webHelper.serverError(e);
            return;
        }

        webHelper.redirect("/professor/view/" + input.getId());
    }

    /**
     * 교수 조회
     * 
     * @param model 모델
     * @param id 학과 ID
     * @return 뷰 페이지 경로
     */
    @GetMapping("/professor/view/{id}")
    public String view(Model model, @PathVariable(value="id", required=true) int id) {
        Professor input = new Professor();
        input.setId(id);

        Professor output = null;

        try {
            output = professorService.getItem(input);
        } catch(Exception e) {
            webHelper.serverError(e);
            return null;
        }

        model.addAttribute("professor", output);

        return "professor/view";
    }

    /**
     * 교수 삭제 처리
     * @param model
     * @param id
     */
    @ResponseBody
    @DeleteMapping("/professor/delete/{id}")
    public void delete(Model model, @PathVariable(value="id", required = true) int id) {
    
        // 삭제할 교수 정보를 조회하여 프로필 사진의 경로 추출
        Professor input = new Professor();
        input.setId(id);
    
        Professor output = null;
    
        try {
            output = professorService.getItem(input);
        } catch (Exception e) {
            webHelper.serverError(e);
            return;
        }
    
        String photoUrl = output.getPhotoUrl();
    
        // 사진 파일이 존재하면 삭제
        if (photoUrl != null && !photoUrl.isEmpty()) {
            try {
                fileHelper.deleteFile(photoUrl);
            } catch (Exception e) {
                webHelper.serverError(e);
                return;
            }
        }
    
        // 교수 삭제 처리
        try {
            professorService.deleteItem(input);
        } catch (Exception e) {
            webHelper.serverError(e);
            return;
        }
    
        // 삭제 후 목록 페이지로 리다이렉트
        webHelper.redirect("/professor", "삭제되었습니다.");
    }



    /**
     * 교수 수정 화면
     *
     * @param model 모델
     * @param id    수정할 교수의 ID
     * @return 교수 수정 화면을 구현한 View 경로
     */
    @GetMapping("/professor/edit/{id}")
    public String edit(Model model, @PathVariable(value = "id", required = true) int id) {
        // 수정할 교수 정보 조회
        Professor input = new Professor();
        input.setId(id);
    
        Professor output = null;
        List<Department> departmentList = null;
    
        try {
            output = professorService.getItem(input);
            departmentList = departmentService.getList(null);
        } catch (Exception e) {
            webHelper.serverError(e);
            return "forward:/error";      // 예외 발생 시 에러 페이지로 포워딩 (템플릿 엔진 에러 방지)
        }
    
        model.addAttribute("professor", output);
        model.addAttribute("departmentList", departmentList);
    
        return "professor/edit";
    }


    @PostMapping("professor/edit_ok/{id}")
    public void editOk(Model model
                          , @RequestParam(value="id", required=true) int id
                          , @RequestParam(value="name", required=false) String name
                          , @RequestParam(value="user_id", required=false) String userId
                          , @RequestParam(value="position", required=false) String position
                          , @RequestParam(value="sal", required=false) String sal
                          , @RequestParam(value="hiredate", required=false) String hiredate
                          , @RequestParam(value="comm", required=false) String comm
                          , @RequestParam(value="email", required=false) String email
                          , @RequestParam(value="phone", required=false) String phone
                          , @RequestParam(value="photo_url", required=false) MultipartFile photoUrl
                          , @RequestParam(value="status", required=false) String status
                          , @RequestParam(value="department_id", required=false) String departmentId
                          , @RequestParam(value="delete_photo", defaultValue="N" ) String deletePhoto) {
                              
                              // (1) 입력값에 대한 유효성 검사
                              try {
                                  regexHelper.isValue(name, "교수 이름이 없습니다.");
                                  regexHelper.isKor(name, "교수 이름은 한글만 입력하세요.");
                      
                                  regexHelper.isValue(userId, "교수 아이디가 없습니다.");
                                  regexHelper.isEngNum(userId, "교수 아이디는 영문자와 숫자만 입력하세요.");
                      
                                  regexHelper.isValue(position, "교수 직급이 선택되지 않았습니다.");
                      
                                  regexHelper.isValue(sal, "교수 급여가 입력되지 않았습니다.");
                                  regexHelper.isNum(sal, "교수 급여는 숫자만 입력해야 합니다.");
                      
                                  regexHelper.isValue(hiredate, "교수의 입사일이 입력되지 않았습니다.");
                      
                                  regexHelper.isValue(email, "교수 이메일이 입력되지 않았습니다.");
                                  regexHelper.isEmail(email, "교수 이메일 형식이 잘못되었습니다.");
                      
                                  regexHelper.isValue(phone, "교수 연락처가 입력되지 않았습니다.");
                                  regexHelper.isPhone(phone, "교수 연락처 형식이 잘못되었습니다.");
                      
                                  regexHelper.isValue(status, "교수 상태가 선택되지 않았습니다.");
                      
                                  regexHelper.isValue(departmentId, "학과가 선택되지 않았습니다.");
                                  
                              } catch(StringFormatException e) {
                                  webHelper.badRequest(e);
                                  return;
                              }
                              
                              // (2) 파일 업로드 처리
                              UploadItem uploadItem = null;
                      
                              try {
                                  uploadItem = fileHelper.saveMultipartFile(photoUrl);
                                  log.debug("업로드된 파일 경로: " + (uploadItem != null ? uploadItem.getFilePath() : "없음"));
                              } catch(Exception e) {
                                  // 이미지가 필수 항목인 경우 이 위치에서 예외 처리가 필요함
                                  // webHelper.badRequest(e);
                                  // return;
                              }

                              // (3) 기존 데이터에서 사진 정보를 가져온다. 
                              String existingPhotoUrl = null;

                              Professor temp = new Professor();
                              temp.setId(id);

                              try {
                                Professor existingProfessor = professorService.getItem(temp);
                                existingPhotoUrl = existingProfessor.getPhotoUrl();                   /////////////////////////
                              } catch (Exception e) {
                                  webHelper.serverError(e);
                                  return;
                            }

                              // (4) 기존 사진이 있는 경우
                              if (existingPhotoUrl != null && !existingPhotoUrl.isEmpty()) {
                                  // 사진 삭제 체크가 있는 경우
                                  if ("Y".equals(deletePhoto)) {
                                      try {
                                          fileHelper.deleteFile(existingPhotoUrl);
                                      } catch (Exception e) {
                                          log.debug("기존 사진이 삭제되지 않았습니다.");
                                      }
                                  } else if (uploadItem == null) {
                                      // 사진을 새로 등록하지 않은 경우 기존 사진 경로를 유지
                                      uploadItem = new UploadItem();
                                      uploadItem.setFilePath(existingPhotoUrl);
                                      log.debug("기존 사진이 유지됩니다 : " + existingPhotoUrl);
                                  }
                              }
                          
                              // (5) 입력값을 Beans로 변환
                              Professor input = new Professor();
                              input.setId(id);
                              input.setName(name);
                              input.setUserId(userId);
                              input.setPosition(position);
                              input.setSal(Integer.parseInt(sal));
                              input.setHiredate(hiredate);
                              // DB에서 컬럼값이 null을 허용하는 경우, Beans에서는 Integer로 선언해야 함
                              input.setComm(comm.isEmpty() ? null : Integer.parseInt(comm)); // comm이 비어있으면 null로 설정
                              input.setEmail(email);
                              input.setPhone(phone);
                              input.setPhotoUrl(uploadItem == null ? null : uploadItem.getFilePath()); // 업로드된 파일의 경로
                              input.setStatus(status);
                              input.setDepartmentId(Integer.parseInt(departmentId)); // 학과 번호 설정
                          
                              // (6) DB에 수정 내용 저장
                              try {
                                  // DB에 수정 내용 저장
                                  professorService.editItem(input);
                              } catch (AlreadyExistsException e) {
                                  // 이미 존재하는 아이디인 경우 --> HTTP 에러코드 400을 반환
                                  webHelper.badRequest(e);
                                  return;
                              } catch (Exception e) {
                                  // 그 외의 예외는 서버 에러로 처리 --> HTTP 에러코드 500을 반환
                                  webHelper.serverError(e);
                                  return;
                              }
                          
                              // (7) 성공적으로 수정된 후, 교수 상세 페이지로 리다이렉트
                              webHelper.redirect("/professor/view/" + input.getId(), "수정되었습니다.");
                          }
                        
                        
                        
                        }