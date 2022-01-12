<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP의 내장 객체들</title>
</head>
<body>
<h2>JSP의 내장 객체들 점검</h2>
<h3>[ request ]</h3>
getMethod() : <%=  request.getMethod()  %><br>
getRequestURI() : <%=  request.getRequestURI()  %><br>
<!-- 어떤 종류의 브라우저인지 확인 가능, 요청을 보내온 client가 어떤애인지 알 수 있음 웹클라이언트로부터 웹 서버에 전달이 될때 client의 머신이 뭔지 알게해주는 정보를 담고있다 -->
getHeader("user-agent") : <%=  request.getHeader("user-agent")  %><br>
<h3>[ out ]</h3>
<!-- client로부터 출력을 담당.내장객체말고 지시자로 사용할 수 도 있음 -->
<% out.print("<h4>out내장 객체로 출력!!</h4>"); %>
<h3>[ session ]</h3>
<!--  session객체 만들어 진 시간 다 다름 , jsp는 session객체 생성이 기본이다.세션생성시간-->
getId() : <%=  session.getId()  %><br>
getCreationTime() : <%=  new Date(session.getCreationTime())  %><br>
<h3>[ response ]</h3>
<!-- status:파일속성  -->
getStatus() : <%=  response.getStatus() %><br>
getBufferSize() : <%=  response.getBufferSize() %><br>
getContentType() : <%=  response.getContentType() %>
<% response.addCookie(new Cookie("myCookie", "myValue")); %>
<h3>[ application ]</h3>
<!-- 톰캣은 edu를 하나의 서블릿 컨택스트 객체라고 한다.  -->
getContextPath() : <%=  application.getContextPath()  %><br> <!-- \edu -->
getServerInfo() : <%=  application.getServerInfo()  %><br>
getMajorVersion() : <%=  application.getMajorVersion()  %><br> <!-- 메이저 버전은? -->
<H4>Web Application(/edu) 디렉토리의 파일 리스트 </H4>
<!-- 최상위폴더를 알려줌 webapp안에 있는 애들 -->
<% 
java.util.Set<String> list = application.getResourcePaths("/");
if (list != null) {
   Object obj[] = list.toArray();
   for(int i=0; i < obj.length; i++) {
      out.print(obj[i]+", ");
   }
}
%>
</body>
</html>