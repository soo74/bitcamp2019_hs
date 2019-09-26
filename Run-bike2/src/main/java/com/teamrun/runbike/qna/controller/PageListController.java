package com.teamrun.runbike.qna.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamrun.runbike.qna.domain.ListViewData;
import com.teamrun.runbike.qna.domain.SearchParam;
import com.teamrun.runbike.qna.service.BoardListService;


@RestController
@RequestMapping("/rest/page/list")
public class PageListController {
		
	
	private BoardListService pageListService;

	@GetMapping
	public ResponseEntity<ListViewData> restListAll(@RequestParam(value = "page", defaultValue = "1") int page,
													@RequestParam(value = "searchType", required = false) String sType,
													@RequestParam(value="keyword", required = false) String keyword) {

		SearchParam searchParam = null;
		
		if(sType!=null && keyword!=null && !sType.isEmpty() && !keyword.isEmpty() ) {
			searchParam = new SearchParam();
			searchParam.setSearchType(sType);
			searchParam.setKeyword(keyword);
			
			System.out.println("컨트롤러 : "+searchParam);
		}
		
		ListViewData listData = pageListService.listViewData(page,searchParam);
		
		ResponseEntity<ListViewData> entity = new ResponseEntity<ListViewData>(listData,HttpStatus.OK);
		
		return entity;
	}
}
