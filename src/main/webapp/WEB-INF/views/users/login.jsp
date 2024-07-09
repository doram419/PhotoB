<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <jsp:param name="title" value="로그인" />


<div class="container">
    <section id="login" class="form">
        <h2>로그인</h2>
        <form id="login-form" action="loginProcess.jsp" method="post">
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

<script>
    document.getElementById('login-form').addEventListener('submit', function(e) {
        // 클라이언트 측 유효성 검사 등을 수행할 수 있습니다.
    });
</script>
