<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
<form method="post"
		action="${pageContext.servletContext.contextPath }/User/delete">
		<!-- hidden: 사용자 입력 값은 아니지만
		폼을 처리하기 위해 개발자가 세팅하는 숨겨진 값 -->
		<input type='hidden' name="no" value="${no}"> 
		<label
			for="password">비밀번호</label>
		<input type="password" name="password">
		<input type="submit" value="확인"><br> 
		<a href="${pageContext.servletContext.contextPath }/User/userlist">목록
			보기</a>
	</form>
</body>
</html>