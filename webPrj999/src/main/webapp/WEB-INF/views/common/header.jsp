<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
    * {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    #wrap {
        width: 100vw;
        background-color: wheat;
    }

    header{
        width: 1280px;
        height: 86px;
        margin: auto;
        display: grid;
        grid-template-rows: 22px 64px;
    }

    header .top-list {
        display: flex;
        justify-content: end;
        padding-top: 8px;
        padding-left: 40px;
        padding-right: 40px;
    }

    header .top-list ul {
        display: flex;
        align-items: center;
        padding: 0;   
        text-decoration: none;
    }

    header .top-list ul li {
        align-items: center;
        margin-left: 8px;
        font-size: 12px;
        font-family: 'Pretendard';
    }
    
    .top-list ul li a {
    	text-decoration: none;
    	color: rgba(34, 34, 34, 0.8);;
    }
	
	header .main-list {
		display: flex;
		justify-content: space-between;
		align-items: center;
		padding-top: 20px;
		padding-left: 40px;
		padding-right: 40px;
		padding-bottom: 20px;
	}
	
	.main-list .logo-area {
		display: flex;
		justify-content: center;
		align-items: center;
		width: 130px;
		height: 24px;
	}
	
	.main-list .logo-area a{
		display: flex;
		justify-content: center;
		align-items: center;
		width: 130px;
		height: 24px;
	}
	.main-list .head-list {
	}
	
	.main-list .head-list ul {
		display: flex;
		align-items: center;
	}
	
	header .main-list li {
		width: 90px;
		font-size: 18px;
		font-family: 'Pretendard Light';
	}
	
	.main-list li a {
		text-decoration: none;
		color: #222;
	}
	
	.main-list #search-btn{
		width: 70px;
		height: 24px;
		border: 1px solid black;
		border-radius: 12px;
		color: white;
		background-color: #222;
		font-size: 15px;
		font-family: 'Pretendard Light';
		cursor: pointer;
	}

</style>

<header>
<div class="header-inner">
    <div class="top-list">
        <ul>
            <li><a href="">고객센터</a></li>
            <li><a href="">마이페이지</a></li>
            <li><a href="">관심</a></li>
            <li><a>알림</a></li>
            <li><a href="">로그인</a></li>
        </ul>
    </div>
    <div class="main-list">
        <div class="logo-area">
            <a href="">
            <img src="">
            </a>
        </div>
        <div class="head-list">
        	<ul>
        		<li><a href="">HOME</a></li>
        		<li><a href="">SHOP</a></li>
	        	<button id="search-btn" type="button" onclick="">Search</button>
    		</ul>
        </div>
    </div>
</div>
</header>

<script>
	const searchBtn = document.querySelector("#search-btn");
</script>