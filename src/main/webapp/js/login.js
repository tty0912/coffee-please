function loginHandler(event) {
	let userId = document.querySelector('#userId');
	let userPassword = document.querySelector('#userPassword');
	let loginMsg = document.querySelector('#loginMsg');
	
	loginMsg.innerHTML = '';
	
	if(userId == null || userPassword == null){
		userId.value = '';
		userPassword.value = '';
		
		loginMsg = '아이디와 비밀번호를 모두 입력해야 합니다.';
		inputCheck = false;
	}
	
	if(!inputCheck) {
		event.preventDefault();
		msgDiv.innerHTML = msg;
	}
}
		
function init() {
	let loginButton = document.querySelector('#loginButton');
	console.log(loginButton);
	loginButton.addEventListener('submit', loginHandler);
}

window.addEventListener('load', init);
	
	