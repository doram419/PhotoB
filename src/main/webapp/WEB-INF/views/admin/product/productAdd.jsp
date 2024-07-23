<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>제품 추가</title>
    <link type="text/css" rel="stylesheet" href='<c:url value="/css/common_style.css"/>' />
</head>
<body>
    <c:import url="/WEB-INF/views/admin/includes/admin_header.jsp"></c:import>

    <div class="main-content">
        <div class="header">
            <h2>제품 추가</h2>
        </div>
        <div class="card">
            <div class="card-header">새로운 제품 추가</div>
            <div class="card-body">
                <form method="post" action="<c:url value='/admin/products/add'/>">
                    <div class="form-group">
                        <label for="productCode">상품코드</label>
                        <input type="text" id="productCode" name="productCode" placeholder="상품코드 입력" required>
                    </div>
                    <div class="form-group">
                        <label for="price">가격</label>
                        <input type="number" id="price" name="price" placeholder="가격 입력" required>
                    </div>
                    <div class="form-group">
                        <label for="size">사이즈</label>
                        <input type="text" id="size" name="size" placeholder="사이즈 입력" required>
                    </div>
                    <div class="form-group">
                        <label for="imageUrl">이미지 URL</label>
                        <input type="text" id="imageUrl" name="imageUrl" placeholder="이미지 URL 입력">
                    </div>
                    <button type="submit" class="btn btn-success">추가</button>
                </form>
            </div>
        </div>
    </div>

    <c:import url="/WEB-INF/views/admin/includes/admin_footer.jsp"></c:import>
</body>
</html>
