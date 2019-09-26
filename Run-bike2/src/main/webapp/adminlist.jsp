<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
        div.card {
            float: left;
            width: 20%;
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>


<!-- 해더 시작 -->
<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<!-- 해더 끝 -->

		<ul>
		<li><a href="<c:url value='stamp.jsp' />">스탬프관리</a></li>
		<li><a href="<c:url value='badge.jsp' />">뱃지관리</a></li>	
		</ul>


			<div id="memberalllist">
			<h1>회원 리스트</h1>
			<div id="memberlistAdmin"></div>
			</div>
			





<script>
			$(document).ready(function(){
				list();		
		        
			});
		    
			//회원리스트
		    function list(){
		        
		    	
		    	$.ajax({
					url : 'http://localhost:8080/runbike/rest/admin',
					type : 'GET',
					success : function(data){
		                
		                var html = '';
		                for(var i=0; i<data.length;i++){
		                    html += '<div class="card">\n';
		                    html += 'idx : ' + data[i].u_idx +'<br>\n';
		                    html += '아이디      : ' + data[i].u_id +'<br>\n';
		                    html += '이름(닉네임) : ' + data[i].u_name +'<br>\n';
		                    html += '사진 : ' + data[i].u_photo +' <br>\n';
		                    html += '가입일자 : ' + data[i].regDate + ' <br>\n';
		                    html += '이메일 인증 여부 T/F : ' + data[i].u_verify + ' <br>\n';
		                    html += 'sns 가입 여부 : ' + data[i].u_sns + ' <br>\n';
		                    html += '회원 인증 코드 : ' + data[i].u_code + ' <br>\n';
		                    html += '<button onclick="del('+ data[i].u_idx +')">삭제하기</button><br>\n';
		                    html += '</div>\n';
		                }
		                
		                $('#memberlistAdmin').html(html);
					}
				
		            });
		         }

					
			
			//삭제
		    function del(u_idx){
		        
		        if(confirm('정말 삭제하시겠습니까?')){
		           $.ajax({
		                url : 'http://localhost:8080/runbike/rest/admin/'+u_idx,
		                type : 'DELETE',
		                success : function(data){
		             
		                    if(data=='SUCCESS'){
		                        alert('삭제가 완료되었습니다');
		                        list();
		                    }          
		                }
		            });
		           
		           
		           }
				
				
				
		    }
    
			
			
			
			
			
			
               

    
			
			
    
</script>







</body>
</html>