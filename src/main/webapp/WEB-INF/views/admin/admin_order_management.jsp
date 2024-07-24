<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>주문 관리</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/common_style.css'/>" />
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
<input type="text" name="keyword" placeholder="고객명 검색"
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
<th>총액</th>
<th>처리</th>
</tr>
</thead>
<tbody>
<c:forEach var="orderInfo" items="${orderList}">
<tr>
    <td><a href="<c:url value='/admin/order/detail'>
    <c:param name='orderId' value='${orderInfo.ordersVo.orderId}'/>
    </c:url>">
    ${orderInfo.ordersVo.orderId} </a></td>
    <td> <c:choose>
        <c:when test="${not empty orderInfo.userName}">
            ${orderInfo.userName}
        </c:when>
        <c:otherwise>
            ${orderInfo.usersVo.userName}
        </c:otherwise>
    </c:choose></td>
    <td>${orderInfo.ordersVo.orderDate}</td>
    <td>${orderInfo.ordersVo.oQuantity}</td>
    <td>${orderInfo.ordersVo.total}원</td>
    <td>${orderInfo.status}</td>
    <td>
		<form action="<c:url value="/admin/order/createShipment"/>" method="post">
			<input type="hidden" name="createOrderId" value="${orderInfo['ordersVo'].orderId}"/>
			<button type="submit" class="btn btn-primary">배송 생성</button>
		</form>
		<form action="<c:url value="/admin/order/createRefund"/>" method="post">
			<input type="hidden" name="createOrderId" value="${orderInfo['ordersVo'].orderId}"/>
			<button type="submit" class="btn btn-primary">환불 생성</button>
		</form>
	</td>
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