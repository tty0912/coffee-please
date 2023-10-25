<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

<!-- SignupSeller -->
    <section id="signup" class="section">
        <div class="max-container">
            <div class="signup">
                <div class="signup__form-div">
                    <h2 class="signup__title">Bean2B 비즈니스 회원 가입을 진행합니다.</h2> 
                    <h4 class="signup__description">커피도시 부산의 신선하고 맛있는 원두를 공급할 사장님들을 기다리고 있습니다.</h4> 
                    <form id="signup__form" method="post" action="memberController">
                        <label for="new-userId" class="signup__label">
                            <i class="fa-regular fa-envelope"></i>
                            <input
                                class="signup__input"
                                type="email"
                                id="new-userId"
                                name="seller_email"
                                placeholder="email@example.com"
                            />
                        </label> 
                        <label for="new-password" class="signup__label">
                            <i class="fa-solid fa-key"></i>
                            <input
                                class="signup__input"
                                type="password"
                                id="new-password"
                                name="passwd"
                                placeholder="4자리 이상 입력해주세요."
                            />
                        </label>
                        <label for="new-passwordConfirm" class="signup__label">
                            <i class="fa-solid fa-check"></i>
                            <input
                                class="signup__input"
                                type="password"
                                id="new-passwordConfirm"
                                name="passwdConfirm"
                                placeholder="비밀번호 확인"
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
                        <h4 class="business__title">사업자 정보</h4>
                        <label for="new-businessName" class="signup__label">
                            <i class="fa-solid fa-store"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-businessName"
                                name="business_name"
                                placeholder="상호명을 입력해주세요."
                            />
                        </label>
                        <label for="new-businessNumber" class="signup__label">
                            <i class="fa-regular fa-address-card"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-businessNumber"
                                name="business_num"
                                placeholder="사업자번호를 입력해주세요."
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
                        <button class="signup__button" id="signup-button" name="action" value="signUppage" type="submit">회원가입</button>
                      
                    </form>
                </div>
            </div>
        </div>
    </section>


<%@ include file = "/WEB-INF/views/footer.jsp" %>