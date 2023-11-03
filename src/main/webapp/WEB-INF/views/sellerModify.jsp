<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

 <!-- SellerModify -->
    <section id="signup" class="section">
        <div class="max-container">
            <div class="signup">
                <div class="signup__form-div">
                    <h2 class="signup__title">Bean2B 비즈니스 회원 정보를 수정해주세요.</h2> 
                    <form id="signup__form" method="post" action="sellerModifyChange">
                        <label for="new-userId" class="signup__label">
                            <i class="fa-regular fa-envelope"></i>
                            <input
                                class="signup__input"
                                type="email"
                                id="new-userId"
                                name="sellerEmail"
                                value="${ seller.sellerEmail }"
                                placeholder="email@example.com"
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
                                value="${ seller.nickname }"
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
                                value="${ seller.tel }"
                                placeholder="휴대폰번호를 입력해주세요."
                            />
                        </label>
                        <h4 class="business__title">사업자 정보</h4>
                        <label for="new-businessName" class="signup__label">
                            <i class="fa-solid fa-store"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-businessName"
                                name="businessName"
                                value="${ seller.businessName }"
                                placeholder="상호명을 입력해주세요."
                                disabled
                            />
                        </label>
                        <label for="new-businessNumber" class="signup__label">
                            <i class="fa-regular fa-address-card"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-businessNumber"
                                name="businessNum"
                                value="${ seller.businessNum }"
                                placeholder="사업자번호를 입력해주세요."
                                disabled title="입력 폼이 비활성화되었습니다."
                            />
                        </label>
                        
                        <label for="new-address" class="signup__label">
                            <i class="fa-solid fa-location-dot"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-address"
                                name="address"
                                value="${ seller.address }"
                                placeholder="주소를 입력해주세요."
                            />
                        </label>
                        <input type="file" class="fileInput" />
                        <div class="signup__button-div">
                            <button class="signup__button" id="signup-button" type="submit">수정</button>
                        </div>
                    </form>
                    <form method="get" action="myPageSeller">
	                	<button class="signup__button" id="signup-button">취소</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

<%@ include file = "/WEB-INF/views/footer.jsp" %>