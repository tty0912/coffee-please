<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.product.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ include file="/WEB-INF/views/header.jsp"%>
         <!-- Category -->
      <section id="listCategory" class="section">
        <div class="max-container">
            <h1 class="mainCategory__title">Category</h1>
            <div class="mainCategory">
                <div class="mainCategory__detail">
                    <img src="images/categoryTest1.jpg" alt="" class="mainCategory__detailImg" />
                    <p class="mainCategory__detailTitle">영국</p>
                </div>
                <div class="mainCategory__detail">
                    <img src="images/categoryTest1.jpg" alt="" class="mainCategory__detailImg" />
                    <p class="mainCategory__detailTitle">영국</p>
                </div>
            </div>

        </div>
    </section>

    <!--productList  -->
    <section id="productList" class="section">
        <div class="max-container">
            <div class="productList">
                <div class="productList__sortSerch">
                    <div class="productList__sortDiv">
                        <span class="productList__sortText">정렬</span>

                        <form action="/coffee/goProductList" method="GET" id="sorting">
                        <label for="category">카테고리:</label>	
							<select id="category" name="category">
                                <option value="0" ${param.category == '0' ? 'selected' : '' }>전체</option>
                                <option value="1" ${param.category == '1' ? 'selected' : '' }>브라질</option>
                                <option value="2" ${param.category == '2' ? 'selected' : '' }>콜롬비아</option>
                                <option value="3" ${param.category == '3' ? 'selected' : '' }>에티오피아</option>
                                <option value="4" ${param.category == '4' ? 'selected' : '' }>온두라스</option>
                                <option value="5" ${param.category == '5' ? 'selected' : '' }>인도</option>
						    </select>
	                        <button class="productList__sort" name="sort" value="recent" type="submit">최신순</button>
	                        <button class="productList__sort" name="sort" value="mostLiked" type="submit">인기순</button>
	                        <button class="productList__sort" name="sort" value="bestSelling" type="submit">판매량순</button>
                        </form>
                    </div>
                    <form class="productList__search">
                        <input type="text" class="productList__searchInput" id="searchInput" />
                        <button class="productList__searchButton" type="submit" name="search" value="search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button> 
                    </form>
                </div>
                <div id="beansTable" class="productList__productDiv">
                <c:forEach items="${beansList}" var="bean">
                    <div  class="productList__product">
                        <img class="productList__productImg" src="${bean.beansDO.beanImg}" alt="">
                        <div class="productList__productText">

                            <p class="productList__productTitle">${bean.beansDO.beanName}</p>
                            <p class="productList__productPrice">${bean.beansDO.beanPrice}원</p>
                            <div class="productList__likeButton">

                            <c:choose>
                				<c:when test="${bean.aBoolean == false}">
                                    <form method="post" action="like" >
                                        <button name="beansNum" value="${bean.beansDO.beansNum}" class="myPageLike__button"><i class="fa-regular fa-heart"></i></button>
                                    </form>
                				</c:when>
                				<c:when test="${bean.aBoolean == true}">
                    				<button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                				</c:when>
                			</c:choose>
                                <p class="mainBeanBest__productLikeCount">${bean.beansDO.likeCount}</p>
                            </div>
                        </div>
                        <button class="productList__button" id="${bean.beansDO.beansNum}">상세보기</button>
                    </div>
                </c:forEach>
                </div>
                <div class="productList__buttonDiv">
                    <%--<button class="productList__button"><i class="fa-solid fa-angles-left"></i></button>--%>
                    <c:if test="${currentPage > 1}">
					    <c:url var="prevUrl" value="/goProductList">
					        <c:param name="page" value="${currentPage - 1}" />
					        <c:if test="${not empty search}">
					            <c:param name="search" value="${search}" />
					        </c:if>
					        <c:param name="sort" value="${sortOption}" />
					        <c:param name="category" value="${categoryNum}" />
					    </c:url>
					    <a class="productList__button" href="${prevUrl}"><i class="fa-solid fa-angles-left"></i></a>
					</c:if>

                    <%-- <button class="productList__button"><i class="fa-solid fa-angles-right"></i></button> --%>
                    <c:if test="${currentPage < totalPages}">
					    <c:url var="nextUrl" value="/goProductList">
					        <c:param name="page" value="${currentPage + 1}" />
					        <c:if test="${not empty search}">
					            <c:param name="search" value="${search}" />
					        </c:if>
					        <c:param name="sort" value="${sortOption}" />
					        <c:param name="category" value="${categoryNum}" />
					    </c:url>
					    <a class="productList__button" href="${nextUrl}"><i class="fa-solid fa-angles-right"></i></a>
					</c:if>
                </div>
            </div>
        </div>
    </section>

<script>
    function categoryHandler () {
        document.querySelector('#sorting').submit();
    }

    function prodDetailHandler(event) {
        let beans = event.target.getAttribute('id');
        //alert(beans);

        let url = '/coffee/goListDetail?beansNum=' + beans;
        location.href = url;
    }
    function init() {
        document.querySelector('#category').addEventListener('change', categoryHandler);
        document.querySelector('#beansTable').addEventListener('click', prodDetailHandler);

    }
    window.addEventListener('load', init);
</script>
<%@ include file="/WEB-INF/views/footer.jsp"%>