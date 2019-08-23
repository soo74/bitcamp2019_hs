package com.bitcamp.rc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestfulClientController {

	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public List<MemberInfo> getAllList() {
		 
		RestTemplate restTemplate = new RestTemplate();    //객체 생성
		
		MemberInfo[] members = restTemplate.getForObject("http://localhost:8080/mm/rest/members", MemberInfo[].class);
		
		List<MemberInfo> list = Arrays.asList(members);   //배열을 리스트로 변환
		
		for(MemberInfo m : list) {
			System.out.println(m);
		}
		
		return list;
	}
	
	
	
	@RequestMapping("/member/{idx}")
	@ResponseBody
	public String getMember(@PathVariable("idx") int idx) {
		
		RestTemplate restTemplate = new RestTemplate(); 
		
		MemberInfo info = restTemplate.getForObject("http://localhost:8080/mm/rest/members/{id}", MemberInfo.class,idx);   //idx에 해당 회원번호 입력하면 회원정보가 콘솔에 출력
		
		System.out.println(info);
		
		
		return null;
	}
}
