<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 테스트</title>
</head>
<body>
<h2>EL 변수</h2>
<hr>
<!-- 내장객체 변수가아니면,  name이라는 이름으로 보관된 객체라는 뜻과 같다. 일반변수가 아님..!  
내장객체 변수이거나, 아니면 그 변수명을 어딘가 보관되어잇는 객체의 이름으로 생각해야한다. 
name el의 내장객체 변수 아님, name이라는 이름으로 보관되어잇는 객체의 이름으로 인식 -->
name 변수의 값 : ${name}<br>
<!-- 네임이라는 이름으로 객체를 저장한게 아님 -->
<% String name="듀크"; %>
name 변수의 값(표현식 태그) : <%= name %><br>
<!-- 여전히 name이라는 이름으로 보관되어있는 객체의 이름을 표현하시오 -->
name 변수의 값(EL) : ${name}<br>
<!-- 드디어 객체를 보관하고 있다. jsp수행시작할때 pageContext한번시작해서 jsp수행끝나면 pageContext도 끝난다.  -->
<% pageContext.setAttribute("name", "자바");  %>
<!-- pageScope는 생략가능 !, name이라는 pageScope > request Scope > session> application scope까지 다 찾아봄 -->
name 변수의 값 : ${name}<br>
<!-- pageScope.name이 명확함 -->
pageScope.name 변수의 값 : ${pageScope.name}<br>
<hr>
<% pageContext.setAttribute("number", 100); %>
number 변수의 값 : ${number}<br>
pageScope.number 변수의 값 : ${pageScope.number}<br>
number 변수의 값에 23을 더한 값 : ${ number + 23 }
</body>
</html>

