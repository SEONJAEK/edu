<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원정보<hr>
<ul>
<% MemberVO m = (MemberVO)request.getAttribute("member"); %>
<li>회원 이름 : <%= m.getName() %> </li>
<li>회원 전화번호 : <%= m.getPhone() %></li>
<li>회원 계정 : <%= m.getAccount() %></li>
<li>회원 암호 : <%= m.getPasswd() %></li>
</ul>
</body>
</html>
