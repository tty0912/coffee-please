/**
 * 
 */
function modifyHandler(event) {
		let beans = event.target.getAttribute('id');
		
		let beansNum = parseInt(beans, 10);
		
		let url = '/coffee/productListDetail?productListDetail&beansNum=' + beansNum;
		
		location.href = url;
	}
	function init() {
		let beansTable = document.querySelector('#beansTable');
		
		beansTable.addEventListener('click', modifyHandler);
	}
	window.addEventListener('load', init);