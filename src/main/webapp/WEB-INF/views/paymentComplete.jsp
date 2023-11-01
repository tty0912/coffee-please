<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

<<!-- Cart -->
    <section id="cart">
        <div class="max-container">
            <div class="cart">
                <h2 class="signup__title">상품 결제가 완료되었습니다.</h2> 
                <h4 class="signup__description">즐거운 쇼핑 되세요.</h4>
                <c:forEach items="${test}" var="test">
                	<div class="paymentProduct">
                    	<img class="cartProduct__img" src="${beansDO.beanImg}" alt="">
                    	<div class="cartProductInfo">
                        	<p class="cartProductInfo__Name">${beansDO.beanName}</p>
                        	<div class="cartProductInfo__QtyDiv">
                            	<button class="cartProductInfo__QtyButton"><i class="fa-solid fa-plus"></i></button>
                            	<input type="text" class="cartProductInfo__QtyText" value="${beansDO.beanPrice}" />	
                            	<button class="cartProductInfo__QtyButton"><i class="fa-solid fa-minus"></i></button>
                        	</div>
                        	<p class="cartProductInfo__price">${beansDO.beanPrice}원</p>
                    	</div>
                	</div>
                </c:forEach>

                <div class="paymentCompletePrice">
                    <p class="cartTotalPriceText">결제 금액 : <p class="cartTotalPrice">${beansDO.beanPrice}</p></p>
                    <p class="cartTotalPriceText">현재 잔액 : <p class="cartTotalPrice">${buyerDO.point}</p></p>
                </div>
                <div class="paymentCompletePrice">
                    <button class="cartPayment">확인</button>
                </div>
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>