<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
	
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 작성 페이지</title>
  	<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/common-style.css"/>'>
</head>

<body>
	<c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>
	
    <h1>글 작성 페이지</h1>
    
    <div class="content">
        <p>글 작성하기</p>
    </div>
    
    <c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>
