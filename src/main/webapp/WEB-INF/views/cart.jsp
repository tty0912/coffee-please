<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

<<!-- Cart -->
    <section id="cart" class="section">
        <div class="max-container">
            <div class="cart" id="cartList">
                <h2 class="cartTitle">님의 장바구니</h2>
                <c:forEach items="" var="cartDO" varStatus="index">
                	<div class="cartProduct" id="checkBoxes">
                    	<input type="checkbox" class="cartProduct__check" value="${cartDO.beanName}" checked />          
                    	<img class="cartProduct__img" src="" alt="">
                    	<div class="cartProductInfo">
                        	<p class="cartProductInfo__Name">상품이름</p>
                        	<div class="cartProductInfo__QtyDiv" id="qtyBtn">
                            	<button class="cartProductInfo__plus cartProduct__check"><i class="fa-solid fa-plus"></i></button>
                            	<button class="cartProductInfo__minus cartProduct__check"><i class="fa-solid fa-minus"></i></button>
                            	<span class="qty cartProduct__check">1</span>개
                        	</div>
                        	<p class="cartProductInfo__price" value="3000">3000원</p>
                    	</div>
                    	<button class="cartProductInfo__delete"><i class="fa-solid fa-trash"></i></button>
                	</div>
                </c:forEach>

                <div class="cartPrice">
                    <p class="cartTotalPriceText" id="totalPrice">합산 금액: </p>
                    <p class="cartTotalPrice">120,000</p>
                    <button class="cartPayment">결제</button>
                </div>
            </div>
        </div>
    </section>

<%@ include file = "/WEB-INF/views/footer.jsp" %>