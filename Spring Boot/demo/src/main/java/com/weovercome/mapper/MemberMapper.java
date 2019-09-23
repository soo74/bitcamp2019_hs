package com.weovercome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.weovercome.domain.MemberInfo;

public interface MemberMapper {

	@Select("select * from member order by idx desc") //mapper.xml을 사용하지않고 어노테이션으로 쿼리문 등록
	public List<MemberInfo> selectAll();
	
	public MemberInfo selectMemberById(String uid);
	
}
