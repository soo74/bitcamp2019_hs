<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
</head>
<body>
<h1>Login Form</h1>
<hr>

<!-- <form action="loginProcess" method="post"> -->
<!-- <form action="loginProc" method="get"> -->
<form action="loginOk" method="post">

아이디 :  <input type="text" name="uId"> <br>          <!-- 전달해줘야하므로 name 속성 -->
비밀번호 : <input type="password" name="uPw"> <br>
<input type="submit" value="로그인">


</form>















</body>
</html>