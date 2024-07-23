<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="ko">

<head>
<meta charset="UTF-8">
<title>제품 수정</title>
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
        <table class="table" border="1">
            <thead>
                <tr>
                    <th>상품이미지</th>
                    <th>상품코드</th>
                    <th>가격</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="file" name="albumPhoto_${status.index}" id="albumPhoto_${status.index}"></td>
                    <td>${album.albumId}</td>
                    <td><input type="text" name="albumPrice_${status.index}" id="albumPrice_${status.index}" value="${inventory.albumPrice}"></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="3" style="text-align: center;">
                    <form action="<c:url value='/admin/product/update'/>" id="form1" name="form1" enctype="multipart/form-data" method="post">
                    	<input type="hidden" name="albumId" value="${album.albumId}">
                        <input type="submit" value="확인">
                        <input type="button" id="deleteBtn" value="삭제"
                            onclick="location.href='<c:url value='/admin/product/delete?albumId='/>${album.albumId}'">
                        <input type="button" id="listBtn" value="상품목록" style="float: right;"
                            onclick="location.href='<c:url value='/admin/products/search'/>'">
                       </form>
                    </td>
                </tr>
            </tfoot>
        </table>
</section>
</div>
</body>
<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</html>