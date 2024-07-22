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
<script>
	$(document).ready(function() {
		$("#editBtn").click(function() {
			var albumId = $("#albumId").val();
			var albumPrice = $("#albumPrice").val();
			var albumPhoto = $("#albumPhoto").val();

			if (albumId == "") {
				alert("상품명을 입력해주세요");
				$("#albumId").foucs();
			} else if (albumPrice == "") {
				alert("상품 가격을 입력해주세요");
				$("#albumPrice").focus();
			} /* else if (albumPhoto == "") {
				alert("상품 사진을 입력해주세요");
				$("#albumPhoto").focus();
			} */
			document.form1.action = "${path}/admin/product/productUpdate.do";
			document.form1.submit();
		});
		$("#deleteBtn").click(function() {
			if (confirm("상품을 삭제하시겠습니까?")) {
				document.form1.action = "${path}/admin/product/productDelete.do";
				document.form1.submit();
			}
		});
		$("#listBtn").click(function() {
			location.href = "${path}/admin/products/list.do";
		});
	});
</script>
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>
	<div class="main-content">
		<div class="header">
			<h2>제품 수정</h2>
	</div>		
	<section id="update">
		<form action="" id="form1" name="form1" enctype="multipart/form-data" method="post">
			<table class="table">
				<tr>
					<td>상품이미지</td>
					<td><input type="file" name="albumPhoto" id="albumPhoto"></td>
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
					<input type="button" id="editBtn" value="확인">
					<input type="button" id="deleteBtn" value="삭제">
					<input type="button" id="listBtn" value="상품목록">
					</td>
				</tr>
			</table>
		</form>
	</section>
</div>
</body>
<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</html>