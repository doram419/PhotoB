<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품관리 수정</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/common_style.css"/>' />
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	
	<h2>상품 수정</h2>
	<form action="" id="form1" name="form1" enctype="multipart/form-data" method="post">
		<table border="1">
			<tr>
				<td>상품이미지</td>
				<!-- <td><input type="file" name="albumPhoto" id="albumPhoto"></td> -->
			</tr>
			<tr> 
				<td>상품코드</td>
				<td><input type="text" name="albumId" id="albumId"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="albumPrice" id="albumPrice"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="albumId" value="${vo.albumId}">
					<input type="button" id="editBtn" value="수정">
					<input type="button" id="deleteBtn"value="삭제">
					<input type="button" id="listBtn" value="상품목록">
				</td>
			</tr>
		</table>
	</form>
</body>
	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</html>