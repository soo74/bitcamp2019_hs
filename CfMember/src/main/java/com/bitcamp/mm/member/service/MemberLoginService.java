package com.bitcamp.mm.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberDaoInterface;
import com.bitcamp.mm.member.domain.MemberInfo;

@Service("loginService")
public class MemberLoginService implements MemberService {

	private static MemberLoginService service = new MemberLoginService();

	

	private MemberDaoInterface dao;
	

	@Inject
	private SqlSessionTemplate template;
	
	public int login(String id, String pw, HttpServletRequest request) {
		

		dao = template.getMapper(MemberDaoInterface.class);
		
		
		
		
		
		int loginChk = 0;
		
		MemberInfo memberInfo = null;

			memberInfo = dao.selectMemberById(id);
			
			if(memberInfo!=null && memberInfo.pwChk(pw)) {
				

				if(memberInfo.getVerify() == 'Y') {

					request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());
					loginChk = 2;
				} else {

					request.getSession(true).setAttribute("reEmail", memberInfo.getU_id());
					loginChk = 1 ;
				}
			}
			System.out.println("service"+loginChk);
		return loginChk;
		
	}
	
	
	
	
	
	

}
