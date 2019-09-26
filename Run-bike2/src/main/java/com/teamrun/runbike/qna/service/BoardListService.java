package com.teamrun.runbike.qna.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamrun.runbike.qna.dao.BoardDaoInterface;
import com.teamrun.runbike.qna.domain.ListViewData;
import com.teamrun.runbike.qna.domain.Message;
import com.teamrun.runbike.qna.domain.SearchParam;


@Service("listService")
public class BoardListService implements BoardService {
	


	@Autowired
	private SqlSessionTemplate template;
	
	private BoardDaoInterface dao; 

	
	// 1. 한페이지에 보여줄 게시글의 개수
	private static final int MESSAGE_COUNT_PER_PAGE = 5;
	
	
	public ListViewData listViewData(int pageNumber, SearchParam searchParam) {
		
		// dao 생성
		dao = template.getMapper(BoardDaoInterface.class);
		
		ListViewData pagelistData = new ListViewData();
		
		
		List<Message> messageList = null;
		
		System.out.println("searchparam :"+searchParam);
		
		
		pagelistData.setCurrentPageNumber(pageNumber);
		
		int totalCount = dao.selectTotalCount(searchParam);
		pagelistData.setTotalCount(totalCount);
		
		int totalPageCount = 0;
		
		if(totalCount > 0) {
			totalPageCount = totalCount/MESSAGE_COUNT_PER_PAGE;
			if(totalCount%MESSAGE_COUNT_PER_PAGE > 0) {
				totalPageCount++;
			}
		}
		
		pagelistData.setPageTotalCount(totalPageCount);
		
		int index = (pageNumber-1)*MESSAGE_COUNT_PER_PAGE;
		
	Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("index", index);
		param.put("count", MESSAGE_COUNT_PER_PAGE);
		param.put("search", searchParam);
		
		messageList = dao.pageListAll(param);
		if(messageList.size()>0) {
			
			System.out.println("messageList :" + messageList.get(0).getU_idx());
			
		}
		
		pagelistData.setPageList(messageList);
		
		int no = totalCount - index;
		
		pagelistData.setNo(no);
		
		return pagelistData;
	}
		
		
	
		
	
	
	
	
	
	//게시글 전체리스트 출력 
	public List<Message> getAllList(){
		
		dao = template.getMapper(BoardDaoInterface.class);
		
		List<Message> list = dao.selectAllList();
		
		return list;
		
	}
	
	
	
	/*
	 * 
	 * //답글+게시글 리스트 public List<Message> replyList(){
	 * 
	 * dao = template.getMapper(BoardDaoInterface.class);
	 * 
	 * List<Message> list = dao.replyList(); return list; }
	 * 
	 */

	
	
	

}
