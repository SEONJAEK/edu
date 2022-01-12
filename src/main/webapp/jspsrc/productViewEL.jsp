<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>선택된 상품 정보는 다음과 같습니다.</h1><hr>
선택된 사과의 개수 : ${fruit.getApple_cnt()}<br>
선택된 바나나의 개수 :${fruit.getBanana_cnt()} <br>
선택된 한라봉의 개수 : ${fruit.getHanra_cnt()}<br>
<hr>
<a href="${header.referer}">상품선택화면으로</a>
</body>
</html>