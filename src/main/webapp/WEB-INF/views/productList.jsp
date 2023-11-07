<%@ page contentType="text/html; charset=UTF-8" import="java.util.*"%>
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

                        <form action="/coffee/productList" method="GET" id="sorting">
	                        <button class="productList__sort" value="recent" type="submit">최신순</button>
	                        <button class="productList__sort" value="mostLiked" type="submit">인기순</button>
	                        <button class="productList__sort" value="bestSelling" type="submit">판매량순</button>
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
                        <img class="productList__productImg" src="images/test2.jpg" alt="">
                        <div class="productList__productText">

                            <p class="productList__productTitle">${bean.beanName}</p>
                            <p class="productList__productPrice">${bean.beanPrice}원</p>
                            <p class="productList__productCategory">케냐</p>
                            <button class="productList__button" id="${bean.beansNum}" type="button">상세보기</button>
                            <div class="productList__likeButton">
                                <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                                <p class="mainBeanBest__productLikeCount">${bean.likeCount}</p>
                            </div>
                        </div>
                        <button class="productList__button" id="${bean.beansNum}">상세보기</button>
                    </div>
                    </c:forEach>
                </div>
                <div class="productList__buttonDiv">
                    <button class="productList__button"><i class="fa-solid fa-angles-left"></i></button>
                    <c:if test="${currentPage > 1}">
					    <c:url var="prevUrl" value="/productList">
					        <c:param name="page" value="${currentPage - 1}" />
					        <c:if test="${not empty search}">
					            <c:param name="search" value="${search}" />
					        </c:if>
					        <c:param name="sort" value="${sortOption}" />
					        <c:param name="category" value="${categoryNum}" />
					    </c:url>
					    <a href="${prevUrl}">Previous</a>
					</c:if>

                    <button class="productList__button"><i class="fa-solid fa-angles-right"></i></button>
                    <c:if test="${currentPage < totalPages}">
					    <c:url var="nextUrl" value="/productList">
					        <c:param name="page" value="${currentPage + 1}" />
					        <c:param name="category" value="${categoryNum}" />
					        <c:if test="${not empty search}">
					            <c:param name="search" value="${search}" />
					        </c:if>
					        <c:param name="sort" value="${sortOption}" />
					        <c:param name="category" value="${categoryNum}" />
					    </c:url>
					    <a href="${nextUrl}">Next</a>
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
        //document.querySelector('#category').addEventListener('change', categoryHandler);
        document.querySelector('#beansTable').addEventListener('click', prodDetailHandler);

    }
    window.addEventListener('load', init);
</script>
<%@ include file="/WEB-INF/views/footer.jsp"%>