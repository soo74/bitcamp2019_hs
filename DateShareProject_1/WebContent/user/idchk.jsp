<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="dateShare.Dao.dateUserDao"/>
<%

 int rst = 0;
 String id = (String)request.getParameter("id");
 rst = dao.idCheck(id);
 
%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>

</style>
</head>
<body>

		<title>아이디 중복 확인</title>
		
		</head>
		<body>
		<%
		if(rst == 1){
		%>
		
		<script>
		alert("아이디가 존재합니다.");
		</script>
		
		<%}else{ %>
		<script>
		alert("아이디 사용이 가능합니다.");
		</script>
		<%} %>
</body>
</html>







</body>
</html>