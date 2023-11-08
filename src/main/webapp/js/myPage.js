


function likeButtonHandler(event) {
	let myPageLike = document.getElementById('myPageLike');
	
	myPageLike.style.display = 'block'; 
}

function purchaseButtonHandler(event) {
	let myPagePurchase = document.getElementById('myPagePurchase');
	
	myPagePurchase.style.display = 'block'; 
}

function purchaseGroupButtonHandler(event) {
	let myPagePurchaseGroup = document.getElementById('myPagePurchaseGroup');
	
	myPagePurchaseGroup.style.display = 'block'; 
	
}

function init() {
	let likeButton = document.getElementById('myPageNav__likeButton');
	let purchaseButton = document.getElementById('myPageNav__purchaseButton');
	let purchaseGroupButton = document.getElementById('myPageNav__purchaseGroupButton');
	
	likeButton.addEventListener('click', likeButtonHandler);
	purchaseButton.addEventListener('click', purchaseButtonHandler);
	purchaseGroupButton.addEventListener('click', purchaseGroupButtonHandler);
}

window.addEventListener('load', init);


