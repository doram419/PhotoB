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
		src='<c:url value="/javascript/admin/delivery_detail.js"/>'></script> 
</head>

<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	
    <div class="container">
		<h1>배송 상세 정보</h1>
        <table id="orderTable">
        	<tr class="section-title">
                <td colspan="3">배송 정보</td>
            </tr>
            <tr>
                <td>배송 번호</td>
                <td>
                	<input type="text" id="delivery_data"
                		value="${deliveryDetailInfos['shipmentsVo'].shipmentId}" 
               			disabled/>
                <td>
                	<button id="confirm-shipmentId" class="edit-btn">수정</button>
                </td>
            </tr>
            <tr>
                <td>배송 일자</td>
                <td>${deliveryDetailInfos['shipmentsVo'].shipmentDate}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr>
                <td>배송 상태</td>
                <td>${deliveryDetailInfos['status']}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr class="section-end">
                <td colspan="3"></td>
            </tr>
            <tr class="section-title">
                <td colspan="3">주문 정보</td>
            </tr>
            <tr>
                <td>주문 번호</td>
                <td>${deliveryDetailInfos['ordersVo'].orderId}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr>
                <td>주문자 아이디</td>
                <td>${deliveryDetailInfos['usersVo'].userId}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr>
                <td>주문자 이름</td>
                <td>${deliveryDetailInfos['usersVo'].userName}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr>
                <td>주문 일자</td>
                <td>${deliveryDetailInfos['ordersVo'].orderDate}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr class="section-end">
                <td colspan="3"></td>
            </tr>
            <tr class="section-title">
                <td colspan="3">상품 정보</td>
            </tr>
            <tr>
                <td>상품 id</td>
                <td>${deliveryDetailInfos['albumVo'].albumId}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr>
                <td>표지 재질</td>
                <td>${deliveryDetailInfos['albumVo'].material}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr>
                <td>표지 색</td>
                <td>${deliveryDetailInfos['albumVo'].color}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr>
                <td>앨범 사이즈</td>
                <td>${deliveryDetailInfos['albumVo'].albumSize}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr class="section-end">
                <td colspan="3"></td>
            </tr>
            <tr class="section-title">
                <td colspan="3">결제 정보</td>
            </tr>
            <tr>
                <td>총 금액</td>
                <td>${deliveryDetailInfos['ordersVo'].total}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
            <tr>
                <td>총 수량</td>
                <td>${deliveryDetailInfos['ordersVo'].oQuantity}</td>
                <td><button class="edit-btn">수정</button></td>
            </tr>
        </table>
        
        <form action="<c:url value="/admin/delivery"/>" method="get">
        	<!-- 지금은 css 유지 위해서 놔둠 나중에 id 수정--> 
       		<button id="confirmEdit">배송 관리로 가기</button>
        </form>
        <button id="confirmEdit" onclick="confirmEdit()">수정 확인</button>
    </div>

    <script>
        function enableEdit(id) {
            const cell = document.getElementById(id);
            const currentValue = cell.innerText;
            cell.innerHTML = `<input type="text" id="${id}_input" value="${currentValue}">`;
            document.getElementById('confirmEdit').style.display = 'block';
        }

        function confirmEdit() {
            const inputs = document.querySelectorAll('input[type="text"]');
            inputs.forEach(input => {
                const id = input.id.replace('_input', '');
                document.getElementById(id).innerText = input.value;
            });
            document.getElementById('confirmEdit').style.display = 'none';
        }
    </script>
</body>
</html>