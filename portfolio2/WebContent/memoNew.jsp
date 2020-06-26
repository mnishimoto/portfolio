<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
    <H1>Sign Up Form (POST版)</H1>
    <br><hr><br>
    <FORM method="POST" action="PostHttpServlet">
      FirstName : <INPUT type="text" name="firstname">
      LastName : <INPUT type="text" name="lastname"><br><br>
      Mail Address : <INPUT type="text" name="mailaddress"><br><br>
      Zip Code : <INPUT type="text" name="zipcode"><br><br>
      Address : <INPUT type="text" name="address"><br><br>
      telephone : <INPUT type="text" name="telephone"><br><br>

      Gender  :
      <INPUT type="radio" name="gender" value="female" checked>female
      <INPUT type="radio" name="gender" value="male">male<BR><BR>
      Birthday : 
      <SELECT name="birthday">
        <OPTION value="" selected>----</OPTION>
        <OPTION value="Jan">Jan</OPTION>
        <OPTION value="Feb">Feb</OPTION>
        <OPTION value="Mar">Mar</OPTION>
        <OPTION value="Apr">Apr</OPTION>
        <OPTION value="May">May</OPTION>
        <OPTION value="Jun">Jun</OPTION>
        <OPTION value="Jly">Jly</OPTION>
        <OPTION value="Aug">Aug</OPTION>
        <OPTION value="Sep">Sep</OPTION>
        <OPTION value="Oct">Oct</OPTION>
        <OPTION value="Nov">Nov</OPTION>
        <OPTION value="Dec">Dec</OPTION>
      </SELECT><BR><BR>
      <INPUT type="submit" value="SEND">
      <INPUT type="reset" value="RESET">  
    </FORM>  
  </body>
</html>