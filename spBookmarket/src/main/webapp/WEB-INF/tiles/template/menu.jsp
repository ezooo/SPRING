<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/home">Book Market</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/spBookmarket/home">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/spBookmarket/books">Books</a></li>
				<li class="nav-item"><a class="nav-link" href="/spBookmarket/books/add">Add Book</a></li>
				<li class="nav-item"><a class="nav-link" href="/spBookmarket/cart">Cart</a></li>
			</ul>
		</div>
	</div>
</nav>
