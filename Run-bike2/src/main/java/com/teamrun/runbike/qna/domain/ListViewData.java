package com.teamrun.runbike.qna.domain;

import java.util.List;

public class ListViewData {
		
		private List<Message> pageList;
		private int totalCount;
		private int no;
		//현재 페이지번호
		private int currentPageNumber;
		private int pageTotalCount;
		
		
		public ListViewData() {}
		
		
		public ListViewData(List<Message> pageList, int totalCount, int no, int currentPageNumber, int pageTotalCount) {
			super();
			this.pageList = pageList;
			this.totalCount = totalCount;
			this.no = no;
			this.currentPageNumber = currentPageNumber;
			this.pageTotalCount = pageTotalCount;
		}


		
		
		public List<Message> getPageList() {
			return pageList;
		}


		public void setPageList(List<Message> pageList) {
			this.pageList = pageList;
		}


		public int getTotalCount() {
			return totalCount;
		}


		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}


		public int getNo() {
			return no;
		}


		public void setNo(int no) {
			this.no = no;
		}


		public int getCurrentPageNumber() {
			return currentPageNumber;
		}


		public void setCurrentPageNumber(int currentPageNumber) {
			this.currentPageNumber = currentPageNumber;
		}


		public int getPageTotalCount() {
			return pageTotalCount;
		}


		public void setPageTotalCount(int pageTotalCount) {
			this.pageTotalCount = pageTotalCount;
		}



		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
