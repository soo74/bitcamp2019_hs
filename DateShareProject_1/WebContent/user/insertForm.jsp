<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>DATE SHARE</title>
</head>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<style></style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>


<div id="wrap">
    <div id="main_wrap">
        <div id="header">
        	<%@include file="../frame/my.jsp" %>
            <%@include file="../frame/header.jsp" %>
        </div>
        <div id="nav">
            <%@include file="../frame/nav.jsp" %>
        </div>
        
        <div id="content">
        	<h3>회원가입 페이지</h3>
		<hr>
		<form action="insertMember.jsp" method="post">
		<table>
		
			<tr>
				<td>아이디(이메일)</td>
				<td><input type="email" name="u_id"> 
					<input type="button" name="confirm_id" value="중복확인"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="u_pw"> </td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="u_name"> </td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="u_bday"></td>
             </tr>
             <tr>
             	<td>성별</td>
             	<td><input type="radio" name=u_gender value="M">남자</td>
             	<td><input type="radio" name=u_gender value="F">여자</td>
             </tr>  
			<tr>
				<td></td>
				<td><input type="submit" value="회원가입"> </td>
			</tr>
		</table>
	</form>
</div>
        <div id="footer">
            <%@include file="../frame/footer.jsp" %>
        </div>
    </div>
    </div>
</body>
</html>