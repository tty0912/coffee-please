<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.product.BeansDO"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Group Beans List</title>
</head>
<body>
	<h1>Group Beans List</h1>

	<form action="/coffee/beansList" method="GET">
    	<button type="submit" name="sort" value="bestSelling">판매량 높은 순</button>
	</form>
	<form action="/coffee/beansList" method="GET">
	    <button type="submit" name="sort" value="mostLiked">좋아요 높은 순</button>
	</form>
	
    <p>현재 정렬 옵션: ${sortOption}</p>
	<table border="1">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>이미지</th>
			<th>찜수</th>
			<th>마감 기한</th>
			<th>목표 kg</th>
			<th>할인 된 가격</th>
		</tr>
		<c:forEach items="${groupBeansList}" var="bean">
			<tr>
				<td>${bean.beansNum}</td>
				<td>${bean.beanName}</td>
				<td>${bean.beanPrice}</td>
				<td>${bean.beanImg}</td>
				<td>${bean.likeCount}</td>
				<td>${bean.deadline}</td>
				<td>${bean.goalQty}</td>
				<td>${bean.goalPrice}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="<c:url value='/groupBeansList?page=${currentPage - 1}' />">Prev</a>
	</c:if>
	<c:if test="${currentPage < totalPages}">
		<a href="<c:url value='/groupBeansList?page=${currentPage + 1}' />">Next</a>
	</c:if>

</body>
</html>