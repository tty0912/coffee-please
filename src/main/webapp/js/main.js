
//1~5등 이미지 연결
function bestBeansImgHandler(){
	const images = ["/coffee/images/number1.png", "/coffee/images/number2.png", 
					"/coffee/images/number3.png", "/coffee/images/number4.png", 
					"/coffee/images/number5.png"];
	
	const bestBeans = document.querySelectorAll('.mainBeanBest__product');

    bestBeans.forEach((bean, index) => {
        const img = bean.querySelector('.beanBest__number');
            img.src = images[index];  
    });
}

//국기이미지 다음(>) 버튼 기능
function nextBtnHandler(){
	
	let categoryList = document.querySelector('#categoryList');
    let firstChild = categoryList.firstElementChild;

    categoryList.insertBefore(firstChild , null);
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
    let firstChild = categoryList.firstElementChild;

    categoryList.insertBefore(firstChild , null);
}
	
	
function seeMoreHandler(){
	let url = '/coffee/goProductList?';
	
	location.href = url;
}

function categoryListHandler(event){
	let categoryNum = event.target.getAttribute('categoryNum');
	let url = '/coffee/goProductList?category=' + categoryNum;
	
	location.href = url;
}

function init(){
	let categoryList = document.querySelector('#categoryList');
	
	let nextBtn = document.querySelector('#nextBtn');
	let prevBtn = document.querySelector('#prevBtn');
	let loginCheck = document.querySelector('#mainIntro__loginForm');
	
	let seeMore = document.querySelector('mainBeanBest__plusButton');

	categoryList.addEventListener('click', categoryListHandler);
	categoryList.addEventListener('load', autoCycleCategoryListHandler);
	
	//국기이미지 옆 버튼
	nextBtn.addEventListener('click', nextBtnHandler);
	prevBtn.addEventListener('click', prevBtnHandler);
	
	loginCheck.addEventListener('submit', loginCheckHandler);

	seeMore.addEventListener('click', seeMoreHandler);
	
	
		}
		
window.addEventListener('load', init);

//국기이미지 자동으로 넘어가기, 8초(8000ms)로 설정
setInterval(autoCycleCategoryListHandler, 8000);

bestBeansImgHandler();