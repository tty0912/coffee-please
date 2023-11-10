<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Seo -->
    <title>Bean2B</title>
	<%@ include file = "/WEB-INF/views/header.jsp" %>
	<!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/signupStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/productStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/myPageStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/mainStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/cartStyle.css">
    <!-- Javascript -->
    <script type="module" src="${pageContext.request.contextPath }/js/buyNow.js" defer></script>
</head>
<body>
<%@ include file = "/WEB-INF/views/headerNav.jsp" %>

<<!-- Cart -->
    <section id="cart" class="section">
        <div class="max-container">
            <div class="cart">
                <h2 class="cartTitle">결제진행</h2>
                	<div class="paymentProduct">
                    	<img class="cartProduct__img" src="${beansDO.beanImg}" alt="">
                    	<div class="cartProductInfo">
                        	<p class="cartProductInfo__Name">${beansDO.beanName}</p>
                        	<div class="cartProductInfo__QtyDiv">
                            	<p class="cartProductInfo__QtyText" >수량 : ${qty}</p>	
                        	</div>
                        	<p class="cartProductInfo__price">${beansDO.beanPrice}원</p>
                    	</div>
                	</div>

                <div class="paymentPrice">
                    <p class="cartTotalPriceText">합산 금액 :</p>
                    <p class="cartTotalPrice">${beansDO.beanPrice * qty}</p>
                </div>
                <div class="paymentPrice">
                    <button class="cartPayment">취소</button>
	                <button class="cartPayment" id="buy">결제</button>
                </div>
                <form method="post" id="hiddenForm">
                    <input type="hidden" id="beansNum" name="beansNum" value="${ beansDO.beansNum }">
                    <input type="hidden" id="qty" name="qty" value="${ qty }">
                </form>
            </div>
        </div>
    </section>

<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>