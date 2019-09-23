package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTemplateDao;
import com.bitcamp.mm.member.dao.MemberDaoInterface;
import com.bitcamp.mm.member.domain.MemberInfo;


@Service("loginService")
public class MemberLoginService implements MemberService {
	
	//@Autowired
	//private MemberDao dao; 
	
	//@Autowired
	//private MemberJdbcTemplateDao dao;
	
	//자동 메퍼를 이용해서 생성할 dao
	private MemberDaoInterface dao;
	
	@Inject
	private SqlSessionTemplate template;
	
	
	public int login(String id, String pw, HttpServletRequest request) {
		
		//dao 생성
		dao = template.getMapper(MemberDaoInterface.class);
		
		
		//변수 타입 변경 boolean -> int
		//0 : 로그인 실패
		//1 : 미인증 로그인
		//2 : 로그인 정상 처리
		
		int loginChk = 0;
		
		MemberInfo memberInfo = null;
		
		//Connection conn = null;
		
		//try {
		//	conn = ConnectionProvider.getConnection();
			
		//memberInfo = dao.selectMemberById(conn, id);
			memberInfo = dao.selectMemberById(id);
			
			if(memberInfo!=null && memberInfo.pwChk(pw)) {
				
				if(memberInfo.getVerify() == 'Y') {
				
				// 세션에 저장
				// loginChk 상태값을 변경
				request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());
				loginChk = 2;
			}else {
				//미인증 로그인
				request.getSession(true).setAttribute("reEmail", memberInfo.getuId());
				loginChk = 1;
			}
		}
		
		return loginChk;
		
	}

}