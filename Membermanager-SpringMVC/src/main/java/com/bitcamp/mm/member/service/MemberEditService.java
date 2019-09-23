package com.bitcamp.mm.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberDaoInterface;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberEdit;

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
		
		String path = "/uploadfile/userphoto";
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		//Connection conn = null;
		
		
		// 신규 파일 체크
		if(edit.getuPhoto() != null && !edit.getuPhoto().isEmpty() && edit.getuPhoto().getSize()>0) {
			
			String newFileName = edit.getuId()+"_"+edit.getuPhoto().getOriginalFilename();
			
			try {
				// 신구파일 저장 
				edit.getuPhoto().transferTo(new File(dir, newFileName));
				// 데이터 베이스 저장을 위한 새로운 파일 이름
				memberInfo.setuPhoto(newFileName);
				// 이전 파일 삭제
				new File(dir, oldFileName).delete();
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			// 신규파일이 없으면 이전 파일 이름을 그대로 업데이트
			memberInfo.setuPhoto(oldFileName);
		}
		
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