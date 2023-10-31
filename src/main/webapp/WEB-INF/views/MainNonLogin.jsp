<%@ page  contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Bean 2 B</title>

    <!--favicon-->
    <link rel="icon" href="coffee/images/logo/logoCircle.png" type="image/x-icon" />

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&display=swap"
            rel="stylesheet"
    />

    <!-- Font Awesome -->
    <script
            src="https://kit.fontawesome.com/98a796a30f.js"
            crossorigin="anonymous"
    ></script>

    <!-- CSS -->
    <link rel="stylesheet" href="/coffee/css/MainNonLogin.css" />
    <!-- Javascript -->
    <script type="text/javascript" src="../JS/coffee.js"></script>
</head>

<body>
<!-- Header -->
<header class="header">
    <nav class="header__nav">
        <ul class="header__menu">
            <li><a class="header__menu__item" href="#about">STORE</a></li>
            <div class="header__logo">
                <img
                        class="header__logo__img"
                        src="/coffee/images/logo/logoName.png"
                        alt="logo"
                />
            </div>
            <li><a class="header__menu__item" href="#about">GROUP</a></li>
        </ul>
    </nav>
</header>

<!-- main -->
<main class="main-container">
    <div class="banner-container">
        <img class="banner-img" src="/coffee/images/logo/MainSetMeUp.png">
        <form class="login-container">
            <input class="login-id" placeholder="아이디를 입력해주세요"></input>
            <input class="login-pwd" placeholder="비밀번호를 입력해주세요"></input>
            <div class="btn-container">
                <button class="login-btn btn-item">로그인 하기</button>
                <a class="register-btn btn-item" href="#">회원가입 하기</a>
            </div>
        </form>
    </div>

    <!-- 나라별 카테고리 -->
    <div class="country-container">
        <div class="country-category">원두 나라별 카테고리</div>
    </div>

   <!-- 나라별 국기 , 국기 이름-->
    <div class="flag-container">
    <c:forEach items="${categoryList}" var="categoryDO" >
        <div class="flag-item">
            <span>${categoryDO.categoryName}</span>
        </div>
        </c:forEach>
    </div>

    <!-- 원두 베스트 상품 -->
    <div class="bestProductName-container">
        <div class="bestProductName">원두 베스트 상품</div>
    </div>

    <!-- 베스트 상품 -->
    <div class="product-container">
    <c:forEach items="${bestBean}" var="beansDO" >
        <img src="${beansDO.beanImg}" >
        <div>${beansDO.likeCount}</div>
    </c:forEach>
    </div>

    <!-- 상품 찜하기기능 -->
    <div class="Steamed-container">
        <div id='result'>0</div>
    <input class="plus-button" type='button'
           onclick='count("plus")'
           value='+'/>
    </div>

    <!-- 상품 더보기 기능 -->
    <div class="seemore-container">
        <botton class="seemore">상품 목록 페이지로 이동</botton>
    </div>
</main>

<!-- Footer -->
<footer id="contact" class="section">
    <div class="max-container">
        <p>©Ga young Yu - All rights reserved</p>
    </div>
</footer>
</body>
</html>