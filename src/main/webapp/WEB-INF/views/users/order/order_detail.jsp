<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>주문 - 포토북 제작 서비스</title>
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/header_footer.css"/>'>
</head>

<body>
    <c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>

    <main>
        <section id="order">
            <h2>주문 상세</h2>
            <table>
                <thead>
                    <tr>
                        <th>주문 번호</th>
                        <th>제품</th>
                        <th>수량</th>
                        <th>가격</th>
                        <th>주문 상태</th>
                    </tr>
                </thead>
                <tbody>
                	<!-- 주문에 관한 정보는 OrderVo에서, 주문 상태는 ShipmentVo 참조해서 
                		ShipmentVo::shipmentStatus가 R이면 RefundVo::refundStatus를 
                		참조해야 함 
                		그래서 List<Map<String,ObjectVo>>구조로 넘겨줘야함. 
                			String의 값은 shipmentStatus, 없으면 refundStatus
                		-->	
                	<c:forEach items="${orderlist}" var="orderMaps" varStatus="status" >
                		<c:forEach items="${orderMaps}" var="orderMap" varStatus="status">
                			<!-- 맵의 키가 텍스트"OrderVo"이면 -->
                			<c:if test="${orderMap.key eq 'OrderVo'}">
                				<!-- orderVo 변수의 값을 해당 맵의 value로 설정-->
								<c:set var="orderVo" value="${orderMap.value}"/>
							</c:if>
							<!-- 맵의 키가 텍스트"orderStatus"과 일치하면 -->
							<c:if test="${orderMap.key eq 'orderStatus'}">
								<!-- orderStatus 변수의 값을 해당 맵의 value로 설정-->
								<c:set var="orderStatus" value="${orderMap.value}"/>
							</c:if>
                		</c:forEach>
                		
                		<tr>
	                        <td>${orderVo.orderId}</td>
	                        <td>${orderVo.albumId}</td>
	                        <td>${orderVo.oQuantity}</td>
	                        <td>${orderVo.total}원</td>
	                        <!-- orderStatus의 값에 맞는 설명 출력 -->
	                        <td>${Status}</td>      
                    	</tr>
                	</c:forEach>
                	<!-- 더미 데이터 시작 *01~ -->
                    <tr>
                        <td>ORDER-001</td>
                        <td>포토북 1</td>
                        <td>1</td>
                        <td>30,000원</td>
                        <td>주문 완료</td>
                    </tr>
                    <!-- ~01* 더미 데이터 시작  -->
                </tbody>
            </table>
        </section>
    </main>

 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>