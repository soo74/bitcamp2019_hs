package com.weovercome.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.weovercome.entity.MemberEntity;

public class MemberDaoImpl implements MemberDao<MemberEntity> {  /* MemberDao인터페이스를 구현하는것 */

	
	private EntityManager entityManager;
	
	
	public MemberDaoImpl() {}
	
	
	public MemberDaoImpl(EntityManager entityManager) {             //생성자 생성
	super();
	this.entityManager = entityManager;
}


	@Override
	public List<MemberEntity> getAll() {
		
		Query query = entityManager.createQuery("from MemberEntity");        //쿼리문 작성, 테이블이름이 아닌 엔티티객체이름이 들어간다.
		
		List<MemberEntity> list = query.getResultList();
		
		entityManager.close();
		
		return list;
	} 
	
	@Override
	public MemberEntity findByIdx(long idx) {
		Query query = entityManager.createQuery("from MemberEntity where idx="+idx);
		MemberEntity entity = (MemberEntity)query.getSingleResult();
		return entity;
	}
	
	public List<MemberEntity> findByUname(String name){
		Query query = entityManager.createQuery("from MemberEntity where uname="+uname);
		List<MemberEntity> list = query.getResultList();
		return list;
	}
	
	public List<MemberEntity> find(String fstr){
		List<MemberEntity> list = null;
		String qSql = "from MemberEntity where idx=:fidx or uname like :fname or uid like :fid";
		Long fIdx = 0L;
	}
	
	


}
