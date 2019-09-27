<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div id="contents">
	<h3>회원 리스트</h3>
	<hr>
	<div class="searchBox">
	
		<form>
			검색<br>
			<select name="stype">
				<option value="both">아이디+이름</option>
				<option value="id">아이디</option>
				<option value="name">이름</option>
			</select>
			<input type="text" name="keyword"> <input type="submit" value="검색">
		</form>
		
	</div>
	<table>
		<tr>
			<td>no</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>			
			<td>가입일</td>
			<td>관리</td>
		</tr>
		
		<c:forEach items="${pageviewData.messageList}" var="loginInfo" varStatus="stat" >
		<tr>
			<td><%-- ${memberInfo.idx} / ${stat.index} / ${stat.count} / ${viewData.totalCount} /  --%>${pageviewData.no-stat.index}</td>
			<td>${loginInfo.u_id}</td>
			<td>${loginInfo.u_idx}</td>
			<td>${loginInfo.u_name}</td>
			
			<td>
				<fmt:formatDate value="${loginInfo.regDate}" pattern="yyyy.MM.dd"/>
			</td>
		
		</tr>
		</c:forEach>
		
	</table>
	<c:if test="${pageviewData.totalCount>0}">
	<div id="pagingBox">
		<c:forEach begin="1" end="${pageviewData.pageTotalCount}" var="num">
			<%-- <div><a href="memberList?p=${num}">${num}</a> </div> --%>
			<div><a href="memberList?p=${num}&stype=${param.stype}&keyword=${param.keyword}">${num}</a> </div> 
		</c:forEach>
		
	</div>
	</c:if>
	
</div>




</body>
</html>