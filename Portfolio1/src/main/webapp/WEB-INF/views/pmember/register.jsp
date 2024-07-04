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
<h2>회원가입</h2>
<form id="registerMember" action="/pmember/register.do" method="post">
    <p>
        <label for="name">아이디 : </label>
        <input type="text" id="name" name="name">
    </p>
    <p>        
        <label for="passowrd">비밀번호 : </label>
        <input type="password" id="password" name="password">
    </p>
    <p>        
        <label for="email">이메일 : </label>
        <input type="email" id="email" name="email">
    </p>
    <p>
        <button id="register" type="submit">회원가입</button>
        <button id="back" type="button">돌아가기</button>
    </p>
    
    <script>
    	$("#back").on("click", function(){
    		self.location="/";
    	})
    </script>
</form>
</body>
</html>