<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>

	<form action="TopServlet" method="get">
		<button name="btn" value="select">全スケジュール</button>
		<input type="hidden" name="selectWay" value="all">
	</form>
	${message}
	<c:forEach var="i" items="${list}">
		${i.schedule}
	</c:forEach>
	</div>
</body>
	
</body>
</html>