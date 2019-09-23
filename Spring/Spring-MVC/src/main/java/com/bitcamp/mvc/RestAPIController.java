package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mvc.domain.Login;

@RestController
public class RestAPIController {
	
	//@GetMapping(value = "/restapi/hello")
	@RequestMapping(name = "/restapi/hello", 
			method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("restapi/login")
	public Login login() {
		
		Login login = new Login();
		login.setuId("cool");
		login.setuPw("123456");
		
		return login;
		
	}
	
	@RequestMapping("restapi/loginList")
	public List<Login> loginList() {
		
		List<Login> list = new ArrayList<Login>();
		
		Login login = new Login();
		login.setuId("cool");
		login.setuPw("123456");
		
		list.add(login);
		
		login = new Login();
		login.setuId("Hot");
		login.setuPw("password");
		
		list.add(login);
		
		return list;
		
	}
	
	@RequestMapping("restapi/loginMap")
	public Map<String, Login> loginMap() {
		
		Map<String, Login> maps = new HashMap<String, Login>();
		
		
		Login login = new Login();
		login.setuId("cool");
		login.setuPw("123456");
		
		maps.put("1", login);
		
		login = new Login();
		login.setuId("Hot");
		login.setuPw("password");
		
		maps.put("2", login);
		
		return maps;
		
	}
	
	
	
	
	
	
	
	
	
}