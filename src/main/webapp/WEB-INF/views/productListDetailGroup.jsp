<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

    <!-- productListDetail -->
    <section id="productListDetail" class="section">
        <div class="max-container">
            <div class="productListDetail__top">
                <div class="productListDetail__topLeft">
                    <img src="images/test1.jpg" alt="" class="productListDetail__img">
                    <div class="productListDetail__likeButton">
                        <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                        <p class="mainBeanBest__productLikeCount">30</p>
                    </div>
                </div>
                <div class="productListDetail__topRight">
                    <p class="productListDetail__beanName">1</p>
                    <p class="productListDetail__price">1</p>
                    <p class="productListDetail__term">1</p>
                    <p class="productListDetail__time">1</p>
                    <p class="productListDetail__currentWeight">1</p>
                    <p class="productListDetail__goalWeight">1</p>
                    <div class="cartProductInfo__QtyDiv">
                        <button class="cartProductInfo__QtyButton"><i class="fa-solid fa-plus"></i></button>
                        <input type="text" class="cartProductInfo__QtyText" />
                        <button class="cartProductInfo__QtyButton"><i class="fa-solid fa-minus"></i></button>
                    </div>
                    <div class="productListDetail__button">
                        <button class="productListDetail__pay">바로구매</button>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- productListDetail__bottom -->
    <section id="productListDetail__bottom" class="section">
        <div class="max-container">
            <h2 class="productListDetail__bottomTitle">상세설명</h2>
            <div class="productListDetail__bottom">
                <img src="images/test1.jpg" alt="" class="productListDetail__bottomImg">
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>