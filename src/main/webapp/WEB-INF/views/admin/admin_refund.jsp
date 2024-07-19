<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 환불 관리</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
            <div class="card-header">환불 목록</div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>주문 ID</th>
                            <th>이름</th>
                            <th>환불 ID</th>
                            <th>환불 상태</th>
                        </tr>
                    </thead>
                   
                    <tbody>
                        <tr>
                            <td>test</td>
                            <td>test</td>
                            <td>test</td>
                            <td>배송 준비중</td>
                        </tr>
                        <!-- 추가 주문 데이터 -->
                        
                    </tbody>
                   
                </table>
            </div>
        </div>
	</div>

</body>

<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>

</html>