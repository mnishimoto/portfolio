<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="LoginStyle.css">
<title>LOGIN</title>
</head>
<body>
	<div>
		<label>LOGIN</label>
		<form action="LoginServlet" method="post">
			<p>USER NAME</p>
			<input type="text" name="name" placeholder="IDを入力してね">
			<p>PASSWORD</p>
			<input type="password" name="pass" placeholder="PASSWORDを入力してね">
			<button>LOGIN</button>
		</form>
	</div>
</body>
</html>