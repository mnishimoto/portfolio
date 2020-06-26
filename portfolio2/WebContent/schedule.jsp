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
	<form action="Schedule" method="post">
	<p>スケジュール名</p>
	<input type="text" name="schedule">
	<div>
	<p>予定時刻</p>
	<select name="start">
		<option value="">-</option>
  		<c:forEach begin="1" end="24" var="i">
    	<option><c:out value="${i}" /></option>
  		</c:forEach>
	</select>　時
	<p>～</p>
	<select name="end">
		<option value="">-</option>
  		<c:forEach begin="1" end="24" var="i">
    	<option><c:out value="${i}" /></option>
  		</c:forEach>
	</select>　時
	</div>	
	<input type="submit" id="ok" name="ok" value="送信"/>
	</form>
</body>
</html>