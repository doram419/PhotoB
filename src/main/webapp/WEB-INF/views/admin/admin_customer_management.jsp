<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객 관리</title>
	<link type="text/css" 
		rel="stylesheet" 
		href="<c:url value="/css/common_style.css"/>"/>
</head>

<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
 
    <div class="main-content">
        <div class="header">
            <h2>고객 관리</h2>
        </div>
        <div class="card">
            <div class="card-header">고객 검색</div>
            <div class="card-body">
                <form method="get" action="<c:url value='/admin/search'/>">
                    <div class="form-group">
                    <label for="search-category">검색 분류:</label>
                    <select id="search-category" name="search-category">
                            <option value="all">전체</option>
                            <option value="USER_NAME">이름</option>
                            <option value="USER_ID">회원 ID</option>
                            <option value="EMAIL">이메일</option>
                            <option value="PHONE_NUMBER">핸드폰</option>
                        </select>
                        <label for="search-input">검색어:</label>
                        <input type="text" name="keyword" placeholder="검색어를 입력하세요">
                    </div>
                    <div class="form-group">
                        <label>기간 검색:</label>
                        <select id="date-type" name="date-type">
                            <option value="registration">가입날짜</option>
                        </select>
                        <input type="date" id="start-date" name="start-date">
                        <input type="date" id="end-date" name="end-date">
                    </div>
                    <button type="submit" class="btn btn-primary">검색</button>
                    <button type="reset" class="btn btn-secondary">초기화</button>
                </form>
            </div>
        </div>
        <div class="card">
            <div class="card-header">고객 목록</div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                        	<th>번호</th>
                            <th>이름</th>
                            <th>회원ID</th>
                            <th>이메일</th>
                            <th>핸드폰</th>
                            <th>주소</th>
                            <th>역할</th><!-- 가입일 추가필요 --> 
                            <th>작업</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="user" items="${userList}" varStatus="status">
                        <tr>
                            <!-- <td>${status.index + 1}</td>   -->
                                <td>${user.userName}</td>
                                <td>${user.userId}</td>
                                <td>${user.email}</td>
                                <td>${user.phoneNumber}</td>
                                <td>${user.address}</td>
                                <td>${user.role}</td>
                            <td>
                                <a href="<c:url value='/admin/update?userId=${user.userId}'/>">
                                        <button class="btn btn-primary">수정</button>
                                </a>
                                <a href="<c:url value='/admin/delete?userId=${user.userId}'/>">
                                        <button class="btn btn-danger">삭제</button>
                                </a>
                            </td>
                        </tr>
                      </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
  
	<!--<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>-->
</body>
</html>