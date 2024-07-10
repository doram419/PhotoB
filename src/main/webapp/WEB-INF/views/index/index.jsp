<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>나만의 포토북 서비스</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #f8f8f8;
            padding: 1rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            display: inline;
            margin-right: 1rem;
        }
        .hero {
            text-align: center;
            padding: 3rem 0;
            background-color: #e9e9e9;
        }
        .cta-button {
            display: inline-block;
            padding: 0.5rem 1rem;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .popular-templates, .customer-reviews {
            padding: 2rem;
        }
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 1rem;
            position: absolute;
            bottom: 0;
            width: 100%;
        }
        .admin-menu {
            background-color: #ff4500;
            color: white;
        }
    </style>
</head>
<body>
    <header>
        <div class="logo">로고</div>
        <nav>
            <ul id="navMenu">
       <li><a href="<c:url value='/' />">홈</a></li>
                <li class="auth-required"><a href="<c:url value='/photobook.html' />">포토북 만들기</a></li>
                <li class="auth-required"><a href="<c:url value='/order.html' />">주문내역</a></li>
                <li class="auth-required"><a href="<c:url value='/board.html' />">게시판</a></li>
                <li id="adminLink" style="display: none;"><a href="<c:url value='/admin.html' />" class="admin-menu">관리자 페이지</a></li>
                <li id="loginLink"><a href="<c:url value='/users/login' />">로그인/회원가입</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section class="hero">
            <h1>나만의 특별한 순간을 포토북으로</h1>
            <a href="photobook.html" class="cta-button" id="ctaButton">나만의 포토북 만들기</a>
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
    <footer>
        <p>&copy; 2024 나만의 포토북 서비스. All rights reserved.</p>
    </footer>

    <script>
        // 로그인 상태를 확인하는 함수 (실제 구현 필요)
        function isLoggedIn() {
            // 여기에 실제 로그인 상태 확인 로직 구현
            return false; // 예시로 항상 로그아웃 상태 반환
        }

        // 관리자 권한을 확인하는 함수 (실제 구현 필요)
        function isAdmin() {
            // 여기에 실제 관리자 권한 확인 로직 구현
            return false; // 예시로 항상 일반 사용자 상태 반환
        }

        // 페이지 로드 시 실행
        window.onload = function() {
            const authRequired = document.querySelectorAll('.auth-required');
            const loginLink = document.getElementById('loginLink');
            const adminLink = document.getElementById('adminLink');
            const ctaButton = document.getElementById('ctaButton');

            if (isLoggedIn()) {
                authRequired.forEach(item => item.style.display = 'inline');
                loginLink.innerHTML = '<a href="logout.html">로그아웃</a>';
                ctaButton.href = 'photobook.html';

                if (isAdmin()) {
                    adminLink.style.display = 'inline';
                }
            } else {
                authRequired.forEach(item => item.style.display = 'none');
                adminLink.style.display = 'none';
                ctaButton.href = 'users/login.html';
                ctaButton.addEventListener('click', function(e) {
                    e.preventDefault();
                    alert('포토북 만들기는 로그인 후 이용 가능합니다.');
                    window.location.href = 'users/login';
                });
            }
        }

        // 인증이 필요한 페이지로의 접근을 제어하는 함수
        function checkAuth(e) {
            if (!isLoggedIn()) {
                e.preventDefault();
                alert('로그인이 필요한 서비스입니다.');
                window.location.href = 'login.html';
            }
        }

        // 관리자 권한이 필요한 페이지로의 접근을 제어하는 함수
        function checkAdminAuth(e) {
            if (!isAdmin()) {
                e.preventDefault();
                alert('관리자 권한이 필요한 페이지입니다.');
                window.location.href = 'index.html';
            }
        }

        // 인증이 필요한 링크에 이벤트 리스너 추가
        document.querySelectorAll('.auth-required a').forEach(link => {
            link.addEventListener('click', checkAuth);
        });

        // 관리자 페이지 링크에 이벤트 리스너 추가
        document.querySelector('#adminLink a').addEventListener('click', checkAdminAuth);
    </script>
</body>
</html>