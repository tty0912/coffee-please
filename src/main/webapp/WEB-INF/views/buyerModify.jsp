<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

<!-- BuyerModify -->
    <section id="signup__buyerModify" class="section">
        <div class="max-container">
            <div class="signup__buyerModify">
                <div class="signup__form-div">
                    <h2 class="signup__title">Bean2B 구매자 회원 정보를 수정해주세요.</h2> 
                    <!-- 수정부분 form에서 method, action, input name속성 수정 -->
                    <form id="signup__form" method="post" action="buyerModifyChange">
                        <label for="new-userId" class="signup__label">
                            <i class="fa-regular fa-envelope"></i>
                            <input
                                class="signup__input"
                                type="email"
                                id="new-userId"
                                name="buyerEmail"
                                value="${ buyer.buyerEmail }"
                                disabled
                            />
                        </label> 
                        <label for="new-username" class="signup__label">
                            <i class="fa-regular fa-id-card"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-username"
                                name="buyerName"
                                value="${ buyer.buyerName }"
                                disabled
                            />
                        </label>
                        <label for="new-sellerName" class="signup__label">
                            <i class="fa-regular fa-circle-user"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-sellerName"
                                name="nickname"
                                value="${ buyer.nickname }"
                                placeholder="2자리 이상 입력해주세요."
                            />
                        </label>
                        <label for="new-phoneNumber" class="signup__label">
                            <i class="fa-solid fa-phone"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-phoneNumber"
                                name="tel"
                                value="${ buyer.tel }"
                                placeholder="휴대폰번호를 입력해주세요."
                            />
                        </label>
                        <label for="new-address" class="signup__label">
                            <i class="fa-solid fa-location-dot"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-address"
                                name="address"
                                value="${ buyer.address }"
                                placeholder="주소를 입력해주세요."
                            />
                        </label>
                        <input type="file" class="fileInput" />
                        <div class="signup__button-div">
                            <button class="signup__button" id="signup-button" type="submit" name="action" value="buyerModifyChange">수정</button>
                            <button class="signup__button" id="signup-button" type="submit" name="action" value="previousPage">취소</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>