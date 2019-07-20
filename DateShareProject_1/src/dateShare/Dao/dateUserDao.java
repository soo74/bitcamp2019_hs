package dateShare.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.Session;
import com.mysql.cj.protocol.Resultset;

import dateShare.Model.DateUser;


public class dateUserDao {

	
private static dateUserDao dao = new dateUserDao();      //객체 생성
	
	public static dateUserDao getInstance() {   //getInstance(): 싱글톤패턴적용시 주로 사용
		return dao;
	}
	
	private dateUserDao() {}  //외부에서 새로 생성할수없게 막는것, 외부에서 new불가
	
	
	
	public int insert(Connection conn, DateUser dUser ) {   //메서드
	
		int rCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into dateuser values(dateuser_seq.nextVal,?, ?, ? ,?,sysdate,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dUser.getU_id());
			pstmt.setString(2, dUser.getU_pw());
			pstmt.setString(3, dUser.getU_name());
			pstmt.setString(4, dUser.getU_bday());
			pstmt.setString(5, dUser.getU_gender());
			
			rCnt =  pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();     //stacktrace : stack에 메서드가 호출된 기록을 남김
										 //printStackTrace(): 에러가 발생한 메서드의 호출기록 출력
			}
			
		}	
		
			return rCnt;
	}
	
	
	
public DateUser login(Connection conn, String u_id) {
    
    DateUser dUser = null;
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    String sql = "select u_num, u_id, u_pw, u_name from dateuser where u_id=?";
    
    try {
       
       pstmt = conn.prepareStatement(sql);
       pstmt.setString(1, u_id);
       
       rs = pstmt.executeQuery();
       
       if(rs.next()) {
          dUser = new DateUser();
          dUser.setU_num(rs.getInt(1));
          dUser.setU_id(rs.getString(2));
          dUser.setU_pw(rs.getString(3));
          dUser.setU_name(rs.getString(4));
       }
       
    } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
    }

    return dUser;
    
 }

//아이디 중복체크

public static boolean check(Connection conn, String u_id) {
	
	
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	String sql = "select id from dateuser";
	try {
		pstmt = conn.prepareStatement(sql);
		
		while(rs.next()) {
			if(rs.getString("u_id").equals(u_id)) {
				return true;
			}
		}
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
}


//아이디 중복체크
public int idCheck(Connection conn, String id){
	
	
	  int rst = 0;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  String sql = "select * from member where id=?";
	  
	  try{

	  
	   ps = conn.prepareStatement(sql);
	   ps.setString(1, id);
	   rs = ps.executeQuery();
	   
	   if(rs.next()){
	    rst = 1;
	   }
	   
	  }catch(Exception e){
	   e.printStackTrace();
	  }
	  return rst;
	 }








//아이디 중복체크
public DateUser confirmId(Connection conn, String u_id) {
	
	DateUser dUser = null;
	int x= -1;
	PreparedStatement pstmt = null; 
	ResultSet rs = null;
	
	String sql = "select u_id from dateuser where u_id=?";
	
	try {
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, u_id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			  x=1; //해당 아이디 존재
		  }else {
			  x=-1; //해당 아이디 존재x
		  }
	}catch(Exception e) {
			  e.printStackTrace();
	}
	return dUser;
	
}



//회원정보수정 메서드
public int update(Connection conn, DateUser dUser ) {  
	
	int rCnt = 0;
	PreparedStatement pstmt = null;
	
	String sql = "update dateuser set u_pw=?, u_name=? where u_id=?";
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, dUser.getU_pw());
		pstmt.setString(2, dUser.getU_name());
		pstmt.setString(3, dUser.getU_id());
		
		rCnt =  pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
			
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();    
		}
		
	}	
		return rCnt;
}








//마이페이지 read 메서드
public DateUser read(Connection conn, DateUser dUser ) {  
	
	DateUser dateuser = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	String sql = "select * from dateuser where u_id=?";
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dUser.getU_id());
		
		rs =  pstmt.executeQuery();
		
		if(rs.next()) {
			dateuser = new DateUser();
			dateuser.setU_num(rs.getInt("u_num"));
			dateuser.setU_id(rs.getString("u_id"));
			dateuser.setU_pw(rs.getString("u_pw"));
			dateuser.setU_name(rs.getString("u_name"));
			dateuser.setU_bday(rs.getString("u_bday"));
			dateuser.setU_regdate(rs.getDate("u_regdate"));
			dateuser.setU_gender(rs.getString("u_gender"));
		}
		

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
		return dateuser;
}



public void deleteMember(Connection conn, String u_id) {
	PreparedStatement pstmt = null;
	
	try {
		String sql = "delete dateuser where u_id=?"; 
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,u_id);
		pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}


