
function nextBtnHandler(){
	
	let categoryList = document.querySelector('#categoryList');
	let categoryName = document.querySelector('#categoryName');
	
	
	categoryList.appendChild(categoryName);
	}
	
function prevBtnHandler(){
	
	let categoryList = document.querySelector('#categoryList');
	let categoryName = document.querySelector('#categoryName');
	
	categoryList.removeChild(categoryName);
	categoryList.appendChild(categoryName);
	
}

function autoCycleCategoryListHandler(){
	
	let categoryList = document.querySelector('#categoryList');
	let categoryName = document.querySelector('#categoryName');
	
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
	/*
	let seeMore = document.querySelector('#seeMore');
	*/
	categoryList.addEventListener('click', categoryListHandler);
	categoryList.addEventListener('load', autoCycleCategoryListHandler);
	
	nextBtn.addEventListener('click', nextBtnHandler);
	prevBtn.addEventListener('click', prevBtnHandler);
	
	/*
	seeMore.addEventListener('click', seeMoreHandler);
	*/
}

window.addEventListener('load', init);
setInterval(autoCycleCategoryListHandler, 4000);