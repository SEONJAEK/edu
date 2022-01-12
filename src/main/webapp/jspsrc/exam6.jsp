<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP로 구현한 구구단</title> 
</head>
<body>
<h2>JSP로 구현한 구구단</h2>
 <%
 int dan= Integer.parseInt(request.getParameter("dan"));
 if (dan <= 9) {
 	for (int i=1;i<=9;i++){
%>
<!-- 표현식 테그를 사용하여 지정 -->
		 <%= dan %> x <%=i %> = <%=dan*i%><br>
<%	
	}
 %>
 	<hr>
 <!-- out 내장 객체를 사용하여 출력: 전체적으로 복잡한 경우, out.print로 묶는게 낫다 -->
<%
	for (int i=1;i<=9;i++){
		out.print(dan + " x " + i + " = "  + dan*i + "<br>");	
	}
 } else {
%>
	<h3 style="color:red">1에서 9사이의 값을 입력해 주세요..</h3>
<%	
}
 %>
</body>
</html>





