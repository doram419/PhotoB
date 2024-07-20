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
	
	<div class="main-content">
	<!-- postVo 요청 혹은 각 데이터를 요청 -->
	
	<h2>제목 : ${vo['boardVo'].title}</h2>
    <p>글번호 : ${vo['boardVo'].boardId}</p>
    <p>작성자 : ${vo['usersVo'].userName}</p>
    <p>내용 : ${vo['boardVo'].content}</p>
    
    <!-- 댓글 기능 지원 -->
    <hr>
   	<p>댓글</p>
    <table>
    <c:forEach items="${commentList}" var="commentVo" varStatus="status">
		<tr>
			<td>${commentVo.commentId}</td>
			<td>${commentVo.userName}</td>
			<td>${commentVo.content}</td>
			<td>${commentVo.comDate}</td>
		</tr>
	</c:forEach>   
	</table> 
    <hr>
	   
	   
    </div>    
    
    <p><a href="<c:url value="/board"/>">돌아가기</a></p>
 
    <c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>

</html>
