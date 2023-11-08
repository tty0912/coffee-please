<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

<<!-- Cart -->
    <section id="cart" class="section">
        <div class="max-container">
            <div class="cart" id="cartList">
                <h2 class="cartTitle">${buyerDO.buyerName}님의 장바구니</h2>
                <c:forEach items="${cartList}" var="cartDO" varStatus="index">
                	<div class="cartProduct">
                    	<input type="checkbox" class="cartProduct__check" value="${index.count}" checked />
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
                    	<button class="cartProductInfo__delete"><i class="fa-solid fa-trash"></i></button>
                	</div>
                </c:forEach>

                <div class="cartPrice">
                    <p class="cartTotalPriceText">합산 급액 :</p>
                    <p class="cartTotalPrice">120,000</p>
                    <button class="cartPayment">결제</button>
                </div>
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>