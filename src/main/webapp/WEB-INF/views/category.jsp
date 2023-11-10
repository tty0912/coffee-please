<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Category -->
    <section id="mainCategory" class="section">
       <div class="max-container">
        <h1 class="mainCategory__title">Category</h1>
            	<div id="categoryList" class="mainCategory">
                    <c:forEach items="${categoryList}" var="categoryDO" >
        			<div class="mainCategory__detail">
        				<img id="categoryName"  alt="" class="mainCategory__detailImg" src="${categoryDO.categoryImg}"/>
        				<p class="mainCategory__detailTitle">${categoryDO.categoryName}</p>
        			</div>
        			</c:forEach>
            	</div>
        </div>
    </section>