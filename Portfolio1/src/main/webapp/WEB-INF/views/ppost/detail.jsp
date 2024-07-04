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

<h2>글 내용</h2>

<form id="form">
	<p>
        <input type="hidden" id="id" name="id" value="${ppost.id }" readonly="readonly">
    </p>
   	<p>
        <label for="title">제목 : </label>
        <input type="text" id="title" name="title" value="${ppost.title }" readonly="readonly">
    </p>
    <p>
        <label for="writer">작성자 : </label>
        <input type="text" id="writer" name="writer" value="${ppost.writer }" readonly="readonly">
    </p>
    <p>
        <label for="content">내용 : </label>
        <textarea rows="10" cols="20" name="content" id="content" readonly="readonly">${ppost.content }</textarea>
    </p>
</form>

<p>
	<button id="update" type="button">수정하기</button>
	<button id="delete" type="button">삭제하기</button>
	<button id="back" type="button">목록으로</button>
</p>

<!-- 페이지 유지 수정 -->
<script>
	$("#update").on("click", function(){
		self.location="/ppost/update?id="+$("#id").val()
			+"&page=${scri.page}"
			+"&amount=${scri.amount}"
			+"&keyword=${scri.keyword}"
			+"&searchType=${scri.searchType}";
	})
	
	$("#delete").on("click", function(){
		self.location="/ppost/delete?id="+$("#id").val()
			+"&page=${scri.page}"
			+"&amount=${scri.amount}"
			+"&keyword=${scri.keyword}"
			+"&searchType=${scri.searchType}";
	})

	$("#back").on("click", function(){
		self.location="/ppost/list.do"
			+"?page=${scri.page}"
			+"&amount=${scri.amount}"
			+"&keyword=${scri.keyword}"
			+"&searchType=${scri.searchType}";
	})
</script>

<br>
<h3>댓글</h3>

<div class="replies">
	<table>
		<c:forEach var="reply" items="${replies }">
			<input type="hidden" id="rid" value="${reply.id }">
			<tr>
				<td>${reply.writer }</td>
				<td>${reply.content }</td>
				<td>${reply.regdate }</td>
				<td>
					<button id=rupdate type="button">수정</button>
					<button id=rdelete type="button">삭제</button>
				</td>
			</tr>
			
			<script>
				$("#rupdate").on("click", function(){
					self.location="/preply/update?id="+$("#rid").val()
						+"&post_id="+$("#id").val()
						+"&page=${scri.page}"
						+"&amount=${scri.amount}"
						+"&keyword=${scri.keyword}"
						+"&searchType=${scri.searchType}";
				})
				
				$("#rdelete").on("click", function(){
					self.location="/preply/delete?id="+$("#rid").val()
						+"&post_id="+$("#id").val()
						+"&page=${scri.page}"
						+"&amount=${scri.amount}"
						+"&keyword=${scri.keyword}"
						+"&searchType=${scri.searchType}";
				})
			</script>
		</c:forEach>
	</table>
</div>

<div class="replyWrite">
	<form id=rwrite action="/preply/write.do" method="post">
		<input type="hidden" id="post_id" name="post_id" value="${ppost.id }" readonly="readonly">
		<p>
			<label for="rwriter">작성자 : </label>
			<input type="text" id="rwriter" name="writer" value="${rwriter.name }" readonly="readonly">
		</p>
		<p>	
			<label for="rcontent">내용 : </label>
			<textarea rows="5" cols="20" id="rcontent" name="content"></textarea>
		</p>
		<p>
			<button type="submit">댓글작성</button>
		</p>
	</form>
</div>

</body>
</html>