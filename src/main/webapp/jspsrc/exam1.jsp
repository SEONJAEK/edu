<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 이 jsp에 실행되는 코드는 자바이구, 이 페이지는 UTF-8이다
    contentType지정해줬엉 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 학습 예제1</title>
</head>
<body>
<h1>JSP 맛보기</h1>
<hr>
<!-- jsp테그를 사용하여 java 사용 가능 :표현식-->
<h3>현재 시간 정보: <%= java.time.LocalDateTime.now() %></h3>
</body>
</html>