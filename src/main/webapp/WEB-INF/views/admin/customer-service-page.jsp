<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
    
<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객 센터</title>
    <link rel="stylesheet" href="/admin.css/common-style.css">
</head>

<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>

    <div class="main-content">
        <div class="header">
            <h2>고객 센터</h2>
        </div>
        <div class="card">
            <div class="card-header">문의 검색</div>
            <div class="card-body">
                <form action="searchInquiry.jsp" method="GET">
                    <div class="form-group">
                        <input type="text" name="searchTerm" placeholder="문의 번호 또는 고객ID 검색">
                    </div>
                    <button type="submit" class="btn btn-primary">검색</button>
                </form>
            </div>
        </div>
        <div class="card">
            <div class="card-header">문의 목록</div>
            <div class="card-body">
                <table class="table">
                    <thead>
                        <tr>
                            <th>문의번호</th>
                            <th>고객명</th>
                            <th>제목</th>
                            <th>접수일</th>
                            <th>상태</th>
                            <th>작업</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%-- 여기에 문의 데이터를 동적으로 생성하는 Java 코드를 추가할 수 있습니다 --%>
                        <tr>
                            <td>1</td>
                            <td>박영희</td>
                            <td>배송 관련 문의</td>
                            <td><%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %></td>
                            <td>답변대기</td>
                            <td>
                                <button class="btn btn-primary" onclick="location.href='inquiryDetail.jsp?id=1'">상세보기</button>
                                <button class="btn btn-primary" onclick="location.href='respondInquiry.jsp?id=1'">답변하기</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</body>

</html>