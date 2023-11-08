function calcItems(event) {
	event.target.getAttribute('id');
	doucument.querySelector('#cartList').submit();
}

function init() {
	document.querySelector('#cartList').addEventListener('change', calcItemsHandler);
}

window.addEventListener('load', init);