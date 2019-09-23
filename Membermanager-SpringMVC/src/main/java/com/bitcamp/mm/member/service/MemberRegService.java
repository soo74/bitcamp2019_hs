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
import org.springframework.web.multipart.MultipartFile;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTemplateDao;
import com.bitcamp.mm.member.dao.MemberDaoInterface;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberRegist;

@Service("registService")
public class MemberRegService implements MemberService {
	
	//@Autowired
	//private MemberDao dao;
	
	
	//@Autowired
	//private MemberJdbcTemplateDao dao;
	
	//@Autowired
	//private SqlSessionTemplate template;
	
	// 자동 메퍼를 이용해서 생성할 dao
	private MemberDaoInterface dao;
	
	@Autowired
	MailSenderService mailService;
	
	
	// 자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	// @Inject : 타입에 맞는 주입 ( java 에서 지원 : 특정 프레임워크에 의존하지 않음 )
	@Inject
	private SqlSessionTemplate template;
	
	
	
	
	public int memberInsert(
			HttpServletRequest request, 
			RequestMemberRegist regist) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberDaoInterface.class);
		
		// 서버 경로
		String path = "/uploadfile/userphoto"; // 리소스 매핑 필요  //저장하고자 하는 경로
		// 절대 경로 
		String dir = request.getSession().getServletContext().getRealPath(path);
		
		MemberInfo memberInfo = regist.toMemberInfo();
		
		int resultCnt = 0;
		
		// 새로운 파일 이름 생성
		//String newFileName = memberInfo.getuId()+System.nanoTime();
		String newFileName = "";
		
		//String newFileName = memberInfo.getuId()+"_"+regist.getuPhoto().getOriginalFilename();
		
		MultipartFile file = regist.getuPhoto();
		
		//Connection conn = null;
		try {
			if(file != null && !file.isEmpty() && file.getSize()>0 ) {
				// 새로운 파일 이름 생성
				//String newFileName = memberInfo.getuId()+System.nanoTime();				
				newFileName = memberInfo.getuId()+"_"+regist.getuPhoto().getOriginalFilename();
				// 파일을 서버의 지정 경로에 저장
				regist.getuPhoto().transferTo(new File(dir, newFileName));
				// 데이터베이스 저장을 하기위한 파일 이름 set
				memberInfo.setuPhoto(newFileName);
			} else {
				memberInfo.setuPhoto("default.png");
			}
			
			resultCnt = dao.insertMember(memberInfo);
			
			// 메일 발송
			mailService.send(memberInfo.getuId(), memberInfo.getCode());
			
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("오류");
			if(regist.getuPhoto()!= null) {
				new File(dir,newFileName).delete();
			}
		}
		
		
		return resultCnt;
	}
	
	public char idCheck(String id) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberDaoInterface.class);
		
		char chk = dao.selectMemberById(id)==null?'Y':'N' ;
		
		return chk;
	}
	
	public String idCheck1(String id) {
		
		// SqlSessionTemplate getMapper 를 이용해 dao 생성
		dao = template.getMapper(MemberDaoInterface.class);
		
		String chk = dao.selectMemberById2(id)==null ? "Y" : "N" ;
		
		return chk;
	}
	
	
	
	
	
	
	
	
	
	
	
}