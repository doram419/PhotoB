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
                        <th>제품</th>
                        <th>수량</th>
                        <th>가격</th>
                        <th>주문 상태</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${orderList}" var="{orderVo}">
                	<tr>
                		<td> 
                        	<!-- orderVo로 출력하고 no가져올 필요 있음 -->
                        	<a href="<c:url value="/order/detail?orderId=${no}"/>">
                        		ORDER-001 
                        	</a>
                        </td>
                        <td>포토북 1</td>
                        <td>1</td>
                        <td>30,000원</td>
                        <td>주문 완료</td>
                	<tr>
                	</c:forEach>
                	<!-- 더미 데이터 시작 *01~ -->
                    <tr>
                        <td> 
                        	<a href="<c:url value="/order/detail{}"/>">ORDER-001</a>
                        </td>
                        <td>포토북 1</td>
                        <td>1</td>
                        <td>30,000원</td>
                        <td>주문 완료</td>
                    </tr>
                    <!-- ~01* 여기까지 -->
                </tbody>
            </table>
        </section>
    </main>

 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>