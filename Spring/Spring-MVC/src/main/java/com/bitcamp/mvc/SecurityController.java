package com.bitcamp.mvc;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AES256Util aesUtil;
	
	@ResponseBody
	@RequestMapping("/encodepassword")
	public String bcript() {
		
		String str = "password";
		
		String encodingStr = encoder.encode(str);
		
		boolean result = encoder.matches(str, encodingStr);
		
		return str + " : " + encodingStr + "<br>"
				+ "str=encodingStr ==> "+ result;
		
	}
	

	@ResponseBody
	@RequestMapping("/encodepassword1")
	public String bcript1() {
		
		String str = "password";		
		String encodingStr = Sha256.encrypt(str);
		String pw = "password";
		boolean result = encodingStr.equals(Sha256.encrypt(pw));
		
		return str + " : " + encodingStr + "<br>"
				+ "encodingStr = pw ==> " + result ;
		
	}

	

	@ResponseBody
	@RequestMapping("/encodepassword2")
	public String bcript2() throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		
		String str = "password";		
		String encodingStr = aesUtil.encrypt(str);
		String decodingStr = aesUtil.decrypt(encodingStr);
		
		
		return str + " : " + encodingStr + " : "  + decodingStr ;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}