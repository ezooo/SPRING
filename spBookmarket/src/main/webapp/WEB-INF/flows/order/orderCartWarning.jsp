<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/spBookmarket/resources/css/bootstrap.min.css"></link>
<meta charset="UTF-8">
<title>thank you</title>
</head>

<body>
<!-- <nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/spBookmarket/home">Home</a>
			<a class="navbar-brand" href="/spBookmarket/books">Books</a>
			<a class="navbar-brand" href="/spBookmarket/cart">Cart</a>
		</div>
	</div>
</nav>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">주문취소</h1>
	</div>
</div> -->
<div class="container">
	<h2 class="alert alert-danger">주문을 취소하였습니다.</h2>
</div>
<div class="container">
	<p>
		<a href="<c:url value="/books"></c:url>" class="btn btn-primary">&laquo; 도서목록</a>
	</p>
</div>
</body>
</html>