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
		href='<c:url value="/css/home_index_style.css"/>'>

</head>

<body>
   	<c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>

    <main>
        <section class="hero">
            <h1>나만의 특별한 순간을 포토북으로</h1>
            <a href="photobook.jsp" class="cta-button">나만의 포토북 만들기</a>
        </section>

        <section class="popular-templates">
            <h2>인기 템플릿</h2>
            <!-- 템플릿 미리보기 이미지들 -->
             <div class="template-images">
        <div class="template-image">
            <img src="template1.jpg" alt="템플릿 1">
        </div>
        <div class="template-image">
            <img src="template2.jpg" alt="템플릿 2">
        </div>
        <div class="template-image">
            <img src="template3.jpg" alt="템플릿 3">
        </div>
        <!-- 추가적인 템플릿 이미지들을 필요에 따라 추가 -->
    </div>
        </section>

        <section class="customer-reviews">
            <h2>고객 리뷰</h2>
            <!-- 리뷰 내용 -->
             <div class="review">
        <div class="reviewer-info">
            <img src="user1.jpg" alt="고객 이미지">
            <p>고객명: 홍길동</p>
        </div>
        <div class="review-content">
            <p>포토북으로 제작한 선물을 받은 친구들이 너무 좋아했어요. 감사합니다!</p>
        </div>
    </div>
    <div class="review">
        <div class="reviewer-info">
            <img src="user2.jpg" alt="고객 이미지">
            <p>고객명: 김철수</p>
        </div>
        <div class="review-content">
            <p>포토북 제작이 정말 간편하고 결과물이 예상보다 훨씬 멋져서 만족스럽습니다.</p>
        </div>
    </div>
        </section>
    </main>

	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>
