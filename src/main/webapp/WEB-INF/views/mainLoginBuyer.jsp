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
                    <img class="mainIntro__introImg" src="${pageContext.request.contextPath }/images/mainTest1.gif" alt="">
                </div>
                <div class="mainIntro__loginbuyer">
                    <img class="mainIntro__loginbuyerImg src="images/userImginit.png" alt="">
                    <p class="mainIntro__loginbuyerId">${Buyer.nickname }</p>
                    <form method="post" action="mainLoginBuyer" class="mainIntro__buyer">
                        <button type="submit" name="command" value="logout" class="mainIntro__logoutButton">로그아웃</button>
                        <button type="submit" name="command" value="myPageBuyer" class="mainIntro__myPageButton">마이페이지</button>
                    </form>
                </div>  
            </div>
        </div>
    </section>
    <!-- Category -->
    <section id="mainCategory">
        <div class="max-container">
            <div class="mainCategory__detail">
                <img src="${pageContext.request.contextPath }/images/categoryTest1.jpg" alt="" class="mainCategory__detailImg" />
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
                    <img src="${pageContext.request.contextPath }/images/test1.jpg" alt="" class="mainBeanBest__productImg" />
                    <p class="mainBeanBest__productLikeCount">30</p>
                </div>
                <div class="mainBeanBest__button">
                    <button class="mainBeanBest__plusButton">더보기</button>
                </div>
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>