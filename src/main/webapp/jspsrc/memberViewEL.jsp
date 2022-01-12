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

<li>회원 이름 : ${member.name} </li>
<li>회원 전화번호 : ${member.phone} </li>
<li>회원 계정 :  ${member.account}</li>
<li>회원 암호 :  ${member.passwd}</li>
</ul>
</body>
</html>
