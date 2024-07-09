<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    </style>
</head>
<body>
    <header>
        <div class="logo">로고</div>
        <nav>
            <ul>
                <li><a href="#">홈</a></li>
                <li><a href="photobook.html">포토북 만들기</a></li>
                <li><a href="order.html">주문내역</a></li>
                <li><a href="board.html">게시판</a></li>
                <li><a href="login.html">로그인/회원가입</a></li>
            </ul>
        </nav>
    </header>

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

    <footer>
        <p>&copy; 2024 나만의 포토북 서비스. All rights reserved.</p>
    </footer>
</body>
</html>