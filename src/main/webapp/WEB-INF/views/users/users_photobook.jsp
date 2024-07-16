<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>포토북 제작 - 포토북 제작 서비스</title>
    <link type="text/css" 
		rel="stylesheet" 
		href='<c:url value="/css/photobook_style.css"/>'>
</head>

<body>
    <c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>

    <main>
        <section class="photobook-container">
            <h2>포토북 제작</h2>
            <form action="<c:url value='/users/create_photobook'/>" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="size">사이즈 선택:</label>
                    <select id="size" name="size">
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="B">B</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="cover">커버 재질 선택:</label>
                    <select id="cover" name="cover">
                        <option value="linen">천</option>
                        <option value="leather">가죽</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="color">색깔 선택:</label>
                    <select id="color" name="color">
                        <option value="blue">파란색</option>
                        <option value="gray">회색</option>
                        <option value="brown">갈색</option>
                    </select>
                </div>
                <div class="form-group">
                <!--form method="post" enctype="multipart/form-data"-->
                    <label for="photos">사진 업로드:</label>
                    <input type="file" id="photos" name="photos" accept="image/*" onchange="showImage" multiple required>
                </div>
                
                <div class="form-group">
                    <button type="submit">포토북 제작</button>
                </div>
            </form>
        </section>
    </main>
    
 	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>