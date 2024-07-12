<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='/css/login_style.css' />">
</head>
<body>
    <div class="auth-container">
        <h2>로그인</h2>
        <form action="<c:url value='/users/login' />" method="post">
            <input type="email" name="email" placeholder="이메일" required>
            <input type="password" name="password" placeholder="비밀번호" required>
            <button type="submit">로그인</button>
        </form>
        <div class="signup-link">
            <a href="<c:url value='/users/register' />">계정이 없으신가요? 회원가입</a>
        </div>
    </div>
</body>
</html>
