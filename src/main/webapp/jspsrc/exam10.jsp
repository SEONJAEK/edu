<%@ page contentType="text/html; charset=utf-8"   %>
<!DOCTYPE html>
<html>
<HEAD>
<meta charset="UTF-8">
<TITLE>forward 액션 태그를 이용한 분기 예제  </TITLE>
</HEAD>
<BODY>
<!-- param테그는 종료테그 없이 />를 써준다 -->
<% if(request.getParameter("type")==null || 
           request.getParameter("type").equals("admin") ){ %>
  <jsp:forward page="admin_new.jsp">
  	<jsp:param name="message" value="Hi! Administrator" />
  </jsp:forward>
<% } else  {%>
  <jsp:forward page="user_new.jsp">
  	<jsp:param name="message" value="Hi! User" />
  </jsp:forward>
<%} %> 
</BODY>
</HTML>
