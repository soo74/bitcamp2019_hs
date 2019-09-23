package com.bitcamp.cm.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cm.jdbc.ConnectionProvider;
import com.bitcamp.cm.member.dao.MemberDaoInterface;
import com.bitcamp.cm.member.domain.MemberInfo;
import com.bitcamp.cm.member.domain.RequestMemberEdit;

@Service("editService")
public class MemberEditService implements MemberService {

	//@Autowired
	//private MemberDao dao;	
	
	//@Autowired
	//private MemberJdbcTemplateDao dao;
	
	private MemberDaoInterface dao;
	
	@Inject
	private SqlSessionTemplate template;
	
	public MemberInfo getEditFormData(int id) {
		
		
		dao = template.getMapper(MemberDaoInterface.class);
		//Connection conn = null;
		//MemberInfo memberInfo = null;
		
		//try {
		//	conn= ConnectionProvider.getConnection();
		MemberInfo memberInfo = dao.selectMemberByIdx(id);
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		//System.out.println("service : " + memberInfo);
		
		return memberInfo;
	}

	public int edit(RequestMemberEdit edit, String oldFileName, HttpServletRequest request) {
		
		dao = template.getMapper(MemberDaoInterface.class);
		
		int rCnt = 0;
		MemberInfo memberInfo = edit.toMemberInfo();
		
		
		
		//try {
		//	conn = ConnectionProvider.getConnection();
			rCnt = dao.memberUpdate(memberInfo);
			
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		return rCnt;
	}
	
	

}