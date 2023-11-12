<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>더 많은 원두 보기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/mainStyle.css"> 
</head>
<body>
    <div class="popup">
    	<img class="popupImg" src="${pageContext.request.contextPath }/images/popupSignup.png" alt="">
        <p>로그인 후 이용가능합니다.</p>
        <button id="closePopupButton">닫기</button>
    </div>

    <script>
        document.getElementById('closePopupButton').addEventListener('click', function () {
            var popup = document.querySelector('.popup');
            popup.classList.remove('active');
        });
        document.getElementById('closePopupButton').addEventListener('click', function () {
            window.close();
        });

    </script>
</body>
</html>
