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

<h2>글 작성</h2>

<form action="/ppost/write.do" method="post">
	<input type="hidden" name="page" value="${scri.page }">
	<input type="hidden" name="amount" value="${scri.amount }">
	<input type="hidden" name="searchType" value="${scri.searchType }">
	<input type="hidden" name="keyword" value="${scri.keyword }">

   	<p>
        <label for="title">제목 : </label><input type="text" id="title" name="title">
    </p>
    <p>
        <label for="writer">작성자 : </label><input type="text" id="writer" name="writer" value="${writer.name }" readonly="readonly">
    </p>
    <p>
        <label for="content">내용 : </label><textarea name="content" id="content"></textarea>
    </p>
    
    <button type="submit">글쓰기</button>
</form>

<button id="back" type="button">목록으로</button>

<!-- 페이지 유지 수정 -->
<script>
	$("#back").on("click", function(){
		self.location="/ppost/list.do"
		+"?page=${scri.page}"
		+"&amount=${scri.amount}"
		+"&keyword=${scri.keyword}"
		+"&searchType=${scri.searchType}";
	})
</script>

</body>
</html>