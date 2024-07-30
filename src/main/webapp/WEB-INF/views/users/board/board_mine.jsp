<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="ko">

<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="<c:url value='/css/board_style.css' />">
</head>

<body>
	<c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>

	<main>
			
            <h4>내가 쓴 글</h4>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성일</th>
                        <th>상태</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${postList}" var="postMap" varStatus="status">
                        <c:if test="${authUser.userId == postMap['boardVo'].userId}">
                            <tr>
                                <td>${postMap['boardVo'].boardId}</td>
                                <td><a
                                    href="<c:url value="/users/board/post/${postMap['boardVo'].userId}/${postMap['boardVo'].boardId }"/>">${postMap['boardVo'].title}</a></td>
                                <td>${postMap['boardVo'].regDate}</td>
                                <td>${postMap['boardVo'].status}</td>
                                <td>
                                    <a href="<c:url value="/users/board/${postMap['boardVo'].userId}/${postMap['boardVo'].boardId }/modify"/>">수정</a>
                                    <a href="<c:url value="/users/board/${postMap['boardVo'].userId}/${postMap['boardVo'].boardId }/delete"/>">삭제</a>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
      	<div class="board-actions">
			<p>
				<a href="<c:url value="/users/board/write"/>">글쓰기</a>
			</p>
			<p>
				<a href="<c:url value="/users/boardList"/>">목록으로</a>
			</p>
		</div>
	
	</main>
	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>