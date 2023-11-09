<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

<<!-- Cart -->
    <section id="cart" class="section">
        <div class="max-container">
            <div class="cart">
                <h2 class="cartTitle">결제진행</h2>
                <c:forEach items="${bean}" var="beansDO">
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

                <div class="paymentPrice">
                    <p class="cartTotalPriceText">합산 금액 :</p>
                    <p class="cartTotalPrice">${beansDO.beanPrice}</p>
                </div>
                <div class="paymentPrice">
                    <button class="cartPayment">취소</button>
                    <button class="cartPayment">결제</button>
                </div>
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>