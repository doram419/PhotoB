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
            background-color: #f0f0f0;
            padding: 20px;
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
         .image-container {
            text-align: left;
            margin-bottom: 20px;
        }
        .image-container img {
            width: 75px;
            height: 75px;
            cursor: pointer;
            margin: 5px;
            border: 2px solid transparent;
            transition: border-color 0.3s ease;
        }
        .image-container img:hover {
            border-color: #333; /* 마우스 오버 시 테두리 색상 변경 */
        }
        .main-image-container {            
            display: flex;
            justify-content: left; /* 수평 가운데 정렬 */
            align-items: center; /* 수직 가운데 정렬 */
            text-align: left;
            margin-bottom: 20px;
        }
        .main-image-container img {
            width: 100%; /* 큰 이미지의 너비를 화면 너비의 100%로 설정 */
            height: auto; /* 높이는 자동으로 조정됩니다 */
            max-width: 550px; /* 최대 너비 제한 */
            max-height: 550px; /* 최대 높이 제한 */
        }
         .image-slide {
            display: none; /* 초기에는 모든 이미지 숨기기 */
        }
        .image-slide.active {
            display: block; /* 활성 이미지만 보이기 */         
        }
        .tooltip {
            position: absolute;
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 10px;
            max-width: 200px;
            display: none;
            z-index: 1;
             /* 아래에 위치하도록 설정 */
            top: 500px; /* 부모 요소 아래쪽으로 10px 여백 */
            left: 800px;
            transform: translateX(-50%);
            text-align: center; /* 이미지를 가운데 정렬하기 위해 추가 */
    		cursor: pointer; /* 툴팁 내의 텍스트에 맞춰서 커서를 포인터로 설정 */
        }
        .tooltip img {
    		max-width: 100%; /* 이미지를 최대 너비 기준으로 조정 */
   			height: auto; /* 높이는 자동으로 조정됩니다 */
    		margin-bottom: 10px; /* 이미지와 설명 사이 간격을 조정 */
		}
        .photo-page:hover .tooltip {
            display: block;
        }
       
        
    </style>
</head>
<body>
    <header>
        <div class="logo">로고</div>
        <nav>
            <ul id="navMenu">
       			<li><a href="<c:url value='/' />">홈</a></li>
<c:choose>
    <c:when test="${not empty sessionScope.user}">
        <li><a href="<c:url value='/photobook.html' />">포토북 만들기</a></li>
        <li><a href="<c:url value='/order.html' />">주문내역</a></li>
        <li><a href="<c:url value='/board.html' />">게시판</a></li>
        <li><a href="/logout">로그아웃</a></li>
        <c:if test="${sessionScope.user.role == 'A'}">
            <li><a href="<c:url value='/admin.html' />" class="admin-menu">관리자 페이지</a></li>
        </c:if>
    </c:when>
    <c:otherwise>
        <li><a href="<c:url value='/users/login' />">로그인/회원가입</a></li>
    </c:otherwise>
