<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>재고 관리 시스템</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        form {
            margin-bottom: 20px;
        }
        .btn {
            padding: 8px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h1>재고 관리 시스템</h1>
    
    <h2>재고 현황</h2>
    <table>
        <thead>
            <tr>
                <th>앨범 ID</th>
                <th>앨범 가격</th>
                <th>재고 수량</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${inventory}">
                <tr>
                    <td>${item.albumId}</td>
                    <td>${item.albumPrice}</td>
                    <td>${item.quantity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <h2>재고 추가</h2>
    <form action="${pageContext.request.contextPath}/inventory" method="post">
        <input type="hidden" name="action" value="add">
        앨범 ID: <input type="text" name="albumId" required><br>
        앨범 가격: <input type="text" name="albumPrice" required><br>
        수량: <input type="number" name="quantity" required><br>
        <button type="submit" class="btn">추가</button>
    </form>
    
    <h2>재고 판매</h2>
    <form action="${pageContext.request.contextPath}/inventory" method="post">
        <input type="hidden" name="action" value="sell">
        앨범 ID:
        <select name="albumId" required>
            <c:forEach var="item" items="${inventory}">
                <option value="${item.albumId}">${item.albumId}</option>
            </c:forEach>
        </select><br>
        수량: <input type="number" name="quantity" min="1" required><br>
        <button type="submit" class="btn">판매</button>
    </form>
</body>
</html>
