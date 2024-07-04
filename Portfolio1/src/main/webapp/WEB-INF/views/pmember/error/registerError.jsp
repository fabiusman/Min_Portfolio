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
<!--회원 아이디가 중복된 경우-->
<div class="loginError">
    <p>중복된 아이디로 가입하셨습니다.</p>
    <p>
        <button id="back" type="button">회원가입</button>
        
        <script>
	    	$("#back").on("click", function(){
	    		self.location="/";
	    	})
    	</script>
    </p>
</div>
</body>
</html>