let totalPrice = document.querySelector('#totalPrice');
let sum = totalPrice.innerHTML * 1;

function clickHandler(e) {

	if (e.target.className === 'fa-solid fa-trash'){
		if (confirm('장바구니에서 삭제 하시겠습니까?')) {
			let beansNum = document.querySelector('#num').getAttribute('value')
			location.href = '/coffee/deleteItem?beansNum=' + beansNum;
		}
	}

	if (e.target.nodeName !== 'BUTTON') {
		return;
	}

	// 상품 하나에 대한 요소들만 찾도록 변경
	let cartProduct = e.target.closest('.cartProduct');
	let priceInput = cartProduct.querySelector('.cartProductInfo__price').innerHTML;
	let qtySpan = cartProduct.querySelector('.qty');

	if (e.target.classList.contains('cartProductInfo__plus')) {
		sum += priceInput * 1;
		qtySpan.innerHTML = (qtySpan.innerHTML * 1) + 1;
	} else if (e.target.classList.contains('cartProductInfo__minus')) {
		if ((qtySpan.innerHTML * 1) >= 1) {
			sum -= priceInput * 1 ;
			qtySpan.innerHTML = (qtySpan.innerHTML * 1) - 1;
		}
	}



	document.querySelector('#totalPrice').innerHTML = sum;
}

function changeHandler(e) {
	if (e.target.getAttribute('type') !== 'checkbox') {
		return;
	}

	// 상품 하나에 대한 요소들만 찾도록 변경
	let cartProduct = e.target.closest('.cartProduct');
	let price = cartProduct.querySelector('.cartProductInfo__price').innerHTML;
	let qtySpan = cartProduct.querySelector('.qty');
	let plusButton = cartProduct.querySelector('.cartProductInfo__plus');
	let minusButton = cartProduct.querySelector('.cartProductInfo__minus');
	
	if (e.target.checked) {
		plusButton.disabled = false;
		minusButton.disabled = false;

		sum += (price * 1) * (qtySpan.innerHTML * 1);
	} else {
		plusButton.disabled = true;
		minusButton.disabled = true;

		sum -= (price * 1) * (qtySpan.innerHTML * 1);
	}


	document.querySelector('#totalPrice').innerHTML = sum;

}

function payHandler(){
	let beansNum = document.querySelector('#num').getAttributeNames()
	alert(beansNum)
}

function init() {
	const cartProducts = document.querySelectorAll('.cartProduct');

	cartProducts.forEach(function(cartProduct) {
		//console.log('cart box id:', cartProduct.id);
		cartProduct.addEventListener('click', clickHandler);
		cartProduct.addEventListener('change', changeHandler);
	});
	document.querySelector('.cartPayment').addEventListener('click', payHandler);
}

window.addEventListener('load', init);