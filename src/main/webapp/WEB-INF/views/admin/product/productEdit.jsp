<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="ko">

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
	<div class="main-content">
		<div class="header">
			<h2>제품 수정</h2>
	</div>		
	<section id="update">
		<form action="<c:url value='/admin/product/productEdit'/>" id="form1" name="form1" enctype="multipart/form-data" method="post">
			<table class="table">
				<tr>
					<td>상품이미지</td>
					<td><input type="file" name="albumPhoto" id="albumPhoto"></td>
				</tr>
				<tr>
					<td>상품코드</td>
					<td><input type="text" name="albumId" id="albumId" value="${album.albumId}"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="albumPrice" id="albumPrice" value="${inventory.albumPrice}"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="확인">
					<input type="button" id="deleteBtn" value="삭제"
					onclick="location.href='<c:url value='/admin/product/delete?albumId='/>${album.albumId}'">
					<input type="button" id="listBtn" value="상품목록"
					onclick="location.href='<c:url value='/admin/products/search'/>'">
					</td>
				</tr>
			</table>
		</form>
	</section>
</div>
</body>
<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</html>