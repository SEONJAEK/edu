<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Query 문자열 추출(GET&amp;POST)</h1>
<hr>
<%
	if(request.getMethod().equals("POST")){
		request.setCharacterEncoding("utf-8");
	}
%>
<h2>당신의 이름은<%=request.getParameter("name") %>이군요!!</h2>
<!-- 이 jsp를 요청한 대상이 누구냐 -->
<!-- referer쓰는 것과 절대 path주는 것 장단점 뭐임? -->
<a href="<%=request.getHeader("referer")%>">입력 화면으로</a>
</body>
</html>