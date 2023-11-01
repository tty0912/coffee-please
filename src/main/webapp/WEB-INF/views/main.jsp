<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

<!-- Main -->
    <section id="mainIntro">
        <div class="max-container">
            <div class="mainIntro">
                <div class="mainIntro__intro">
                    <img src="images/mainTest1.gif" alt="">
                </div>
                <div class="mainIntro__login">
                    <form id="mainIntro__loginForm" action="Controller">
                        <label><input type="radio" name="login" value="buyer"/>구매자</label>
                        <label><input type="radio" name="login" value="seller"/>판매자</label>
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
                        <button class="mainIntro__loginButton">로그인</button>
                        <button class="mainIntro__loginButton">회원가입</button>
                    </form>
                </div>
            </div>
        </div>

    </section>
    <!-- Category -->
    <section id="mainCategory">
        <div class="max-container">
            <div class="mainCategory__detail">
                <img src="images/categoryTest1.jpg" alt="" class="mainCategory__detailImg" />
                <p class="mainCategory__detailTitle">영국</p>
            </div>
        </div>
    </section>
    <!-- BeanBest -->
    <section id="mainBeanBest">
        <div class="max-container">
            <div class="mainBeanBest">
                <div class="mainBeanBest__product">
                    <p class="mainBeanBest__productTitle">1위</p>
                    <img src="images/test1.jpg" alt="" class="mainBeanBest__productImg" />
                    <p class="mainBeanBest__productLikeCount">30</p>
                </div>
                <div class="mainBeanBest__button">
                    <button class="mainBeanBest__plusButton">더보기</button>
                </div>
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>