<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="UTF-8">
	<title>제품 관리 페이지</title>
</head>

<body>
	<!-- jsp파일로 바꿔서 header로 떼서 import하기  
		<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	-->
	<header>
    <h1>포토북 제작 서비스 - 관리자 페이지</h1>
    <nav>
        <ul>
            <li><a href="admin_index.html">관리자 홈</a></li>
            <li><a href="admin_customer.html">고객 관리</a></li>
            <li><a href="admin_order.html">주문 관리</a></li>
            <li><a href="admin_product.html">제품 관리</a></li>
            <li><a href="admin_customer_center.html">고객 센터</a></li>
            <li><a href="admin_delivery.html">배송 관리</a></li>
            <li><a href="admin_refund.html">환불 관리</a></li>
        </ul>
    </nav>
	</header>
	<!-- 여기까지 -->

	<p>제품 관리 페이지입니다</p>
</body>

	<!-- jsp파일로 바꿔서 footer로 떼서 include하기 
    	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
    -->
</html>