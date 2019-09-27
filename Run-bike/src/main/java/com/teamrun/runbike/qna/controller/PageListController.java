//package com.teamrun.runbike.qna.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.teamrun.runbike.qna.domain.ListViewBoardData;
//import com.teamrun.runbike.qna.domain.SearchParam;
//import com.teamrun.runbike.qna.service.BoardListService;
//
//@Controller
//public class PageListController {
//
//	@Autowired
//	private BoardListService boardlistService;
//	
//	@RequestMapping("/qnaboard/list")
//	public String pageList(Model model,@RequestParam(value = "p", defaultValue = "1") int pageNumber,
//										@RequestParam(value = "stype", required = false) String stype,
//										@RequestParam(value = "keyword", required = false) String keyword
//			) {
//		
//		
//		SearchParam searchParam = null; 
//		
//		if(	stype!=null && keyword!=null && !stype.isEmpty() && !keyword.isEmpty()) {
//			searchParam = new SearchParam();
//			searchParam.setStype(stype);
//			searchParam.setKeyword(keyword);
//		}
//		
//		ListViewBoardData pagelistdata = boardlistService.getListData(pageNumber,searchParam);
//		
//		model.addAttribute("viewData", pagelistdata);
//		
//		return "/qnaboard/list";
//		
//	}
//}
//
