<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Board</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link type="text/css" rel="stylesheet" href="<c:url value="/css/board.css"/>">
	<script src="<c:url value='/javascript/users/user.js'/>"></script>
</head>
<body>
	<form method="POST" action="<c:url value="/users/modify"/>" id="boardModify">

	<input type="hidden" name="userId" value="${vo['boardVo'].userId }">
	<input type="hidden" name="boardId" value="${vo['boardVo'].boardId }">

		<table border="1" width="640">
			<tr>
				<td colspan="2"><h3>게시판</h3></td>
			</tr>
			<tr>
				<th colspan="2">글수정</th>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${vo['boardVo'].title }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea id="content" name="content">${vo['boardVo'].content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="<c:url value="/users/boardList"/>" onclick="boardCancel(event)">취소</a>
					<input type="submit" onclick="boardModify(event)" value="수정">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
