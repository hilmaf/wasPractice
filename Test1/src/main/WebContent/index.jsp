<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원목록 조회(회원 번호 검색)</h1>
	<form action="/Test1/selectUser" method="get">
		<input type="text" name="userNo" placeholder="회원 번호 입력">
		<input type="submit" value="조회">
	</form>
</body>
</html>