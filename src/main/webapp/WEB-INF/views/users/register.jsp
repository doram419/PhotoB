<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <jsp:param name="title" value="회원가입" />
</jsp:include>

<div class="container">
    <section id="register" class="form">
        <h2>회원가입</h2>
        <form id="register-form" action="registerProcess.jsp" method="post">
            <input type="email" id="register-email" name="email" placeholder="이메일" required>
            <input type="password" id="register-password" name="password" placeholder="비밀번호" required>
            <input type="password" id="register-password-confirm" name="password-confirm" placeholder="비밀번호 확인" required>
            <input type="text" id="register-name" name="name" placeholder="이름" required>
            <input type="tel" id="register-phone" name="phone" placeholder="전화번호" required>
            <input type="text" id="register-address" name="address" placeholder="주소" required>
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
</div>

<script>
    document.getElementById('register-form').addEventListener('submit', function(e) {
       
    });
</script>
