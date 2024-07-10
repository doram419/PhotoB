<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나만의 포토북 서비스</title>
    
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/header-footer.css"/>'>
	<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/home_index_style.css"/>'>
	<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/common-style.css"/>'>
</head>

<body>
   	<c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>

    <main>
        <section class="hero">
            <h1>나만의 특별한 순간을 포토북으로</h1>
            <a href="photobook.html" class="cta-button">나만의 포토북 만들기</a>
        </section>

        <section class="popular-templates">
            <h2>인기 템플릿</h2>
            <!-- 템플릿 미리보기 이미지들 -->
        </section>

        <section class="customer-reviews">
            <h2>고객 리뷰</h2>
            <!-- 리뷰 내용 -->
        </section>
    </main>

	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>
