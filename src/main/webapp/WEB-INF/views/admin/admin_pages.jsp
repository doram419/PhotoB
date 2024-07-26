<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 대시보드</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/common_style.css"/>'/>
</head>

<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>

   <div class="main-content">
    <div class="header">
        <h2>대시보드</h2>
    </div>
    <div class="card">
        <div class="card-header">
            <a href="<c:url value='/admin/Norder'/>">미처리 주문 ${OrderCount}건이 있습니다</a>
        	</div>
        <div class="card-header">
 			<a href="<c:url value='/admin/Nshipment'/>">미처리 배송 ${ShipCount}건이 있습니다</a>
 			</div>
 		<div class="card-header">
 			<a href="<c:url value='/admin/Nrefund'/>">미처리 환불 ${RefCount}건이 있습니다</a>
 			</div>
 		<div class="card-header">
 			<a href="<c:url value='/admin/cs'/>">미처리 문의 ${CsCount}건이 있습니다</a>
 		</div>
        </div>
    </div>

    
	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import> 
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
