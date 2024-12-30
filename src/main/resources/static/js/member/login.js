
const signupForm = document.getElementById('login-form');
const usernameInput = document.getElementById('login-username');
const passwordInput = document.getElementById('login-password');



// 로그인 폼 제출 (AJAX)
signupForm.addEventListener('submit', (event) => {
    event.preventDefault();
// 'role' 이름을 가진 라디오 버튼에서 체크된 값 가져오기
    const role = document.querySelector('input[name="role"]:checked').value;

    const username = usernameInput.value;
    const password = passwordInput.value;


        // 유효성 검사 통과 후 회원가입 정보를 서버에 AJAX로 전송
        const userData = {
            id: username,
            password: password,
            role: role,
        };

        fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userData), // 회원가입 데이터를 JSON으로 전송
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    // 회원가입 성공
                    alert('로그인이 완료되었습니다!');
                    location.href = "/"; // 로그인 페이지로 리디렉션
                } else {
                    // 서버에서 실패 메시지 처리
                    alert('로그인에 실패했습니다. 다시 시도해주세요.');
                }
            })
            .catch(error => {
                console.error('로그인 오류:', error);
                alert('서버 오류가 발생했습니다. 나중에 다시 시도해주세요.');
            });

});
