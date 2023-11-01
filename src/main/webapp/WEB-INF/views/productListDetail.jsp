<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

    <!-- productListDetail -->
    <section id="productListDetail">
        <div class="max-container">
            <div class="productListDetail__top">
                <div class="productListDetail__topLeft">
                    <img src="images/test1.jpg" alt="" class="productListDetail__img">
                    <p class="mainBeanBest__productLikeCount"></p>
                </div>
                <div class="productListDetail__topRight">
                    <p class="productListDetail__beanName"></p>
                    <p class="productListDetail__deliveryPrice"></p>
                    <div class="cartProductInfo__QtyDiv">
                        <button class="cartProductInfo__QtyButton"><i class="fa-solid fa-plus"></i></button>
                        <input type="text" class="cartProductInfo__QtyText" />
                        <button class="cartProductInfo__QtyButton"><i class="fa-solid fa-minus"></i></button>
                    </div>
                    <div class="productListDetail__button">
                        <button class="productListDetail__cart">장바구니</button>
                        <button class="productListDetail__pay">바로구매</button>
                    </div>
                </div>
            </div>
            <div class="productListDetail__bottom">
                <img src="images/test1.jpg" alt="" class="productListDetail__bottomImg">
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>