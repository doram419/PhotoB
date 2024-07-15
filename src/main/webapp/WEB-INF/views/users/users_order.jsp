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
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderInfos}" var="infoMap" varStatus="status">
					<!-- orderVo 키를 가진 맵은 OrderVo 객체로 등록-->
                	<c:if test="${infoMap.key eq 'ordersVo'}">
						<c:set var="orderVo" value="${infoMap.value}"/>
					</c:if>
					<!-- AlbumVo 키를 가진 맵은 AlbumVo 객체로 등록-->
                	<c:if test="${infoMap.key eq 'albumVo'}">
						<c:set var="albumVo" value="${infoMap.value}"/>
					</c:if>

                	<tr>
                		<!-- detail과 연결 필요 -->
                		<td><a href="#">${orderVo.orderId}</a></td>
                        <td>${albumVo.albumId}</td>
                        <td>${orderVo.orderDate}</td>
                        <td>${orderVo.total}원</td>
                        <td>${orderVo.oQuantity}</td>
                        <td><!-- 주문 상태 가져올 필요 있음 -->
                	<tr>
                </c:forEach>             
                </tbody>
            </table>
        </section>
    </main>

 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>