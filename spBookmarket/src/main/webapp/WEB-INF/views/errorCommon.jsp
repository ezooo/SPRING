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
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/spBookmarket/home">Home</a>
		</div>
	</div>
</nav>
<div class="jumbotron">
	<div class="container">
		<h2 class="alert alert-danger">
			요청한 도서가 존재하지 않습니다. <br>

		</h2>
	</div>
</div>
<div class="container">
	<p>${exception }</p>
</div>
<div class="container">
	<p>
		<a class="btn btn-secondary" href="/spBookmarket/books">도서목록 &raquo;</a>
	</p>
</div>
</body>
</html>