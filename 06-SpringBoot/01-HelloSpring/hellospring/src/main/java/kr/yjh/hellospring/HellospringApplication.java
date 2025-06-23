package kr.yjh.hellospring;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//springBoot 프로그램이 필요로 하는 기본 기능을 탑재
@SpringBootApplication
@Controller
public class HellospringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellospringApplication.class, args);
	}

	/** 1) 서블릿 형태의 컨트롤러 */
	// 리턴하는 문자열을 웹 브라우저에게 전달함
	// 이 항목을 명시하지 않을 경우 리턴하는 문자열은 view의 파일이름이 됨
	// --> import org.springframework.web.bind.annotation.ResponseBody;
	@ResponseBody
	//이 메서드가 연결될 URL 경로를 지정
	@GetMapping("/hellospring")
	public String hello() {
		String message = "<h1>Hello SpringBoot</h1>";
		message += "<p>안녕하세요~ 스피링~!!</p>";
		System.out.println(message);
		return message;
	}

	/** 2) 자동으로 View의 이름을 찾는 컨트롤러 */
	// im
	@GetMapping("/now")
	public void world(Model model) {
		// import java.util.date;
		model.addAttribute("nowtime", new Date().toString());

		//void형의 메서드이므로 이 메서드가 사용하는 view의 이름은
		// URL 이름과 동일한 now.html이 된다.
		// --> "/src/main/resources/templates/now.html" 파일을 찾아서 실행
	}

	/** 3) view의 이름을 반황하는 컨트롤러 */
	@GetMapping("/today")
	public String nice(Model model) {
		model.addAttribute("message1", "스프링부트 View 테이스 입니다.");
		model.addAttribute("message2", "안녕하세요~");
		model.addAttribute("message3", "반갑습니다~");

		// String형의 메서드 이므로 이 메서트가 리턴하는 문자열이 View의 이름이 된다.
		// --> "/src/main/resources/templates/myview.html" 파일을 찾아서 실행
		return "myview";
	}

	
}
