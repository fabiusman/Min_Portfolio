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

<form action="/ppost/delete.do" method="post">
    <input type="hidden" id="id" name="id" value="${ppost.id }" >
	<input type="hidden" name="page" value="${scri.page }">
	<input type="hidden" name="amount" value="${scri.amount }">
	<input type="hidden" name="searchType" value="${scri.searchType }">
	<input type="hidden" name="keyword" value="${scri.keyword }">
    
    <p>
        삭제합니까?
    </p>
    <p>
        <button type="submit">예</button>
        <button type="button" id="back">돌아가기</button>
    </p>
    
    <script>
    	$("#back").on("click", function(){
    		self.location="/ppost/detail.do?id="+$("#id").val()
	    		+"&page=${scri.page}"
	    		+"&amount=${scri.amount}"
	    		+"&keyword=${scri.keyword}"
	    		+"&searchType=${scri.searchType}";
    	})
    </script>
</form>

</body>
</html>