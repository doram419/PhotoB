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
	<form action="<c:url value='/admin/product/update'/>" id="form1" method="post">
    <table class="table" border="1">
        <thead>
            <tr>
                <th>상품이미지</th>
                <th>상품코드</th>
                <th>가격</th>
                <th>재질</th>
                <th>컬러</th>
                <th>앨범사이즈</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><img src="<c:url value="/photobook-images/album//${ProductMap['album'].albumId}/1.jpg"/>" /></td>
                <td><input type="hidden" name="albumId" id="albumId" value="${ProductMap['album'].albumId}">
                	<input type="text" value="${ProductMap['album'].albumId}" disabled></td>
                <td><input type="text" name="price" id="price" value="${ProductMap['inventory'].albumPrice}"></td>
                <td><input type="text" name="material" id="material" value="${ProductMap['album'].material}"></td>
                <td><input type="text" name="color" id="color" value="${ProductMap['album'].color}"></td>
                <td><input type="text" name="albumSize" id="albumSize" value="${ProductMap['album'].albumSize}"></td>
            </tr>
         	<tr>
         		<td><input type="file" name="albumPhoto_${status.index}" id="albumPhoto"></td>
                <td colspan="5" style="text-align: center;">
                    <input type="submit" value="확인"> 
                    <input type="button" id="listBtn" value="상품목록" style="float: right;"
                        onclick="location.href='<c:url value='/admin/products/search'/>'">
                </td>
            </tr>
        </tbody>
      </table>
      </form>
</div>
</body>
<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</html>