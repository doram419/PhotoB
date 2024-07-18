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
			<form action="<c:url value='/users/create_photobook'/>" method="post">
				<div class="form-group">
					<label for="material">커버 재질:</label> <select id="material"
						name="material">
						<option value="LINEN">린넨</option>
						<option value="LEATHER">가죽</option>
						<option value="HARD">하드</option>
						<option value="SOFT">소프트</option>
					</select>
				</div>
				<div class="form-group">
					<label for="albumSize">사이즈:</label> <select id="albumSize"
						name="albumSize">
						<option value="S">S</option>
						<option value="M">M</option>
						<option value="B">B</option>
					</select>
				</div>
				<div class="form-group">
					<label for="color">색상:</label> <select id="color" name="color">
						<option value="GRAY">회색</option>
						<option value="BLUE">파란색</option>
						<option value="BROWN">갈색</option>
					</select>
				</div>
				<div class="form-group">
					<label for="quantity">수량:</label> <input type="number"
						id="oQuantity" name="oQuantity" min="1" max="100" value="1" required>
				</div>
				<div class="form-group">
					<button type="submit">포토북 제작</button>
				</div>
			</form>
		</section>

		<script>
		document.addEventListener('DOMContentLoaded', function() {
		  const material = document.getElementById('material');
		  const albumSize = document.getElementById('albumSize');
		  const color = document.getElementById('color');

		  function updateOptions() {
		    const materialValue = material.value;
		    albumSize.innerHTML = '';
		    ['S', 'M', 'B'].forEach(s => {
		      if (!(materialValue === 'LINEN' && s === 'B') &&
		          !(materialValue === 'SOFT' && s === 'B')) {
		        const option = document.createElement('option');
		        option.value = s;
		        option.textContent = s;
		        albumSize.appendChild(option);
		      }
		    });

		    color.innerHTML = '';
		    if (materialValue === 'LEATHER') {
		      ['GRAY', 'BROWN'].forEach(c => {
		        const option = document.createElement('option');
		        option.value = c;
		        option.textContent = c === 'GRAY' ? '회색' : '갈색';
		        color.appendChild(option);
		      });
		    } else {
		      ['GRAY', 'BLUE', 'BROWN'].forEach(c => {
		        const option = document.createElement('option');
		        option.value = c;
		        option.textContent = c === 'GRAY' ? '회색' : (c === 'BLUE' ? '파란색' : '갈색');
		        color.appendChild(option);
		      });
		    }
		  }

		  material.addEventListener('change', updateOptions);
		  updateOptions();
		});
		</script>
	</main>

	<c:import url="/WEB-INF/views/users/includes/users_footer.jsp"></c:import>
</body>
</html>