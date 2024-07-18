<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포토북 제작 - 사진 업로드 및 미리보기</title>
    <link type="text/css" rel="stylesheet" href='<c:url value="/css/create_photobook_style.css"/>'>
    <link rel="stylesheet" href="<c:url value='/css/header_footer.css'/>">
</head>
<body>
    <c:import url="/WEB-INF/views/users/includes/users_header.jsp" />

    <h1>포토북 제작 - 사진 업로드 및 미리보기</h1>

    <div class="selected-options">
        <h2>선택된 옵션</h2>
        <p>커버 재질: ${param.material}</p>
        <p>사이즈: ${param.albumSize}</p>
        <p>색상: ${param.color}</p>
    </div>

    <div class="upload-section">
        <h2>사진 업로드</h2>
        <input type="file" id="photoUpload" accept="image/*" multiple>
    </div>

    <div class="preview-section">
        <h2>미리보기</h2>
        <div class="preview-container">
            <!-- 여기에 미리보기 이미지들이 동적으로 추가됩니다 -->
        </div>
    </div>

    <div class="style-options">
        <label><input type="radio" name="style" value="1" checked> 1장</label>
        <label><input type="radio" name="style" value="2"> 2장</label>
        <label><input type="radio" name="style" value="3"> 3장</label>
        <label><input type="radio" name="style" value="4"> 4장</label>
    </div>

    <div class="nav-buttons">
        <button id="prevPage">이전 페이지</button>
        <button id="nextPage">다음 페이지</button>
    </div>

    <form action="<c:url value='/users/photobookOrder'/>" method="post">
        <input type="hidden" id="selectedStyle" name="selectedStyle">
        <input type="hidden" name="albumId" value="${sessionScope.albumId}">
        <input type="hidden" name="userId" value="${sessionScope.authUser.userId}">
            
        <button type="submit" class="create-button">제작 완료</button>
    </form>

    <script>
        const material = "${param.material}";
        const albumSize = "${param.albumSize}";
        const color = "${param.color}";

        // 여기에 사진 업로드, 미리보기, 스타일 선택 등의 JavaScript 코드를 추가합니다
        const photoUpload = document.getElementById('photoUpload');
        const previewContainer = document.querySelector('.preview-container');
        const styleOptions = document.querySelectorAll('input[name="style"]');
        const selectedStyleInput = document.getElementById('selectedStyle');

        // 사진 업로드 처리
        photoUpload.addEventListener('change', function(event) {
            previewContainer.innerHTML = ''; // 기존 미리보기 삭제
            const files = event.target.files;
            for (let i = 0; i < files.length; i++) {
                const file = files[i];
                const reader = new FileReader();
                reader.onload = function(e) {
                    const img = document.createElement('img');
                    img.src = e.target.result;
                    img.style.width = '100px'; // 미리보기 이미지 크기 조정
                    img.style.height = 'auto';
                    previewContainer.appendChild(img);
                }
                reader.readAsDataURL(file);
            }
        });

        // 스타일 선택 처리
        styleOptions.forEach(option => {
            option.addEventListener('change', function() {
                selectedStyleInput.value = this.value;
                // 여기에 선택된 스타일에 따른 미리보기 업데이트 로직 추가
            });
        });

        // 초기 스타일 설정
        selectedStyleInput.value = document.querySelector('input[name="style"]:checked').value;
    </script>

    <c:import url="/WEB-INF/views/users/includes/users_footer.jsp" />
</body>
</html>