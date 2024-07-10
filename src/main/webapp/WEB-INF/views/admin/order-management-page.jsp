<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 관리</title>
	<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/common-style.css"/>'/>
</head>

<body> 
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	
    <div class="main-content">
        <div class="header">
            <h2>주문 관리</h2>
        </div>
        <div class="card">
            <div class="card-header">주문 검색</div>
            <div class="card-body">
                <form>
                    <div class="form-group">
                        <input type="text" placeholder="주문번호 또는 고객ID 검색">
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
                        <tr>
                            <td>1001</td>
                            <td>김철수</td>
                            <td>2024-07-09 15:30</td>
                            <td>배송중</td>
                            <td>50,000원</td>
                            <td>
                                <button class="btn btn-primary">상세보기</button>
                                <button class="btn btn-primary">상태변경</button>
                            </td>
                        </tr>
                        <!-- 추가 주문 데이터 -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
   
	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</body>
</html>