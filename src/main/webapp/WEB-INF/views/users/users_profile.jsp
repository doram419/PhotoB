<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>프로필 관리 - 포토북 제작 서비스</title>
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/profile_style.css"/>'>
</head>
<body>
    <c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>

    <main>
        <section id="profile">
            <h2>프로필 관리</h2>
            <form action="profile_update.html" method="post">
                <div>
                    <label for="name">이름:</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div>
                    <label for="email">이메일:</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div>
                    <label for="phone">전화번호:</label>
                    <input type="tel" id="phone" name="phone" required>
                </div>
                <div>
                    <label for="address">주소:</label>
                    <input type="text" id="address" name="address" required>
                </div>
                <button type="submit">프로필 업데이트</button>
            </form>
        </section>
    </main>

 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>