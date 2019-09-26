<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	div {
		border : 2px solid #666;
		width : 200px;
	}
</style>
</head>
<body>


	
	<H1> 게시글 </H1>
	
	<DIV style="text-align: right;"> <a href="boardwriteForm.jsp">글쓰기</a></DIV>
	
	

	
	<c:forEach items="${viewData.messageList}" var="message">
		<div>
		메시지 번호 : ${message.q_num}<br> 
		작성자 : ${message.q_writer}<br>
		제목 :${message.q_title}<br>
		메시지 :${message.q_content}<br> 
		
		<a href="delete?messageId=${message.q_num}">삭제하기</a>
		</div>
	
	
	</c:forEach>













</body>
</html>
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

</body>
</html>