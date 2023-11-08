<%@ page contentType="text/html; charset=UTF-8"
	import="java.util.*, model.product.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

    <!-- productListDetail -->
    <section id="productListDetail" class="section">
        <div class="max-container">
            <div class="productListDetail__top">
                <div class="productListDetail__topLeft">
                    <img src="${productListDetail.beansDO.beanImg}" alt="" class="productListDetail__img">
                    <div class="productListDetail__likeButton">
                        <c:choose>
                            <c:when test="${productListDetail.aBoolean == false}">
                                <form method="post" action="like">
                                    <button name="beansNum2" value="${productListDetail.beansDO.beansNum}" class="myPageLike__button"><i class="fa-regular fa-heart"></i></button>
                                </form>
                            </c:when>
                            <c:when test="${productListDetail.aBoolean == true}">
                                <form method="post" action="like">
                                    <button name="beansNum2" value="${productListDetail.beansDO.beansNum}" class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                                </form>
                            </c:when>
                        </c:choose>

                        <p class="mainBeanBest__productLikeCount">${productListDetail.beansDO.likeCount}</p>
                    </div>
                </div>
                <form method="post" action="cartOrPayment">
                    <div class="productListDetail__topRight">
                        <p class="productListDetail__beanName">${ productListDetail.beansDO.beanName }</p>
                        <p class="productListDetail__deliveryPrice">${ productListDetail.beansDO.beanPrice }원</p>
                        <div class="cartProductInfo__QtyDiv">
                            <button class="cartProductInfo__QtyButton"><i class="fa-solid fa-plus"></i></button>
                            <label>
                                <input type="number" id="qty" name="qty" class="cartProductInfo__QtyText"/>
                            </label>
                            <button class="cartProductInfo__QtyButton"><i class="fa-solid fa-minus"></i></button>
                        </div>
                        <div class="productListDetail__button">
                            <button id="${productListDetail.beansDO.beansNum}" class="productListDetail__cart" name="action" value="cart">장바구니</button>
                            <button class="productListDetail__pay" name="action" value="onePayment">바로구매</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </section>
    <section id="productListDetail__bottom" class="section">
        <div class="max-container">
            <h2 class="productListDetail__bottomTitle">상세설명</h2>
            <div class="productListDetail__bottom">
                <img src="${productListDetail.beansDO.descript}" alt="" class="productListDetail__bottomImg">
            </div>
        </div>
    </section>


<%@ include file = "/WEB-INF/views/footer.jsp" %>