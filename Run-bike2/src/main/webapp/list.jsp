<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        div#boardlist {
            overflow: hidden;
            width : 130%;
        }
        
    
		 div.card {
            /* float: left;
         	 width: 40%;
            height: 20%; */
            border: 1px solid #ddd;
            display: flex;
            justify-content: space-between;
        }
        
        div#listheader{
        	width:500px;
        	height:500px;
        	/* border: 2px solid #000; */
        	/* position:absolute; */
        	
        	margin:auto;   
        }
        
        div#detailFrame,#editFrame{
        	width:500px;
			margin:auto;
        }
        
  		.p{
  			word-spacing:2em;
  		}
        
        #listshowbtn,#editpresetbtn,#delboardbtn,#replywritebtn{
        	width: 100px;
        	height: 30px;
        }


        
        
   /*      div#detailFrame{
        	width:500px;
        	height:500px;
        } */



    </style>
</head>
<body>



<!-- 해더 시작 -->
<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<!-- 해더 끝 -->
			
	<div id="listheader">
			<h1>문의글 리스트</h1>

				<div style="text-align: right;"><a href="writeboard.jsp">글쓰기</a></div>
			
			    
    <!-- <table class="board_list"> -->
    <table class="table">
<%--         <colgroup> --%>
<%--             <col width="10%"/> --%>
<%--             <col width="20%"/> --%>
<%--             <col width="15%"/> --%>
<%--             <col width="15%"/> --%>
<%--             <col width="20%"/> --%>
<%--         </colgroup> --%>
        <thead>
            <tr>
                <th scope="col">글번호</th>
                <th scope="col">제목</th>
                <th scope="col">idx</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
            </tr>
        </thead>
       	

       	
    </table>
    <br/>
			<div id="boardlist"></div>

	</div>		
	
	


	
	
	
	

				<c:if test="${viewData.totalCount>0}">
	<div id="pagingBox">
		<c:forEach begin="1" end="${viewData.pageTotalCount}" var="num">
			<%-- <div><a href="memberList?p=${num}">${num}</a> </div> --%>
			<div><a href="list?p=${num}&stype=${param.stype}&keyword=${param.keyword}">${num}</a> </div> 
		</c:forEach>
		
	</div>
	</c:if>
    		

			
			
