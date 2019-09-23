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
<h1>Index Page</h1>

<ul>
	<li> <a href="/mvc/hello">/hello</a> </li>	
	<li> <a href="member/login">/member/login</a> </li>	
	<li> <a href="<c:url value="/member/memberLogin" />">/member/memberLogin</a> </li>
	<li> <a href="<c:url value="/order/order" />">/order/order</a> </li>
	<li> <a href="<c:url value="/cookie/makeForm" />">/cookie/makeForm</a> </li>
	<li> <a href="<c:url value="/cookie/viewCookie" />">/cookie/viewCookie</a> </li>
	<li> <a href="<c:url value="/header/getHeader" />">/header/getHeader</a> </li>
	<li> <a href="<c:url value="/search/search" />">/search/search</a> </li>
	<li> <a href="<c:url value="/fileupload/uploadForm" />">/fileupload/uploadForm</a> </li>
</ul>













</body>
</html>