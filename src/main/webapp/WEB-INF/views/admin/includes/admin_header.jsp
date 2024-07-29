<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/header_footer.css"/>' />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<div class="sidebar">
	<div class="sidebar-header">
		<h3>관리자 패널</h3>
	</div>
	<ul class="sidebar-menu">
		<li><a href="<c:url value="/admin/home"/>">대시보드</a></li>
		<li><a href="<c:url value="/admin/cm"/>">고객 관리</a></li>
		<li><a href="<c:url value="/admin/product"/>">제품 관리</a></li>
		<li><a href="<c:url value="/admin/om"/>">주문 관리</a>
			<ul>
				
				<li><a href="<c:url value="/admin/delivery"/>">배송 관리</a></li>
				<li><a href="<c:url value="/admin/refund"/>">환불 관리</a></li>
				
			</ul>
		</li>
		<li><a href="<c:url value="/admin/inventory"/>">재고 관리</a>
		<li><a href="<c:url value="/admin/cs"/>">고객 센터</a></li>
		<li><a href="<c:url value="/users/home"/>">홈</a></li>
	</ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>