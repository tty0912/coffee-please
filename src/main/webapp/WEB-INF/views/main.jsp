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
	<script type="module" src="${pageContext.request.contextPath }/js/login.js" defer></script>
	<script type="module" src="${pageContext.request.contextPath }/js/category.js" defer></script>
	<script type="module" src="${pageContext.request.contextPath }/js/bestBean.js" defer></script>
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
                        <li><img class="introImg" src="images/main1.gif" alt=""></li>
                        <li><img class="introImg" src="images/main2.png" alt=""></li>
                        <li><img class="introImg" src="images/main3.png" alt=""></li>
                    </ul>  
                    <div class="controller">
                        <span class="prev">&lang;</span>  
                        <span class="next">&rang;</span>
                    </div>
                </div>
                <div class="mainIntro__loginAll">
                    <h2 class="mainIntro__loginTitle">Login</h2>
                    <div class="mainIntro__login">
                        <form id="loginForm" class="mainIntro__loginForm" method="post" action="mainLogin">
                            <div class="loginRadio">
                                <input type="radio" name="user" value="buyer" checked/><label class="radioLabel">구매자</label>
                                <input type="radio" name="user" value="seller" /><label class="radioLabel">판매자</label>
                            </div>
                                   
                            <label for="id" class="login__label">
                                <i class="fa-regular fa-user login__icon"></i>
                                <input
                                    class="login__input"
                                    type="email"
                                    id="userId"
                                    name="id"
                                    placeholder="email@example.com"
                                />
                            </label> 
                            <label for="password" class="login__label">
                                <i class="fa-solid fa-lock login__icon"></i>
                                <input
                                    class="login__input"
                                    type="password"
                                    id="userPassword"
                                    name="passwd"
                                    placeholder="비밀번호 입력"
                                />
                            </label>
                            <div class="mainIntro__loginFormButton">
                                <button id="loginButton" class="mainIntro__loginButton" type="submit" name="action" value="login">로그인</button>
                                <button class="mainIntro__loginButton" type="submit" name="action" value="signup">회원가입</button>
                            </div>
                        </form>
                    </div>
                     <div class="loginErrorMsg" id="loginMsg"></div>
                </div>
            </div>
        </div>

    </section>
    <!-- Category -->
	<%@ include file = "/WEB-INF/views/category.jsp" %> 
    <!-- BeanBest -->
    <%@ include file = "/WEB-INF/views/bestBean.jsp" %>
    
    
<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>