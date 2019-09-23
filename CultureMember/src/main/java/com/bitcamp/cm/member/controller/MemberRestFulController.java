package com.bitcamp.cm.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.cm.member.domain.MemberInfo;
import com.bitcamp.cm.member.domain.RequestMemberEdit;
import com.bitcamp.cm.member.domain.RequestMemberRegist;
import com.bitcamp.cm.member.service.MemberDeleteService;
import com.bitcamp.cm.member.service.MemberEditService;
import com.bitcamp.cm.member.service.MemberListService;
import com.bitcamp.cm.member.service.MemberRegService;

@RestController  // @RestController씀으로써 @ResponseBody 생략한다.
@RequestMapping("/rest/members")   //경로 설정(앞에있는 것과 구별하기위해 설정)
public class MemberRestFulController {
	
	@Autowired
	private MemberListService listService;

	@Autowired
	private MemberDeleteService deleteService;
	
	@Autowired
	private MemberRegService regService;
	
	@Autowired
	private MemberEditService editService;
	
	
	
	//@RequestMapping(method = RequestMethod.GET)
	//@ResponseBody
	@CrossOrigin
	@GetMapping		
	public ResponseEntity<List<MemberInfo>> getAllList(){	
	
		List<MemberInfo> list = listService.getAllList();
		
		ResponseEntity<List<MemberInfo>> entity = new ResponseEntity<List<MemberInfo>>(list,HttpStatus.OK);
		
		//HttpStatus.OK -> 200
		//HttpStatus.NOT_FOUND -> 404
		//HttpStatus.INTERNAL_SERVER_ERROR -> 500
		
		return entity;
	}
	
	
	@CrossOrigin
	@DeleteMapping("/{id}")     //    /rest/members/12
	public ResponseEntity<String> deleteMember( @PathVariable("id") int idx ) {  //@PathVariable : uri경로에서 원하는 데이터를 추출하는 용도로 사용 
		
		//int cnt = deleteService.memberDelete(idx);
		
		return new ResponseEntity<String>( deleteService.memberDelete(idx)>0?"SUCCESS":"FAIL", HttpStatus.OK);
		
	}
	
	
	//RequestMapping(method = HttpMethod.POST)
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> regMember(RequestMemberRegist regRequest, HttpServletRequest request){
		
		System.out.println("check : " + regRequest);
		
		int cnt = regService.memberInsert(request, regRequest);
		
		return new ResponseEntity<String>(cnt>0 ? "SUCCESS" : "FAIL",HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<MemberInfo> getMemberInfo(@PathVariable("id") int idx){
		
		MemberInfo info = editService.getEditFormData(idx);
		
		return new ResponseEntity<MemberInfo>(info, HttpStatus.OK);
		
	}
	
	
	
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<String> editMember(@PathVariable("id") int id, @RequestBody RequestMemberEdit editRequest,HttpServletRequest request){
		
		editRequest.setIdx(id);
		
		System.out.println(editRequest);
		
		int cnt = editService.edit(editRequest, null, request);
		
		return new ResponseEntity<String>(cnt>0?"success":"fail" , HttpStatus.OK);
	}
	
}
