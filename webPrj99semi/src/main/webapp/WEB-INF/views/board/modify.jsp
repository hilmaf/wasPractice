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

<link rel="stylesheet" href="/app99/resources/css/write.css">

</head>
<div id="wrap">
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<form action="/app99/board/write" method="post">
		<main>
			<h1>게시글 수정</h1>		
			
			카테고리 
			<select name="category">
				<option value="1" <%if(vo.getCategoryNo().equals("1")){%> selected="selected"<%}%>>자유</option>
				<option value="2" <%if(vo.getCategoryNo().equals("2")){%> selected="selected"<%}%>>게임</option>
				<option value="3" <%if(vo.getCategoryNo().equals("3")){%> selected="selected"<%}%>>요리</option>
				<option value="4" <%if(vo.getCategoryNo().equals("4")){%> selected="selected"<%}%>>운동</option>
				<option value="5" <%if(vo.getCategoryNo().equals("5")){%> selected="selected"<%}%>>자바</option>
				<option value="6" <%if(vo.getCategoryNo().equals("6")){%> selected="selected"<%}%>>자스</option>
				<option value="7" <%if(vo.getCategoryNo().equals("7")){%> selected="selected"<%}%>>쿼리</option>
			</select>
			
			제목
			<input type="text" name="title" value = "<%= vo.getTitle() %>">
			
			내용
			<textarea name="content" rows="10"><%= vo.getContent() %></textarea>
		
			<input type="submit" value="작성하기">		
		</main>
	</form>
	</div>
</body>
</html>