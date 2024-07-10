<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login_style.css' />">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/header-footer.css' />">
</head>
<body>
<div class="container">
    <section id="login" class="form">
        <h2>로그인</h2>
          <form action="/users/login" method="post">
            <input type="email" id="login-email" name="email" placeholder="이메일" required>
            <input type="password" id="login-password" name="password" placeholder="비밀번호" required>
            <button type="submit">로그인</button>
        </form>
    </section>
</div>

<div id="login-popup" class="popup">
    <p id="login-message"></p>
    <p id="login-attempts"></p>
    <button onclick="closePopup('login-popup')">확인</button>
</div>
</body>
</html>