<div id="editFrame" style="display: none" >
      <div class="page-header">
     <h3>문의글 수정</h3>
    </div>
         <hr>
         <div style="padding : 30px;">
         
         <form id="editForm" method="post" onsubmit="return false;">
         <div class="row">
          <div class="form-group">
            <input type="hidden" name="u_idx" id="u_idx" value="1">
            <input type="hidden" name="q_num" id="q_num" value="32">

             <label>글번호</label>
            <input type="text" name="q_num" id="eq_num" class="form-control" readonly />
             <label>작성자</label>
            <input type="text" name="q_writer" id="eq_writer" class="form-control" readonly />
           </div>
          </div>
             <div class="row">
          <div class="form-group">
               <label>제목</label>
            <input type="text" name="q_title" id="eq_title" class="form-control" required/>
          </div>
         </div>
          <div class="row">
           <div class="form-group">
            <label>내용</label>
            <textarea name="q_content" id="eq_content" class="form-control" rows="15" required ></textarea>
           </div>
      </div>
      <input type="submit" value="수정" onclick="editSubmit();">

       

         </form>
      </div>
      </div>




	
	 <div id="detailFrame" style="display: none">
		    <div class="page-header">
		    <hr>
			  <h3>문의글 상세보기</h3>
			 </div>
        	<hr> 
        	<div style="padding : 30px;">
        	
        	<form id="detailForm" onsubmit="return false;">
        	<div class="row">
	         <div class="form-group">
            <input type="hidden" name="u_idx" id="u_idx" value="${param.u_idx}">
            <!-- <input type="hidden" name="q_num" id="dq_num"> -->
             <label>글번호</label>
            <input type="text" name="q_num" id="dq_num" class="form-control" readonly />
             <label>작성자</label>
	           <input type="text" name="q_writer" id="dq_writer" class="form-control" readonly />
	          </div>
	         </div>
             <div class="row">
	         <div class="form-group">
	              <label>제목</label>
	           <input type="text" name="q_title" id="dq_title" class="form-control" readonly/>
	         </div>
	        </div>
          <div class="row">
	          <div class="form-group">
	           <label>내용</label>
	           <textarea name="q_content" id="dq_content" class="form-control" rows="15" readonly ></textarea>
	          </div>
	  		 </div>
	  		 <!-- <a href="boardreply.jsp?q_num="+q_num>답글달기</a> -->
        

        	</form>
   			</div>
   			</div>







			<!-- 답글달기 --> 
			 <div id="replyFrame" style="display: none">
		    <div class="page-header">
			  <h3>RE: 게시글 답글달기</h3>
			 </div>
        	<hr>
        	
        	
        	<div style="padding : 30px;">
        	
        	<form id="replyForm" method="post" onsubmit="return false;">
        	<div class="row">
	         <div class="form-group">
	         <%-- <input type="hidden" name="q_num" id="rpq_num" value="${param.q_num}"> --%>
	          <input type="hidden" name="u_idx" id="u_idx" value="1">
	          <input type="hidden" name="q_num" id="rpq_num">
           
             <label>작성자</label>
	           <input type="text" name="q_writer" id="rpq_writer" class="form-control" placeholder="작성자를 입력하세요" required />
	          </div>
	         </div>
             <div class="row">
	         <div class="form-group">
	              <label>제목</label>
	           <input type="text" name="q_title" id="rpq_title" class="form-control" value="RE:" required/>
	         </div>
	        </div>
          <div class="row">
	          <div class="form-group">
	           <label>내용</label>
	           <textarea name="q_content" id="rpq_content" class="form-control" rows="15" placeholder="내용을 입력하세요" required ></textarea>
	          </div>
	  		 </div>
	  	
	  		 <%--   <button type="submit" id="replybtn" onclick="formSubmit('${param.q_num}')">등록</button> --%>
					<button type="submit" id="replybtn" onclick="replyformSubmit(q_num);">등록</button>
        	</form>
   			</div>
   			</div>
			



<button id="button">토글버튼</button>
 <div id="divToggle" style="display: none;">다시버튼 누르면 안보임</div>



				














<%-- <!-- 푸터 시작 -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
<!-- 푸터 끝 -->
 --%>








