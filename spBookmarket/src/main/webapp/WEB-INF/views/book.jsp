<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/spBookmarket/resources/css/bootstrap.min.css"></link>
<script src="/spBookmarket/resources/js/controllers.js"><</script>
<title>도서 상세 정보</title>
</head>

<body>
<!-- <nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/spBookmarket/home">Home</a>
		</div>
	</div>
</nav>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">도서 정보</h1>
	</div>
</div> -->

<div class="container">
	<div class="row">
		<div class="col-md-4">
			<c:choose>
					<c:when test="${book.getFileName() ==null }">
					이미지없
						<img src="<c:url value="/resources/images/${book.fileName}" />" style="width:100%" />
					</c:when>
					<c:otherwise>
						<img src="<c:url value="/resources/images/${book.fileName}" />" style="width:100%" />
					</c:otherwise>
				</c:choose>
		</div>
		<div class="col-md-12">
			<h3>${book.name}</h3>
			<p>${book.description }</p>
			<br>
			<p><b>도서코드 : </b> <span class="badge badge-info">${book.bookId}</span></p>
			<p><b>저자 : </b> ${book.author }</p>
			<p><b>출판사 : </b> ${book.publisher}</p>
			<p><b>출판일 : </b> ${book.releaseDate}</p>
			<p><b>분류 : </b> ${book.category}</p>
			<p><b>재고수 : </b> ${book.unitsInStock}</p>
			<h4>${book.unitPrice}원</h4>
			<br>
			<form:form name="addForm" method="PUT">
				<p><a href="javascript:addToCart('../cart/add/${book.bookId}')" class="btn btn-primary">도서주문 &raquo;</a>
					<a href="<c:url value="/cart"/>" class="btn btn-warning" role="button">장바구니 &raquo;</a>
					<a href="<c:url value="/books"/>" class="btn btn-secondary" role="button">도서목록 &raquo;</a></p>		
			</form:form>
		</div>
	</div>
	<hr>
<!-- 	<footer>
		<p>&copy; WebMarket</p>
	</footer> -->
</div>
</body>
<!-- 
<script >	//src="/spBookmarket/resources/js/controllers.js"
function addToCart(action)
{
	console.log("addToCart 함수 호출됨");
	document.addForm.action = action;
	document.addForm.submit();
	alert("도서가 장바구니에 추가되었습니다!");
}
</script> -->
</html>