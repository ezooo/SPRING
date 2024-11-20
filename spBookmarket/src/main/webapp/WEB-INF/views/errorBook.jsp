<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/spBookmarket/resources/css/bootstrap.min.css"></link>
<meta charset="UTF-8">
<title>예외 처리</title>
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
			해당 도서가 존재하지 않습니다. <br>
			요청 도서ID : ${invalidBookId }
		</h2>
	</div>
</div>
<div class="container">
	<p>${url }</p>
	<p>${exception }</p>
</div>
<div class="container">
	<p>
		<a class="btn btn-secondary" href="/spBookmarket/books">도서목록 &raquo;</a>
	</p>
</div>
</body>
</html>