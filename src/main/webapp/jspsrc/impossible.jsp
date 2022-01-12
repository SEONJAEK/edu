<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>
<%@ page import= "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Calendar" %>

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

Calendar cal = Calendar.getInstance();
cal.setTime(date);
cal.add(Calendar.MINUTE, 30);
String thirM = format.format(cal.getTime());
%>

<h3 style="color:red">더 이상 응모할 수 없어요.. <%=thirM %>이후에 응모하거나 브라우저를 재기동한 후에 응모하세요</h3>
</body>
</html>