<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/header_footer.css"/>'>
</head>

<header>
    <h1>PHOTOB</h1>
    <nav>
        <ul>
	    	<li><a href="<c:url value="/users/home"/>">Home</a></li>
    	<c:choose>
    		<c:when test="${not empty authUser}">
	            <li><a href="<c:url value="/users/profile"/>">Profile</a></li>
	            <li><a href="<c:url value="/users/photobook"/>">Creation</a></li>
	            <li><a href="<c:url value="/users/order"/>">Order</a></li>
	            <li><a href="<c:url value="/users/boardList"/>">Board</a></li>
        		<li><a href="<c:url value="/users/logout"/>">Logout</a></li>
		        <c:if test="${sessionScope.authUser.role == 'A'}">
		            <li><a href="<c:url value='/admin/home' />" class="admin-menu">Admin Page</a></li>
		        </c:if>
    		</c:when>
		    <c:otherwise>
		        <li><a href="<c:url value='/users/login' />">로그인로고박기</a></li>
		    </c:otherwise>
		</c:choose>
		</ul>
	</nav>
</header>