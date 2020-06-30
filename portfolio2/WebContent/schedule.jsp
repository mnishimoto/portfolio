<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="scheduleStyle.css">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form action="Schedule" method="post">
	<p>スケジュール名</p>
	<input type="text" name="schedule"placeholder="※英数字のみで入力してください※">
	
	<p>予定時刻</p>
	<select name="start">
		<option value="">-</option>
  		<c:forEach begin="1" end="24" var="i">
    	<option><c:out value="${i}" /></option>
  		</c:forEach>
	</select>　時
	<a>～</a>
	<select name="end">
		<option value="">-</option>
  		<c:forEach begin="1" end="24" var="i">
    	<option><c:out value="${i}" /></option>
  		</c:forEach>
	</select>　時	
	<button>送信</button>
	</form>
	</div>
</body>
</html>