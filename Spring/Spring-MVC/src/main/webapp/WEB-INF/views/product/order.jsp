<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		width : 250px;
		border : 1px solid #DDD;
		padding : 10px;
		margin : 5px;
	}
</style>
</head>
<body>
	<h1>주문내역</h1>
	
	<c:forEach items="${orders.orderItems}" var="item">
		<div>
			상품 id : ${item.itemId} <br>
			상품개수 : ${item.number} <br>
			주의사항 : ${item.remark}		
		</div>	
	</c:forEach>
	

	<h1>배송지</h1>
	<div>
		우편번호 : ${orders.address.zipcode}	<br>
		주소 : ${orders.address.address1} ${orders.address.address2}
	</div>












</body>
</html>