<script>
	
	
	$(document).ready(function(){
				
				list();		

				$("#button").click(function (){ 
					$("#divToggle").toggle();
				});

				
		
				
			});
		    
		    
	
	//수정하기 - 원래 데이터 불러오기
    function editPreSet(q_num){
        
		
    	
		
        disNone();
        
        $('#editFrame').css('display', 'block');
        
           $.ajax({
                url : 'http://localhost:8080/runbike/rest/board/'+q_num,
                type : 'GET',
                success : function(data){
                  	$('#u_idx').val(u_idx);
                    $('#eq_num').val(q_num);
                    $('#eq_writer').val(data.q_writer);
                    $('#eq_title').val(data.q_title);
                    $('#eq_content').val(data.q_content);
                }
            });

    }

  
  //수정하기(글번호를 찾아서 수정)
	  function editSubmit(){
	        

	 
	  		var q_num =$('#eq_num').val();       
	  		var q_writer = $('#eq_writer').val();
	  		var q_title = $('#eq_title').val();
	  		var q_content = $('#eq_content').val();
	  		var u_idx = ($('#u_idx').val());
        
         $.ajax({
             url : 'http://localhost:8080/runbike/rest/board/'+q_num,
             type : 'POST',
             data : {q_num:q_num, q_writer:q_writer, q_title:q_title, q_content:q_content},   
             success : function(data){
             	
                 alert(data);
                 
                 if(data == 'success') {
                     alert('수정되었습니다.');
                     $('#editFrame').css('display', 'none');
                     list();
                 }
             },
             error : function(error){
                 alert(error);
             }
         });
         
         
         return false;
     
     
 		}
	
	

	
	
	
	
	
	
	


			
			
			//게시물 리스트
		    function list(){
		        
		    	
				
		    	$.ajax({
					url : 'http://localhost:8080/runbike/rest/board',
					type : 'GET',
					success : function(data){

		                
		                var html = '';
		                
		                for(var i=0; i<data.length;i++){
//		                	html += '<div class="card">\n';
		                
		                  	 html += '<p class="p">';
		                    html += data[i].q_num+'\n';
		                    html += '<a onclick="detaildata('+data[i].q_num+')" style="font-weight:bold;text-decoration:underline;font-size:18px;" ><tr><td> ' +data[i].q_title+'</a></td></tr>\n';
		                    html += '<tr><td>' + data[i].u_idx +'</td></tr>\n';		                   
		               		html += '<tr><td> ' + data[i].q_writer +' </td></tr>\n';
		                    html += '<tr><td>' + data[i].message_regdate +' </td></tr><br>';

// 							html += data[i].u_idx+'\n';
// 							html += data[i].q_writer+'\n';
// 							html += data[i].message_regdate +'\n';
		                    html += '</p>';
		                    
		                    
		                    html += '<button id="editpresetbtn" onclick="editPreSet('+ data[i].q_num +')">수정하기</button>';
		                    html += '<button id="delboardbtn" onclick="del('+ data[i].q_num +')">삭제하기</button>';
		                    html += '<button id="listshowbtn" onclick="getreplylist('+data[i].q_num+');">답변리스트</button>';
//		                    html += '<button id="listhidebtn">리스트접기</button>';
							html += '<button id="replywritebtn" onclick="writeCmt('+data[i].q_num+')">답변작성</button><br>\n';

//							html += '<button onclick="replyform('+data[i].q_num+')">답변작성</button><br>\n';
		                    html += '<div id="getreplylist'+data[i].q_num+'">';
		                    html += '</div>'
		                   	html += '<div id="writeForm'+data[i].q_num+'" class="writeForm col-6 mt-3" >';
	                        html += '</div>';
// 		                    html += '<div id="replywriteform'+data[i].q_num+'">';
// 		                    html += '</div>'
		                                               
		                    /* html += '<button onclick="boardreplywrite('+data[i].q_num+')">답변</button><br>\n'; */
		                    
//		                      html += '<div class="card">\n'; 
		                      }
		                
		                $('#boardlist').html(html);
					}
				
		            });
		         }
			
			
		
			
			

			

			
			
			
			
			
			//답글 작성폼
 		    function writeCmt(q_num){
 		    	
 		    	//var u_idx = "10";
 		    	
	        	var html = '';
		        html += '<div id="writeBox'+q_num+'" class="row" style="display:block; border:1px solid #bbb">';
		        html += '<strong><h3>답글쓰기</h3></strong>';
 		        html += '<form id="writeCmt'+q_num+'" onsubmit="return false" method="post">';
 		       /*  html += '<input type="hidden" value="'+u_idx+'" id="u_idx" name="u_idx">'; */
 		        html += '<input type="hidden" value="10" id="u_idx" name="u_idx">';         //관리자만 작성가능
 		        html += '<input type="hidden" id="q_num" name="q_num" value="'+q_num+'">';
 		        html += '<div class="form-group col-lg-3"><label for="rp_writer">작성자</label><textarea class="form-control"  placeholder="관리자" id="rp_writer" name="rp_writer" col="100" readonly></textarea></div>';
 		        html += '<div class="form-group col-lg-11"><label for="rp_title">제목</label><textarea class="form-control"  placeholder="제목을 입력하세요." required id="rp_title" name="rp_title" col="100"></textarea></div>';
 		        html += '<div class="form-group col-lg-11"><label for="rp_text">내용</label><textarea class="form-control"  placeholder="내용을 입력하세요." required id="rp_text" name="rp_text" col="100"></textarea></div>';
		        html += '<div class="form-group center"><input type="submit" class="btn btn-lg btn-primary" value="작성완료" onclick="submitForm('+q_num+')"></div>';
 		        html += '</form>';
 		        html += '</div>';

 		        $('#getreplylist'+q_num).html(html);
 		    } 
			
	
 		    //답글 작성
			 function submitForm(q_num){
				 
			        console.log("submitForm : "+q_num);
			        
			        var formData = new FormData();
			        
			        console.log("submitForm idx: "+$('#u_idx').val());
			        
			      	formData.append("u_idx",$('#u_idx').val());
			        formData.append("rp_writer",$('#rp_writer').val());
			        formData.append("rp_title",$('#rp_title').val());
			        formData.append("rp_text",$('#rp_text').val());
			       	formData.append("q_num", $('#q_num').val());
			       
			        
			    
			        $.ajax({
			            type : 'POST',
			            url : 'http://localhost:8080/runbike/rest/reply',
			            enctype: 'multipart/form-data',
			            contentType : false,
			            processData : false,
			            data : formData,
			            success : function(data){
			            	
			                alert("폼작성성공!");
			                $('#writeBox'+q_num).css('display','none');
			                getreplylist(q_num);
			            },
			            error : function(){
			                console.log("오류");
			            }
			        });
			        
    }
			 
		/* 	 
			  function submitForm(q_num){
			        

					 
			  		var q_num =$('#rpq_num').val();       
			  		var q_writer = $('#rpq_writer').val();
			  		var q_title = $('#rpq_title').val();
			  		var q_content = $('#rpq_content').val();
			  		var u_idx = ($('#eu_idx').val());
		         
		         $.ajax({
		             url : 'http://localhost:8080/runbike/rest/board/'+q_num,
		             type : 'POST',
		             data : {q_num:q_num, q_writer:q_writer, q_title:q_title, q_content:q_content},   
		             success : function(data){
		             	
		                 alert(data);
		                 
		                 if(data == 'success') {
		                     alert('수정되었습니다.');
		                     $('#editFrame').css('display', 'none');
		                     list();
		                 }
		             },
		             error : function(error){
		                 alert(error);
		             }
		         });
		         
		         
		         return false;
		     
		     
		 		}
			 
			  */
			 
			 
			 
			 
			 
			 
			 
