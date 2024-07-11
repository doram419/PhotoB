<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포토북 스타일 미리보기</title>
    <link rel="stylesheet" href="<c:url value='/css/header_footer.css'/>">
</head>
<body>
	
    <c:import url="/WEB-INF/views/users/includes/users_header.jsp"/>
    
    <h1>포토북 스타일 미리보기</h1>
    
    <div class="style-options">
        <label class="style-option">
            <input type="radio" name="style" value="1" checked> 1장
        </label>
        <label class="style-option">  
            <input type="radio" name="style" value="2"> 2장
        </label>
        <label class="style-option">
            <input type="radio" name="style" value="3"> 3장
        </label>
        <label class="style-option">
            <input type="radio" name="style" value="4"> 4장
        </label>
    </div>

    <div class="preview-wrapper">
        <div class="preview-container">
            <div class="preview-page"></div>
            <div class="pagination"></div>
        </div>
    </div>

    <div class="nav-buttons">
        <button id="prevPage">이전 페이지</button>
        <button id="nextPage">다음 페이지</button>
    </div>

    <form action="<c:url value='/users/order'/>" method="post">
        <input type="hidden" id="selectedStyle" name="selectedStyle">
        <button type="submit" class="create-button">제작</button>
    </form>

    <script>
    	// 효원 코드: 이거 잘 몰라서 전부 gpt 돌렸습니다. 포토북 제작툴 기능 구현 가능하신 능력자분 구합니다. 
        const styleOptions = document.querySelectorAll('input[name="style"]');
        const previewPage = document.querySelector('.preview-page');
        const paginationDisplay = document.querySelector('.pagination');
        const prevPageBtn = document.getElementById('prevPage');
        const nextPageBtn = document.getElementById('nextPage');
        const selectedStyleInput = document.getElementById('selectedStyle');

        let currentPage = 1;
        const totalPages = 24;

        function updatePreview() {
            const selectedStyle = document.querySelector('input[name="style"]:checked').value;
            selectedStyleInput.value = selectedStyle;
            
            const numImages = parseInt(selectedStyle);
            const imageSizes = calculateImageSize(numImages);
            
            previewPage.innerHTML = '';

            for (let i = 0; i < numImages; i++) {
                const img = document.createElement('div');
                img.className = 'preview-image';
                img.style.width = `${imageSizes[i].width}%`;
                img.style.height = `${imageSizes[i].height}%`;
                img.style.backgroundImage = `url("<c:url value='/api/placeholder/400/400'/>");`;

                if (numImages === 3 && i === 2) {
                    img.classList.add('bottom');
                }

                previewPage.appendChild(img);
            }

            updatePagination();
        }

        function calculateImageSize(numImages) {
            const gap = 1;

            switch (numImages) {
                case 1:
                    return [{ width: 100, height: 100 }];
                case 2:
                    return [
                        { width: (100 - gap) / 2, height: 100 },
                        { width: (100 - gap) / 2, height: 100 }
                    ];
                case 3:
                    return [
                        { width: (100 - gap) / 2, height: (100 - gap) / 2 },
                        { width: (100 - gap) / 2, height: (100 - gap) / 2 },
                        { width: 100, height: (100 - gap) / 2 }  
                    ];
                case 4:
                    return [
                        { width: (100 - gap) / 2, height: (100 - gap) / 2 },
                        { width: (100 - gap) / 2, height: (100 - gap) / 2 },
                        { width: (100 - gap) / 2, height: (100 - gap) / 2 },
                        { width: (100 - gap) / 2, height: (100 - gap) / 2 }
                    ];
                default:
                    return [];
            }
        }

        function updatePagination() {
            paginationDisplay.textContent = `${currentPage} / ${totalPages}`;
        }

        function prevPage() {
            if (currentPage > 1) {
                currentPage--;
                updatePagination();
            }
        }

        function nextPage() {
            if (currentPage < totalPages) {
                currentPage++;
                updatePagination();
            }
        }

        styleOptions.forEach(option => {
            option.addEventListener('change', updatePreview);
        });

        prevPageBtn.addEventListener('click', prevPage);
        nextPageBtn.addEventListener('click', nextPage);

        updatePreview();
    </script>
</body>
</html>