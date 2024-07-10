<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 - 포토북 제작 서비스</title>
    <link rel="stylesheet" href="css/header-footer.css">
    <link rel="stylesheet" href="css/common-style.css">
</head>
<body>
    <header>
        <h1>포토북 제작 서비스</h1>
        <nav>
            <ul>
                <li><a href="home_index.html">홈</a></li>
                <li><a href="profile.html">프로필 관리</a></li>
                <li><a href="photobook.html">포토북 제작</a></li>
                <li><a href="order.html">주문</a></li>
                <li><a href="board.html">게시판</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section id="board">
            <h2>게시판</h2>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td><a href="post.html">포토북 제작 문의드립니다.</a></td>
                        <!--pose.html 만들어야함-->
                        <td>사용자1</td>
                        <td>2023-06-01</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td><a href="post.html">주문 관련 문의합니다.</a></td>
                        <td>사용자2</td>
                        <td>2023-06-02</td>
                    </tr>
                </tbody>
            </table>
            <a href="write.html" class="button">글쓰기</a>
            <!--write.html 만들어야함-->
        </section>
    </main>

    <footer>
        <p>&copy; 2024 포토북 제작 서비스. All rights reserved.</p>
    </footer>
</body>
</html>