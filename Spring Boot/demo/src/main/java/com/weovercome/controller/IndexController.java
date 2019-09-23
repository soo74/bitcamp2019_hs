package com.weovercome.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weovercome.dao.MemberDaoImpl;
import com.weovercome.domain.MemberInfo;
import com.weovercome.entity.MemberEntity;
import com.weovercome.mapper.MemberMapper;
import com.weovercome.repository.MemberRepository;

@Controller
public class IndexController {

	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private MemberMapper mapper;
	
	
	@RequestMapping("/")
	@ResponseBody 								/*-->ResponseBody : 응답으로 텍스트가 들어간다*/
	public String index() {
		
		return "Spring Boot Start";
		
	}
	
	
	
	@RequestMapping("/hello")
	@ResponseBody
	public void hello1() {    //컨트롤러는 void로 return을 요청받지 못하기 때문에 hello.jsp라는 뷰를 반환하게된다.
		
	}

	@RequestMapping("/memberInfo")
	public void selectByIdx() {
		
		mapper = template.getMapper(MemberMapper.class);
		
		MemberInfo info = mapper.selectMemberById("dale94011@gmail.com");
	
		System.out.println(info);
	}
	
	
	
	@RequestMapping("/members")
	@ResponseBody
	public List<MemberInfo> selectMembers() {
		
		mapper = template.getMapper(MemberMapper.class);
		
		List<MemberInfo> info =  mapper.selectAll();
		
		for (MemberInfo memberInfo : info) {
			System.out.println(memberInfo);
		}
		
		return info;
				
	}
	
	
	@RequestMapping("/member/list")
	@ResponseBody
	public List<MemberEntity> getMemberList(){
		
		List<MemberEntity> list = null;
		
		list = repository.findAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
	}
	
	
	@RequestMapping("/member/insert")
	@ResponseBody
	public String insertMember() {
		
		MemberEntity entity = new MemberEntity();
		entity.setUid("cool@hot");
		entity.setUname("COOLin");
		entity.setUpw("12345");
		
		return repository.saveAndFlush(entity).toString();
		
	}
	
	
	@RequestMapping("/member/edit/{id}")
	@ResponseBody
	public String editMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		entity.setIdx(idx);
		entity.setUid("cool@hot.com");
		entity.setUname("COOLinHot");
		entity.setUpw("editPW");
		
		return repository.saveAndFlush(entity).toString();
		
	}
	
	@RequestMapping("/member/delete/{id}")
	@ResponseBody
	public String deleteMember(@PathVariable("idx") int idx) {
		
		MemberEntity entity = new MemberEntity();
		entity.setIdx(idx);   //삭제하고자하는 idx
				
		 repository.delete(entity);
		 
		return "delete success";
		
	}
	
	
	
	
	
	
	@RequestMapping("/member/member/{idx}")
	@ResponseBody
	public MemberEntity getMemberInfo(@PathVariable("idx") long idx) {
		
		MemberEntity entity = null;
		
		entity = repository.findByIdx(idx);
		System.out.println(entity);
		return entity;
	}
	
	/*
	 * @RequestMapping("/member/memberbyname/{name}")
	 * 
	 * @ResponseBody public MemberEntity getMemberInfo(@PathVariable("name") String
	 * name) {
	 * 
	 * List<MemberEntity> entitys = null;
	 * 
	 * entitys = repository.findByUnameLike("%"+name+"%");
	 * 
	 * for (MemberEntity memberEntity : entitys) { System.out.println(memberEntity);
	 * }
	 * 
	 * return entitys; }
	 */
	
	
	@RequestMapping("/member/memberbybetween")
	@ResponseBody
	public List<MemberEntity> getMemberInfo() {
		
		List<MemberEntity> entitys = null;
		
		entitys = repository.findByIdxBetween(20, 30);
		
		for (MemberEntity memberEntity : entitys) {
			System.out.println(memberEntity);
		}
		
		return entitys;
	}
	
	
	
	@PersistenceContext
	EntityManager entityManager;
	
	private MemberDaoImpl dao;
	
	public IndexController() {
		this.dao = new MemberDaoImpl(entityManager);
	}
	
	@RequestMapping("/listall")
	@ResponseBody
	public List<MemberEntity> memberListAll(){
		List<MemberEntity> list = dao.getAll();
		
		for (MemberEntity memberEntity : list) {
			System.out.println(memberEntity);
		}
		
		return list;
	}
	
	
	@RequestMapping("/listbyidx/{idx}")
	@ResponseBody
	public MemberEntity memberByIdx(@PathVariable("idx") long idx){
		this.dao = new MemberDaoImpl(entityManager);
		MemberEntity entity = dao.findByIdx(idx);
		System.out.println(entity);
		
		return entity;
	}
	
	
	@RequestMapping("/listbyname/{name}")
	@ResponseBody
	public List<MemberEntity> memberByName(@PathVariable("name") long name){
		this.dao = new MemberDaoImpl(entityManager);
		List<MemberEntity> entity = dao.findByUname(name);
		System.out.println(entity);
		
		return entity;
	}


	


}
