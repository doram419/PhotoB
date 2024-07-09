<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객 관리</title>
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
            <h2>고객 관리</h2>
        </div>
        <div class="card">
            <div class="card-header">고객 검색</div>
            <div class="card-body">
                <form action="searchCustomer.jsp" method="GET">
                    <div class="form-group">
                        <input type="text" name="searchTerm" placeholder="고객명 또는 ID 검색">
                    </div>
                    <button type="submit" class="btn btn-primary">검색</button>
                </form>
            </div>
        </div>
        <div class="card">
            <div class="card-header">고객 목록</div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>이름</th>
                            <th>이메일</th>
                            <th>가입일</th>
                            <th>작업</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%-- 여기에 고객 데이터를 동적으로 생성하는 Java 코드를 추가할 수 있습니다 --%>
                        <tr>
                            <td>1</td>
                            <td>홍길동</td>
                            <td>hong@example.com</td>
                            <td><%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %></td>
                            <td>
                                <button class="btn btn-primary" onclick="location.href='editCustomer.jsp?id=1'">수정</button>
                                <button class="btn btn-primary" onclick="if(confirm('정말로 삭제하시겠습니까?')) location.href='deleteCustomer.jsp?id=1'">삭제</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
