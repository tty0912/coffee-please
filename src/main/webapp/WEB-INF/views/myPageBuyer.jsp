<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

    <!-- myPageInfo -->
    <section id="myPageInfo" class="section">
        <div class="max-container">
            <div class="myPageInfo">
                <div class="myPageInfo__info">
                    <img src="${pageContext.request.contextPath}/images/userImginit.png" alt="" class="myPageInfo__img">
                    <p class="myPageInfo__id">${buyer.nickname}</p>
                </div>
                <div class="myPageInfo__po-mo">
                    <div class="myPageInfo__pointDiv">
                        <p class="myPageInfo__balance">${buyer.point}</p>
                        <p class="myPageInfo__point">point</p>
                    </div>
                    <div class="myPageInfo__button">
                    
                    <form method="get" action="buyerModify">
                        <button class="myPageInfo__modify"><i class="fa-solid fa-gear"></i></button>
                    </form>
                    <!-- 수정 부분 -->
                    <form method="get" action="logout">
	                    <button class="myPageInfo__logout"><i class="fa-solid fa-arrow-right-from-bracket"></i></button>
                    </form>
                     
                          <!-- 
                     	<a href="/myPageBuyer"><button class="myPageInfo__modify"><i class="fa-solid fa-gear"></i></button></a>
                     	<form method="post" action="buyerModify">
                     	<button type="submit" name="command" value="logout" class="myPageInfo__logout"><i class="fa-solid fa-arrow-right-from-bracket"></i></button>
                     	</form>
                     	    -->
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- nav -->
    <section id="myPageNav">
        <div class="max-container">
            <div class="myPageNav">
                <button id="myPageNav__likeButton" class="myPageNav__button" >찜 내역</button>
                <button id="myPageNav__purchaseButton" class="myPageNav__button">구매내역</button>
                <button id="myPageNav__purchaseGroupButton" class="myPageNav__button">공동구매내역</button>
            </div>
        </div>
    </section>
    <!-- myPageLike -->
    <section id="myPageLike" class="section">
        <div class="max-container">
        	<div>
        		<h2 class="myPageLike__title">내가 찜한 목록을 확인해보세요!</h2> 
            	<div class="myPageLike">
            		<c:forEach items="${likeList}" var="beansDO">
                		<div class="myPageLike__product">
                    		<img class="myPageLike__productImg" src="${beansDO.beanImg}" alt="buyerImg" />
                    		<div class="myPageLike__productInfo">
                        		<p class="myPageLike__productName">${beansDO.beanName}</p>
                        		<p class="myPageLike__productPrice">${beansDO.beanPrice}</p>
                    		</div>
                    		<button class="myPageLike__hate"><i class="fa-solid fa-heart"></i></button>
                		</div>
                	</c:forEach>
            	</div>
        	</div>
        	<div>
        		<h2 class="myPagePurchase__title">내가 구매한 내역을 확인해보세요!</h2> 
            	<div class="myPagePurchase">
            		<c:forEach items="${orderList}" var="OrderProductDO">
                		<div class="myPagePurchase__product">
                    		
                    		<div class="myPagePurchase__productInfo">
                        		<p class="myPagePurchase__productName">${OrderProductDO.orderDatetime}</p>
                        		<p class="myPagePurchase__productPrice">${OrderProductDO.orderTotalPrice}</p>
                    		</div>
                    		<button class="myPagePurchase__detail"><i class="fa-solid fa-heart"></i></button>
                		</div>
                	</c:forEach>
            	</div>
        	</div>
        	<div>
        		<h2 class="myPagePurchaseGroup__title">내가 찜한 목록을 확인해보세요!</h2> 
            	<div class="myPagePurchaseGroup">
            		<c:forEach items="${likeList}" var="beansDO">
                		<div class="myPagePurchaseGroup__product">
                    		<img class="myPagePurchaseGroup__productImg" src="${beansDO.beanImg}" alt="buyerImg" />
                    		<div class="myPagePurchaseGroup__productInfo">
                        		<p class="myPagePurchaseGroup__productName">${beansDO.beanName}</p>
                        		<p class="myPagePurchaseGroup__productPrice">${beansDO.beanPrice}</p>
                    		</div>
                    		<button class="myPagePurchaseGroup__detail"><i class="fa-solid fa-heart"></i></button>
                		</div>
                	</c:forEach>
            	</div>
        	</div>
            
        </div>
    </section>
    <div class="myPageSources">
        출처 <a href="https://kr.freepik.com/free-vector/flat-design-profile-icon-set_29332702.htm#query=%EC%82%AC%EC%9A%A9%EC%9E%90&position=4&from_view=search&track=sph">Freepik</a>
    </div>s



<%@ include file = "/WEB-INF/views/footer.jsp" %>