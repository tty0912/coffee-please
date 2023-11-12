<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
    <script type="module" src="${pageContext.request.contextPath }/js/productDetail.js" defer></script>
<%--     <script type="module" src="${pageContext.request.contextPath }/js/slideShow.js" defer></script> --%>
    
<%--     <script type="module" src="${pageContext.request.contextPath }/js/login.js" defer></script> --%>
    <%-- <script type="module" src="${pageContext.request.contextPath }/js/signup.js" defer></script> --%>
     <%--<script type="module" src="${pageContext.request.contextPath }/js/myPage.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/main.js" defer></script> --%>
</head>
<body>
<%@ include file = "/WEB-INF/views/headerNav.jsp" %>

    <!-- productListDetail -->
    <section id="productListDetail" class="section">
        <div class="max-container">
            <div class="productListDetail__top">
                <div class="productListDetail__topLeft">
                    <img src="${productListDetail.beansDO.beanImg}" alt="" class="productListDetail__img">

                    <c:choose>
                        <c:when test="${not empty buyerEmail}">
                            <div class="productListDetail__likeButton">
                                <c:choose>
                                    <c:when test="${productListDetail.aBoolean == false}">
                                        <form method="get" action="like">
                                            <input type="hidden" name="sort" value="detail">
                                            <button name="beansNum" value="${productListDetail.beansDO.beansNum}" class="myPageLike__button"><i class="fa-regular fa-heart"></i></button>
                                        </form>
                                    </c:when>
                                    <c:when test="${productListDetail.aBoolean == true}">
                                        <form method="get" action="like">
                                            <input type="hidden" name="sort" value="detail">
                                            <button name="beansNum" value="${productListDetail.beansDO.beansNum}" class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                                        </form>
                                    </c:when>
                                </c:choose>

                                <p class="mainBeanBest__productLikeCount">${productListDetail.beansDO.likeCount}</p>
                            </div>
                        </c:when>
                    </c:choose>

                </div>
                    <div class="productListDetail__topRight">
                        <p class="productListDetail__beanName">${ productListDetail.beansDO.beanName }</p>

                        <p class="productListDetail__deliveryPrice"><fmt:formatNumber pattern="#,###" value="${productListDetail.beansDO.beanPrice}"/>원</p>
                        <div class="cartProductInfo__QtyDiv">
                            <button class="cartProductInfo__QtyButton" id="increase"><i class="fa-solid fa-plus"></i></button>
                            <label>
                                <input type="number" name="qty" class="cartProductInfo__QtyText" id="quantityInput" value="1" min="1" max="999"/>
                            </label>
                            <button class="cartProductInfo__QtyButton" id="decrease"><i class="fa-solid fa-minus"></i></button>
                        </div>
                        <div class="productListDetail__button">
                            <button class="productListDetail__cart" id="cart">장바구니</button>
                            <button class="productListDetail__pay" id="buyNow">바로구매</button>
                        </div>

                    </div>
                <form method="post" id="hiddenForm" action="/coffee/cartOrPayment">
                    <input type="hidden" id="beansNum" name="beansNum" value="${ productListDetail.beansDO.beansNum }">
                    <input type="hidden" id="qty" name="qty" value=1>
                   	<button id="submitBtn"></button>
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
</body>
</html>

