<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="calendarStyle.css">
</head>
<body>
<b><%= session.getAttribute("year") %>年<%=session.getAttribute("month") %>月のカレンダー</b>
<div>
<br/>
<br/>
<%= session.getAttribute("calender") %>
<br/>
</div>
</body>
</html>