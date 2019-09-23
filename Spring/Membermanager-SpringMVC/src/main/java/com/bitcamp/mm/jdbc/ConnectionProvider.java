package com.bitcamp.mm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {   //throws : 예외가 발생시 해당 예외실행한 메소드에게 던져준다.
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:pool");
	}
	
	
}


//커넥션 풀(DBCP API 사용) : 데이터 베이스와 연결된 커넥션을 미리 만들어서 풀 속에 저장해두고 있다가
//							필요할때에 커넥션을 풀에서 가져다 쓰고 다시 풀에 반환하는 기법
//							: 장점 : 커넥션 연결시간 줄일수있다/ 커넥션 수가 일정하게 유지
/*
 * 커넥션 풀 초기화 : 서블릿 클래스 작성 후 web.xml 파일에 추가
 * 
 * <servlet>
 * <servlet-name>DBCPInit</servlet-name>
 * <servlet-class>jdbc.DBCPInit</servlet-class>
 * <load-on-startup>/<load-on-startup>
 * </servlet>
 * 
 * 
 * -DBCPInit.java
 * package jdbc
 * public class DBCPInit extends HTTPServlet{
 * 
 *@Override
 *public void init() throws ServletException{
 *	loadJDBCDriver(); //드라이버 로드
 *	initConnectionPool();  //pooling 등록
 * .....메서드 작성
 * }
 * }
 * 
 * 
 * -사용하기 
 * String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";  //풀이름
 * Connection conn = DriverManager.getConnection(jdbcDriver);
 * 
 *
 *
 * 
 * 
 * 
 * 
 */

