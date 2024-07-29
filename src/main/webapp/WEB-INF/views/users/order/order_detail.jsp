<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>${orderVo.orderId}</title>
  <link type="text/css" rel="stylesheet"
	href='<c:url value="/css/order_style.css"/>'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
                	<tr>
                		<td>${ordersId}</td>
                		<td>${albumId}</td>
                		<td>${orderDate}</td>
                		<td>${oQuantity}</td>
                		<td>${status}</td>
                	</tr>
                </tbody>
            </table>
        </section>
    </main>

 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>