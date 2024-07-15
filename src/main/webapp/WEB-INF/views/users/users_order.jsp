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
                        <th>비고</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${orderInfos}" var="infoMap">				
                	<tr>
                		<td>${infoMap['ordersVo'].orderId}</a></td>
                        <td>${infoMap['albumVo'].albumId}</td>
                        <td>${infoMap['ordersVo'].orderDate}</td>
                        <td>${infoMap['ordersVo'].total}원</td>
                        <td>${infoMap['ordersVo'].oQuantity}</td>
                        <td>${infoMap['status']}</td>
                        <!-- detail과 연결 필요 -->
                      	<td> <button>조회</button> </td> 
                	</tr>
                </c:forEach>             
                </tbody>
            </table>
        </section>
    </main>

 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>