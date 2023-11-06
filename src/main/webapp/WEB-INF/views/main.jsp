<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

 <!-- Main -->
    <section id="mainIntro" class="section">
        <div class="max-container">
            <div class="mainIntro">
                <div class="mainIntro__intro">
                    <img class="mainIntro__introImg" src="/coffee/images/mainTest1.gif" alt="">
                </div>
                <div class="mainIntro__loginAll">
                    <h2 class="mainIntro__loginTitle">Login</h2>
                    <div class="mainIntro__login">
                        <form class="mainIntro__loginForm" method="post" action="mainLogin">
                            <div class="loginRadio">
                                <input type="radio" name="login" value="buyer" /><label class="radioLabel">구매자</label>
                                <input type="radio" name="login" value="seller" /><label class="radioLabel">판매자</label>
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
                                <button class="mainIntro__loginButton">로그인</button>
                            </div>
                        </form>
                        <form id="mainIntro__loginForm" method="get" action="signup">
                          <button class="mainIntro__loginButton">회원가입</button>
                        </form>
                    </div>
                     <h4 class="loginErrorMsg" id="msg"></h4>
                </div>
            </div>
        </div>

    </section>
    <!-- Category 버튼 꾸미기?? -->
    <section id="mainCategory" class="section">
       <div class="max-container">
        <h1 class="mainCategory__title">Category</h1>
            <div id="categoryList" class="mainCategory">
                    <c:forEach items="${categoryList}" var="categoryDO" >
        			<div class="mainCategory__detail">
        			<img id="categoryName"  alt="" class="mainCategory__detailImg" categoryName="${categoryDO.categoryName}" src="${categoryDO.categoryImg}"/>
        			<p class="mainCategory__detailTitle" categoryName="${categoryDO.categoryName}">${categoryDO.categoryName}</p>
        			</div>
        			</c:forEach>
            </div>
            <button id="prevBtn"> < </button>
            <button id="nextBtn"> > </button>
     
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
                    <button class="mainBeanBest__plusButton"><i class="fa-solid fa-angles-right"></i></button>
                
            </div>
        </div>
    </section>

    
<%@ include file = "/WEB-INF/views/footer.jsp" %>