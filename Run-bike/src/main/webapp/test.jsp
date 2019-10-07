<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


 <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">문의글 리스트
    </h1>
    

    
<div id="map" style="width:100%;height:350px;"></div>
    <div class="row">
     
      
    </div>
    
    <!-- Pagination -->
    <ul class="pagination justify-content-center">
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
          <span class="sr-only">Previous</span>
        </a>
      </li>
      <li class="page-item">
        <a class="page-link" href="#" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
          <span class="sr-only">Next</span>
        </a>
      </li>
    </ul>
  </div>
  <!-- /.container -->


<script>

$(document).ready(function(){

  listAll();
 
});






function listAll(pgNum){
    console.log($('#stype').val());
    console.log($('#keyword').val());
    $.ajax({
    	url : 'http://localhost:8080/runbike/rest/board/list',
        contentType : 'application/json; charset=utf-8',
        data : {page : pgNum, stype : $('#stype').val(), keyword : $('#keyword').val()},
        dataType : 'json',
        type : 'GET',
        success : function(data){
            var $row = $('.row')[0];
            var list = data.boardList;
            var html = '';
            if(list.length>0){

                    html += '<div class="col-lg-12 col-sm-12 portfolio-item">';
                    html += '<div class="card h-100">';
                    html += '<div class="card-body">';

                    console.log(list[i].q_num);
                    html += '<p class="card-text">'+list[i].q_title+'<br>'+list[i].q_num+'<br>';

					html += '<a onclick="detaildata('+q_num+')" style="font-weight:bold;text-decoration:underline;font-size:18px;">'+q_title+'</a>';
					html += '회원번호:'+u_idx+'\n';
					html += '작성자'+q_writer+'\n';
					html += '작성일자'+regdate+'\n';

                    html += '</div>';
                    html += '</div>';
                    html += '</div>';
                }
            
            html += '<div class="col-lg-12 input-group">';
            html += '<form id="searchBox" class="input-group-prepend" onsubmit="return false" class="float-lg-right">';
            html += '<select id="stype" class="custom-select"><option value="q_title">제목</option><option value="q_writer">작성자</option></select>';
            html += '<input type="text" class="control" name="keyword" id="keyword">';
            html += '<input type="submit" class="btn btn-primary" value="검색" onclick="listAll('+pgNum+')">';
            html += '</form>';
            html += '</div>';
            var paging = '';
            for(var j=1;j<=data.pageTotalCount;j++){
                paging += '<li class="page-item"><a class="page-link" href="#" onclick="listAll('+j+')">'+j+'</a></li>';
            }
            $('.row').html(html);
            
            $('.pagination').html(paging);
        }
        
    });
}



//게시글 상세보기(내용까지 보이도록)
function detaildata(q_num){
	
	disNone();
	
	$('#detailFrame').css('display','block');
		
		$.ajax({
			//url : 'http://localhost:8080/runbike/rest/board/detail/'+q_num,
			url : './rest/board/detail/'+q_num,
			type : 'GET',
			 success : function(data){
                    $('#dq_num').val(data.q_num);
                    $('#dq_writer').val(data.q_writer);
                    $('#dq_title').val(data.q_title);
                    $('#dq_content').val(data.q_content);
                }
		
		
		});
		
		
}






</script>




</body>
</html>