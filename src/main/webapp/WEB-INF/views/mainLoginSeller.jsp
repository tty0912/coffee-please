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
                    <img class="mainIntro__introImg" src="images/mainTest1.gif" alt="">
                </div>
                <div class="mainIntro__loginbuyer">
                    <img class="mainIntro__loginbuyerImg src="images/userImginit.png" alt="">
                    <p class="mainIntro__loginbuyerId"></p>
                    <div class="mainIntro__buyer">
                        <button class="mainIntro__logoutButton">로그아웃</button>
                        <button class="mainIntro__myPageButton">마이페이지</button>
                    </div>
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
        <!-- ResisterProduct -->
    <section id="resisterProduct">
        <div class="max-container">
            <div class="resisterProduct">
                <img class="resisterProductImg" src="images/test1.jpg" alt="">
                <div class="resisterProductButton">
                    <button class="resisterProductButton">일반상품판매등록</button>
                    <button class="resisterProductButton__group">공동상품판매등록</button>
                </div>
            </div>
        </div>

    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>