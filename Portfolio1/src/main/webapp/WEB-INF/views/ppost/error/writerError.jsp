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
<p>로그인 해주세요</p>

<p>
    <button id="back" type="button">목록으로</button>
    <button id="home" type="button">로그인하기</button>
</p>

<!-- 페이지 유지 수정 -->
<script>
	$("#back").on("click", function(){
		self.location="/ppost/list.do"
			+"?page=${scri.page}"
			+"&amount=${scri.amount}"
			+"&keyword=${scri.keyword}"
			+"&searchType=${scri.searchType}";
	})
	
	$("#home").on("click", function(){
		self.location="/";
	})
</script>

</body>
</html>