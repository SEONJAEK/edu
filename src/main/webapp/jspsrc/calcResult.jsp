${fruit.getApple_cnt()}<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int result = (int)request.getAttribute("result"); %>
<h1>연산 요청 결과</h1><hr>
결과: <%=result %><br>
<a href="/edu/htmlexam/calcForm.html">입력화면</a>
</body>
</html>