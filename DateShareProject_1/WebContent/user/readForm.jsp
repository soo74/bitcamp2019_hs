<%@page import="dateShare.Model.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   session = request.getSession(false);
	LoginInfo user = (LoginInfo)session.getAttribute("userinfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>DATE SHARE</title>
</head>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<style></style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script>
   
</script>
</head>
<body>
<div id="wrap">
    <div id="main_wrap">
        <div id="header">
            <%@include file="../frame/header.jsp" %>
        </div>
        <div id="content">
      <div id="login_form_wrap">
               <h1>내정보보기</h1>
               <form action="insertMember.jsp" method="post">
                  <div>
                     ID<input class="input_t" type="text" name="u_id" value="<%= user.getU_id() %>">
                  </div>
                  <div>
                     PW<input class="input_t" type="password" name="u_pw" value="<%= user.getU_pw() %>">
                  </div>
                  <div>
                     이름<input class="input_t" type="text" name="u_name" value="<%= user.getU_name() %>">
                  </div>
                  <div>
                     <a href="../main.jsp" class="input_ba">이전으로</a>
                  </div>
                  <div>
                  	<a href="../updateForm"><input type="button" value="수정"></a> 
                  </div>
                  <div>
                  	<input type="button" value="탈퇴"> 
                  </div>
                  
               </form>
      </div>
</div>
        <div id="footer">
            <%@include file="../frame/footer.jsp" %>
        </div>
    </div>
    </div>
</body>
</html>
























<%-- 

<%@page import="dateShare.Model.DateUser"%>
<%@page import="dateShare.Dao.dateUserDao"%>
<%@page import="dateShare.service.user.ReadMemberService"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>






<html>
<head>
<meta charset="UTF-8">
    <title>DATE SHARE</title>
</head>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<style></style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
<div id="wrap">
    <div id="main_wrap">
        <div id="header">
        	<%@include file="../frame/my.jsp" %>
            <%@include file="../frame/header.jsp" %>
        </div>
        <div id="nav">
            <%@include file="../frame/nav.jsp" %>
        </div>
        <div id="content">
        
        
        try{
		<h1>MYPAGE</h1>
			<table border=1>
				<tr>
					<th>회원번호<%= %></th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>가입일자</th>
					<th>성별</th>
					<th>작성한 게시글 수<th>
				</tr>		
				<tr>
					<td></td>
					<td><%=service.getU_id("u_id")%></td>                           
					<td><%=rs.getString("u_pw")%></td>
					<td><%=rs.getString("u_name")%></td>
					<td><%=rs.getString("u_bday")%></td>
					<td><%=rs.getString("u_regdate") %></td>
					<td><%=rs.getString("u_gender")%></td>
					<td></td>
				</tr>
			</table>
			
			<%
        }catch(Exception e){
				System.out.println("Exception :"+e.getMessage());
				
			}
	
			%>
        
        
        
        
        
            
        </div>
        <div id="footer">
            <%@include file="../frame/footer.jsp" %>
        </div>
    </div>
    </div>
</body>
</html>
 --%>

















