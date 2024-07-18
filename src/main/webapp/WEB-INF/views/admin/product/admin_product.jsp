<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 제품 관리</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/common_style.css"/>' />
</head>
<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>


	<div class="main-content">
		<div class="header">
			<h2>대시보드</h2>

			<div class="card-header">제품 검색</div>
			<div class="card-body">
				<form method="get" action="<c:url value='/admin/product/search'/>">
					<div class="form-group">
						<label for="search-category">검색 분류:</label> <select
							id="search-category" name="search-category">
							<option value="ALBUM_ID">상품코드</option>
						</select> <label for="search-input">검색어:</label> <input type="text"
							placeholder="검색어를 입력하세요">
					</div>
					<button type="submit" class="btn btn-primary">검색</button>
					<button type="reset" class="btn btn-secondary">초기화</button>
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-header">제품 목록</div>
			<div class="card-body">
				<table class="table">
					<thead>
						<tr>
							<th>번호</th>
							<th>이미지</th>
							<th>상품코드</th>
							<th>가격</th>
							<th>사이즈</th>
							<th>작업</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="Album" items="${AlbumList}" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>이미지넣기</td>
								<td>${album.albumId}</td>
								<td align="center">${inventory.albumPrice}</td>
								<td>${album.albumSize}</td>
								<td><a
									href="<c:url value='/admin/product/productEdit?albumId=${album.albumId}'/>">
										<button class="btn btn-primary">수정</button>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</html>