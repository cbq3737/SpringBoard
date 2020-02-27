<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방문자 게시판</title>
</head>
<body>
<h1>방명록</h1>
	<form 
			action="${pageContext.servletContext.contextPath }/User/insert" 
			method="POST">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br/>

	<!-- 게시물 Loop -->
	<c:forEach items="${userlist }" var="vo">
	<table width=510 border=1>
		<tr>
			<td>[${vo.no }]</td>
			<td>${vo.name }</td>
			<td>${vo.regdate }</td>
			<td>
				<!-- 수정 -->
				<a href="${pageContext.servletContext.contextPath }/User/delete?no=${vo.no}">
					삭제
				</a>
			</td>
		</tr>
		<tr>
			<td colspan=4>${vo.content}</td>
		</tr>
	</table>
	</c:forEach>

</body>
</html>