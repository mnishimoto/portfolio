<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="SelectdbStyle.css">
<title>Insert title here</title>
</head>
<body>
	<div>
	<form action="TopServlet" method="get">
		<button name="btn" value="select">全スケジュール</button>
		<input type="hidden" name="selectWay" value="all">
	</form>


	
		<form action="TopServlet" method="get">
			<p>スケジュール検索</p>
			<input type="text" name="schedule">
			<button name="btn" value="select">検索</button>
			<input type="hidden" name="selectWay" value="schedule">
		</form>
		
			<p>日付検索</p>
		<form action="TopServlet" method="get">
			<select id="year" name="year">
				<%
					int year = Integer.parseInt(request.getAttribute("year").toString());
					int month = Integer.parseInt(request.getAttribute("month").toString());
					int day = Integer.parseInt(request.getAttribute("day").toString());
					for (int i = year - 10; i <= year + 10; i++) {
				%>
				<option value="<%=i%>" <%if (i == year) {%> selected
					<%}%>><%=i%>年
				</option>
				<%
					}
				%>
			</select> <select id="moneth" name="month">
				<%
					for (int i = 1; i <= 12; i++) {
				%>
				<option value="<%=i%>" <%if (i == month) {%> selected<%}%>>
					<%=i%>月
				</option>
				<%
					}
				%>
			</select><select id="day" name="day">
				<%
					for (int i = 1; i <= 31; i++) {
				%>
				<option value="<%=i%>">
					<%=i%>日
				</option>
				
				<%
					}
				%><option value="0" selected>指定なし</option>
			</select> <br /> <br /><button name="btn" value="select">検索</button>
			<input type="hidden" name="selectWay" value="name">
		</form>
		
	

	
		<c:if test="${list != null }">
			<table border="1">
				<tr>
					<th>登録id</th>
					<th>日付</th>
					<th>スケジュール</th>
					<th>開始時間</th>
					<th>終了時間</th>
				</tr>

				<c:forEach var="calendar" items="${list}">
					<tr>
						<td>${calendar.id}</td>
						<td>${calendar.date}</td>
						<td>${calendar.schedule}</td>
						<td>${calendar.start}</td>
						<td>${calendar.end}</td>

					</tr>
				</c:forEach>
			</table>
		</c:if>
	
	</div>
</body>

</body>
</html>