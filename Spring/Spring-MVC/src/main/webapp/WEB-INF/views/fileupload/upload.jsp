<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<h3>
		학번 : ${sno}  ${report.sno}<br>
		리포트 : ${fileName} ${report.fileName} ( ${fileSize} ${report.fileSize} byte  )	
	</h3>
</body>
</html>