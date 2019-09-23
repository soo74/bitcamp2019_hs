package com.bitcamp.mm.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.mm.jdbc.JdbcUtil;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;


@Repository("templateDao")
public class MemberJdbcTemplateDao { // memberDao
	
	@Autowired           //자동주입받아야하므로
	JdbcTemplate template;//jdbc템플릿의 메서드를 이용해야하니까
	
	
	

	public MemberInfo selectMemberById(Connection conn, String userId) {	//userId를 받아서 uid로 식별후 memberInfo로 처리
		
		MemberInfo memberInfo = null;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		System.out.println("dao : memberId -> " + userId);
		
		String sql = "select * from member where uid=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				System.out.println("check ::::::::::::::::::::::::");
				memberInfo = new MemberInfo(
					rs.getInt("idx"), 
					rs.getString("uid"), 
					rs.getString("upw"), 
					rs.getString("uname"), 
					rs.getString("uphoto"), 
					new Date(rs.getTimestamp("regdate").getTime()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return memberInfo;
	}

	public MemberInfo selectMemberById(String userId) {  //하나의 객체로 반환하므로 rowmapper클래스를 따로만들어서 처리하면 편하다
		
		String sql = "select * from member where uid=?";
		
		List<MemberInfo> list = template.query(sql, new Object[] {userId}, new MemberInfoRowMapper());   //object는 최상위클래스 //new Object[] {userId} : 배열객체생성
		//template.query(sql, rse, userId)  이렇게도쓰인다//rowmapper가 중간,위에꺼는 파라미터가 중간
		
		return list.isEmpty()?null:list.get(0);
	}
	
	public MemberInfo selectMemberById2(String userId) {

		String sql = "select * from member where uid=?";

		MemberInfo memberInfo = null;

		try {
			memberInfo = template.queryForObject(sql, new Object[] { userId }, new MemberInfoRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberInfo;

	}
	
	
	
	
	
	
	public int insertMember(Connection conn, MemberInfo memberInfo) {

		
		PreparedStatement pstmt = null;
		
		int rCnt = 0;
		
		String sql = "insert into member (uid, uname, upw, uphoto) values (?,?,?,?) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuId());
			pstmt.setString(2, memberInfo.getuName());
			pstmt.setString(3, memberInfo.getuPW());
			pstmt.setString(4, memberInfo.getuPhoto());
			rCnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rCnt;
		
	}

	public int insertMember(MemberInfo memberInfo) {
		
		String sql = "insert into member (uid, uname, upw, uphoto) values (?,?,?,?) ";
		
		 return template.update(
				sql,
				memberInfo.getuId(),
				memberInfo.getuName(),
				memberInfo.getuPW(),
				memberInfo.getuPhoto()
				);

	}
	
	
	
	
	public int selectTotalCount(Connection conn, SearchParam searchParam) {
		
		int totalCnt = 0;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select count(*) from member";
		
		if(searchParam != null) {
			sql = "select count(*) from member where ";
			if(searchParam.getStype().equals("both")) {
				sql += " uid like '%"+searchParam.getKeyword()+"%' or uname  like '%"+searchParam.getKeyword()+"%'";
			}
			if(searchParam.getStype().equals("id")) {
				sql += " uid  like '%"+searchParam.getKeyword()+ "%'";
			}
			if(searchParam.getStype().equals("name")) {
				sql += " uname  like '%"+searchParam.getKeyword()+"%'";
			}
		}
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				totalCnt = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return totalCnt;
	}

	public int selectTotalCount(SearchParam searchParam) {
		
		String sql = "select count(*) from member";
		
		if(searchParam != null) {
			sql = "select count(*) from member where ";
			if(searchParam.getStype().equals("both")) {
				sql += " uid like '%"+searchParam.getKeyword()+"%' or uname  like '%"+searchParam.getKeyword()+"%'";
			}
			if(searchParam.getStype().equals("id")) {
				sql += " uid  like '%"+searchParam.getKeyword()+ "%'";
			}
			if(searchParam.getStype().equals("name")) {
				sql += " uname  like '%"+searchParam.getKeyword()+"%'";
			}
		}
		return template.queryForObject(sql, Integer.class);
	}
	
	
	
	
		
	
	
	public List<MemberInfo> selectList(Connection conn, int index, int count) {
		
		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.setInt(2, count);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberInfo(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberList;
	}

	public List<MemberInfo> selectList(int index, int count) {
	
		String sql = "SELECT * FROM member limit ?, ?";
		
		return template.query(sql, new MemberInfoRowMapper(), index, count);
		
	}
	
	
	
	
	

	
	
	
	public List<MemberInfo> selectListById(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member where uid like ?  limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchParam.getKeyword()+"%");
			pstmt.setInt(2, index);
			pstmt.setInt(3, count);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberInfo(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberList;
	}

	public List<MemberInfo> selectListById(int index, int count, SearchParam searchParam) {

		String sql = "SELECT * FROM member where uid like ?  limit ?, ?";

		return template.query(sql, new MemberInfoRowMapper(), "%" + searchParam.getKeyword() + "%", index, count);
	}
	
	
	
	
	public List<MemberInfo> selectListByName(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member where uname like ?  limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchParam.getKeyword()+"%");
			pstmt.setInt(2, index);
			pstmt.setInt(3, count);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberInfo(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberList;
	}

	public List<MemberInfo> selectListByName(int index, int count, SearchParam searchParam) {

		String sql = "SELECT * FROM member where uname like ?  limit ?, ?";

		return template.query(sql, new MemberInfoRowMapper(), "%" + searchParam.getKeyword() + "%", index, count);
	}
	
	
	
	public List<MemberInfo> selectListByBoth(Connection conn, int index, int count, SearchParam searchParam) {

		List<MemberInfo> memberList = new ArrayList<MemberInfo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM member where uid like ? or  uname like ?  limit ?, ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchParam.getKeyword()+"%");
			pstmt.setString(2, "%"+searchParam.getKeyword()+"%");
			pstmt.setInt(3, index);
			pstmt.setInt(4, count);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				memberList.add(new MemberInfo(
						rs.getInt("idx"), 
						rs.getString("uid"), 
						rs.getString("upw"), 
						rs.getString("uname"), 
						rs.getString("uphoto"), 
						new Date(rs.getDate("regdate").getTime())));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberList;
	}
	
	public List<MemberInfo> selectListByBoth(int index, int count, SearchParam searchParam) {

		String sql = "SELECT * FROM member where uid like ? or  uname like ?  limit ?, ?";

		return template.query(sql, new MemberInfoRowMapper(), "%" + searchParam.getKeyword() + "%",
				"%" + searchParam.getKeyword() + "%", index, count);

	}
	
	
	
	
	public MemberInfo selectMemberByIdx(Connection conn, int id) {

		MemberInfo memberInfo = null;
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		System.out.println("dao : memberId -> " + id);
		
		String sql = "select * from member where idx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				System.out.println("check ::::::::::::::::::::::::");
				memberInfo = new MemberInfo(
					rs.getInt("idx"), 
					rs.getString("uid"), 
					rs.getString("upw"), 
					rs.getString("uname"), 
					rs.getString("uphoto"), 
					new Date(rs.getTimestamp("regdate").getTime()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		
		return memberInfo;
	}
			
	public MemberInfo selectMemberByIdx(int id) {

		String sql = "select * from member where idx=?";

		MemberInfo memberInfo = null;

		try {
			memberInfo = template.queryForObject(sql, new MemberInfoRowMapper(), id);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return memberInfo;
	}
	
	
	
	
	
	
	
	public int memberUpdate(Connection conn, MemberInfo memberInfo) {
		
		System.out.println(">>>>>>>>>>>> "+memberInfo);
		int rCnt = 0;
		PreparedStatement pstmt = null;
		String sql = "update member set uname=?, upw=?, uphoto=? where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberInfo.getuName());
			pstmt.setString(2, memberInfo.getuPW());
			pstmt.setString(3, memberInfo.getuPhoto());
			pstmt.setInt(4, memberInfo.getIdx());
			rCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return rCnt;
	}

	public int memberUpdate(MemberInfo memberInfo) {
		
		String sql = "update member set uname=?, upw=?, uphoto=? where idx=?";
		
		return template.update(sql,memberInfo.getuName(),memberInfo.getuPW(),memberInfo.getuPhoto(),memberInfo.getIdx());
		
		
	}
	
	

	public int memberDelete(Connection conn, int id) {
	
		int rCnt = 0;  //결과 가져올수있는거
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);                //첫번째 파라미터에 세팅
		
			rCnt = pstmt.executeUpdate();   //결과 생성
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rCnt;
		}
	
	public int memberDelete(int id) {
	
		String sql = "delete from member where idx=?";
		
		return template.update(sql, id);		
	}
}	


