<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
     <script src="<c:url value='/assets/js/jquery.min.js'/>"></script>
 <script src="<c:url value='/assets/js/layout.js'/>"></script>
   <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/assets/css/layout.css'/>">
<style>
	h1{
		text-align:center;
	}

	table {
		border-collapse: collapse;
		border: 0;	
		margin: auto;
	}
	td {
		padding : 3px 10px;		
        height:50px;
   		border: 1px solid #999;

	}
	
	div#pagingBox {	
		overflow: hidden;
		/* margin-top:15px; */
		/* margin : 15px 1000px; */
	}
	div#pagingBox>div {
		float: left;
		width: 30px;
	
	}
	
	div.searchBox {
		margin : 15px 243px;
		width : 500px;
		padding : 15px;
	}
	


	
</style>
</head>
<body>

<!-- 해더 시작 -->
<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<!-- 해더 끝 -->



<!-- 컨텐츠 시작 -->
<div id="contents">
	<h1>게시물 리스트</h1>
	<div style="text-align: center;"><a href="board/writeform">글쓰기</a></div>	 
	<hr>
	<table>
		<tr bgcolor="#81BEF7">
			<td>no</td>
			<td>글번호</td>
			<td>글제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>작성자 회원번호</td>
			<td>작성일자</td>
			<td>답글리스트</td>		
		</tr>
		<c:forEach items="${testData.testList}" var="boardInfo" varStatus="stat" >
		<tr>
			<td>${testData.no-stat.index}</td>
			<td>${boardInfo.q_num}</td>
			<td><a href="../testdetail/${boardInfo.q_num}">${boardInfo.q_title}</a></td>   <!-- 상세보기 페이지로 이동 -->
			<td>${boardInfo.q_content}</td>
			<td>${boardInfo.q_writer}</td>
			<td>${boardInfo.u_idx}</td>
			<td>${boardInfo.regdate}</td>
			<td><a href="#" onclick="getreplylist('+${boardInfo.q_num}+')">답글리스트</a></td>			
		</tr>
		<tr>
					
		
		</tr>
		</c:forEach>
		
	</table>
	
	
		<div class="searchBox">
		<form>
			<select name="stype">
				<option value="q_title">글제목</option>
				<option value="q_writer">글 작성자</option>
			</select>
			<input type="text" name="keyword"><input type="submit" value="검색">
		</form>
		</div>
	

	


	
			  
		      <c:if test="${testData.pageTotalCount>0}">
			      	 
			    <ul class="pagination justify-content-center">
			      <li>
			        <a class="page-link" href="testlist?p=1&stype=${param.stype}&keyword=${param.keyword}">
			          <span>처음</span>
			        </a>
			      </li>	    
			            <div id="pagingBox">
							<c:forEach begin="1" end="${testData.pageTotalCount}" var="num">
								<div><a class="page-link" href="testlist?p=${num}&stype=${param.stype}&keyword=${param.keyword}">${num}</a></div>
							</c:forEach>
						</div>
			      <li>
			        <a class="page-link" href="testlist?p=${testData.pageTotalCount}&stype=${param.stype}&keyword=${param.keyword}">
			          <span>마지막</span>
			        </a>
			      </li>
			    </ul>
		 	</c:if>
		 	
		 	
		<div style="text-align:center"><a href="../test/testlist">처음목록으로 돌아가기</a></div>	 	
		 	
	
</div>



<!-- 푸터 시작 -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
<!-- 푸터 끝 -->






<script>


//답글리스트
function getreplylist(q_num){
        
    	//alert('글번호 :'+q_num);
    	
    	$.ajax({
			//url : 'http://localhost:8080/runbike/rest/reply/reply/'+q_num,
			url : './rest/reply/reply/'+q_num,
			type : 'GET',
			success : function(data){
				if(data.length>0){
  
                var html = '';
				
                for(var i=0; i<data.length;i++){
                	//html += '<div class="card">\n';
                	 html += '<div id="writeBox'+q_num+'" class="row" style="display:block;">';
					html +='<table width="800" border="3" align="center">';

                	 html += '<tr>';
                	 html += '<td id="title" style="font-weight:bold">작성자</td>';
                	 html += '<td>'+data[i].rp_writer+'</td>';
                	 html += '<td id="title" style="font-weight:bold">작성일자</td>';
                	 html += '<td colspan=3>'+data[i].rp_regdate+'</td>';
                	 html += '</tr>';
                	 html += '<tr>';
                	 html += '<td id="title" style="font-weight:bold">제목</td>';
                	 html += '<td colspan=5>'+ data[i].rp_title +'</td>';
                	 html += '</tr>';
                	 html += '<tr>';
                	 html += '<td id="text" style="font-weight:bold">내용</td>';     
                	 html += '<td colspan=5>' + data[i].rp_text +'</td>';		
                	 html += '</tr>';
                	 
                	 html += '<tr>';
                	 html += '<td id="title" style="font-weight:bold">원글번호</td>';
                	 html += '<td>' + data[i].q_num +'</td>';	
                	 html += '<td id="title" style="font-weight:bold">답글번호</td>';
                	 html += '<td>' + data[i].rp_num +'</td>';	

                	 html += '<td><button onclick="delreply('+ data[i].rp_num +')">삭제하기</button></td>';
                	 html += '<td><button onclick="hidebox('+data[i].q_num+')">리스트 접기</button></td>';
                	 html +='</tr>';
                	 html += '</div>';
                	 html += '<br>';
                	
                	// html += '</div>';
                	
                }
     
                $('#getreplylist'+q_num).html(html);
                
				  }else{
				        alert("답글이 없습니다.");
				       }
				  }		    		
		});
	}














</script>














</body>
</html>