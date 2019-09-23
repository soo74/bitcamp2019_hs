
<%@page import="dateShare.service.user.ConfirmIdService"%>
<%@page import="dateShare.Model.DateUser"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String u_id = request.getParameter("u_id");
	String u_pw = request.getParameter("u_pw");

	ConfirmIdService service = ConfirmIdService.getInstance();

	DateUser dUser = service.confirmId(u_id);

	if (u_id != null && dUser.getU_id() != null && dUser.getU_id().equals(u_id)) {

			out.println("사용가능한 아이디 입니다.");
			// 로그인 처리 후 회원가입창으로 이동	
			response.sendRedirect("../insertForm.jsp");

		} else {
			
			out.println("중복된 아이디가 있습니다");
			//out.println("alert('중복된 아이디가 있습니다').");
			
			
		}
%>