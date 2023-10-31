<%@ page contentType="text/html; charset=UTF-8" 
	import="java.util.*"
    	  %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<%@ include file = "/WEB-INF/views/header.jsp" %>

 <!-- registerProduct -->
   <section id="signup" class="section">
        <div class="max-<div class="max-container">">
            <div class="signup">
                <div class="signup__form-div">
                    <h2 class="signup__title">Bean2B 일반 상품 등록을 진행합니다.</h2> 
                    <h4 class="signup__description">맛있는 원두를 등록해주세요!</h4> 
                    <form id="signup__form" action="Controller">
                        <label for="new-beanName" class="signup__label">
                            <img src="${pageContext.request.contextPath}/images/bean.png" alt="" class="bean__img">
                            <input
                                class="signup__input"
                                type="text"
                                id="new-beanName"
                                name="beanName"
                                placeholder="상품 이름 입력"
                            />
                        </label> 
                        <label for="new-beanPrice" class="signup__label">
                            <i class="fa-solid fa-tags"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-beanPrice"
                                name="beanPrice"
                                placeholder="상품 가격 입력"
                            />
                        </label>
                        <label for="new-cName" class="signup__label">
                            <i class="fa-solid fa-flag-checkered"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-cName"
                                name="cName"
                                placeholder="원산지 입력"
                            />
                        </label>
                        <label for="new-deliveryCharge" class="signup__label">
                            <i class="fa-solid fa-truck-fast"></i>
                            <input
                                class="signup__input"
                                type="text"
                                id="new-deliveryCharge"
                                name="deliveryCharge"
                                placeholder="배송료 입력"
                            />
                        </label>
                        <input type="file" class="fileInput" name="beanImg" />
                        <input type="file" class="fileInput" name="descript" />
                        <div class="signup__button-div">
                            <button class="signup__button" id="signup-button" name="action" value="signUppage" type="submit">취소</button>
                            <button class="signup__button" id="signup-button" name="action" value="signUppage" type="submit">등록</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <div class="sources">
        <a href="https://www.flaticon.com/kr/free-icons/" title="커피 아이콘">커피 아이콘  제작자: Freepik - Flaticon</a>
    </div>
<%@ include file = "/WEB-INF/views/footer.jsp" %>