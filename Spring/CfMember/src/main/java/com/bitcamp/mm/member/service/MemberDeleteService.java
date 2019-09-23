package com.bitcamp.mm.member.service;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.MemberDaoInterface;

@Service("deleteService")
public class MemberDeleteService implements MemberService {

	
	private MemberDaoInterface dao;

	@Inject
	private SqlSessionTemplate template;
	

	public int memberDelete(int id) {
		

		dao = template.getMapper(MemberDaoInterface.class);
		
		return dao.memberDelete(id);
	}

	
	
	
	
	
	
	
	
	
	
	
}
