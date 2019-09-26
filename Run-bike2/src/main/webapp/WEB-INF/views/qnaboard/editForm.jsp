<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



 <div id="editFrame" style="display: none">
			  <h3>문의글 수정</h3>
        	<hr>
        	<form id="editForm" onsubmit="return false;" method="post" >
            <input type="hidden" name="u_idx" id="eu_idx">
            작성자 <input type="text" name="q_writer" id="eq_writer" readonly> <br>
            제목 <input type="text" name="q_title" id="eq_title" required> <br>
            내용 <input type="text" name="q_content" id="eq_content" required><br>

            <input type="submit" value="등록" onclick="editSubmit();">

        	</form>
   			</div>
			









</body>
</html>