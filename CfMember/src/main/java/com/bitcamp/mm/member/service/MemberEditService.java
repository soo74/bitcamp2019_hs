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

import com.bitcamp.mm.member.dao.MemberDaoInterface;

import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberEdit;

@Service("editService")
public class MemberEditService implements MemberService {


	private MemberDaoInterface dao;
	
	@Inject
	private SqlSessionTemplate template;
	
	
	public MemberInfo getEditFormData(int id) {
		

		dao = template.getMapper(MemberDaoInterface.class);
		
		MemberInfo memberInfo = dao.selectMemberByIdx(id);
		return memberInfo;
	}

	
	
	public int edit(RequestMemberEdit edit, String oldFileName, HttpServletRequest request) {

		
	
		dao = template.getMapper(MemberDaoInterface.class);
		
		int rCnt = 0;
		MemberInfo memberInfo = edit.toMemberInfo();

		String path = "/uploadfile/userphoto";
		String dir = request.getSession().getServletContext().getRealPath(path);

		// 신규 파일 체크
		if (edit.getU_photo() != null && !edit.getU_photo().isEmpty() && edit.getU_photo().getSize() > 0) {

			String newFileName = edit.getU_id() + "_" + edit.getU_photo().getOriginalFilename();

			try {
				// 신규파일 저장
				edit.getU_photo().transferTo(new File(dir, newFileName));
				
				memberInfo.setU_photo(newFileName);
				
				new File(dir, oldFileName).delete();

			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			memberInfo.setU_photo(oldFileName);
		}

		rCnt = dao.memberUpdate(memberInfo);

		return rCnt;
	}

}
