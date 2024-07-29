<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      
<!DOCTYPE html>

<html>

<head>
    <meta charset="UTF-8">
    <title>${orderVo.orderId}</title>
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/header_footer.css"/>'>
	<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/order_detail.css"/>'>
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
                		<td>${orderVo.orderId}</td>
                		<td>${orderVo.albumId}</td>
                		<td>${orderDate}</td>
                		<td>${orderVo.oQuantity}</td>
                		<td>${status}</td>
                	</tr>
                </tbody>
            </table>
            <div>
            	<h1>포토북 이미지</h1>
            	<div id="gallery">
            	<c:forEach var="index" begin="1" end="${imagesCount}">
            		<img src="<c:url value="/photobook-images/order/${orderVo.userId}/${orderVo.orderId}/${index}.jpg" />" />
        		</c:forEach>	
        		</div> 
            </div>
        </section>
    </main>

 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>