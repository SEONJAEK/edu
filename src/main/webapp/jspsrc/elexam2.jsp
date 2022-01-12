<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL의 Query 문자열 추출</h2>
<hr>
<!-- EL은 표현하는 것에 전문이다. 표현할게 없으면 아무것도 출력안한다, null추출하지 않는다, 에러도 두지 않고 비워둔다 -->
<!-- empty:EL에만 있는 연산자 -->
전달된 메시지의 존재 여부 : ${ !empty param.message }<hr>
전달된 메시지의 내용은 ${param.message} 입니다.<br>
<!--[]사용시, 인덱스로 반드시 문자열 형식으로 줘야한다.  -->
전달된 메시지의 내용은 ${param["message"]} 입니다.<br>
전달된 메시지의 내용은 <%= request.getParameter("message") %> 입니다.<br>
</body>
</html>