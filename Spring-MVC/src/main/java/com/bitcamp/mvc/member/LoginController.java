package com.bitcamp.mvc.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.mvc.domain.Login;

@Controller
public class LoginController {
	
	// 로그인 폼 페이지 요청
	@RequestMapping(value = "/member/login")
	public String getLoginForm() {
				
		// View Path : Resolver 의 범위에 포함된 경로
		return "member/loginForm";
		//   /WEB-INF/views/member/loginForm.jsp
	}
	
	
	@RequestMapping( value = "/member/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request ) {
		
		String id = request.getParameter("uId");
		String pw = request.getParameter("uPw");
		
		System.out.println(id + " : " + pw);
		
		ModelAndView modelAndView = new ModelAndView();
		
		// View Name 설정
		modelAndView.setViewName("member/login");
		modelAndView.addObject("id", id);
		modelAndView.addObject("pw", pw);
		
		return modelAndView;
	}
	
	
	
	@RequestMapping("/member/loginProc")
	public String loginproc(
			@RequestParam(value = "uId", defaultValue = "cool") String id,
			@RequestParam(value = "uPw", required = false) String pw,
			Model model
			) {
		
		System.out.println(id + " : " + pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		
		return "member/login";
	}
	
	
	@RequestMapping("/member/loginOk")                  //Login login : 커맨드 객체(뷰에 바로 공유가 가능) 
	public String loginOk(@ModelAttribute("user") Login login) {
		
		System.out.println(login.getuId() + " : " + login.getuPw());
		
		login.setuId(login.getuId()+"-12345");
		
		return "member/login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}