<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<section class="board">
			<h1 class="title">게시판</h1>
			<form name="deleteForm" action="/board_delete" method="post">
				<input type="hidden" name="bid" value="${bid}">
				<input type="hidden" name="page" value="${page}">
				<table>
					<tr>
						<td><img src="http://localhost:9000/images/trash.jpg"></td>
					</tr>
					<tr>					
						<td>정말로 삭제 하시겠습니까?</td>
					</tr>				
					<tr>
						<td colspan="2">
							<button type="submit" class="btn_style" id="btnBoardDelete">삭제완료</button>
							<a href="/board_content/${bid}/${page}">
								<button type="button" class="btn_style">이전페이지</button></a>
							<a href="/board_list/${page}">
								<button type="button" class="btn_style">리스트</button></a>
							<a href="http://localhost:9000/">
								<button type="button" class="btn_style">홈으로</button></a>
						</td>				
					</tr>
				</table>
			</form>
		</section>
	</div>
	
	<!-- footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>

















