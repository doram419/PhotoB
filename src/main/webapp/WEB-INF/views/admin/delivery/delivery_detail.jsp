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
</head>

<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	
    <div class="container">
        <h1>주문 배송 정보</h1>
        <table id="orderTable">
            <tr class="section-title">
                <td colspan="3">주문 정보</td>
            </tr>
            <tr>
                <td>주문 아이디</td>
                <td id="orderId">ORD12345</td>
                <td><button class="edit-btn" onclick="enableEdit('orderId')">수정</button></td>
            </tr>
            <tr>
                <td>주문자 이름</td>
                <td id="customerName">홍길동</td>
                <td><button class="edit-btn" onclick="enableEdit('customerName')">수정</button></td>
            </tr>
            <tr>
                <td>주문 일자</td>
                <td id="orderDate">2024-07-17</td>
                <td><button class="edit-btn" onclick="enableEdit('orderDate')">수정</button></td>
            </tr>
            <tr class="section-end">
                <td colspan="3"></td>
            </tr>

            <tr class="section-title">
                <td colspan="3">상품 정보</td>
            </tr>
            <tr>
                <td>상품명</td>
                <td id="productName">프리미엄 포토북</td>
                <td><button class="edit-btn" onclick="enableEdit('productName')">수정</button></td>
            </tr>
            <tr>
                <td>표지 재질</td>
                <td id="coverMaterial">하드커버</td>
                <td><button class="edit-btn" onclick="enableEdit('coverMaterial')">수정</button></td>
            </tr>
            <tr>
                <td>표지 색</td>
                <td id="coverColor">네이비 블루</td>
                <td><button class="edit-btn" onclick="enableEdit('coverColor')">수정</button></td>
            </tr>
            <tr>
                <td>앨범 사이즈</td>
                <td id="albumSize">8x11 인치</td>
                <td><button class="edit-btn" onclick="enableEdit('albumSize')">수정</button></td>
            </tr>
            <tr class="section-end">
                <td colspan="3"></td>
            </tr>

            <tr class="section-title">
                <td colspan="3">배송 정보</td>
            </tr>
            <tr>
                <td>배송 번호</td>
                <td id="trackingNumber">TRK9876543210</td>
                <td><button class="edit-btn" onclick="enableEdit('trackingNumber')">수정</button></td>
            </tr>
            <tr>
                <td>배송 일자</td>
                <td id="shippingDate">2024-07-20</td>
                <td><button class="edit-btn" onclick="enableEdit('shippingDate')">수정</button></td>
            </tr>
            <tr>
                <td>배송 상태</td>
                <td id="shippingStatus">배송 준비중</td>
                <td><button class="edit-btn" onclick="enableEdit('shippingStatus')">수정</button></td>
            </tr>
            <tr class="section-end">
                <td colspan="3"></td>
            </tr>

            <tr class="section-title">
                <td colspan="3">결제 정보</td>
            </tr>
            <tr>
                <td>총 금액</td>
                <td id="totalAmount">59,000원</td>
                <td><button class="edit-btn" onclick="enableEdit('totalAmount')">수정</button></td>
            </tr>
            <tr>
                <td>총 수량</td>
                <td id="totalQuantity">1</td>
                <td><button class="edit-btn" onclick="enableEdit('totalQuantity')">수정</button></td>
            </tr>
        </table>
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