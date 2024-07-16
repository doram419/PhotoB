<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 환불 관리</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/common_style.css"/>'/>
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	

	<div class="main-content">
        <div class="header">
            <h2>대시보드</h2>
        </div>
        <div class="card">
            <div class="card-header">환불 목록</div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>주문 ID</th>
                            <th>주문자명</th>
                            <th>환불 ID</th>
                            <th>주문일자</th>
                            <th>주문금액</th>
                            <th>환불 상태</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${deliveryInfos}" var="infoMap">				
                        <tr>
	                		<td>${infoMap['ordersVo'].orderId}</td>
	                        <td>${infoMap['usersVo'].userName}</td>
	                        <td>${infoMap['refundVo'].refundId}</td>
	                        <td>${infoMap['ordersVo'].orderDate}</td>
	                        <td>${infoMap['ordersVo'].total}</td>
	                        <td>${infoMap['status']}</td>
                		</tr>
           				</c:forEach>   
                    </tbody>
                </table>
            </div>
        </div>
	</div>

</body>

<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>

</html>