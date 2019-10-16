package com.teamrun.runbike.qna.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamrun.runbike.qna.dao.BoardDaoInterface;
import com.teamrun.runbike.qna.domain.ListViewTest;
import com.teamrun.runbike.qna.domain.Message;
import com.teamrun.runbike.qna.domain.SearchParam;

@Service("boardlistservice")
public class BoardTestService {

	
	private BoardDaoInterface dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	final int TEST_LIST = 5;
	
	public ListViewTest getTestData(int currentPageNumber,SearchParam searchParam) {
	
	dao = template.getMapper(BoardDaoInterface.class);
	
	ListViewTest listData = new ListViewTest();
	
	//현재 페이지 번호
	listData.setCurrentPageNumber(currentPageNumber);
	
	int totalCnt = dao.selectTotalCount(searchParam);
	
	int totalPageCnt = 0;
	
	if(totalCnt>0) {
		totalPageCnt = totalCnt/TEST_LIST;
		if(totalCnt%TEST_LIST>0) {
			totalPageCnt++;
		}
	}
	listData.setPageTotalCount(totalPageCnt);
	
	int index = (currentPageNumber-1)*TEST_LIST;
	
	List<Message> testList = null;
	
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("search", searchParam);
	params.put("index", index);
	params.put("count", TEST_LIST);
	
	testList = dao.selectList(params);
	System.out.println("회원 총인원 : " + totalCnt);
	System.out.println("회원리스트 admin 사이즈 : " + testList.size());
	
	listData.setTestList(testList);
	for(Message m : testList) {
		System.out.println(m);
	}
	

	int no = totalCnt - index;
	listData.setNo(no);
	
	listData.setTotalCount(totalCnt);
	


	return listData;
		
}
	
	public List<Message> getAllListTest(){
		
		dao = template.getMapper(BoardDaoInterface.class);
		
		List<Message> list = dao.selectAllList();
		
		return list;
		
	}
	
	
	
	
}
