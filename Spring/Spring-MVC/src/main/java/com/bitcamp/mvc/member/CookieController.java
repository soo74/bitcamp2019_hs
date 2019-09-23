package com.bitcamp.mvc.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieController {

	@RequestMapping("cookie/makeForm")
	
	public String getMakeForm() {
		return "cookie/makeForm";
	}
	
	@RequestMapping("/cookie/makeCookie")
	public String makeCookie( 
		@RequestParam(value = "cName", defaultValue = "none") String cookieName,
		@RequestParam(value = "cValue", defaultValue = "none") String cookieValue,
		HttpServletResponse response
		) {
		
		//쿠키 생성
		Cookie c = new Cookie(cookieName, cookieValue);
		
		//쿠키 전송
		response.addCookie(c);
		
		return "cookie/makeCookie";
	}
}
