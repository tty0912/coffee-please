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
    <script type="module" src="${pageContext.request.contextPath }/js/active.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/myPage.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/like.js" defer></script>
    
<%--     <script type="module" src="${pageContext.request.contextPath }/js/slideShow.js" defer></script> --%>
    
<%--     <script type="module" src="${pageContext.request.contextPath }/js/login.js" defer></script> --%>
    <%-- <script type="module" src="${pageContext.request.contextPath }/js/signup.js" defer></script> --%>
     <%--<script type="module" src="${pageContext.request.contextPath }/js/myPage.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/main.js" defer></script> --%>
</head>
<body>
<%@ include file = "/WEB-INF/views/headerNav.jsp" %>

    <!-- myPageInfo -->
    <section id="myPageInfo" class="section">
        <div class="max-container">
            <div class="myPageInfo">
                <div class="myPageInfo__info">
                    <img src="${buyer.buyerImg}" alt="" class="myPageInfo__img">
                    <p class="myPageInfo__id">${buyer.nickname}</p>
                </div>
                <div class="myPageInfo__po-mo">
                    <div class="myPageInfo__pointDiv">
                        <p class="myPageInfo__balance"><fmt:formatNumber pattern="#,###" value="${buyer.point}"/></p>
                        <p class="myPageInfo__point">point</p>
                    </div>
                    <div class="myPageInfo__button">
                    
                    <form method="get" action="buyerModify">
                        <button class="myPageInfo__modify"><i class="fa-solid fa-gear"></i></button>
                    </form>
                    <!-- 수정 부분 -->
                    <form method="get" action="loginAfter">
	                    <button name="action" value="logout" class="myPageInfo__logout"><i class="fa-solid fa-arrow-right-from-bracket"></i></button>
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
    <section id="myPageNav" class="section">
        <div class="max-container">
            <div class="myPageNav">
                <button id="myPageNav__likeButton" class="myPageNav__button active" >찜 내역</button>
                <button id="myPageNav__purchaseButton" class="myPageNav__button">구매내역</button>
                <button id="myPageNav__purchaseGroupButton" class="myPageNav__button">공동구매내역</button>
            </div>
        </div>
    </section>
    <!-- myPageLike -->
    <section id="myPageLike" class="section">
        <div class="max-container">
        	<div>
        		<h2 class="myPageLike__title">찜한 목록을 확인해보세요!</h2> 
            	<div class="myPageLike">
            		
            		<c:forEach items="${likeList}" var="beansDO">
                		<div class="myPageLike__product">
                		<!-- 수정 부분 -->
                		<form method="get" action="goListDetail">
                			<input type="hidden" id="beansNum" name="beansNum" value="${beansDO.beansNum}" />
                			<button>
	                    		<img class="myPageLike__productImg" src="${beansDO.beanImg}" alt="buyerImg" />
                			</button>
                   		</form>
                    		<div class="productList__productText">
                    			<table class="productList__table">
		                            <tr>
		                                <th class="productList__productTitle">상품명 </th>
		                                <td class="productList__productTitle">${beansDO.beanName}</td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productPrice">가격 </th>
		                                <td class="productList__productPrice"><fmt:formatNumber pattern="#,###" value="${beansDO.beanPrice}"/>원</td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productDelivery">배송비</th>
		                                <td class="productList__productDelivery">Free </td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productCategory">원두 종류</th>
		                                <td class="productList__productCategory">케냐 ?</td>
		                            </tr>
		                        </table>
                    		</div>
                    		<form method="get" action="like" class="productList__likeButton">
                                <input type="hidden" name="sort" value="myPage">
                                <button id="likeButton" name="beansNum" value="${beansDO.beansNum}" class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                            </form>
                		</div>
                	</c:forEach>
            	</div>
        	</div>
        </div>
    </section>
    <section id="myPagePurchase" class="section">
        <div class="max-container">	
        		<h2 class="myPagePurchase__title">구매한 내역을 확인해보세요!</h2> 
            	<div class="myPagePurchase">
            		<c:forEach items="${orderList}" var="orderLists" varStatus="status">
            			<div class="myPageLike__product">
                		<!-- 수정 부분 -->
                		<form method="post" action="paymentDetail">
                			<input type="hidden" id="orderDatetime" name="orderDatetime" value="${orderLists.orderProductDO.orderDatetime}">
                			<button>
	                    		<img class="myPageLike__productImg" src="${orderLists.beansDO.beanImg}" alt="buyerImg" />
                			</button>
                   		</form>
                    		<div class="productList__productText">
                    			<table class="productList__table">
                    				<tr>
		                                <th class="productList__productTitle">구매날짜 </th>
		                                <td class="productList__productTitle">${orderLists.orderProductDO.orderDatetime}</td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productTitle">상품명 </th>
		                                <td class="productList__productTitle">${beansDO.beanName}</td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productDelivery">수량</th>
		                                <td class="productList__productDelivery">${status.count}</td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productPrice">결제 금액</th>
		                                <td class="productList__productPrice"><fmt:formatNumber pattern="#,###" value="${orderLists.orderProductDO.orderTotalPrice}"/>원</p>
		                            </tr>
		                           
		                        </table>
                    		</div>
                    		<form method="post" action="paymentDetail">
                				<input type="hidden" id="orderDatetime" name="orderDatetime" value="${orderLists.orderProductDO.orderDatetime}">
                                <button class="myPagePurchase__detail"><i class="fa-solid fa-heart"></i></button>
                            </form>
                		</div>
                	</c:forEach>
            	</div>
        	</div>
   		</div>
    </section>
    <section id="myPagePurchaseGroup" class="section">
        <div class="max-container">
        	<div>
        		<h2 class="myPagePurchaseGroup__title">공동 구매한 목록을 확인해보세요!</h2> 
            	<div class="myPagePurchaseGroup">
            		<c:forEach items="${orderList}" var="orderLists" varStatus="status">
            			<div class="myPageLike__product">
                		<!-- 수정 부분 -->
                		<form method="post" action="paymentDetail">
                			<input type="hidden" id="orderDatetime" name="orderDatetime" value="${orderLists.orderProductDO.orderDatetime}">
                			<button>
	                    		<img class="myPageLike__productImg" src="${orderLists.beansDO.beanImg}" alt="buyerImg" />
                			</button>
                   		</form>
                    		<div class="productList__productText">
                    			<table class="productList__table">
                    				<tr>
		                                <th class="productList__productTitle">구매날짜 </th>
		                                <td class="productList__productTitle">${orderLists.orderProductDO.orderDatetime}</td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productTitle">상품명 </th>
		                                <td class="productList__productTitle">${beansDO.beanName}</td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productDelivery">수량</th>
		                                <td class="productList__productDelivery">${status.count}</td>
		                            </tr>
		                            <tr>
		                                <th class="productList__productPrice">결제 금액</th>
		                                <td class="productList__productPrice"><fmt:formatNumber pattern="#,###" value="${orderLists.orderProductDO.orderTotalPrice}"/>원</p>
		                            </tr>
		                           
		                        </table>
                    		</div>
                    		<form method="post" action="paymentDetail">
                				<input type="hidden" id="orderDatetime" name="orderDatetime" value="${orderLists.orderProductDO.orderDatetime}">
                                <button class="myPagePurchase__detail"><i class="fa-solid fa-heart"></i></button>
                            </form>
                		</div>
                	</c:forEach>
            	</div>
        	</div>
            
        </div>
    </section>
    <div class="myPageSources">
        출처 <a href="https://kr.freepik.com/free-vector/flat-design-profile-icon-set_29332702.htm#query=%EC%82%AC%EC%9A%A9%EC%9E%90&position=4&from_view=search&track=sph">Freepik</a>
    </div>

<%@ include file = "/WEB-INF/views/footer.jsp" %>
</body>
</html>