</c:choose>
            </ul>
        </nav>
    </header>
    
    <main>
        <section class="hero">
            <h1>나만의 특별한 순간을 포토북으로</h1>
            <a href="<c:url value='/users/photobook'/>" class="cta-button" id="ctaButton">나만의 포토북 만들기</a>
        </section>
        <section class="popular-templates">
            <h2>인기 템플릿</h2>
		  <div class="main-image-container">
                <div class="image-slider">
                    <div class="image-slide"><img src="https://cdn.pixabay.com/photo/2022/07/08/10/37/books-7309019_640.png" alt="큰 이미지 1"></div>
                    <div class="image-slide"><img src="https://cdn.pixabay.com/photo/2024/06/16/05/29/ai-generated-8832689_640.jpg" alt="큰 이미지 2"></div>
                    <div class="image-slide"><img src="https://cdn.pixabay.com/photo/2024/05/20/21/29/ai-generated-8776335_640.jpg" alt="큰 이미지 3"></div>
                    <div class="image-slide"><img src="https://cdn.pixabay.com/photo/2024/05/18/19/21/books-8770940_640.jpg" alt="큰 이미지 4"></div>
                    <div class="image-slide"><img src="https://cdn.pixabay.com/photo/2024/07/13/13/20/ai-generated-8892153_640.png" alt="큰 이미지 5"></div>
                    <div class="image-slide"><img src="https://cdn.pixabay.com/photo/2024/06/18/08/28/book-8837306_640.jpg" alt="큰 이미지 6"></div>
                    
               
                </div>
            </div>
            <div class="image-container">
                <img src="https://cdn.pixabay.com/photo/2022/07/08/10/37/books-7309019_640.png" alt="이미지 1" class="thumbnail-image" onclick="showImage(0)">
                <img src="https://cdn.pixabay.com/photo/2024/06/16/05/29/ai-generated-8832689_640.jpg" alt="이미지 2" class="thumbnail-image" onclick="showImage(1)">
                <img src="https://cdn.pixabay.com/photo/2024/05/20/21/29/ai-generated-8776335_640.jpg" alt="이미지 3" class="thumbnail-image" onclick="showImage(2)">
                <img src="https://cdn.pixabay.com/photo/2024/05/18/19/21/books-8770940_640.jpg" alt="이미지 4" class="thumbnail-image" onclick="showImage(3)">
                <img src="https://cdn.pixabay.com/photo/2024/07/13/13/20/ai-generated-8892153_640.png" alt="이미지 5" class="thumbnail-image" onclick="showImage(4)">
                <img src="https://cdn.pixabay.com/photo/2024/06/18/08/28/book-8837306_640.jpg" alt="이미지 6" class="thumbnail-image"onclick="showImage(5)">
            </div>
            <div class="photo-page" onmouseover="showTooltip(this)" onmouseout="hideTooltip(this)">
        <div>하드 커버</div>
        <div class="tooltip">
            <img src="https://media.istockphoto.com/id/946854272/vector/set-of-blank-book-cover-template.jpg?s=612x612&w=0&k=20&c=9Qs_A8THVQG2jNKr_NiOjhaUMfeMfqzvGJ71BGxKQbE=" alt="하드 커버">
            딱딱하고 두꺼운 종이로 만들어짐
        </div>
    </div>

    <div class="photo-page" onmouseover="showTooltip(this)" onmouseout="hideTooltip(this)">
        <div>소프트 커버</div>
        <div class="tooltip">
            <img src="https://media.istockphoto.com/id/477245034/vector/blank-cover-3d-magazine-mock-template.jpg?s=612x612&w=0&k=20&c=9vfVt8z1R_zdBzPrc36ZIkE0ArxCDk--2en0ckGvOqg=" alt="소프트 커버">
            유연한 재질로 만들어짐
        </div>
    </div>

    <div class="photo-page" onmouseover="showTooltip(this)" onmouseout="hideTooltip(this)">
        <div>리넨 커버</div>
        <div class="tooltip">
            <img src="https://media.istockphoto.com/id/1130869955/photo/blue-standing-hardcover-book-isolated-perspective-view.jpg?s=612x612&w=0&k=20&c=23nLujx9DI6fSngxQ9PG3sb2BYgVkO6UXJn2t5BRh-w=" alt="리넨 커버">
            고급스러운 리넨 소재로 만들어짐
        </div>
    </div>
    <div class="photo-page" onmouseover="showTooltip(this)" onmouseout="hideTooltip(this)">
        <div>가죽 커버</div>
        <div class="tooltip">
            <img src="https://media.istockphoto.com/id/588593044/photo/dark-green-and-silver-leather-cover.jpg?s=612x612&w=0&k=20&c=iGNWOnG8B7dgwd681vNS6VC-a3ZZSkXFv8Qr1Z5ZpSg=" alt="가죽 커버">
            고급스러운 가죽 소재로 만들어짐
        </div>
    </div>
        </section>
        <section class="customer-reviews">
            <h2>고객 리뷰</h2>
            <!-- 리뷰 내용 -->
    		<p>포토북을 처음 만들어보았는데, 결과물이 너무 만족스럽습니다!</p>
    		<p>정성스럽게 제작된 포토북 덕분에 소중한 추억을 더욱 아름답게 간직할 수 있게 되었습니다.</p>
            <p>서비스가 매우 편리하고, 품질이 뛰어나서 친구들에게도 추천하고 싶어요!</p>
         
        </section>
    </main>
   
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
        function showImage(index) {
        var slides = document.querySelectorAll('.image-slide');
        for (var i = 0; i < slides.length; i++) {
            slides[i].classList.remove('active');
        }
        // 클릭한 이미지에 해당하는 슬라이드 보이기
        slides[index].classList.add('active');
        
        // 슬라이드 이동 처리
        var slideWidth = slides[index].clientWidth; // 슬라이드의 너비
        var slider = document.querySelector('.image-slider');
        slider.style.transform = `translateX(${-index * slideWidth}px)`;
    } 
        function showTooltip(element) {
            var tooltip = element.querySelector('.tooltip');
            tooltip.style.display = 'block';
        }

        function hideTooltip(element) {
            var tooltip = element.querySelector('.tooltip');
            tooltip.style.display = 'none';
        }
    
   
    </script>
</body>
</html>