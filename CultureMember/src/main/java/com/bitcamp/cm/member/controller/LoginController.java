package com.bitcamp.cm.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.cm.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login") 
public class LoginController {
	
	@Autowired
	private MemberLoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {
	
		String view = "member/loginForm";
		
		HttpSession session = request.getSession(false);  // false : 현재 세션을 가지고 있다면 가져오고 아니면 그대로 null값 반환
		
		if(session != null && session.getAttribute("loginInfo") != null) {
				view = "redirect:/main";
		
		
	}
		return view;
	}
	

	@RequestMapping(method = RequestMethod.POST)   //loginForm의 <form method="post">
	public String login(@RequestParam("u_id") String id, @RequestParam("u_pw") String pw, HttpServletRequest request, HttpSession session) { 
		
		String view = "member/loginfail";
		//서비스 로그인 처리 후 반환 타입 변경
		int loginChk = loginService.login(id, pw, request);
		
		switch(loginChk) {
		case 1:
			
			view = "member/notVerify";
			break;
		case 2:
			view = "redirect:/main";
			break;
		}
		

		return view;
		
	}
}
