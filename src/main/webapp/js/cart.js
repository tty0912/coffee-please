let sum = 0;

function clickHandler(e) {
	if (e.target.nodeName !== 'BUTTON') {
		return;
	}

	let prodClass = e.target.getAttribute('class').split(' ');
	let products = document.querySelectorAll('.' + prodClass[1]);
	let price;
	let qty;

	for (let i = 0; i < products.length; i++) {
		if (products[i].nodeName === 'INPUT') {
			price = products[i];
		}
		else if (products[i].nodeName === 'SPAN') {
			qty = products[i];
		}
	}

	if (prodClass[0] === 'cartProductInfo__plus') {
		sum += price.value * 1;
		qty.innerHTML = (qty.innerHTML * 1) + 1;
	}
	else if (prodClass[0] === 'cartProductInfo__minus') {
		if ((qty.innerHTML * 1) >= 1) {
			sum -= price.value * 1;
			qty.innerHTML = (qty.innerHTML * 1) - 1;
		}
	}

	document.querySelector('#totalPrice').innerHTML = '합산 금액: ' + sum + '원';
}

function changeHandler(e) {
	if (e.target.getAttribute('type') !== 'checkbox') {
		return;
	}

	let products = document.querySelectorAll('.' + e.target.getAttribute('class'));
	let price = e.target.value;
	let qty;
	let plus;
	let minus;

	for (let i = 0; i < products.length; i++) {
		if (products[i].nodeName === 'BUTTON' && products[i].getAttribute('class').split(' ')[0] === 'cartProductInfo__plus') {
			plus = products[i];
		}
		else if (products[i].nodeName === 'BUTTON' && products[i].getAttribute('class').split(' ')[0] === 'cartProductInfo__minus') {
			minus = products[i];
		}
		else if (products[i].nodeName === 'SPAN') {
			qty = products[i];
		}
	}

	if (e.target.checked) {
		plus.disabled = false;
		minus.disabled = false;

		console.log(qty.innerHTML * 1);
		console.log(price * 1);

		sum += (price * 1) * (qty.innerHTML * 1);
	}
	else {
		plus.disabled = true;
		minus.disabled = true;

		sum -= (price * 1) * (qty.innerHTML * 1);
	}

	alert(typeof(sum));

	document.querySelector('#totalPrice').innerHTML = '합산 금액: ' + sum + '원';
}

function init() {
	const checkBoxes = document.querySelectorAll('#cartList');
	checkBoxes.forEach(function(checkBox) {
		checkBox.addEventListener('change', changeHandler);
		checkBox.addEventListener('click', clickHandler);
	});
	console.log('오류가 안났니?');
	
	
	document.querySelector('#totalPrice').innerHTML = '합산 금액: ' + sum + '원';
}

window.addEventListener('load', init);