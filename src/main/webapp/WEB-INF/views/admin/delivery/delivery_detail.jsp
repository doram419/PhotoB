<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 배송 정보</title>
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/delivery_form_style.css"/>'/>
	<script type="text/javascript" 
		src='<c:url value="/javascript/admin/delivery_detail.js"/>'>
		
	</script> 
</head>

<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	
    <div class="container">
		<h1>배송 상세 정보</h1>
		<form id="modifyForm" action="<c:url value="/admin/delivery/modify"/>" method="post">
			<table id="orderTable">
	      		<tr class="section-title">
	              <td colspan="3">배송 정보</td>
	        	</tr>
	        	<tr>
	               <td>배송 일자</td>
	               <td>
	               <!-- Date는 서비스에서 "yyyy-MM-dd" 형식으로 변환 필요 -->
	               <input type="date" name="shipmentDate"
	               		value="${deliveryDetailInfos['shipmentDate']}" 
	              			disabled/>
	               </td>
	               <td><button type=button class="edit-btn">수정</button></td>
	           </tr>
	           <tr>
	               <td>배송 상태</td>
	               <td>
	               <select id="delivery_status" name="shipmentStatus"
	               	data-default="${deliveryDetailInfos['shipmentsVo'].shipmentStatus}" disabled>
		               <option value="A">배송 준비</option>
		               <option value="B">배송 중</option>
		               <option value="C">배송 완료</option>
		               <option value="R">환불</option> 
	               </select>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr class="section-end">
	               <td colspan="3"></td>
	           </tr>
	           <tr class="section-title">
	               <td colspan="3">주문 정보</td>
	           </tr>
	           <tr>
	               <td>주문 번호</td>
	               <td>
	               <input type="text" name="orderId"
	               		value="${deliveryDetailInfos['ordersVo'].orderId}" 
	              			disabled/>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr>
	               <td>주문자 아이디</td>
	               <td>
	               <input type="text" name="userId"
	               		value="${deliveryDetailInfos['usersVo'].userId}" 
	               		disabled/>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr>
	               <td>주문자 이름</td>
	               <td>
	               <input type="text" name="userName"
	               		value="${deliveryDetailInfos['usersVo'].userName}" 
	               		disabled/>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr>
	               <td>주문 일자</td>
	               <td>
	               <!-- Date는 서비스에서 "yyyy-MM-dd" 형식으로 변환 필요 -->
	               <input type="date" name="orderDate"
	               		value="${deliveryDetailInfos['orderDate']}" 
	              			disabled/>
	               </td>
	               <td><button type=button class="edit-btn">수정</button></td>
	           </tr>
	           <tr class="section-end">
	               <td colspan="3"></td>
	           </tr>
	           <tr class="section-title">
	               <td colspan="3">상품 정보</td>
	           </tr>
	           <tr>
	               <td>상품 id</td>
	               <td>
	               <input type="text" name="albumId"
	               		value="${deliveryDetailInfos['albumVo'].albumId}" 
	               		disabled/>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr>
	               <td>표지 재질</td>
	               <td>
	               <select id="material" name="material"
	               	data-default="${deliveryDetailInfos['albumVo'].material}" disabled>
		               <option value="LINEN">린넨</option>
		               <option value="LEATHER">가죽</option>
		               <option value="HARD">하드</option>
		               <option value="SOFT">소프트</option> 
	               </select>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr>
	               <td>표지 색</td>
	               <td>
	               <select id="color" name="color"
	               	data-default="${deliveryDetailInfos['albumVo'].color}" disabled>
		               <option value="GRAY">회색</option>
		               <option value="BLUE">파란색</option>
		               <option value="BROWN">갈색</option>
	               </select>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr>
	               <td>앨범 사이즈</td>
	               <td>
	               <select id="albumSize" name="albumSize"
	               	data-default="${deliveryDetailInfos['albumVo'].albumSize}" disabled>
		               <option value="S">Small</option>
		               <option value="M">Middle</option>
		               <option value="B">Big</option>
	               </select>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr class="section-end">
	               <td colspan="3"></td>
	           </tr>
	           <tr class="section-title">
	               <td colspan="3">결제 정보</td>
	           </tr>
	           <tr>
	               <td>총 금액</td>
	               <td>
	               <input type="number" name="total" step="1000"
	               		value="${deliveryDetailInfos['ordersVo'].total}" 
	               		disabled/>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	           </tr>
	           <tr>
	               <td>총 수량</td>
	               <td>
	               <input type="number" name="oQuantity" min="1"
	               		value="${deliveryDetailInfos['ordersVo'].oQuantity}" 
	               		disabled/>
	               </td>
	               <td><button type=button id="confirm-btn" class="edit-btn">수정</button></td>
	            </tr>
        	</table>
        </form>
        
        <form action="<c:url value="/admin/delivery"/>" method="get">
       		<button id="big-btn">배송 관리로 가기</button>
        </form>
        
       	<button id="big-btn" type="submit" form="modifyForm">수정 확인</button>
    </div>
</body>
</html>