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
		href='<c:url value="/css/board_modify.css"/>'>
</head>

<body>
	<c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>
    <h1>글 작성 페이지</h1>
    
    <!-- 게시글을 나타낼 수 있는 vo 작성  -->
    <div class="main-content">
	    <form method="POST" action="<c:url value="/admin/board/write"/>" >
	    	<label for="title">글 제목</label>
	   		<input type="text" id="title" name="title" required>
	   		<br>
	   		<label for="content">글 내용</label>
	   		<textarea id="content" name="content" rows="10" col="50">문의사항은 여기 적어주세요</textarea>
	        <button type="submit">글 작성</button>
	    </form>
    </div>
    
    <p> <a href="<c:url value="/admin/boardList"/>">돌아가기</a> </p>
    <p><a href="<c:url value="/admin/cs"/>">관리자 페이지로</a></p>
    
    <c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>

</html>