// 			 function submitForm(q_num){
				 
// 			        console.log("submitForm : "+q_num);
			        
// // 			        var formData = new FormData();
			        
// // 			      	formData.append("u_idx",$('#u_idx').val());
// // 			        formData.append("rp_writer",$('#rp_writer').val());
// // 			        formData.append("rp_title",$('#rp_title').val());
// // 			        formData.append("rp_text",$('#rp_text').val());
// // 			        formData.append("q_num", $('#q_num').val());
			       
// 			       var rp_writer = $('#rpq_writer').val();
// 			       var rp_title = $('#rpq_title').val();
// 			       var rp_text = $('#rpq_text').val();
			    
// 			        $.ajax({
// 			            type : 'POST',
// 			            url : 'http://localhost:8080/runbike/rest/reply',
// 			            data : {rp_writer:rp_writer, rp_title:rp_title, rp_text:rp_text},
// 			            success : function(data){
			            	
// 			                alert("폼작성성공!");
// 			                $('#writeBox'+q_num).css('display','none');
// 			                getreplylist(q_num);
// 			            },
// 			            error : function(){
// 			                console.log("오류");
// 			            }
// 			        });
			        
// }
			
			
			
			
			

			
			
			
			
			
			
			
			
			
			//답글 작성 폼으로 이동 
			function replyform(u_idx){
				
				alert(u_idx);
				disNone();
		    $('#replyFrame').css('display', 'block');			
		    
		    
			}
			
			
			//답글리스트
			function getreplylist(q_num){
			        
			    	alert('글번호 :'+q_num);
			    	
			    	$.ajax({
						url : 'http://localhost:8080/runbike/rest/reply/reply/'+q_num,
						type : 'GET',
						success : function(data){
							if(data.length>0){
			  
			                var html = '';
							
			                for(var i=0; i<data.length;i++){
			                	//html += '<div id="divToggle">'
			                	html += '<div class="card">\n';
			                	 html += '<div id = "replylist_Box_Div'+data[i].q_num+'">';//이거추가함(버튼클릭시 show 또는 hide)
			                	 html += '<div id="writeBox'+q_num+'" class="row" style="display:block; border:1px solid #bbb">';  //이거추가함
			                	 html += '<hr>'
			                	 html += '<tr><td>원글번호 : ' + data[i].q_num +'</td></tr><br>\n';	
			                	 html += '<tr><td>답변글번호:' + data[i].rp_num +'</td></tr><br>\n';		
			                	 html += '<tr><td>답변글 제목:' + data[i].rp_title +'</td></tr><br>\n';		
			                	 html += '<tr><td>답변글 내용:' + data[i].rp_text +'</td></tr><br>\n';		
			                	 html += '<tr><td>답변글 작성자:' + data[i].rp_writer +'</td></tr><br>\n';		
			                	 html += '<tr><td>작성날짜:' + data[i].rp_regdate +'</td></tr><br>\n';
			                	 html += '<button onclick="delreply('+ data[i].rp_num +')">삭제하기</button>';
			                	 html += '</div>';
			                	 html += '</div>';
			                	html += '</div>';
			                	
			                }
			     
							
			                $('#getreplylist'+q_num).html(html);
			                
							  }else{
							        alert("답글이 없습니다.");
							       }
							  }
			    		
				});
			}

			
			
			
			
