function confirmNavigation(event) {
    event.preventDefault(); // 기본 동작 방지
    const userConfirmed = confirm("해당 게시글로 이동하시겠습니까?");
    if (userConfirmed) {
        window.location.href = event.currentTarget.href; // 사용자가 확인할 경우 링크로 이동
    }
}