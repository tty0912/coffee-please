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
                        <button class="productList__sort">최신순</button>
                        <button class="productList__sort">인기순</button>
                        <button class="productList__sort">판매량순</button>
                    </div>
                    <form class="productList__search">
                        <input type="text" class="productList__searchInput" id="searchInput" />
                        <button class="productList__searchButton" type="submit" name="action" value="search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button> 
                    </form>
                </div>
                <div class="productList__productDiv">
                    <div class="productList__product">
                        <img class="productList__productImg" src="images/test2.jpg" alt="">
                        <div class="productList__productText">
                            <p class="productList__productTitle">원두</p>
                            <p class="productList__productPrice">12,000원</p>
                            <p class="productList__productCategory">케냐</p>
                            <div class="productList__likeButton">
                                <button class="myPageLike__button"><i class="fa-solid fa-heart"></i></button>
                                <p class="mainBeanBest__productLikeCount">30</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="productList__buttonDiv">
                    <button class="productList__button"><i class="fa-solid fa-angles-left"></i></button>
                    <button class="productList__button"><i class="fa-solid fa-angles-right"></i></button>
                </div>
            </div>
        </div>
    </section>


<!-- Category -->
<section id="mainCategory">
	<div class="max-container">
		<div class="mainCategory__detail">
			<img src="images/categoryTest1.jpg" alt=""
				class="mainCategory__detailImg" />
			<p class="mainCategory__detailTitle">영국</p>
		</div>
	</div>
</section>
<!-- productList -->
<section id="productList">
	<div class="max-container">
		<div class="productList">
			<form action="/coffee/beansList" method="GET" id="sorting">
				<div class="productList__sortSerch">
					<div class="productList__sort">
						<button class="productList__sort" type="submit" name="sort"	value="recent">최신순</button>
						<button class="productList__sort" type="submit" name="sort" value="mostLiked">인기순</button>
						<button class="productList__sort" type="submit" name="sort" value="bestSelling">판매량순</button>
					</div>
					<div class="productList__search">
						<input type="text" class="productList__searchInput"
							id="searchInput" />
						<button class="productList__searchButton" type="submit"
							name="search" value="search" placeholder="검색어 입력">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>
					</div>
				</div>
			</form>
			<div class="productList__product">
				<div class="productList__productDiv">
					<img class="productList__productImg" src="images/test2.jpg" alt="">
					<p class="productList__productLikeCount"></p>
				</div>
				<%--기존:버튼 현재:링크 --%>
				<div class="productList__button">
					<c:if test="${currentPage > 1}">
						<c:url var="prevUrl" value="/beansList">
							<c:param name="page" value="${currentPage - 1}" />
							<c:if test="${not empty search}">
								<c:param name="search" value="${search}" />
							</c:if>
							<c:param name="sort" value="${sortOption}" />
							<c:param name="category" value="${categoryNum}" />
						</c:url>
						<a class="productList__before" href="${prevUrl}">이전</a>
					</c:if>

					<c:if test="${currentPage < totalPages}">
						<c:url var="nextUrl" value="/beansList">
							<c:param name="page" value="${currentPage + 1}" />
							<c:if test="${not empty search}">
								<c:param name="search" value="${search}" />
							</c:if>
							<c:param name="sort" value="${sortOption}" />
							<c:param name="category" value="${categoryNum}" />
						</c:url>
						<a class="productList__after" href="${nextUrl}">다음</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</section>



<%@ include file="/WEB-INF/views/footer.jsp"%>