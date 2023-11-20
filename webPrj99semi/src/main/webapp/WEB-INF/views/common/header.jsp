<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <style>
    
    #wrap{
        width: 800px;
        border: 5px solid black;
        margin: auto;
    }

    header {
        width: 100%;
        height: 200px;
        display: grid;
        grid-template-rows: 3fr 1fr;
        grid-template-columns: 2fr 4fr 2fr;
    }

    header > div:nth-child(4){
        grid-column: span 3;
    }

    header > div:nth-child(2){
        display: flex;
        justify-content: center;
        align-items: center;
    }

    header > div:nth-child(3) > form {
        width: 100%;
        height: 100%;
    }

    .login-area{
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-rows: 1fr 1fr 1fr;
        grid-template-columns: 1fr 1fr;
    }

    input[name=memberId], input[name=memberPwd] {
        grid-column: span 2;
    }

    nav{
        width: 100%;
        height: 100%;
        background-color: black;
        display: flex;
        justify-content: space-evenly;
        align-items: center;
    }
    
    nav a {
        font-size: 24px;
        color: white;
        text-decoration: none;

    }


    /* 메인 */
    main {
        border: 1px solid black;
        width: 100%;
    }
    
    </style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<header>
	     <div></div>
	     <div><img width="300px" height="120px" src="/app99/resources/img/logo.png" alt="로고이미지"></div>
	     <div>
	         <form action="/app99/member/login" method="post">
	             <div class="login-area">
	                 <input type="text" name="memberId" placeholder="아이디">
	                 <input type="password" name="memberPwd" placeholder="패스워드">
	                 <button type="button" onclick="location.href='/app99/member/join';">회원가입</button>
	                 <input type="submit" value="로그인">
	             </div>
	         </form>
	     </div>
	     <div>
	         <nav>
	             <a href="/app99/board/list">게시판</a>
	             <a href="/app99/notice/list">공지사항</a>
	             <a href="/app99/gallery/list">갤러리</a>
	             <a href="/app99/member/edit">마이페이지</a>
	         </nav>
	     </div>
    </header>
	
</body>
</html>