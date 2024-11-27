<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/spBookmarket/resources/css/bootstrap.min.css"></link>
<meta charset="UTF-8">
<title>도서 등록</title>
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
		<h1 class="display-3"><spring:message code="addBook.form.title.label"></spring:message></h1>
	</div>
</div> -->
<!-- 
<div class="float-right" style="padding-right:30px">
	<a href="?language=ko">Korean</a> | <a href="?language=en">English</a>
</div> -->

<div class="container">
	<div class="float-right" style="padding-right:30px">
		<a href="?language=ko">Korean</a> | <a href="?language=en">English</a>
	</div>
	<form:form modelAttribute="NewBook" action="./add?${_csrf.parameterName }=${_csrf.token }"
		 class="form-horizontal" enctype="multipart/form-data">
	<fieldset>
		<legend><spring:message code="addBook.form.subtitle.label"></spring:message></legend>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.bookId.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="bookId" class="form-control"/>
			</div>
			<div class="col-sm-6">
				<form:errors path="bookId" class="text-danger"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.name.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="name" class="form-control"/>
			</div>
			<div class="col-sm-6">
				<form:errors path="name" class="text-danger"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.unitPrice.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="unitPrice" class="form-control"/>
			</div>
			<div class="col-sm-6">
				<form:errors path="unitPrice" class="text-danger"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.author.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="author" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.description.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="description" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.publisher.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="publisher" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.category.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="category" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.unitsInStock.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="unitsInStock" class="form-control"/>
			</div>
			<div class="col-sm-6">
				<form:errors path="unitsInStock" class="text-danger"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.releaseDate.label"></spring:message></label>
			<div class="col-sm-3">
				<form:input path="releaseDate" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.condition.label"></spring:message></label>
			<div class="col-sm-3">
				<form:radiobutton path="condition" value="New"/>New
				<form:radiobutton path="condition" value="Old"/>Old
				<form:radiobutton path="condition" value="E-Book"/>E-Book
			</div>
		</div>
		<div class="form-group row">
			<label class="col-sm-2 control-label"><spring:message code="addBook.form.bookImage.label"></spring:message></label>
			<div class="col-sm-7">
				<form:input path="bookImage" type="file" class="form-control"/>
			</div>
		</div>
		<div class="form-group row">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-primary" value="<spring:message code="addBook.form.button.label"></spring:message>" />
			</div>
		</div>
	</fieldset>
	</form:form>
	
	<hr>
<!-- 	<footer>
		<p>&copy; WebMarket</p>
	</footer> -->
</div>
</body>
</html>