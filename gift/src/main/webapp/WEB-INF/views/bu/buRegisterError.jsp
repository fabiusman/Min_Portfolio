<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bu/buRegisterError.css">
<!-- 제이쿼리 -->
 <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

</head>
<body>
	<!-- 헤더영역 -->
	<jsp:include page="../commons/header.jsp"></jsp:include>
	
	<p>등록 실패했습니다. 정보를 다시 확인해주세요!</p>
	<p>
		<button type="button" id="toRegister">회원가입</button>
	
		<!-- 쓴 정보 유지하는 기능 필요 -->
		<script>
			$("#toRegister").click(function(){
				self.location="/gift/bu/member/buRegisterForm";
			})
		</script>
	</p>
	
	<!-- 푸터영역 -->
	<jsp:include page="../commons/footer.jsp"></jsp:include>
</body>
</html>