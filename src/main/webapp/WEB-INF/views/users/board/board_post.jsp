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
	<h1>${title}</h1>
  
    <p>글번호 : ${no}</p>
    <p>작성자 : ${users_name}</p>
    <p>내용 : ${content}</p>
        
    <!-- 댓글 기능 지원 -->
    <hr>
   	<p>댓글</p>
    <table>
	    <tr>
	    	<td>2</td>
       		<td>답변드립니다</td>
       		<td>관리자</td>
       		<td>2023-06-02</td>
	    </tr>
    <c:forEach items="${commentList}" var="commentVo" varStatus="status">
		<tr>
			<td>${commentVo.no}</td>
			<td>${commentVo.user_name}</td>
			<td>${commentVo.content}</td>
			<td>${commentVo.post_date}</td>
		</tr>
	</c:forEach>   
	</table> 
    <hr>
	    <form method="POST" action="<c:url value="/comment/write"/>" >
	   		<label for="content">댓글 달기</label>
	   		<textarea id="content" name="content" rows="10" col="50">댓글은 여기 적어주세요</textarea>
	        <button type="submit">작성하기</button>
	    </form>
    </div>    
                        
    <p><a href="<c:url value="/board"/>">돌아가기</a></p>
 
    <c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>

</html>
