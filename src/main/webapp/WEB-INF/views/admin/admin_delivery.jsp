<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 배송 관리</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/common_style.css"/>' />
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>


	<div class="main-content">
		<div class="header">
			<h2>대시보드</h2>
		</div>
		<div class="card">
			<div class="card-header">배송 목록</div>
			<div class="card-body">
				<table class="table">
					<thead>
						<tr>
							<th>주문 ID</th>
							<th>이름</th>
							<th>배송 ID</th>
							<th>배송 일자</th>
							<th>배송 상태</th>
						</tr>
					</thead>
					<c:forEach items="${deliveryList }" var="deliveryVo"
						varStatus="status">
						<tbody>
							<tr>
								<td>${deliveryVo.orderId}</td>
								<td><c:forEach items="${orderList}" var="ordervo">
									<c:if test="${orderVo.orderId == deliveryVo.orderId}">
                      					  ${userVo.name}
                   						 </c:if>
									</c:forEach>
									</td>
								<td>deliveryVo.shipmentId</td>
								<td>deliveryVo.shipmentDate</td>
								<td>deliveryVo.shipmentStatus</td>
							</tr>
							<!-- 추가 주문 데이터 -->
					</c:forEach>
						</tbody>
				</table>
			</div>
		</div>
</body>

<%-- <c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import> --%>

</html>