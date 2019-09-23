package com.bitcamp.mvc.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/memberLogin")
public class MemberLoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {
		return "member/loginForm2";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model ) {	
		
		String id = request.getParameter("uId");
		String pw = request.getParameter("uPw");
		
		System.out.println(id + " : " + pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		
		return "member/login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}