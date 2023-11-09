function categoryHandler () {
		document.querySelector('#sorting').submit();
	}
	
	function init() {
		document.querySelector('#category').addEventListener('change', categoryHandler);
		
	}

	window.addEventListener('load', init);