<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

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
                        <form class="mainIntro__loginForm" method="post" action="mainLogin">
                            <div class="loginRadio">
                                <input type="radio" name="user" value="buyer" /><label class="radioLabel">구매자</label>
                                <input type="radio" name="user" value="seller" /><label class="radioLabel">판매자</label>
                            </div>
                                   
                            <label for="id" class="login__label">
                                <i class="fa-regular fa-user"></i>
                                <input
                                    class="login__input"
                                    type="email"
                                    id="userId"
                                    name="id"
                                    placeholder="email@example.com"
                                />
                            </label> 
                            <label for="password" class="login__label">
                                <i class="fa-solid fa-lock"></i>
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
                     <h4 class="loginErrorMsg" id="loginMsg"></h4>
                </div>
            </div>
        </div>

    </section>
    <!-- Category 버튼 꾸미기?? -->
    <!-- Category -->
    <section id="mainCategory" class="section">
       <div class="max-container">
        <h1 class="mainCategory__title">Category</h1>
            	<div id="categoryList" class="mainCategory">
                    <c:forEach items="${categoryList}" var="categoryDO" >
        			<div class="mainCategory__detail">
        				<img id="categoryName"  alt="" class="mainCategory__detailImg" src="${categoryDO.categoryImg}"/>
        				<p class="mainCategory__detailTitle">${categoryDO.categoryName}</p>
        			</div>
        			</c:forEach>
            	</div>
        </div>
    </section>
    <!-- BeanBest -->
    <section id="mainBeanBest" class="section">
         <div class="max-container">
        <h1 class="mainBeanBest__title">Best</h1>
            <div class="mainBeanBest">
  				<c:forEach items="${bestBean}" var="beansDO" >
                    <div class="mainBeanBest__product">
                    	<img src="" alt="" class="beanBest__number">
        				<img src="${beansDO.beanImg}"  alt="" class="mainBeanBest__productImg" >
        				<div class="likeButton">
                        	<button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                        	<p class="mainBeanBest__productLikeCount">${beansDO.likeCount}</p>
                    	</div>
                    </div>
    			</c:forEach>
            </div>
 	         <div class="mainBeanBest__button">
 	         	<h2 class="mainBeanBest__buttonTitle">더 많은 원두를 보려면?</h2>
 	         	<form method="get" action="goProdcutList">
 	         	    <button class="mainBeanBest__plusButton"><i class="fa-solid fa-angles-right"></i></button>	
 	         	</form>
            </div>
        </div>
    </section>
    
	<!-- Javascript -->
    <script type="module" src="${pageContext.request.contextPath }/js/slideShow.js" defer></script>
    
<%@ include file = "/WEB-INF/views/footer.jsp" %>