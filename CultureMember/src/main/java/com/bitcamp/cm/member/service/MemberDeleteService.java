package com.bitcamp.cm.member.service;

import com.mysql.jdbc.Connection;
import java.sql.SQLException;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.cm.jdbc.ConnectionProvider;

import com.bitcamp.cm.member.dao.MemberDaoInterface;



@Service("deleteService")
public class MemberDeleteService implements MemberService{
	
	//@Autowired 
	//private MemberDao dao;
	
	//@Autowired
	//private MemberJdbcTemplateDao dao;
	
	//자동 메퍼를 이용해서 생성할 dao
	private MemberDaoInterface dao;
	
	//자동 메퍼를 위한 sqlSessionTemplate 객체 주입
	@Inject
	private SqlSessionTemplate template;
	
	
	
	public int memberDelete(int id) {
		
		//SqlSessionTemplate getMapper를 이용해 dao 생성
		dao = template.getMapper(MemberDaoInterface.class);
		
	//	int rCnt = 0;
		
	//	Connection conn = null;   //dao쪽에 커넥션 객체만들어서 전해줌
		
	//	try {
	//		conn = ConnectionProvider.getConnection();   //받아온다
			
	//		rCnt = dao.memberDelete(id);   //delete 처리해주고 id로 받아옴 
	//	} catch (SQLException e) {
			// TODO: handle exception
	//		e.printStackTrace();
	//	}
		
		
		return dao.memberDelete(id); 
	}
	
	
	

}