//아이디, 비밀번호가 맞을경우 테이블의 회원정보를 삭제하는 메서드
		public int removeMember(String u_id, String u_pw) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int rows=0;
			String sql = "delete from dateuser where u_id=? and u_pw=?";
			
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
				
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, u_id);
				pstmt.setString(2, u_pw);
				
				//delete 명령이 실행되어 삭제된 경우 1을 반환하여저장, 아니면 0을 반환하여 저장
				rows = pstmt.executeUpdate();
			}catch(SQLException e) {
				System.out.println("removeMember 메서드 오류 +" + e.getMessage());
			}/*finally {
				if(pstmt != null) try {pstmt.close();} catch(SQLException s) {}
				if(conn != null) try {conn.close();} catch(SQLException s) {}
			}*/
			return rows;
		}
		
		
		

		//회원삭제(회원탈퇴메서드) - 회원의 게시글도 없애야함 / 각자 게시물 sql지우기
		public int delete(Connection conn, DateUser dUser ) {   
			
			int rCnt = 0;
			PreparedStatement pstmt = null;
			
			Statement stmt = null;
			
			
			String sql2 = "delete from f_like where u_num="+dUser.getU_num();
			String sql3 ="delete from m_like where u_num="+dUser.getU_num();
			String sql4 ="delete from a_like where u_num="+dUser.getU_num();
			String sql5 = "delete from food where u_num="+dUser.getU_num();
			String sql6 = "delete from movie where u_num="+dUser.getU_num();
			String sql7 = "delete from activity where u_num="+dUser.getU_num();
			String sql8 = "delete from message where u_num="+dUser.getU_num();   //쪽지
			
			String sql = "select u_pw from dateuser where u_id =?";
			String sql1 = "delete from dateuser where u_id=?";
			
			ResultSet rs = null;
			
			
			try {
				
				// prepareStatement 여러번 사용하는 방법
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dUser.getU_id());
				rs =  pstmt.executeQuery();
				
			

				if(rs.next()){
					System.out.println(123);
				  if(rs.getString("u_pw").equals(dUser.getU_pw())) {
					  System.out.println(456);
					stmt = conn.createStatement();
					  System.out.println(789);
					  
					  
					  System.out.println("chk:::"+stmt.executeUpdate(sql2));
					  System.out.println("chk:::"+stmt.executeUpdate(sql3));
					  System.out.println("chk:::"+stmt.executeUpdate(sql4));
					  System.out.println("chk:::"+stmt.executeUpdate(sql5));
					  System.out.println("chk:::"+stmt.executeUpdate(sql6));
					  System.out.println("chk:::"+stmt.executeUpdate(sql7));
					  System.out.println("chk:::"+stmt.executeUpdate(sql8));
					/*
					 * System.out.println(10111); stmt.executeQuery(sql3); stmt.executeQuery(sql4);
					 * System.out.println("efef"); stmt.executeQuery(sql5);
					 * System.out.println("asdf"); stmt.executeQuery(sql6); stmt.executeQuery(sql7);
					 * stmt.executeQuery(sql8);
					 */

				  pstmt = conn.prepareStatement(sql1);
				  pstmt.setString(1,dUser.getU_id());
				  rCnt = pstmt.executeUpdate();
				  
				  System.out.println("회원탈퇴가 성공했습니다.");
				  
				  }else {
				  
				  System.out.println("비밀번호가 틀렸습니다.");
				  
				  
				  }
				 
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return rCnt;
			}	
				
		}




		
		
		
		











//회원삭제(회원탈퇴메서드)
/*
 * public int delete(Connection conn, DateUser dUser ) {
 * 
 * int rCnt = 0; PreparedStatement pstmt = null;
 * 
 * String sql = "select u_pw from dateuser where u_id =?"; ResultSet rs = null;
 * 
 * try {
 * 
 * pstmt = conn.prepareStatement(sql); pstmt.setString(1, dUser.getU_id()); rs =
 * pstmt.executeQuery();
 * 
 * if(rs.next()){
 * 
 * //if(dUser.getU_pw().equals("u_pw")){
 * 
 * if(rs.getString(1).equals(dUser.getU_pw())) {
 * 
 * dateUserDao del = new dateUserDao(); del.deleteMember(conn, dUser.getU_id());
 * 
 * rCnt = pstmt.executeUpdate();
 * 
 * System.out.println("회원탈퇴가 성공했습니다.");
 * 
 * }else {
 * 
 * System.out.println("비밀번호가 틀렸습니다.");
 * 
 * 
 * } }
 * 
 * } catch (SQLException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } return rCnt; }
 * 
 * }
 */








//아이디 중복 확인 
/*
 * public int confirmId(String u_id) throws Exception{
 * 
 * } int x= -1; Connection conn = null; PreparedStatement pstmt = null;
 * ResultSet rs = null;
 * 
 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); // 2. 데이터베이스 연결 conn=
 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott",
 * "tiger"); String sql = "select u_id from dateuser where u_id=?"; pstmt =
 * conn.prepareStatement(sql); pstmt.setString(1, u_id);
 * 
 * rs= pstmt.executeQuery(); if(rs.next()) { x=1; }else { x=-1; }catch(Exception
 * e) { e.printStackTrace(); }finally { if(rs != null) try { rs.close(); }
 * catch(SQLException s) {} if(pstmt != null) try {pstmt.close();}
 * catch(SQLException s) {} if(conn != null) try {conn.close();}
 * catch(SQLException s) {} } return x; }
 * 
 * 
 * 
 * 
 * }
 */