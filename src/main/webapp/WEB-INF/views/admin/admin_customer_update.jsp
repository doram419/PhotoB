<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객 정보 수정</title>
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/common_style.css"/>'/>
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	
    <h1>고객 정보 수정</h1>
    <form action="admin_customer_update.jsp" method="post" id="customerEditForm">
        <div>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" value="${customer.name}" required>
        </div>
        <div>
            <label for="email">이메일:</label>
            <input type="email" id="email" name="email" value="${customer.email}" required>
        </div>
        <div>
            <label for="phone">전화번호:</label>
            <input type="tel" id="phone" name="phone" value="${customer.phone}" required>
        </div>
        <div>
            <label for="address">주소:</label>
            <input type="text" id="address" name="address" value="${customer.address}" required>
        </div>
        <button type="submit">수정</button>
    </form>
    <c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</body>
</html>