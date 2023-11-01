<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

    <!-- Category -->
    <section id="mainCategory">
        <div class="max-container">
            <div class="mainCategory__detail">
                <img src="images/categoryTest1.jpg" alt="" class="mainCategory__detailImg" />
                <p class="mainCategory__detailTitle">영국</p>
            </div>
        </div>
    </section>
    <!-- productList -->
    <section id="productList">
        <div class="max-container">
            <div class="productList">
                <div class="productList__sortSerch">
                    <div class="productList__sort">
                        <button class="productList__sort">최신순</button>
                        <button class="productList__sort">인기순</button>
                        <button class="productList__sort">판매량순</button>
                    </div>
                    <div class="productList__search">
                        <input type="text" class="productList__searchInput" id="searchInput" />
                        <button class="productList__searchButton" type="submit" name="action" value="search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button> 
                    </div>
                </div>
                <div class="productList__product">
                    <div class="productList__productDiv">
                        <img class="productList__productImg" src="images/test2.jpg" alt="">
                        <p class="productList__productLikeCount"></p>
                    </div>
                    <div class="productList__button">
                        <button class="productList__before">이전</button>
                        <button class="productList__after">다음</button>
                    </div>
                </div>
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>