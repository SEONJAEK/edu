<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower:400" rel="stylesheet">
</head>
<body>
<h1 style="font-family: 'Gamja Flower'">지금은
<!-- 사용할 클래스를 태그로 객체생성: argument안받는 생성자만 호출 -->
<!-- 객체를 생성하겠어. 객체 보관하는 이름을 id에 다가 저장
반드시 id속성은 unique해야 한다
scope속성 요청이 끝날때까지, 세션 끝날때까지, 서버가 죽을 때까지의 유효한 객체 이렇게
다양하게 지정할 수 있다. 
무조건 객체 생성 안하고 객체가 이미 생성되어있으면 가져다가 쓰고 
생성되어잇지 않으면 생성한다 -->
<!-- id의 값은 변수가 된다 -->
<jsp:useBean id="obj" class="jspbean.Today" />

<!-- jsp에서 사용가능한 객체를통해 getProperty액션 태그
자바빈 클래스가가지고 있는 클래스들 중에서 getter먄 호출 + 리턴된 결과를 그자리에서 출력도 해준다 -->
<!-- getter호출하는 것 -->
<jsp:getProperty name="obj"  property="year" />년 
<jsp:getProperty name="obj"  property="month" />월 
<jsp:getProperty name="obj"  property="date" />일
<jsp:getProperty name="obj"  property="hour" />시 
<jsp:getProperty name="obj"  property="minute" />분 입니당</h1>
</body>
</html>