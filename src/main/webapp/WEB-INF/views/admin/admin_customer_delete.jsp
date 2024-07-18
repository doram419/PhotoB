<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보 삭제</title>
    
</head>
<body>
    <h1>회원정보 삭제</h1>
    <p>정말로 위 회원정보를 삭제하시겠습니까? </p>
    <p><strong>이름: </strong><span id="customerName">${customer.name}</span></p>
    <p><strong>이메일: </strong><span id="customerEmail">${customer.email}</span></p>
    <p>이 작업은 되돌릴 수 없습니다.</p>
    
    <form id="deleteForm" action="admin_customer_delete.jsp" method="post">
        <input type="hidden" name="customerId" value="${param.customerId}">
        <button type="submit">예, 삭제합니다</button>
        <!-- 삭제된 고객관리 페이지로 리다이렉트되어야함 -->
    </form>
    
    <a href="javascript:history.back()"><button type="submit">아니오, 취소합니다</button></a>
 
    <script>
    document.getElementById('deleteForm').addEventListener('submit', function(e) {
        e.preventDefault(); // 폼 기본 제출 동작 막기
        
        if (confirm('정말로 삭제하시겠습니까?')) {
            redirectToDeletedCustomerPage();
        }
    });

    function redirectToDeletedCustomerPage() {
        window.location.href = 'admin_customer_delete.jsp'; // 삭제된 고객 관리 페이지 URL
    }
    </script>
</body>
</html>