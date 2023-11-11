//베스트 상품 클릭하면 상품 상세로 가기
function goBestBeanDetailHandler(event){
    let id = event.currentTarget.id;
    let url = '/coffee/goListDetail?beansNum=' + id;
    location.href = url;
}

//1~5등 이미지 연결//
function bestBeansImgHandler(){
	const images = ["/coffee/images/number1.png", "/coffee/images/number2.png", 
					"/coffee/images/number3.png", "/coffee/images/number4.png", 
					"/coffee/images/number5.png"];
	
	const bestBeans = document.querySelectorAll('.mainBeanBest__product');

    bestBeans.forEach((bean, index) => {
        const img = bean.querySelector('.beanBest__number');
            img.src = images[index];  
    });
}


function init(){
	let gobestBeanDetail = document.querySelectorAll('.mainBeanBest__productImg');
	
	gobestBeanDetail.forEach(bestBeanElement => {
    bestBeanElement.addEventListener('click', goBestBeanDetailHandler);
	});
}


bestBeansImgHandler();
window.addEventListener('load', init);