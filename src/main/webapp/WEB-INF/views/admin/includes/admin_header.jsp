<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/header_footer.css"/>'/>
</head>

<div class="sidebar">
    <div class="sidebar-header">
        <h3>관리자 패널</h3>
    </div>
    <ul class="sidebar-menu">
	    <li><a href="<c:url value="/admin/home"/>">대시보드</a></li>
	    <li><a href="<c:url value="/admin/cm"/>">고객 관리</a></li>
	    <li><a href="<c:url value="/admin/om"/>">주문 관리</a></li>
	    <li><a href="<c:url value="/admin/cs"/>">고객 센터</a></li>
	    <li><a href="<c:url value="/admin/dash"/>">설정</a></li>
    </ul>
</div>