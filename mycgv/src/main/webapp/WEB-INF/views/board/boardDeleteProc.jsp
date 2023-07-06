<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mycgv_jsp.dao.BoardDao" %>
<%@ page import="com.mycgv_jsp.vo.BoardVo" %>

<jsp:useBean id="boardVo" class="com.mycgv_jsp.vo.BoardVo" />
<jsp:setProperty property="*" name="boardVo"/>

<%
	String bid = request.getParameter("bid");

	BoardDao boardDao = new BoardDao();
	int result = boardDao.delete(bid);
	
	if(result == 1) {
		out.write("<script>");
		out.write("alert('게시글 삭제가 완료되었습니다');");
		out.write("location.href='http://localhost:9000/board/board_list.jsp';");
		out.write("</script>");
		//response.sendRedirect("http://localhost:9000/board/board_list.jsp");
	}
%>
