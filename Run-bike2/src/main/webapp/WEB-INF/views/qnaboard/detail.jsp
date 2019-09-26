<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	     	<h1>게시글 상세보기</h1>
			</div>
	
		<div style="padding : 30px;">
	     <!-- 파일 업로드 기능을 구현할 시에는 <form> 태그안에 반드시  enctype="multipart/form-data"를 작성해주어야 하고, 용량이 크기 때문에 method는 반드시 post로 작성해야 합니다. -->
	     <form id="form" method="post" onsubmit="return false;" >           <!-- action="qnaboard/writepro" -->
	        <div class="row">
	         <div class="form-group">
	         
	         	<!-- user테이블의 u_idx를 임의 지정 -->
	          <input type="hidden" value="66" name="u_idx" id="u_idx">
	         
	          <label>작성자</label>
	           <input type="text" name="q_writer" id="q_writer" class="form-control" value="${message.q_writer} }" />
	          </div>
	         </div>
	        <div class="row">
	         <div class="form-group">
	              <label>제목</label>
	           <input type="text" name="q_title" id="q_title" class="form-control" value="${message.q_title}" />
	         </div>
	        </div>
	   		<div class="row">
	          <div class="form-group">
	           <label>내용</label>
	           <textarea name="q_content" id="q_content" class="form-control" rows="15" value="${message.q_content}"></textarea>
	          </div>
	  		 </div>
	  	 	
	  	 <div class="row">
	    	<div class="pull-right">
	        <button type="submit" class="btn btn-default" id="boardInsertButton" onclick="formSubmit();">수정</button>
	    	</div>
	   	</div>
	    </form>
	 </div>



 


   

</body>

</html>