function buyHandler() {
//	let qty1 = document.querySelector('.cartProductInfo__QtyText');
	let hiddenForm = document.querySelector('#hiddenForm');
//	let qty = document.querySelector('#qty');

//	qty.value = qty1.value;
	hiddenForm.setAttribute('action', '/coffee/paymentComplete');
	hiddenForm.submit();
}
function init() {
	document.querySelector('#buy').addEventListener('click', buyHandler);
}
window.addEventListener('load', init);