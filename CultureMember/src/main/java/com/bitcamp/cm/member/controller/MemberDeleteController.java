package com.bitcamp.cm.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.cm.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {
	
	@Autowired
	private MemberDeleteService deleteService;

	@RequestMapping("/member/memberDelete")
	public String delete( @RequestParam("memberId") int id) { //멤버아이디 받아서 삭제할것이다
	
		deleteService.memberDelete(id);
		
		
		return "redirect:/member/memberList";
	}
	
	
	@RequestMapping("/member/delete/{id}")         //특정위치의 값을 변수로 처리해줄수있다
	public String del(@PathVariable("id") int id) {
		
		deleteService.memberDelete(id);
		
		
		return "redirect:/member/memberList";
		
	}
	
	
}
