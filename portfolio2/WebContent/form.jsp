<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<b>カレンダーの変更</b>
<br/>
<div style="text-align:center;">
<form action="CalendarForm" method="get">
<select id="year" name="year">
<%
    int year = Integer.parseInt(request.getAttribute("year").toString());
    int month = Integer.parseInt(request.getAttribute("month").toString());
    for(int i = year-10; i <= year+10; i++){
%>
<option value="<%=i %>"
<%
        if(i == year){
%>
selected
<%
        }
%>
><%=i %>年</option>
<%
    }
%>
</select>
  
<select id="moneth" name="month">
<%
    for(int i = 1; i <= 12; i++){
%>
<option value="<%=i %>"
<%
        if(i == month){
%>
selected
<%
        }
%>
><%=i %>月</option>
<%
    }
%>
</select>
<br/>
<br/>
<input type="submit" id="ok" name="ok" value="送信"/>
</form>
</div>
 
</body>
</html>