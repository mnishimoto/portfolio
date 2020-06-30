<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="TopSelectStyle.css">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="CalendarAccess" method="get">
			<input class="regist" type="submit" name="button" value="スケジュールの登録">
		</form>
		<form action="TopServlet" method="get">
			<input class="confirm" type="submit" name="button" value="スケジュールの確認">
		</form>		
	</div>

</body>
</html>