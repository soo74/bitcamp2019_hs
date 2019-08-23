package com.bitcamp.mvc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller   //@Controller 애노테이션을 적용한 클래스는 스프링 MVC에서 컨트롤러로 사용
public class HelloController {
	
	@RequestMapping("/hello")     //@GetMapping : 메서드가 처리할 요청경로를 지정. //@GetMapping("/hello") : /hello로 들어온 요청을 hello()메서드 이용해서 처리한다고 설정
	public ModelAndView hello(HttpServletRequest request) {
		
		// FrontController 전송할 View 경로와 결과 데이터 저장하고 전달할 객체 -> ModelAndView		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello"); // /WEB-INF/views/hello.jsp
		modelAndView.addObject("userName", "Cool");
		modelAndView.addObject("greeting", "안녕하세요");     //greeting이라는 모델 속성에 "안녕하세요"라는 값을 설정
		modelAndView.addObject("now", new Date());
		
		return modelAndView;
		
		
		//----ModelAndView 클래스의 addObject 메서드
		//public ModelAndView addObject(String attributeName, Object attributeValue) {
		//	getModelMap().addAttribute(attributeName, attributeValue);
		//	return this;
		}
		
		
		
	}