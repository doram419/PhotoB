<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>포토북 구매 완료</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/css/style.css"/>" />
</head>
<body>
    <%-- 사용자 헤더 인클루드 --%>
    <jsp:include page="/WEB-INF/views/users/includes/users_header.jsp" />

    <main>
        <section id="purchase-complete">
            <h2>포토북 구매 완료</h2>
            <div>
                <p>포토북 구매가 완료되었습니다!</p>
                <p>선택한 포토북 종류: ${param.bookType}</p>
                <p>구매 수량: ${param.quantity}</p>
                <p>주문 번호: <%-- 실제 로직에서는 주문 번호를 생성하여 여기에 출력합니다 --%></p>
                <p>구매 내역은 마이페이지에서 확인할 수 있습니다.</p>
            </div>
        </section>
    </main>

    <%-- 사용자 푸터 인클루드 --%>
    <jsp:include page="/WEB-INF/views/users/includes/users_footer.jsp" />
</body>
</html>