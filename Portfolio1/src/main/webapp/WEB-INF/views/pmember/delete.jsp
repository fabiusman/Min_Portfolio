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
<div class="delete">
    <p>
        정말 탈퇴합니까?
    </p>
    <p>
        <button id="delete" type="submit">예</button>
        <button id="back" type="button">아니오</button>
    </p>
    
    <script>
    	$("#back").on("click", function(){
    		self.location="/";
    	})
    </script>
</div>
</body>
</html>