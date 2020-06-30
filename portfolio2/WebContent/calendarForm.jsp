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
<div>
<label style="display:block;padding:40px;font-size:30px;font-weight:530;"><%= session.getAttribute("year") %>年<%=session.getAttribute("month") %>月のカレンダー</label>
<br/>
<br/>

<%= session.getAttribute("calender") %>

<br/>
</div>
</body>
</html>