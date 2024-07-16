<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/header_footer.css"/>'>
</head>

<header>
    <h1>포토북 제작 서비스</h1>
    <nav>
        <ul>
	    	<li><a href="<c:url value="/users/home"/>">홈</a></li>
    	<c:choose>
    		<c:when test="${not empty authUser}">
	            <li><a href="<c:url value="/users/profile"/>">프로필 관리</a></li>
	            <li><a href="<c:url value="/users/photobook"/>">포토북 제작</a></li>
	            <li><a href="<c:url value="/users/order"/>">주문</a></li>
	            <li><a href="<c:url value="/users/board"/>">게시판</a></li>
        		<li><a href="<c:url value="/users/logout"/>">로그아웃</a></li>
		        <c:if test="${sessionScope.user.role == 'A'}">
		            <li><a href="<c:url value='/admin/home' />" class="admin-menu">관리자 페이지</a></li>
		        </c:if>
    		</c:when>
	    <c:otherwise>
	        <li><a href="<c:url value='/users/login' />">로그인/회원가입</a></li>
	    </c:otherwise>
		</c:choose>
		</ul>
	</nav>
</header>