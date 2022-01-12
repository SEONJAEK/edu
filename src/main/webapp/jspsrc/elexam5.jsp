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
pageContext.setAttribute("msg", "PageContext객체에 저장된 객체"); 
request.setAttribute("msg","HttpServletRequest 객체에 저장된 객체");
//session.setAttribute("msg", "HttpSession객체에 저장된 객체");
application.setAttribute("msg", "ServletContext객체에 저장된 객체");
%>
pageScope 객체에서 추출:${pageScope.msg}<br>
requestScope객체에서 추출:${requestScope.msg}<br>
sessionScope객체에서 추출:${sessionScope.msg}<br>
applicationScope객체에서 추출: ${applicationScope.msg}<br>
<hr>
<!-- 페이지에 먼저 찾아가서 찾는다.
없으면 request> session > application scope -->
msg추출:${msg}<br>
</body>
</html>