<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

<!-- SignupBuyer -->
    <section id="signup" class="section">
        <div class="max-container">
            <div class="signup">
                <div class="signup__form-div">
                    <h2 class="signup__title">Bean2B 구매자 회원 가입을 진행합니다.</h2> 
                    <h4 class="signup__description">맛있는 커피를 찾고 계신가요? 커피도시 부산의 신선한 원두로 여러분을 기다리고 있습니다.</h4> 
                    <form id="signup__form" method="post" action="signupBuyer">
                        <label for="new-userId" class="signup__label">
                            <i class="fa-regular fa-envelope"></i>
                            <input
                                class="signup__input"
                                type="email"
                                id="new-userId"
                                name="buyerEmail"
                                placeholder="email@example.com"
                            />
                        </label> 
                        <label for="new-username" class="signup__label">
                            <i class="fa-regular fa-id-card"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-username"
                                name="buyerName"
                                placeholder="이름을 입력해주세요."
                            />
                        </label>
                        <label for="new-password" class="signup__label">
                            <i class="fa-solid fa-key"></i>
                            <input
                                class="signup__input"
                                type="password"
                                id="new-username"
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
                                oninput="phoneNumber(this)"
                                placeholder="휴대폰번호를 입력해주세요."
                                maxlength="13"
                            />
                        </label>
                        <label for="new-address" class="signup__label">
                            <i class="fa-solid fa-location-dot"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-address"
                                name="address"
                                placeholder="테스를 입력해주세요."
                            />
                        </label>
                        <button class="signup__button" name="action" value="register" type="submit">회원가입</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <script type="text/javascript">
    const phoneNumber = (target) => {
        
    	const phoneNumberValue = target.value.replace(/-/g, '').replace(/[^0-9]/g, '');
    	let formattedNumber = "";

    	if (phoneNumberValue.length >= 4 && phoneNumberValue.length <= 7) {
        	formattedNumber = phoneNumberValue.replace(/(\d{3})(\d{1,4})/g, "$1-$2");
    	} else if (phoneNumberValue.length > 7) {
        	formattedNumber = phoneNumberValue.replace(/(\d{3})(\d{4})(\d{0,4})/g, "$1-$2-$3");
    	} else {
        	formattedNumber = phoneNumberValue;
    	}

    	target.value = formattedNumber;



   
    	sendDataToServer(phoneNumberValue);
	}
	</script>

<%@ include file = "footer.jsp" %>



















