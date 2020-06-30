<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="TopStyle.css">
<title>Insert title here</title>
</head>
<body>
	<div class=all>
		<label>LOGIN</label>
		<form action="LoginServlet" method="get">
			<input class="login" type="submit" name="button" value="LOGIN">
		</form>
		<label>NEW MEMBER</label>
		<form action="NewMen" method="get">
			<input class="regist" type="submit" name="button" value="REGIST">
		</form>		
	</div>
	
</body>
</html>