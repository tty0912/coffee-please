let sum = 0;

function changeHandler(e) {
	if(e.target.checked) {
		sum += (e.target.value * qtyDisplay());
	}
	else {
		sum -= (e.target.value * qtyDisplay());
	}
	
	document.querySelector('#totalPrice').innerHTML = '합계: ' + sum;
}

	
function init() {
	document.querySelector('#checkBoxes').addEventListener('change', changeHandler);
	document.querySelector('#checkBoxes').addEventListener('click', qtyHandler);
}

window.addEventListener('load', init);


/*
let totalPrice = 0;

function calcItems(event) {
	event.target.getAttribute('id');
	doucument.querySelector('#cartList').submit();
	
	
	
	if(checkbox.checked) {
		totalPrice += price;
	} else {
		totalPrice -= price;
	}
}

function qtyHandler() {
	if
}

function init() {
	document.querySelector('#cartList').addEventListener('change', calcItemsHandler);
	document.querySelector('.cartProductInfo__QtyButton').addEventListener('click', qtyHandler);
}

window.addEventListener('load', init);
*/