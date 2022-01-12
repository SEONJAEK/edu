<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String study = request.getParameter("study");
	if (study == null || study.equals("")) {
	%>
	<h2>study라는 이름으로 전달된 쿼리가 존재하지 않습니다.</h2>
	<%
	}
	else{
		if (study.equals("javascript"))
		response.sendRedirect("http://www.w3schools.com/js/default.asp");
		else if (study.equals("dom"))
		response.sendRedirect("http://www.w3schools.com/js/js_htmldom.asp");
		else if (study.equals("ajax"))
		response.sendRedirect("http//www.w3schools.com/xml/ajax_intro.asp");
		else if (study.equals("json"))
		response.sendRedirect("http//www.w3schools.com/js/js_json_intro.asp");
		else if (study.equals("jsp")) {
		%>
		<!-- 더블 사이드 방식 -->
		<jsp:forward page="exam6.jsp">
			<jsp:param name="dan" value="7" />
		</jsp:forward>
		<% 
		}
		else if (study.equals("html")) {
		%>
		<!-- 싱글 사이드 액션 태그로 forward를 사용했다 -->
		<jsp:forward page="/htmlexam/first.html" />
		<%
		}
	}
	%>
</body>
</html>