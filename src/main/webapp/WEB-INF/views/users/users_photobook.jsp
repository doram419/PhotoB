<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="ko">

<head>
<meta charset="UTF-8">
<title>포토북 제작 - 포토북 제작 서비스</title>
<link type="text/css" rel="stylesheet"
	href='<c:url value="/css/photobook_style.css"/>'>
</head>

<body>
	<c:import url="/WEB-INF/views/users/includes/users_header.jsp"></c:import>

	<main>
		<section class="photobook-container">
			<h2>포토북 제작</h2>
			<form action="<c:url value='/users/create_photobook'/>" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="material">커버 재질:</label> <select
						id="material" name="material">
						<option value="linen">린넨</option>
						<option value="leather">가죽</option>
						<option value="hard">하드</option>
						<option value="soft">소프트</option>
					</select>
				</div>
				<div class="form-group">
					<label for="albumSize">사이즈:</label> <select id="albumSize" name="albumSize">
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="L">L</option>
					</select>
				</div>
				<div class="form-group">
					<label for="color">색상:</label> <select id="color" name="color">
						<option value="gray">회색</option>
						<option value="blue">파란색</option>
						<option value="brown">갈색</option>
					</select>
				</div>
				<div class="form-group">
					<button type="submit">포토북 제작</button>
				</div>
			</form>
		</section>

		<script>
            document.addEventListener('DOMContentLoaded', function() {
                const material = document.getElementById('material');
                const size = document.getElementById('size');
                const color = document.getElementById('color');

                function updateOptions() {
                    const materialValue = coverMaterial.value;
                    size.innerHTML = '';
                    ['S', 'M', 'L'].forEach(s => {
                        if (!(materialValue === 'linen' && s === 'L') && 
                            !(materialValue === 'soft' && s === 'L')) {
                            const option = document.createElement('option');
                            option.value = s;
                            option.textContent = s;
                            size.appendChild(option);
                        }
                    });
                    
                    color.innerHTML = '';
                    if (materialValue === 'leather') {
                        ['gray', 'brown'].forEach(c => {
                            const option = document.createElement('option');
                            option.value = c;
                            option.textContent = c === 'gray' ? '회색' : '갈색';
                            color.appendChild(option);
                        });
                    } else {
                        ['gray', 'blue', 'brown'].forEach(c => {
                            const option = document.createElement('option');
                            option.value = c;
                            option.textContent = c === 'gray' ? '회색' : (c === 'blue' ? '파란색' : '갈색');
                            color.appendChild(option);
                        });
                    }
                }

                coverMaterial.addEventListener('change', updateOptions);
                updateOptions();
            });
        </script>
	</main>

	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>