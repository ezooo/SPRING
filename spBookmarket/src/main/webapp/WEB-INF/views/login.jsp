<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/spBookmarket/resources/css/bootstrap.min.css"></link>
<title>Insert title here</title>
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
		<h1 class="display-3">로그인</h1>
	</div>
</div> -->
<div class="container col-md-4">
	<div class="text-center">
		<h3 class="form-signin-heading">Please login</h3>
	</div>
	<c:if test="${not empty error}">
		<div class="alert alert-danger">
			username 과 password가 올바르지 않습니다. <br>
		</div>
	</c:if>
	<form class="form-singin" action="<c:url value="/login"/>" method="post">
		<div class="form-group row">
			<input type="text" name="username" class="form-control" placeholder="username" required autofocus>
		</div>
		<div class="form-group row">
			<input type="password" name="password" class="form-control" placeholder="password" required>
		</div>
		<div class="form-group row">
			<button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token}" />
		</div>
	</form>
</div>
</body>
</html>