/**
 * - 설명 - 
 * 관리자:배송 상세 페이지(views/admin/delivery_detail.jsp)에서 사용하는 javascript입니다.
 */

window.addEventListener("load", event => {
		console.log("로드됨");
		
		document.getElementById("confirm-shipmentId")
			.addEventListener("click", event => 
			{
				const target = event.target;
				console.log(target);
				const Node = target.parentElement.previousElementSibling.firstElementChild;

				Node.disabled= false;
			});
});

function editAble(event){
	event.target.disalbe='true';
}

