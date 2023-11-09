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
    <script type="module" src="${pageContext.request.contextPath }/js/slideShow.js" defer></script>
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
                    <img src="${productListDetail.beanImg}" alt="" class="productListDetail__img">
                    <div class="productListDetail__likeButton">
                        <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                        <p class="mainBeanBest__productLikeCount">${productListDetail.likeCount}</p>
                    </div>
                </div>
                <form method="post" action="cartOrPayment">
                    <div class="productListDetail__topRight">
                        <p class="productListDetail__beanName">${ productListDetail.beanName }</p>
                        <p class="productListDetail__deliveryPrice">${ productListDetail.beanPrice }원</p>
                        <div class="cartProductInfo__QtyDiv">
                            <button class="cartProductInfo__QtyButton"><i class="fa-solid fa-plus"></i></button>
                            <label name="qty">
                                <input type="number" class="cartProductInfo__QtyText"/>
                            </label>
                            <button class="cartProductInfo__QtyButton"><i class="fa-solid fa-minus"></i></button>
                        </div>
                        <div class="productListDetail__button">
                            <button class="productListDetail__cart" name="action" value="cart">장바구니</button>
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
                <img src="${productListDetail.descript}" alt="" class="productListDetail__bottomImg">
            </div>
        </div>
    </section>

<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>