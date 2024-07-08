<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>포토 다이어리</title>
	<link type="text/css"
		rel="stylesheet"
		href="<c:url value="/css/photobook.css" />"/>
</head>

<body>
    <header>
        <h1>포토 다이어리</h1>
    </header>
    
    <nav>
        <a href="#home">홈</a>
        <a href="#login">로그인</a>
        <a href="#register">회원가입</a>
        <a href="#photobook">포토북 제작</a>
        <a href="#order">주문</a>
        <a href="#board">게시판</a>
        <a href="#admin">관리자</a>
    </nav>
    
    <div class="container">
        <section id="home">
            <h2>환영합니다!</h2>
            <p>포토 다이어리에서 당신만의 특별한 추억을 만들어보세요.</p>
        </section>
        
        <section id="login" class="form">
            <h2>로그인</h2>
            <form id="login-form">
                <input type="email" id="login-email" placeholder="이메일" required>
                <input type="password" id="login-password" placeholder="비밀번호" required>
                <button type="submit">로그인</button>
            </form>
        </section>
        
        <section id="register" class="form">
            <h2>회원가입</h2>
            <form id="register-form">
                <input type="email" id="register-email" placeholder="이메일" required>
                <input type="password" id="register-password" placeholder="비밀번호" required>
                <input type="password" id="register-password-confirm" placeholder="비밀번호 확인" required>
                <input type="text" id="register-name" placeholder="이름" required>
                <input type="tel" id="register-phone" placeholder="전화번호" required>
                <input type="text" id="register-address" placeholder="주소" required>
                <button type="submit">가입하기</button>
            </form>
        </section>
        
        <section id="profile" class="form">
            <h2>프로필 관리</h2>
            <form id="profile-form">
                <input type="text" id="profile-name" placeholder="이름">
                <input type="tel" id="profile-phone" placeholder="전화번호">
                <input type="text" id="profile-address" placeholder="주소">
                <input type="file" id="profile-picture" accept="image/*">
                <button type="submit">프로필 업데이트</button>
            </form>
        </section>
        
        <section id="photobook">
            <h2>포토북 제작</h2>
            <div class="photobook-templates">
                <div class="template">
                    <img src="/api/placeholder/180/120" alt="템플릿 1">
                    <p>템플릿 1</p>
                </div>
                <div class="template">
                    <img src="/api/placeholder/180/120" alt="템플릿 2">
                    <p>템플릿 2</p>
                </div>
                <div class="template">
                    <img src="/api/placeholder/180/120" alt="템플릿 3">
                    <p>템플릿 3</p>
                </div>
            </div>
            <form id="photo-upload-form" class="form">
                <input type="file" id="photo-upload" accept="image/jpeg, image/png" multiple>
                <button type="submit">사진 업로드</button>
            </form>
        </section>
        
        <section id="order" class="form">
            <h2>주문하기</h2>
            <form id="order-form">
                <input type="text" id="order-name" placeholder="이름" required>
                <input type="text" id="order-address" placeholder="주소" required>
                <input type="tel" id="order-phone" placeholder="전화번호" required>
                <select id="order-payment">
                    <option value="credit_card">신용카드</option>
                    <option value="paypal">페이팔</option>
                </select>
                <button type="submit">주문하기</button>
            </form>
        </section>
        
        <section id="board" class="board">
            <h2>게시판</h2>
            <form id="post-form" class="form">
                <input type="text" id="post-title" placeholder="제목" required>
                <textarea id="post-content" placeholder="내용" required></textarea>
                <input type="text" id="post-tags" placeholder="태그 (쉼표로 구분)">
                <button type="submit">게시하기</button>
            </form>
            <div id="post-list">
                <!-- 게시글이 여기에 동적으로 추가됩니다 -->
            </div>
        </section>
        
        <section id="admin" class="admin-panel">
            <h2>관리자 패널</h2>
            <h3>고객 관리</h3>
            <div id="customer-list">
                <!-- 고객 목록이 여기에 동적으로 추가됩니다 -->
            </div>
            <h3>주문 관리</h3>
            <div id="order-list">
                <!-- 주문 목록이 여기에 동적으로 추가됩니다 -->
            </div>
        </section>
    </div>

    <div id="login-popup" class="popup">
        <p id="login-message"></p>
        <p id="login-attempts"></p>
        <button onclick="closePopup('login-popup')">확인</button>
    </div>

    <script>
        // 프론트엔드 JavaScript 로직
        
        // 로그인 처리
        document.getElementById('login-form').addEventListener('submit', function(e) {
            e.preventDefault();
            const email = document.getElementById('login-email').value;
            const password = document.getElementById('login-password').value;
            login(email, password);
        });

        // 회원가입 처리
        document.getElementById('register-form').addEventListener('submit', function(e) {
            e.preventDefault();
            const email = document.getElementById('register-email').value;
            const password = document.getElementById('register-password').value;
            const passwordConfirm = document.getElementById('register-password-confirm').value;
            const name = document.getElementById('register-name').value;
            const phone = document.getElementById('register-phone').value;
            const address = document.getElementById('register-address').value;
            register(email, password, passwordConfirm, name, phone, address);
        });

        // 프로필 업데이트 처리
        document.getElementById('profile-form').addEventListener('submit', function(e) {
            e.preventDefault();
            const name = document.getElementById('profile-name').value;
            const phone = document.getElementById('profile-phone').value;
            const address = document.getElementById('profile-address').value;
            const picture = document.getElementById('profile-picture').files[0];
            updateProfile(name, phone, address, picture);
        });

        // 포토북 주문 처리
        document.getElementById('order-form').addEventListener('submit', function(e) {
            e.preventDefault();
            const name = document.getElementById('order-name').value;
            const address = document.getElementById('order-address').value;
            const phone = document.getElementById('order-phone').value;
            const paymentMethod = document.getElementById('order-payment').value;
            createOrder(name, address, phone, paymentMethod);
        });

        // 게시글 작성 처리
        document.getElementById('post-form').addEventListener('submit', function(e) {
            e.preventDefault();
            const title = document.getElementById('post-title').value;
            const content = document.getElementById('post-content').value;
            const tags = document.getElementById('post-tags').value.split(',').map(tag => tag.trim());
            createPost(title, content, tags);
        });

        // 팝업 닫기 함수
        function closePopup(popupId) {
            document.getElementById(popupId).style.display = 'none';
        }

        // 백엔드 API 호출 함수들 (실제 구현은 서버 사이드에서 이루어집니다)
        function login(email, password) {
            // API 호출: POST /api/login
            // 성공 시: 세션 저장 및 메인 페이지로 리다이렉트
            // 실패 시: 에러 메시지 표시 및 로그인 시도 횟수 증가
        }

        function register(email, password, passwordConfirm, name, phone, address) {
            // API 호출: POST /api/register
            // 성공 시: 로그인 페이지로 리다이렉트
            // 실패 시: 에러 메시지 표시
        }

        function updateProfile(name, phone, address, picture) {
            // API 호출: PUT /api/profile
            // 성공 시: 성공 메시지 표시
            // 실패 시: 에러 메시지 표시
        }

        function createOrder(name, address, phone, paymentMethod) {
            // API 호출: POST /api/orders
            // 성공 시: 주문 확인 페이지로 리다이렉트
            // 실패 시: 에러 메시지 표시
        }

        function createPost(title, content, tags) {
            // API 호출: POST /api/posts
            // 성공 시: 게시글 목록 새로고침
            // 실패 시: 에러 메시지 표시
        }

        // 관리자 기능 (고객 목록 조회, 주문 관리 등)은 별도의 관리자 페이지에서 구현
    </script> 
</body>
</html>
