package com.teamrun.runbike.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamrun.runbike.admin.service.MemberListService;
import com.teamrun.runbike.user.domain.UserInfo;

@Controller
@RequestMapping("/adminpage")
public class MemberListController {



		 	@Autowired 
		 	private MemberListService listService;
			
			@RequestMapping(method=RequestMethod.GET)
			public String adminlist() {
				return "adminpage/adminlist";
			}
			
			@RequestMapping(value="/list", method = RequestMethod.GET)
			@ResponseBody
			public List<UserInfo> getAllListAdmin(){
				
				List<UserInfo> list = listService.getAllListAdmin();
				
				System.out.println(list);
				return list;
				
			}
			

			
}
