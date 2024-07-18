<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 대시보드</title>
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
            <div class="card-header">최근 주문 내역</div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>주문번호</th>
                            <th>고객명</th>
                            <th>주문일시</th>
                            <th>주문상태</th>
                        </tr>
                    </thead>
                   <c:forEach items="${orderDetail}" var="orderDetailVo">
                    <tbody>
                        <tr>
                            <td>${orderDetailVo.orderId }</td>
                            <td>${orderDetailVo.userName }</td>
                            <td>${orderDetailVo.orderDate }</td>
                            <td>${orderDetailVo.status }</td>
                        </tr>
                        <!-- 추가 주문 데이터 -->
                    </tbody>
                   </c:forEach>
                </table>
            </div>
        </div>
        <div class="card">
            <div class="card-header">최근 회원 가입 내역</div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>회원ID</th>
                            <th>이름</th>
                            <th>가입일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>user001</td>
                            <td>이영희</td>
                            <td>2024-07-08</td>
                        </tr>
                        <!-- 추가 회원 데이터 -->
                    </tbody>	
                </table>
            </div>
        </div>
    </div>
    
	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import> 
</body>
</html>
