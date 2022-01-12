<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<h2>오류 발생했어욤ㅠㅠ</h2>
<h3>빠른시일내에 복구하겠습니다...</h3>
<img src="error.jpg">
<!-- 내장객체 변수:exception아무 jsp에서쓸 수 있는 내장 객체변수가 아니다. 유일하게 얘만 기본적으로 사용불가
사용하려면 page지시자에다가 pageisErrorPage= "true" 써줘야 가능 = "에러페이지를 내보내는 전용 페이지다" -->
<%	
    String msg = "오류 원인 : " + exception;	
	System.out.println("----------------------------------------");
	System.out.println(msg);
	System.out.println("----------------------------------------");	
	exception.printStackTrace();
%>
</body>
</html>






