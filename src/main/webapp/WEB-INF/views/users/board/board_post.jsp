<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
	
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- TODO: 글 제목과 연결 
    	<title>${title}</title>
    	-->
    <title>글 내용 페이지</title>
    <!-- 여기 변경 -->
    
  	<link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/common-style.css"/>'>
</head>

<body>
	<c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>
	
	<h1>${title}</h1>
   
    <div class="main-content">
	    <form method="POST" action="<c:url value="/board/write"/>" >
	    	<label for="title">글 제목</label>
	   		<input type="text" id="title" name="title" required>
	   		<br>
	   		<label for="content">글 내용</label>
	   		<textarea id="content" name="content" rows="10" col="50">문의사항은 여기 적어주세요</textarea>
	        <button type="submit">글 작성</button>
	    </form>
    </div>
    
    <c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>

</html>
