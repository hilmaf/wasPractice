<%@page import="com.kh.app.board.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	BoardVo vo = (BoardVo) request.getAttribute("vo");
    
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/app99/resources/css/detail.css">
</head>
<body>
	<div id="wrap">
	<%@ include file = "/WEB-INF/views/common/header.jsp" %>
	<main>
		<h1>게시글 상세조회</h1>
		<table border="1">
			<tbody>
				<tr>
					<td><%= vo.getTitle() %></td>
					<td><%= vo.getWriterNick() %></td>
				</tr>
				<tr>
					<td><%= vo.getEnrollDate() %></td>
					<td><%= vo.getHit() %></td>
				</tr>
				<tr>
					<td colspan="2"><%= vo.getContent() %></td>
				</tr>
			</tbody>
		</table>
		

		<%if(loginMember!=null && vo.getWriterNo().equals(loginMember.getNo())){%>
			<div class="btn-area">
				<button onclick="location.href='/app99/board/edit?no=<%= vo.getNo() %>'">수정</button>
				<button onclick="location.href='/app99/board/delete?no=<%= vo.getNo() %>'">삭제</button>
			</div>
		<%}%>
		
	</div>
	</main>
</body>
</html>
