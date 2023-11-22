<%@page import="com.kh.app.board.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList");
    	
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
        <%@ include file = "/WEB-INF/views/common/header.jsp"%>

		<main>
			<h1>게시글 목록</h1>            
			<h3><%= boardVoList.get(0) %></h3>
			<h3><%= boardVoList.get(1) %></h3>
			<h3><%= boardVoList.get(2) %></h3>
			
		</main>
    </div>
</body>
</html>