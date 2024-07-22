<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>주문 관리</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/common_style.css'/>" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function confirmStatusChange() {
		return confirm("상태를 변경하시겠습니까?");
	}
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>

	<div class="main-content">
		<div class="header">
			<h2>주문 관리</h2>
		</div>
		<div class="card">
			<div class="card-header">주문 검색</div>
			<div class="card-body">
				<form action="<c:url value='/admin/order/search'/>" method="GET">
					<div class="form-group">
						<input type="text" name="keyword" placeholder="주문번호 또는 고객명 검색"
							value="${param.keyword}">
					</div>
					<button type="submit" class="btn btn-primary">검색</button>
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-header">주문 목록</div>
			<div class="card-body">
				<table class="table">
					<thead>
						<tr>
							<th>주문번호</th>
							<th>고객명</th>
							<th>주문일시</th>
							<th>주문상품 개수</th>
							<th>주문상태</th>
							<th>총액</th>
							<th>작업</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="orderInfo" items="${orderInfoList}">
							<tr>
								<td><a
									href="<c:url value='/admin/order/detail'>
<c:param name='orderId' value='${orderInfo["ordersVo"].orderId}'/>
</c:url>">
										${orderInfo['ordersVo'].orderId} </a></td>
								<td>${orderInfo['usersVo'].userName}</td>
								<td>${orderInfo['ordersVo'].orderDate}</td>
								<td>${orderInfo['ordersVo'].oQuantity}</td>
								<td><c:choose>
										<c:when test="${orderInfo['status'] == 'A'}">준비</c:when>
										<c:when test="${orderInfo['status'] == 'B'}">배송중</c:when>
										<c:when test="${orderInfo['status'] == 'C'}">배송완료</c:when>
										<c:otherwise>환불</c:otherwise>
									</c:choose></td>
								<td>${orderInfo['ordersVo'].total}원</td>
								<td><select
									onchange="if(confirmStatusChange()){location.href=this.value}">
										<option value="">상태 변경</option>
										<option
											value="<c:url value='/admin/delivery'>
<c:param name='orderId' value='${orderInfo["ordersVo"].orderId}'/>
</c:url>">배송</option>
										<option
											value="<c:url value='/admin/refund'>
<c:param name='orderId' value='${orderInfo["ordersVo"].orderId}'/>
</c:url>">환불</option>
								</select></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</body>
</html>