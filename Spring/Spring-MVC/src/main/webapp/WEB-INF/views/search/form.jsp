<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>검색</h1>
	인기 검색어 : <c:forEach items="${popularList}" var="keyword">${keyword}, </c:forEach>
	<br>
	<select>
		<option>선택</option>
		<c:forEach items="${searchType}" var="option">
		<option value="${option.no}">${option.name}</option>
		</c:forEach>
	</select>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>