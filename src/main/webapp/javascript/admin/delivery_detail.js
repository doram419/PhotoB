/**
 * - 설명 - 
 * 관리자:배송 상세 페이지(views/admin/delivery_detail.jsp)에서 사용하는 javascript입니다.
 */

window.addEventListener("load", event => {
	document.getElementById("confirm-btn")
			.addEventListener("click", event => 
			{
				editAble(event);
			});
});

function editAble(event){
	let target = event.target;
	let Node = target.parentElement.previousElementSibling.firstElementChild;
	
	if(target.innerText == "수정")
	{
		Node.disabled= false;
		target.innerText = "확인";
	} else {
		Node.disabled= true;
		target.innerText = "수정";
	}
}
