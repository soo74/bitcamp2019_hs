package com.bitcamp.cm.member.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.bitcamp.cm.member.domain.ListViewData;
import com.bitcamp.cm.member.domain.MemberInfo;
import com.bitcamp.cm.member.domain.SearchParam;
import com.bitcamp.cm.member.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService listService;
	
	
	@RequestMapping("/member/memberList")
	public String memberList(
			Model model,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			@RequestParam(value = "stype", required = false) String stype,
			@RequestParam(value = "keyword", required = false) String keyword
			) {
		
		
		SearchParam searchParam = null; 
		
		if(	stype!=null 
				&& keyword!=null 
				&& !stype.isEmpty() 
				&& !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		
		
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		/*
		 * for(MemberInfo m : listdata.getMemberList()) { 
		 * System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		
		return "member/memberList";
	}
	
	
	@RequestMapping("/member/json/memberListJson")	
	public @ResponseBody ListViewData memberListJson(
			@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			@RequestParam(value = "stype", required = false) String stype,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpServletResponse response
			) {
		
		
		SearchParam searchParam = null; 
		
		if(	stype!=null 
				&& keyword!=null 
				&& !stype.isEmpty() 
				&& !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		
		response.setStatus(HttpServletResponse.SC_OK);
		//response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		
		
		
		return listdata;
	}
	
	
	// 반환 타입이 ResponseEntity<T> : SPring 4.2 이상
	// 반환 하는 Body, statusCode, HttpHeader
	@RequestMapping("/member/json/memberListJson2")
	@ResponseBody
	public ResponseEntity<ListViewData> memberListJson2(
			@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			@RequestParam(value = "stype", required = false) String stype,
			@RequestParam(value = "keyword", required = false) String keyword
			) {
		
		
		SearchParam searchParam = null; 
		
		if(	stype!=null 
				&& keyword!=null 
				&& !stype.isEmpty() 
				&& !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		
		ResponseEntity<ListViewData> entity = 
				new ResponseEntity<ListViewData>(
						listdata, HttpStatus.OK);
		
		
		return entity;
	}



	
	

	@RequestMapping("/member/json/memberList.json")
	@ResponseBody
	public ListViewData memberList2(
			Model model,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			@RequestParam(value = "stype", required = false) String stype,
			@RequestParam(value = "keyword", required = false) String keyword,
			HttpServletResponse response
			) {
		
		
		//response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.setStatus(HttpServletResponse.SC_OK);
		
		
		SearchParam searchParam = null; 
		
		if(	stype!=null 
				&& keyword!=null 
				&& !stype.isEmpty() 
				&& !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		
		
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		/*
		 * for(MemberInfo m : listdata.getMemberList()) { 
		 * System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		
		return listdata;
	}

	
	


	@RequestMapping("/member/json/memberList2.json")
	@ResponseBody
	public ResponseEntity<ListViewData> memberList3(
			Model model,
			@RequestParam(value = "p", defaultValue = "1") int pageNumber,
			@RequestParam(value = "stype", required = false) String stype,
			@RequestParam(value = "keyword", required = false) String keyword
			) {
		
		
		SearchParam searchParam = null; 
		
		if(	stype!=null 
				&& keyword!=null 
				&& !stype.isEmpty() 
				&& !keyword.isEmpty()) {
			searchParam = new SearchParam();
			searchParam.setStype(stype);
			searchParam.setKeyword(keyword);
		}
		
		
		
		
		ListViewData listdata = listService.getListData(pageNumber, searchParam);
		
		/*
		 * for(MemberInfo m : listdata.getMemberList()) { 
		 * System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		
		return new ResponseEntity<ListViewData>(listdata, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	

	@RequestMapping("/member/memberList2")
	public String memberList(
			Model model
			) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		
		
		
		ListViewData listdata = restTemplate.getForObject("http://localhost:8080/mm/member/memberList.json", ListViewData.class);
		
		/*
		 * for(MemberInfo m : listdata.getMemberList()) { 
		 * System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		
		return "member/memberList";
	}
	
	
	
	
	
	
}