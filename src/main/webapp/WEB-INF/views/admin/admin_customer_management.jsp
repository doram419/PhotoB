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
		href='<c:url value="/css/common_style.css"/>'/>
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
                <form>
                    <div class="form-group">
                        <input type="text" placeholder="고객명 또는 ID 검색">
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
                        <tr>
                            <td>1</td>
                            <td>홍길동</td>
                            <td>hong@example.com</td>
                            <td>2024-07-01</td>
                            <td>
                                <button class="btn btn-primary">수정</button>
                                <button class="btn btn-primary">삭제</button>
                            </td>
                        </tr>
                        <!-- 추가 고객 데이터 -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
  
	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</body>
</html>