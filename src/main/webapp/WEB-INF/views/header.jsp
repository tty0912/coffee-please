<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Seo -->
    <title>Bean2B</title>
    <link rel="shortcut icon" href="images/logoCircle.ico" type="image/x-icon">
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/98a796a30f.js" crossorigin="anonymous"></script>
    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/signupStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/productStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/myPageStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/mainStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/cartStyle.css">
    <!-- Javascript -->
    <script>
    let sellerEmail = ${sellerEmail};
    let buyerEmail = ${buyerEmail};
    
    
    </script>
    <script type="module" src="${pageContext.request.contextPath }/js/signup.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/myPage.js" defer></script>
    <script type="module" src="${pageContext.request.contextPath }/js/main.js" defer></script>
</head>
<body>
    <!-- Header -->
    <header class="header">
        <nav class="header__nav">
            <ul class="header__menu">
                <li><a class="header__menu__item" href="#about">STORE</a></li>
                <div class="header__menu__item header__logo">
                    <img class="header__logo__img" src="images/logoName.png" alt="logo" />
                </div>
                <li><a class="header__menu__item" href="#about">GROUP</a></li>
            </ul>
            <ul class="header__side">
                <li><a class="header__menu__item header__cart" href="#about"><i class="fa-solid fa-cart-shopping"></i></a></li>
                <li><a class="header__menu__item header__user" href="#about"><i class="fa-regular fa-user"></i></a></li>
            </ul>
        </nav>
    </header>