// 			function displayReplylistBox(q_num){


// 				if ($("#replylist_Box_Div"+q_num+":hidden")){

// 				        $("#replylist_Box_Div"+q_num).show();
// 				        $('#listbtn').text('접기'); 
				       

// 				}
// 				else if($("#replylist_Box_Div"+q_num+":visible")){

// 				        $("#replylist_Box_Div"+q_num).hide(); 
// 				        $('#listbtn').text('답글보기'); 
// 				}
// 				}
			
			

			
			
			//답글 작성
			function replyformSubmit(q_num) {
				
	        		
	            var formData = new FormData();
	           
	            formData.append('q_num', $('#q_num').val());
	            formData.append('rp_num', $('#rp_num').val());
	            formData.append('rp_title', $('#q_writer').val());
	            formData.append('rp_text', $('#q_title').val());
	            formData.append('rp_writer', $('#q_content').val());
	          
	                     
	            alert($('#replyForm').serialize());

	            
	            $.ajax({
	                url: 'http://localhost:8080/runbike/rest/reply',
	                type: 'POST',
	                processData: false,  
	                contentType: false,  
	                data: formData,
	                success : function(data){

	                        alert("글 등록이 완료되었습니다");
	                    	location.href="list.jsp";
	                }
	            });
	        }
	        
			
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			//답변하기 창으로 이동
		    //function boardreplywrite(q_num){
			//	location.href = "boardreply.jsp?q_num="+q_num;
			//}
			
			
			
			//게시글 상세보기(내용까지 보이도록)
			function detaildata(q_num){
				
				disNone();
				
				$('#detailFrame').css('display','block');
					
					$.ajax({
						url : 'http://localhost:8080/runbike/rest/board/detail/'+q_num,
						type : 'GET',
						 success : function(data){
			                    $('#dq_num').val(data.q_num);
			                    $('#dq_writer').val(data.q_writer);
			                    $('#dq_title').val(data.q_title);
			                    $('#dq_content').val(data.q_content);
			                }
					
					
					});
					
					
			}
			
			

		   
		  
		  function disNone() {
		    	
		    	 $('#editFrame').css('display', 'none');
		    	 $('#detailFrame').css('display', 'none');
		    	 $('#replyFrame').css('display', 'none');
		    }	
			
		
			
		    
		  //문의글삭제(원글 글 번호로)
		    function del(q_num){
		        
		        if(confirm('정말 삭제하시겠습니까?')){
		           $.ajax({
		                url : 'http://localhost:8080/runbike/rest/board/del/'+q_num,
		                type : 'DELETE',
		                success : function(data){
		                        if(data=='SUCCESS'){
		                        alert('삭제가 완료되었습니다');
		                        list();
		                    }		                    
		                },
		                error : function(error){
		                	alert('답글이 존재합니다.\n삭제할 수 없습니다.');
		                }
		            });
		           }
		    }
    
               
		//답글삭제(답글 글 번호로)
		function delreply(rp_num){
			
			if(confirm('정말 삭제하시겠습니까?')){
		           $.ajax({
		                url : 'http://localhost:8080/runbike/rest/reply/del/'+rp_num,
		                type : 'DELETE',
		                success : function(data){
		             
		                    if(data=='SUCCESS'){
		                        alert('답글삭제가 완료되었습니다');
		                        list();
		                    }          
		                }
		            });
		           
		           
		           }
		    }
			
		
    
			
		  
	
		  
    
</script>







</body>
</html>