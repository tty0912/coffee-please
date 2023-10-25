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
                    <form id="signup__form" action="Controller">
                        <label for="new-userId" class="signup__label">
                            <i class="fa-regular fa-envelope"></i>
                            <input
                                class="signup__input"
                                type="email"
                                id="new-userId"
                                name="buyer_email"
                                placeholder="email@example.com"
                                disabled
                            />
                        </label> 
                        <label for="new-username" class="signup__label">
                            <i class="fa-regular fa-id-card"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-username"
                                name="buyer_name"
                                placeholder="이름을 입력해주세요."
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
                                placeholder="휴대폰번호를 입력해주세요."
                            />
                        </label>
                        <label for="new-address" class="signup__label">
                            <i class="fa-solid fa-location-dot"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-address"
                                name="adr"
                                placeholder="주소를 입력해주세요."
                            />
                        </label>
                        <input type="file" class="fileInput" />
                        <div class="signup__button-div">
                            <button class="signup__button" id="signup-button" name="action" value="mypageBuyer" type="submit">취소</button>
                            <button class="signup__button" id="signup-button" name="action" value="UpdateMember" type="submit">수정</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>



<%@ include file = "/WEB-INF/views/footer.jsp" %>