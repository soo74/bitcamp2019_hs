<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <style>
        div#memberlist {
            overflow: hidden;
        }
        div.card {
            float: left;
            width: 33%;
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
			<h1>회원 리스트</h1>
			<div id="memberlistAdmin"></div>
			

		    




<script>
			$(document).ready(function(){
				list();		
		        
			});
		    
		    

			
			
			
			
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
    
			
			
			
			
			
			//회원리스트
		    function list(){
		        
		    	
		    	$.ajax({
					url : 'http://localhost:8080/runbike/rest/admin',
					type : 'GET',
					success : function(data){
		                
		                var html = '';
		                for(var i=0; i<data.length;i++){
		                    html += '<div class="card">\n';
		                    html += 'idx : ' + data[i].u_idx +' <br>\n';
		                    html += '아이디      : ' + data[i].u_id +' <br>\n';
		                    html += '이름(닉네임) : ' + data[i].u_name +' <br>\n';
		                    html += '사진 : ' + data[i].u_photo +' <br>\n';
		                    html += '이메일인증여부 : ' + data[i].u_verify + ' <br>\n';
		                    html += '가입일자 : ' + data[i].regDate + ' <br>\n';
		                    html += '회원 인증 코드 : ' + data[i].u_verify + ' <br>\n';
		                    html += 'sns 가입 여부 : ' + data[i].u_sns + ' <br>\n';
		                    html += '<button onclick="del('+ data[i].idx +')">삭제하기</button><br>\n';
		                    html += '</div>\n';
		                }
		                
		                $('#memberlistAdmin').html(html);
					}
				
		            });
		         }
               

    
			
			
    
</script>







</body>
</html>