<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import= "java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Date date = new Date();
SimpleDateFormat format = new SimpleDateFormat("hh시 mm분");
String time = format.format(date);
%>

<h3 style="color:red"><%= time %>에 성공~~ 축하축하</h3>
<img src="/edu/images/success1.png">
</body>
</html>