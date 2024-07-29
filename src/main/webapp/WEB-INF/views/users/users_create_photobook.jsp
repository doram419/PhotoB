<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href='<c:url value="/css/new_create_photobook.css"/>'>
    <script type="text/javascript" 
        src='<c:url value="/javascript/users/create_photobook.js"/>'>
    </script>
</head>
<body>
	<c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>

    <div id="container">
        <div id="canvasArea">
          <h2>포토북 제작</h2>
          <canvas id="mainCanvas"></canvas>
          <button id="addCanvasButton">새 캔버스 추가</button>
        </div>
        <div id="stickerArea">
          <input type="file" id="stickerUpload" accept="image/*" multiple>
          <div id="stickerGallery"></div>
          <div id="stickerPreview"></div>
        </div>
    </div>
      <div id="canvasGallery"></div>
      <button id="createButton">제작</button>
      
   <c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>  
</body>

</html>

