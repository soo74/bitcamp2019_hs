package com.weovercome.dao;

import java.io.Serializable;
import java.util.List;

public interface MemberDao<T> extends Serializable{

	public List<T> getAll();
	public T findByIdx(long idx);
	public List<T> findByUname(String name);
	
}
