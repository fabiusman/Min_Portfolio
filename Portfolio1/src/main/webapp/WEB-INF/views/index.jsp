<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
</head>
<body>
<h1>포트폴리오1 게시판</h1>
<br/>
<div class="loginBox">
	<c:if test="${login==null }">
	<form id="memberForm" action="/pmember/login.do" method="post">
        <p>
            <label for="name">아이디 : </label>
            <input type="text" id="name" name="name">
        </p>
        <p>        
            <label for="password">비밀번호 : </label>
            <input type="password" id="password" name="password">
        </p>
        <p>
            <button type="submit">로그인</button>
        </p>
    </form>
	</c:if>
	<c:if test="${login!=null }">
		<p>
			환영합니다 ${login.name }님!
		</p>
	</c:if>
	
    <br/>
    
    <p>
	    <c:if test="${login==null }">
	    	<button id="register" type="button">회원가입</button>
	    </c:if>
	    <c:if test="${login!=null }">
	    	<button id="update" type="button">회원정보 수정</button>
	        <button id="delete" type="button">회원 탈퇴</button>
	    </c:if>
    </p>
    
    <script>
    	$("#register").on("click", function(){
    		self.location="/pmember/register";
    	})
    	
    	$("#update").on("click", function(){
    		self.location="/pmember/update";
    	})
    	
    	$("#delete").on("click", function(){
    		self.location="/pmember/delete";
    	})
    </script>
    
    <p>
        <button id="post" type="button">게시판</button>
        <c:if test="${login!=null }">
        	<button id="logout" type="button">로그아웃</button>
        </c:if>
    </p>
    
     <script>
    	$("#post").on("click", function(){
    		self.location="/ppost/list.do";
    	})
    	
    	$("#logout").on("click", function(){
    		self.location="/pmember/logout.do";
    	})
    </script>
</div>

</body>
</html>