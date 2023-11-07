function categoryHandler () {
		document.querySelector('#sorting').submit();
	}
	
	function prodDetailHandler(event) {
		let beans = event.target.getAttribute('id');
		
		let beansNum = parseInt(beans, 10);
		
		let url = '/coffee/productListDetail?productListDetail&beansNum=' + beansNum;
		
		location.href = url;
	}

	function init() {
		document.querySelector('#category').addEventListener('change', categoryHandler);
		document.querySelector('#beansTable1').addEventListener('click', prodDetailHandler);
		
	}

	window.addEventListener('load', init);