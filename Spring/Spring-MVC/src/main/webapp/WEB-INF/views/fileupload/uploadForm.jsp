<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>@RequestParm 이용한 파일 처리</h1>
	<hr>
	
	<form action="upload1" method="post" enctype="multipart/form-data">
		
		학번: <input type="text" name="sno">
		리포트 파일: <input type="file" name="report">
		<input type="submit" value="전송">
		
	</form>
	<hr>
	
	<h1>MultipartHttpServletRequest 이용한 파일 처리</h1>
	<hr>
	
	<form action="upload2" method="post" enctype="multipart/form-data">
		
		학번: <input type="text" name="sno">
		리포트 파일: <input type="file" name="report">
		<input type="submit" value="전송">
		
	</form>
	<hr>
	
	<h1>커맨드 객체 이용한 파일 처리</h1>
	<hr>
	
	<form action="upload3" method="post" enctype="multipart/form-data">
		
		학번: <input type="text" name="sno">
		리포트 파일: <input type="file" name="report">
		<input type="submit" value="전송">
		
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>