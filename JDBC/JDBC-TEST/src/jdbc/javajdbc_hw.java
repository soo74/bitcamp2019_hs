package jdbc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class javajdbc_hw  {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Connection conn = null; //JDBC의 정보를 가지는 인터페이스
		
		try {
		String dburl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String dbuser = "scott";
		String dbpw =  "tiger";
		
		
		PreparedStatement pstmt = null; //sql 미리 준비, 실행시 매개변수 받아 사용하는 방식
		ResultSet rs = null; // statement의 쿼리 실행결과 받음
		
		//라이브러리로 활용할 클래스를 로딩(필수), 데이터베이스 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("라이브러리 로드 성공"); //연결정보가지고 실제 데이터베이스 접속
		
		conn = DriverManager.getConnection(dburl, dbuser, dbpw);
		System.out.println("접속 성공");

		// insert 구문
		//1.EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
			
			  String sqlInsert = "insert into emp values(?,?,?,?,?,?,?,?)";
			  pstmt =conn.prepareStatement(sqlInsert);
			  pstmt.setInt(1,13);
			  pstmt.setString(2,"DALE");
			  pstmt.setString(3, "CUTE");
			  pstmt.setInt(4, 7890);
			  pstmt.setString(5, "2011/05/07");
			  pstmt.setInt(6, 3000);
			  pstmt.setInt(7,0);
			  pstmt.setInt(8, 40);
			  
			  int resultCnt = pstmt.executeUpdate(); if(resultCnt>0) {
			  System.out.println("정상적으로 입력되었습니다.");
			  System.out.println("--------------------------------"); }
			 
					
					Statement stmt = conn.createStatement();
					 String sql = "select * from emp order by empno";
					 rs=stmt.executeQuery(sql);
		
/*---------------------------------------------------------------------------*/
		

		
		
		//2.EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
		System.out.println("접속된 사원 정보");
		
		while(rs.next()) {
			System.out.println("사원번호 : "+rs.getInt(1)+"\t"
								+"사원이름 : "+rs.getString(2)+"\t"
								+"직급 : " +rs.getString(3)+"\t"
								+"매니저 : "+rs.getInt(4)+"\t"
								+"고용날짜 : "+rs.getString(5)+"\t"
								+"급여 : "+rs.getInt(6)+"\t"
								+"커미션 : "+rs.getInt(7)+"\t"
								+"부서번호 : "+rs.getInt(8)+"\t");
		}
		
/*---------------------------------------------------------------------------*/
		
		//3. EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
		String sqlUpdate = "update emp set sal=1000 where ename='SCOTT'";
		stmt.executeUpdate(sqlUpdate);
		
/*---------------------------------------------------------------------------*/
		
		//4.EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
		System.out.println("----------------------------------------------");
		//검색한 결과 찾기
		String sqlPrint = "select * from emp where ename='SCOTT'";
		rs=stmt.executeQuery(sqlPrint);  // statement의 쿼리 실행결과 받음
		
		//출력
		
		while(rs.next()) {
			System.out.println("사원번호 : "+rs.getInt(1)+"\t"
								+"사원이름 : "+rs.getString(2)+"\t"
								+"직급 : " +rs.getString(3)+"\t"
								+"매니저 : "+rs.getInt(4)+"\t"
								+"고용날짜 : "+rs.getString(5)+"\t"
								+"급여 : "+rs.getInt(6)+"\t"
								+"커미션 : "+rs.getInt(7)+"\t"
								+"부서번호 : "+rs.getInt(8)+"\t");
		}
		
/*---------------------------------------------------------------------------*/	
		//5.모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
		
			
			 String sqlAllprint = "select * from emp e join dept d on e.deptno = d.deptno";
			 rs=stmt.executeQuery(sqlAllprint);
			 
			 while(rs.next()) {
					System.out.println("사원번호 : "+rs.getInt(1)+"\t"
										+"사원이름 : "+rs.getString(2)+"\t"
										+"직급 : " +rs.getString(3)+"\t"
										+"매니저 : "+rs.getInt(4)+"\t"
										+"고용날짜 : "+rs.getString(5)+"\t"
										+"급여 : "+rs.getInt(6)+"\t"
										+"커미션 : "+rs.getInt(7)+"\t"
										+"부서번호 : "+rs.getInt("deptno")+"\t"
										+"부서명 : "+rs.getString("dname")+"\t"
										+"지역명 :"+rs.getString("loc")+"\t");
				}
		
		rs.close();
		stmt.close();
		pstmt.close();
		conn.close();
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
}
}

