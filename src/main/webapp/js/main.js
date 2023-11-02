

//로그인 유효성 검사 + 메시지(임시)
function loginCheckHandler(){
	let msg = '';
	let loginCheck = true;
	let userId = document.querySelector('#userId');
	let userPasswd = document.querySelector('#userPasswd');
	
	if(userId.value === '' || userPasswd.value === ''  ){
		msg = '계정이 잘못되었습니다!';
		userId.value = '';
		userPasswd.value = '';
		
		loginCheck = false;
	}
	
	if(loginCheck){
		
		userId.value = '';
		userPasswd.value = '';
	}
	else {		
		document.querySelector('#msg').innerHTML = msg;
	}
}

function showCategoryListHandler() {
    let categoryList = document.querySelector('#categoryList');
    
    const categoryItems = categoryList.children;
    
    for (let i = 5; i < categoryItems.length; i++) {
        categoryItems[i].style.display = 'none';
    }
}


//국기이미지 다음(>) 버튼 기능
function nextBtnHandler(){
	
	let categoryList = document.querySelector('#categoryList');
	let categoryName = document.querySelector('#categoryName');
	
	categoryList.appendChild(categoryName);
	}
	
//국기 이미지 이전(<) 버튼 기능
function prevBtnHandler() {
    let categoryList = document.querySelector('#categoryList');
    let lastChild = categoryList.lastElementChild;
    let firstChild = categoryList.firstElementChild;

    categoryList.insertBefore(lastChild, firstChild);
}

//자동 전환 국기 이미지
function autoCycleCategoryListHandler(){
	
	let categoryList = document.querySelector('#categoryList');
	let categoryName = document.querySelector('#categoryName');
	
	categoryList.removeChild(categoryName);
	categoryList.appendChild(categoryName);
}
	
	
function seeMoreHandler(){
	let url = '/coffee/beansList';
	
	location.href = url;
}

function categoryListHandler(event){
	let categoryName = event.target.getAttribute('categoryName');
	let url = '/coffee/beansList?categoryName=' + categoryName;
	
	location.href = url;
}

function init(){
	let categoryList = document.querySelector('#categoryList');
	
	let nextBtn = document.querySelector('#nextBtn');
	let prevBtn = document.querySelector('#prevBtn');
	let loginCheck = document.querySelector('#mainIntro__loginForm');
	
	
	/*
	let seeMore = document.querySelector('#seeMore');
	*/
	categoryList.addEventListener('click', categoryListHandler);
	categoryList.addEventListener('load', autoCycleCategoryListHandler);
	categoryList.addEventListener('load', showCategoryListHandler);
	
	//국기이미지 옆 버튼
	nextBtn.addEventListener('click', nextBtnHandler);
	prevBtn.addEventListener('click', prevBtnHandler);
	
	loginCheck.addEventListener('submit', loginCheckHandler);
	/*
	seeMore.addEventListener('click', seeMoreHandler);
	*/
		}
		
window.addEventListener('load', init);

//국기이미지 자동으로 넘어가기, 8초(8000ms)로 설정
setInterval(autoCycleCategoryListHandler, 8000);