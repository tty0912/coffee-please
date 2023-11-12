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
    <script type="module" src="${pageContext.request.contextPath }/js/slideShow.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/category.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/bestBean.js" defer></script>
<%--     <script type="module" src="${pageContext.request.contextPath }/js/slideShow.js" defer></script> --%>
    
<%--     <script type="module" src="${pageContext.request.contextPath }/js/login.js" defer></script> --%>
    <%-- <script type="module" src="${pageContext.request.contextPath }/js/signup.js" defer></script> --%>
     <%--<script type="module" src="${pageContext.request.contextPath }/js/myPage.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/main.js" defer></script> --%>
</head>
<body>
<%@ include file = "/WEB-INF/views/headerNav.jsp" %>
<!-- Main -->
<section id="mainIntro" class="section">
    <div class="max-container">
        <div class="mainIntro">
            <div id="slideShow" class="mainIntro__intro">
                <ul class="slides">
                  <li><img class="introImg" src="${pageContext.request.contextPath}/images/main1.gif" alt=""></li>
                  <li><img class="introImg" src="${pageContext.request.contextPath}/images/main2.png" alt=""></li>
  	              <li><img class="introImg" src="${pageContext.request.contextPath}/images/main3.png" alt=""></li>
                </ul>  
                <div class="controller">
                    <span class="prev">&lang;</span>  
                    <span class="next">&rang;</span>
                </div>
            </div>
            <div class="mainIntro__loginAll">
                <div class="mainIntro__loginAfter">
                    <div class="user">
                        <!--       <img class="mainIntro__loginImg" src="${pageContext.request.contextPath }/images/userImginit.png" alt="">-->
                        <img class="mainIntro__loginImg" src="${ seller.sellerImg}" alt="">
                        <p class="mainIntro__loginId">${ seller.nickname }<span class="mainIntro__loginIdText">님</span></p>
                    </div>
                    <div class="mainIntro__buyer">
                        <p class="mainIntro__loginPoint"><fmt:formatNumber pattern="#,###" value="${seller.point}"/><span class="mainIntro__loginPointText"> point</span></p>
                        <div class="mainIntro__button">
                            <form method="Get" action="loginAfter">
                                  <button class="mainIntro__AfterButton" type="submit" name="action" value="logout">로그아웃</button>
                            	  <button class="mainIntro__AfterButton" type="submit" name="action" value="sellerModify">정보수정</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Category -->
<%@ include file = "/WEB-INF/views/category.jsp" %>

<!-- BeanBest -->
<%@ include file = "/WEB-INF/views/bestBean.jsp" %>

<!-- ResisterProduct -->
<section id="registerProduct" class="section">
    <div class="max-container">
    <h1 class="registerProduct__title">Register your product right now!</h1>
        <div class="registerProduct">
        	
            <div class="registerProductImgWrapper">
                <img class="registerProductImg" src="${pageContext.request.contextPath}/images/sellerRegister.gif" alt="">
                <div class="registerProductButton">
                    <form method="get" action="goRegisterProd" class="registerProductButton__form">
                        <button name="action" value="normal" class="registerProductButton__detail">일반상품판매등록</button>
                        <button name="action" value="group" class="registerProductButton__detail">공동상품판매등록</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="sources categorySources">
	<a href="https://kr.freepik.com/free-vector/tiny-people-and-big-coffee-grinder_8610416.htm#query=%EC%9B%90%EB%91%90%EB%A5%BC%20%EC%B0%BE%EB%8B%A4&position=27&from_view=search&track=ais">작가 pch.vector</a> 출처 Freepik
    출처 <a href="https://kr.freepik.com/free-vector/number-collection-with-golden-style_2304153.htm#query=%EC%88%9C%EC%9C%84&from_query=%EB%93%B1%EC%88%98&position=7&from_view=search&track=sph">Freepik</a>
</div>

<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>