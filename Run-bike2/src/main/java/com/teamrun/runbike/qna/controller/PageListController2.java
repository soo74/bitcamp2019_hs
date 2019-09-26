package com.teamrun.runbike.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teamrun.runbike.qna.domain.ListViewData;
import com.teamrun.runbike.qna.domain.SearchParam;
import com.teamrun.runbike.qna.service.BoardListService;

@Controller
public class PageListController2 {

	
	private BoardListService pagelistService;
	
	@RequestMapping("/list")
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
			searchParam.setSearchType(stype);
			searchParam.setKeyword(keyword);
		}
		
		
		
		
		ListViewData listdata = pagelistService.listViewData(pageNumber, searchParam);
		
		/*
		 * for(MemberInfo m : listdata.getMemberList()) { 
		 * System.out.println(m); }
		 */
		
		model.addAttribute("viewData", listdata);
		
		
		return "list";
	}
}
