<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String sid = (String)session.getAttribute("sid");
	if(sid != null) {
		session.invalidate();
	}
%>
	<script>
	alert('로그아웃 완료')
	location.href='http://localhost:9000/index.jsp';
	</script>