<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>포토북 제작 - 사진 업로드 및 미리보기</title>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/create_photobook_style.css"/>'>
<link rel="stylesheet" href="<c:url value='/css/header_footer.css'/>">

<style>
/* 팝업 스타일 */
.popup {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: white;
	padding: 20px;
	border: 1px solid #ccc;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	z-index: 1000;
}

.popup h2 {
	margin-top: 0;
}

.popup-buttons {
	text-align: right;
	margin-top: 20px;
}

.popup-buttons button {
	margin-left: 10px;
}

.overlay {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	z-index: 999;
}
</style>
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
		<form id="orderForm" action="<c:url value='/users/photobookOrder'/>"
		method="post" enctype="Multipart/form-data">
			<input type="hidden" id="selectedStyle" name="selectedStyle">
			<input type="hidden" name="albumId" value="${sessionScope.albumId}">
			<input type="hidden" name="userId"
				value="${sessionScope.authUser.userId}">
			<input type="file" id="photoUpload" accept=".jpeg, .jpg" required="required" multiple/>
		</form>
		<button type="button" id="img-add-btn">사진 추가</button>
		
	</div>

	<div class="preview-section">
		<h2>미리보기</h2>
		<div class="preview-container">
			<!-- 여기에 미리보기 이미지들이 동적으로 추가됩니다 -->
		</div>
	</div>
	<div class="img-list">
	</div>
	<div class="nav-buttons">
		<button id="prevPage">이전 페이지</button>
		<button id="nextPage">다음 페이지</button>
	</div>
		<button type="button" id="createButton" 
		class="create-button" form="orderForm">제작 완료
		</button>
	<!-- 팝업 -->
	<div class="overlay" id="overlay"></div>
	<div class="popup" id="confirmationPopup">
		<h2>주문 정보 확인</h2>
		<div id="orderDetails"></div>
		<div class="popup-buttons">
			<button id="cancelOrder">취소</button>
			<button id="confirmOrder">확인</button>
		</div>
	</div>

	<script>
        const material = "${param.material}";
        const albumSize = "${param.albumSize}";
        const color = "${param.color}";

        const photoUpload = document.getElementById('photoUpload');
        const previewContainer = document.querySelector('.preview-container');
        const styleOptions = document.querySelectorAll('input[name="style"]');
        const selectedStyleInput = document.getElementById('selectedStyle');
        const createButton = document.getElementById('createButton');
        const confirmationPopup = document.getElementById('confirmationPopup');
        const overlay = document.getElementById('overlay');
        const cancelOrderButton = document.getElementById('cancelOrder');
        const confirmOrderButton = document.getElementById('confirmOrder');
        const orderForm = document.getElementById('orderForm');

        var imgAddbtn = document.getElementById('img-add-btn');
        console.log(imgAddbtn)
        var imgList = document.getElementById('img-list');
        var imgCount = 1;
        
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
                    img.style.width = '200px'; // 미리보기 이미지 크기 조정
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

        // 제작 완료 버튼 클릭 시 팝업 표시
        createButton.addEventListener('click', function() {
            const orderDetails = document.getElementById('orderDetails');
            orderDetails.innerHTML = `
                <p>커버 재질: ${param.material}</p>
                <p>사이즈: ${param.albumSize}</p>
                <p>색상: ${param.color}</p>
               <p>주문 수량: ${param.oQuantity}개</p>
           
            `;
            confirmationPopup.style.display = 'block';
            overlay.style.display = 'block';
        });

        // 취소 버튼 클릭 시 팝업 닫기
        cancelOrderButton.addEventListener('click', function() {
            confirmationPopup.style.display = 'none';
            overlay.style.display = 'none';
        });

        // 확인 버튼 클릭 시 주문 처리
        confirmOrderButton.addEventListener('click', function() {
            orderForm.submit();
        });
        
        imgAddbtn.addEventListener('click', function(){
        	var radio = document.createElement("input")
        	radio.type = "radio";
        	radio.name = "created-img";
        	radio.innerText = imgCount + "페이지"
        	imgCount = imgCount + 1;
        	//var newImg = document.createElement("img");
        });
    </script>

	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp" />
</body>
</html>