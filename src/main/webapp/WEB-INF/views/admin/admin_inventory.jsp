<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>

<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>고객 센터</title>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/common_style.css"/>' />
	
</head>

<body>
	<c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>

	<div class="main-content">
		<div class="header">
			<h2>고객 센터</h2>
		</div>
		<div class="card">
			<div class="card-header">재고 검색</div>
			<div class="card-body">
				<form action="<c:url value="/admin/inventory/search"/>" method="GET">
					<div class="form-group">
						<input type="text" name="keyword" placeholder="고객 이름 검색">
					</div>
					<button type="submit" class="btn btn-primary">검색</button>	
				</form>
				<br>
				<a href="<c:url value="/admin/inventory"/>"><button type="submit" class="btn btn-primary">초기화</button></a>
				
			</div>
		</div>
		<div class="card">
			<div class="card-header">문의 목록</div>
			<div class="card-body">
				<table class="table">
					<thead>
						<tr>
							<th>앨범ID</th>
							<th>가격</th>
							<th>수량</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<%-- 여기에 문의 데이터를 동적으로 생성하는 Java 코드를 추가할 수 있습니다 --%>
						<c:forEach items="${invenList }" var="invenVo" varStatus="status">
							<tr>
								<td>${invenVo.albumId }</td>
								<td>${invenVo.albumPrice }</td>
								<td>${invenVo.aQuantity }</td>
								<td>
								<form action="<c:url value="/admin/inventory/store"/>" method="GET">
								<input type="number" name="aQuantity" value="0"min="0" step="10">
								<input type="hidden" name="albumId" value="${invenVo.albumId }">
								<button class="btn btn-primary">입고</button>
								</form>
				
								</td>
							</tr>
						</c:forEach>
							<tr>
								<td>${invenDetail.albumId }</td>
								<td>${invenDetail.albumPrice }</td>
								<td>${invenDetail.aQuantity }</td>
								<td>
								<button class="btn btn-primary">입고</button>
								</td>
							</tr>
				
					</tbody>
				</table>
			</div>
		</div>
	</div>
	  
	<c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</body>
	<footer>
	<div class="pagination">
        <c:if test="${currentPage > 1}">
            <a href="<c:url value='/admin/inventory?page=${currentPage - 1}&size=10'/>">Previous</a>
        </c:if>
        <span>Page ${currentPage}</span>
        <c:if test="${invenList.size() == 10}">
            <a href="<c:url value='/admin/inventory?page=${currentPage + 1}&size=10'/>">Next</a>
        </c:if>
    </div>
	</footer>
</html>