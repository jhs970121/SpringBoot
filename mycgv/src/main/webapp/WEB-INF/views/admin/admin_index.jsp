<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%
	String sid = (String)session.getAttribute("sid");
	if(sid == null) {
		out.write("<script>");
		out.write("alert('접근 권한이 없습니다. 로그인을 진행해주세요.');");
		out.write("location.href='http://localhost:9000/login/login.jsp';");
		out.write("</script>");
	}else {
	
	if(!sid.equals("admin")) {
		out.write("<script>");
		out.write("alert('관리자 접근 권한이 필요합니다.');");
		out.write("location.href='http://localhost:9000/login/login.jsp';");
		out.write("</script>");
	}else {
			
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYCGV</title>
<link rel="stylesheet" href="http://localhost:9000/css/mycgv_jsp.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="../header.jsp"></jsp:include>
	
	<!-- content -->
	<div class="content">
		<section class="admin">
			<h1 class="title">관리자 메인</h1>
			<div>
				<article><a href="admin_notice_list.do">🛕 공지사항 관리</a></article>
				<article>🚗영화 관리</article>
				<article><a href="admin_member_list.do">👩회원 관리</a></article>
			</div>
		</section>
	</div>
	
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
<%-- <%
		} // admin id 체크
	} // sid != null 체크
%>
 --%>















