<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>포토북 구매 확인</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>" />
</head>
<body>
    <%-- 사용자 헤더 인클루드 --%>
    <jsp:include page="/WEB-INF/views/users/includes/users_header.jsp" />

    <main>
        <section id="purchase-confirm">
            <h2>포토북 구매 확인</h2>
            <div>
                <p>선택한 포토북 종류: ${param.bookType}</p>
                <p>구매 수량: ${param.quantity}</p>
                <p>총 가격: <%-- 실제 로직에서는 가격을 계산하여 여기에 출력합니다 --%></p>
            </div>
            <form action="purchase_complete.jsp" method="post">
                <input type="hidden" name="bookType" value="${param.bookType}">
                <input type="hidden" name="quantity" value="${param.quantity}">
                <button type="submit">결제 완료</button>
            </form>
        </section>
    </main>

    <%-- 사용자 푸터 인클루드 --%>
    <jsp:include page="/WEB-INF/views/users/includes/users_footer.jsp" />
</body>
</html>