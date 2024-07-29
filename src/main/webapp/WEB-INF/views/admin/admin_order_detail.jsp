<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>주문 상세 정보</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/common_style.css"/>' />
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/order_detail.css"/>' />
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>

	<div class="main-content">
		<div class="header">
			<h2>주문 상세 정보</h2>
		</div>
		<div class="card">
			<div class="card-header">주문 정보</div>
			<div class="card-body">
				<p>
					<strong>주문번호:</strong> ${orderDetail['order'].orderId}
				</p>
				<p>
					<strong>주문일시:</strong> ${orderDetail['order'].orderDate}
				</p>
				<p>
					<strong>주문수량:</strong> ${orderDetail['order'].oQuantity}
				</p>
				<p>
					<strong>총 금액:</strong> ${orderDetail['order'].total}원
				</p>
			</div>
		</div>
		<div class="card">
			<div class="card-header">고객 정보</div>
			<div class="card-body">
				<p>
					<strong>고객 이름:</strong> ${orderDetail['user'].userName}
				</p>
				<p>
					<strong>연락처:</strong> ${orderDetail['user'].phoneNumber}
				</p>
				<p>
					<strong>주소:</strong> ${orderDetail['user'].address}
				</p>
			</div>
		</div>
		<div class="card">
			<div class="card-header">상품 정보</div>
			<div class="card-body">
				<p>
					<strong>앨범ID:</strong> ${orderDetail['album'].albumId}
				</p>
				<p>
					<strong>앨범소재:</strong> ${orderDetail['album'].material}
				</p>
				<p>
					<strong>앨범색상:</strong> ${orderDetail['album'].color}
				</p>
				<p>
					<strong>앨범사이즈:</strong> ${orderDetail['album'].albumSize}
				</p>
			</div>
		</div>
		<div class="card">
			<div class="card-header">포토북 이미지</div>
			<div id="gallery" class="card-body">
	           	<c:forEach var="index" begin="1" end="${orderDetail['imagesCount']}">
	           		<img src="<c:url value="/photobook-images/order/${orderDetail['user'].userId}/${orderDetail['order'].orderId}/${index}.jpg" />" />
	       		</c:forEach>
	        </div>	
		</div>
	</div>

	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>