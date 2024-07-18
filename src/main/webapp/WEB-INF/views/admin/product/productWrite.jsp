<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/common_style.css"/>' />
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	
	<h2>상품 등록</h2>
	<form action="" id="form1" name="form1" enctype="multipart/form-data" method="post">
		<table border="1">
			<tr> 
				<td>상품명</td>
				<td><input type="text" name="productName" id="productName"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="productPrice" id="productPrice"></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><textarea rows="5" cols="60" name="productDesc" id="productDesc"></textarea></td>
			</tr>
			<tr>
				<td>상품이미지</td>
				<td><input type="file" name="productPhoto" id="productPhoto"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="등록" id="addBtn">
					<input type="button" value="목록" onclick="location.href='${path}/shop/product/list.do';">
				</td>
			</tr>
		</table>
	</form>
</body>
	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</html>