<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 관리</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="sidebar">
        <div class="sidebar-header">
            <h3>관리자 패널</h3>
        </div>
        <ul class="sidebar-menu">
            <li><a href="index.jsp">대시보드</a></li>
            <li><a href="customers.jsp">고객 관리</a></li>
            <li><a href="orders.jsp">주문 관리</a></li>
            <li><a href="customer-service.jsp">고객 센터</a></li>
        </ul>
    </div>
    <div class="main-content">
        <div class="header">
            <h2>주문 관리</h2>
        </div>
        <div class="card">
            <div class="card-header">주문 검색</div>
            <div class="card-body">
                <form action="searchOrder.jsp" method="GET">
                    <div class="form-group">
                        <input type="text" name="searchTerm" placeholder="주문번호 또는 고객ID 검색">
                    </div>
                    <button type="submit" class="btn btn-primary">검색</button>
                </form>
            </div>
        </div>
        <div class="card">
            <div class="card-header">주문 목록</div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>주문번호</th>
                            <th>고객명</th>
                            <th>주문일시</th>
                            <th>주문상태</th>
                            <th>총액</th>
                            <th>작업</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%-- 여기에 주문 데이터를 동적으로 생성하는 Java 코드를 추가할 수 있습니다 --%>
                        <tr>
                            <td>1001</td>
                            <td>김철수</td>
                            <td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()) %></td>
                            <td>배송중</td>
                            <td>50,000원</td>
                            <td>
                                <button class="btn btn-primary" onclick="location.href='orderDetail.jsp?id=1001'">상세보기</button>
                                <button class="btn btn-primary" onclick="location.href='changeOrderStatus.jsp?id=1001'">상태변경</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
