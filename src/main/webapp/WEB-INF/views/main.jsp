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
                    <img class="mainIntro__introImg" src="images/mainTest1.gif" alt="">
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
                    <h4 class="loginErrorMsg">로그인에러입니다.</h4>
                </div>
            </div>
        </div>

    </section>
    <!-- Category -->
    <section id="mainCategory" class="section">
        <div class="max-container">
            <h1 class="mainCategory__title">Category</h1>
            <div class="mainCategory">
                <div class="mainCategory__detail">
                    <img src="images/categoryTest1.jpg" alt="" class="mainCategory__detailImg" />
                    <p class="mainCategory__detailTitle">영국</p>
                </div>
            </div>

        </div>
    </section>
    <!-- BeanBest -->
    <section id="mainBeanBest" class="section">
        <div class="max-container">
            <h1 class="mainBeanBest__title">Best</h1>
            <div class="mainBeanBest">
                <div class="mainBeanBest__product">
                    <img src="images/number1.png" alt="" class="beanBest__number">
                    <img src="images/test1.jpg" alt="" class="mainBeanBest__productImg" />
                    <div class="likeButton">
                        <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                        <p class="mainBeanBest__productLikeCount">30</p>
                    </div>
                </div>
                <div class="mainBeanBest__product">
                    <img src="images/number2.png" alt="" class="beanBest__number">
                    <img src="images/test1.jpg" alt="" class="mainBeanBest__productImg" />
                    <div class="likeButton">
                        <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                        <p class="mainBeanBest__productLikeCount">30</p>
                    </div>
                </div>
                <div class="mainBeanBest__product">
                    <img src="images/number3.png" alt="" class="beanBest__number">
                    <img src="images/test1.jpg" alt="" class="mainBeanBest__productImg" />
                    <div class="likeButton">
                        <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                        <p class="mainBeanBest__productLikeCount">30</p>
                    </div>
                </div>
                <div class="mainBeanBest__product">
                    <img src="images/number4.png" alt="" class="beanBest__number">
                    <img src="images/test1.jpg" alt="" class="mainBeanBest__productImg" />
                    <div class="likeButton">
                        <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                        <p class="mainBeanBest__productLikeCount">30</p>
                    </div>
                </div>
                <div class="mainBeanBest__product">
                    <img src="images/number5.png" alt="" class="beanBest__number">
                    <img src="images/test1.jpg" alt="" class="mainBeanBest__productImg" />
                    <div class="likeButton">
                        <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                        <p class="mainBeanBest__productLikeCount">30</p>
                    </div>
                    
                </div>
            </div>
            <div class="mainBeanBest__button">
                <h2 class="mainBeanBest__buttonTitle">더 많은 원두를 보려면?</h2>
                <button class="mainBeanBest__plusButton"><i class="fa-solid fa-angles-right"></i></button>
            </div>
        </div>
    </section>
    <div class="sources">
        출처 <a href="https://kr.freepik.com/free-vector/number-collection-with-golden-style_2304153.htm#query=%EC%88%9C%EC%9C%84&from_query=%EB%93%B1%EC%88%98&position=7&from_view=search&track=sph">Freepik</a>
    </div>



<%@ include file = "/WEB-INF/views/footer.jsp" %>