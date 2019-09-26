<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>

</style>
</head>
<body>

	
			<div class="page-header">
	     	<h1>게시글 작성</h1>
			</div>
	
		<div style="padding : 30px;">
	     <!-- 파일 업로드 기능을 구현할 시에는 <form> 태그안에 반드시  enctype="multipart/form-data"를 작성해주어야 하고, 용량이 크기 때문에 method는 반드시 post로 작성해야 합니다. -->
	     <form method="post" action="qnaboard/writepro">
	        <div class="row">
	         <div class="form-group">
	          <label>작성자</label>
	           <input type="text" name="bWriter" id="bWriter" class="form-control" placeholder="작성자를 입력하세요" />
	          </div>
	         </div>
	        <div class="row">
	         <div class="form-group">
	              <label>제목</label>
	           <input type="text" name="bTitle" id="bTitle" class="form-control" placeholder="제목을 입력하세요" />
	         </div>
	        </div>
	   		<div class="row">
	          <div class="form-group">
	           <label>내용</label>
	           <textarea name="bContents" id="bContents" class="form-control" rows="15" placeholder="내용을 입력하세요"></textarea>
	          </div>
	  		 </div>
	  	 	
	  	 <div class="row">
	    	<div class="pull-right">
	        <button type="submit" class="btn btn-default" id="boardInsertButton">등록</button>
	    	</div>
	   	</div>
	    </form>
	 </div>
	
		
	
</body>
</html>
	











	<!-- <h3>문의글 쓰기</h3>
	<hr>
	<form action="qnaboard/writepro" method="post">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록"></td>
			</tr>
		</table>
	</form>

</body>
</html> -->