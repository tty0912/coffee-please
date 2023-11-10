function loginHandler(event) {
    let userId = document.querySelector('#userId');
    let userPassword = document.querySelector('#userPassword');
    let loginMsg = document.querySelector('#loginMsg');
    let loginLabels = document.querySelectorAll('.login__label');
    let loginIcons = document.querySelectorAll('.login__icon');  // 이 부분을 수정

    let msg = '';

    loginMsg.innerHTML = '';

    // 모든 에러 클래스 제거
    loginLabels.forEach(label => label.classList.remove('error'));
    loginIcons.forEach(icon => icon.classList.remove('error'));

    if (userId.value === '' && userPassword.value === '') {
        msg = '<i class="fa-solid fa-triangle-exclamation"></i> 아이디와 비밀번호를 모두 입력해야 합니다.';
        loginLabels[0].classList.add('error');
        loginIcons[0].classList.add('error');
        loginLabels[1].classList.add('error');
        loginIcons[1].classList.add('error');
    } else if (userId.value === '') {
        msg = '<i class="fa-solid fa-triangle-exclamation"></i> 아이디를 입력해주세요.';
        userId.value = '';
        loginLabels[0].classList.add('error');
        loginIcons[0].classList.add('error');
    } else if (userPassword.value === '') {
        msg = '<i class="fa-solid fa-triangle-exclamation"></i> 비밀번호를 입력해주세요.';
        userPassword.value = '';
        loginLabels[1].classList.add('error');
        loginIcons[1].classList.add('error');
    }

    if (msg !== '') {
        event.preventDefault();
        loginMsg.innerHTML = msg;
    }
}

function init() {
    let loginForm = document.querySelector('#loginForm');
    loginForm.addEventListener('submit', loginHandler);
}

init();
