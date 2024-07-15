<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>포토북 구매 페이지</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>" />
</head>
<body>
    <%-- 사용자 헤더 인클루드 --%>
    <jsp:include page="/WEB-INF/views/users/includes/users_header.jsp" />

    <main>
        <section id="purchase">
            <h2>포토북 구매</h2>
            <form action="users_purchase_confirm.jsp" method="post">
                <div>
                    <label for="bookType">포토북 종류 선택:</label>
                    <select id="bookType" name="bookType">
                        <option value="standard">스탠다드 포토북</option>
                        <option value="premium">프리미엄 포토북</option>
                        <option value="deluxe">디럭스 포토북</option>
                    </select>
                </div>
                <div>
                    <label for="quantity">수량:</label>
                    <input type="number" id="quantity" name="quantity" min="1" value="1" required>
                </div>
                <button type="submit">구매하기</button>
            </form>
        </section>
    </main>

    <%-- 사용자 푸터 인클루드 --%>
    <jsp:include page="/WEB-INF/views/users/includes/users_footer.jsp" />
</body>
</html>