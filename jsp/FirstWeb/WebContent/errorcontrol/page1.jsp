<!-- errorcontrol 폴더에서는 : 프로그램의 흐름 - 에러발생 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="../errorpage/viewErrorPage.jsp" %>
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

name 파라미터 값 : <%= request.getParameter("name").toUpperCase() %>



</body>
</html>