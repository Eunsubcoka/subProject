document.querySelector('.unique-dropdown-btn').addEventListener('click', function () {
    const dropdownContent = document.querySelector('.unique-dropdown-content');
    if (dropdownContent.style.display === 'block') {
        dropdownContent.style.display = 'none';
    } else {
        dropdownContent.style.display = 'block';
    }
});

    // 로그아웃 버튼 클릭 시 AJAX 요청
    $('#logoutBtn').on('click', function () {
    $.ajax({
        url: '/api/logout',
        type: 'POST',
        success: function (response) {
            alert(response); // 로그아웃되었습니다.
            // 메인 페이지로 리다이렉트
            window.location.href = '/';
        },
        error: function () {
            alert('로그아웃 중 오류가 발생했습니다.');
        }
    });
});
