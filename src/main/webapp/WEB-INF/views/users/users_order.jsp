<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>Order</title>
   
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
 <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/header_footer.css"/>'>
</head>

<body>
    <c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>
    <main>
        <section id="order">
            <h2>주문</h2>
            <table>
                <thead>
                    <tr>
                        <th>주문 번호</th>
                        <th>제품 이름</th>
                        <th>주문 일자</th> 
                        <th>가격</th>
                        <th>수량</th>
                        <th>주문 상태</th>
                        <th>비고</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderInfos}" var="infoMap">				
                	<tr>
                		<td>${infoMap['ordersVo'].orderId}</td>
                        <td>${infoMap['ordersVo'].albumId}</td>
                        <td>${infoMap['ordersVo'].orderDate}</td>
                        <td>${infoMap['ordersVo'].total}원</td>
                        <td>${infoMap['ordersVo'].oQuantity}</td>
                        <td>${infoMap['status']}</td>
                        <td> 
	                        <form method="post" 
	                        	action="<c:url value="/users/order/detail"/>">
	                        	<input type="hidden" name="ordersId" 
	                        		value="${infoMap['ordersVo'].orderId}"/>
	                        	<input type="hidden" name="albumId" 
	                        		value="${infoMap['ordersVo'].albumId}"/>
	                        	<input type="hidden" name="orderDate"
	                        		value="${infoMap['ordersVo'].orderDate}"/>
	                        	<input type="hidden" name="oQuantity"
	                        		value="${infoMap['ordersVo'].oQuantity}"/>
	                        	<input type="hidden" name="status"
	                        		value="${infoMap['status']}"/>
	                      		<button>조회</button> 
	                      	</form>
                      	</td> 
                	</tr>
                </c:forEach>             
                </tbody>
            </table>
        </section>
    </main>

 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>