
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
            success: function() {
                location.href = "/";
            },
            error: function(err) {
                console.error("에러 발생:", err);
                alert("로그인에 실패했습니다.");
            }
        });


});
