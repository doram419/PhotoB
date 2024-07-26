/**
 * 
 */
function showLoginMessage() {
           alert("로그인 후 이용 가능합니다");
       }

       function getImageFileName(albumId) {
       	switch(albumId) {
           case "A001":
           case "A003":
               return "린넨회색.jpeg";
           case "A002":
           case "A005":
               return "린넨파란색.jpeg";
           case "A004":
           case "A006":
               return "린넨갈색.jpeg";
           case "A007":
           case "A009":
           case "A011":
               return "가죽회색.jpeg";
           case "A008":
           case "A010":
           case "A012":
               return "가죽갈색.jpeg";
           case "A013":
           case "A016":
           case "A019":
               return "하드회색.jpeg";
           case "A014":
           case "A017":
           case "A020":
               return "하드파란색.jpeg";
           case "A015":
           case "A018":
           case "A021":
               return "하드갈색.jpeg";
           case "A022":
           case "A025":
               return "소프트회색.jpeg";
           case "A023":
           case "A026":
               return "소프트파란색.jpeg";
           case "A024":
           case "A027":
               return "소프트갈색.jpeg";
           default:
               return "default.jpeg";
       }
       }

       var topAlbums = [
           <c:forEach items="${topAlmubs}" var="album" varStatus="status">
               "${album.ALBUM_ID}"${!status.last ? ',' : ''}
           </c:forEach>
       ];

       document.addEventListener('DOMContentLoaded', function() {
           var popularTemplatesDiv = document.getElementById('popularTemplates');
           topAlbums.forEach(function(albumId) {
               var templateItem = document.createElement('div');
               templateItem.className = 'template-item';
               
               var img = document.createElement('img');
               var fileName = getImageFileName(albumId);
               img.src = '${pageContext.request.contextPath}/resources/images/' + fileName;
               img.alt = '인기 템플릿 ' + albumId;
               
               var p = document.createElement('p');
               p.textContent = fileName.replace('.jpeg', '');
               
               templateItem.appendChild(img);
               templateItem.appendChild(p);
               popularTemplatesDiv.appendChild(templateItem);
           });
       });