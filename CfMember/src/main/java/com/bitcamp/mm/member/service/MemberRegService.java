package com.bitcamp.mm.member.service;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.mm.member.dao.MemberDaoInterface;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberRegist;

@Service("registService")
public class MemberRegService implements MemberService {
	


	private MemberDaoInterface dao;
	
	@Autowired
	MailSenderService mailService;
	
	@Inject
	private SqlSessionTemplate template;
	
	
	
	
	public int memberInsert(HttpServletRequest request, RequestMemberRegist regist) {
		

		dao = template.getMapper(MemberDaoInterface.class);
		

		String path = "/uploadfile/userphoto"; // 리소스 매핑 필요 
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		MemberInfo memberInfo = regist.toMemberInfo();

		int resultCnt = 0;
		
		
		
		String newFileName = "";
		MultipartFile file = regist.getU_photo();
		
		try {
			if(file != null && !file.isEmpty() && file.getSize()>0 ) {
				
				newFileName = memberInfo.getU_id()+"_"+regist.getU_photo().getOriginalFilename();

				regist.getU_photo().transferTo(new File(dir, newFileName));
				memberInfo.setU_photo(newFileName);
			} else {
				memberInfo.setU_photo("default.png");
			}
			
			resultCnt = dao.insertMember(memberInfo);
			

			mailService.send(memberInfo.getU_id(), memberInfo.getCode());
			
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
			System.out.println("error");
			
			if(regist.getU_photo()!= null) {
				new File(dir,newFileName).delete();
			}
		}
		
		
		return resultCnt;
	}
	
			public char idCheck(String id) {
				
				
				dao = template.getMapper(MemberDaoInterface.class);
				char chk = dao.selectMemberById(id)==null?'Y':'N' ;
			
				return chk;
			}
			
			public String idCheck1(String id) {
				
			
				dao = template.getMapper(MemberDaoInterface.class);
				String chk = dao.selectMemberById2(id)==null ? "Y" : "N" ;
				
				return chk;
			}
			
			
			
			
	
	
	
	
	
	
	
}
