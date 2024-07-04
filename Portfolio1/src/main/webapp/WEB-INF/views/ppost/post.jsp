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
	<h2>게시글 목록</h2>
	<table>
	    <tr>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>등록일</th>
	        <th>조회수</th>
	    </tr>
	    <c:forEach var="ppost" items="${pposts}">
		    <tr>
		        <td>${ppost.title }</td>
		        <td><a href="/ppost/detail.do?id=${ppost.id }
		        	&page=${scri.page}&amount=${scri.amount}
		        	&keyword=${scri.keyword}&searchType=${scri.searchType}">
		        	${ppost.writer }</a></td>
		        <td>${ppost.regdate }</td>
		        <td>${ppost.hits }</td>
		    </tr>
	    </c:forEach>
	</table>
    <p>
    	<button id="write" type="button">글쓰기</button>
        <button id="back" type="button">홈으로</button>
    
    	<script>
	    	$("#write").on("click", function(){
				self.location="/ppost/write?page=${scri.page}"
					+"&amount=${scri.amount}"
					+"&keyword=${scri.keyword}"
					+"&searchType=${scri.searchType}";
			})
    	
    		$("#back").on("click", function(){
    			self.location="/";
    		})
    	</script>
    </p>
    
    <div id="searchBox">
    	<select id="searchType" name="searchType">
    		<option value="t">제목</option>
    		<option value="c">내용</option>
    		<option value="w">작성자</option>
    		<option value="tc">제목+내용</option>
    	</select>
    	
    	<input type="text" id="keyword" name="keyword">
    	
    	<button id="search" type="button">검색</button>
    	
    	<script>
    		$("#search").on("click", function(){
    			self.location="/ppost/list.do?searchType="
    					+$("select option:selected").val()
    					+"&keyword="+$("#keyword").val();
    		})
    	</script>
    </div>
    
    
    <div id="paging">
	    <ul>
	    	<c:if test="${pageMaker.prev==true }">
	    		<span><li><a href="/ppost/list.do?${pageMaker.makeSearch(pageMaker.pageStart-1) }">이전</a></li></span>
	    	</c:if>
	    	<c:forEach begin="${pageMaker.pageStart }" end="${pageMaker.pageEnd }" var="idx">
	    		<span><li><a href="/ppost/list.do?${pageMaker.makeSearch(idx) }">${idx }</a></li></span>
	    	</c:forEach>
	    	<c:if test="${pageMaker.next==true }">
	    		<span><li><a href="/ppost/list.do?${pageMaker.makeSearch(pageMaker.pageEnd+1)}">다음</a></li></span>
	    	</c:if>
		</ul>
	</div>
    
    
    
    
</body>
</html>