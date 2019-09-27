package com.teamrun.runbike.admin.service;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamrun.runbike.admin.dao.AdminDao;
import com.teamrun.runbike.user.domain.UserInfo;


@Service("memberlistservice")
public class MemberListService {

	private AdminDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	
	public List<UserInfo> getAllListAdmin(){
		
		dao = template.getMapper(AdminDao.class);
		
		List<UserInfo> list = dao.selectAllListAdmin();
		
		return list;
		
	}
	
}
