<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h2>스프링 시큐리티 태그 예 2</h2>

<sec:authorize access="hasRole('ROLE_MANAGER')" var="isManager">
	<p><h3>매니저 권한 화면입니다.</h3></p>
</sec:authorize>

<c:choose>
	<c:when test="${isManager }">
		<p>ROLE_MANAGER 권한 로그인 중입니다.</p>
		<p><a href="<c:url value='/exam02' />">[웹 요청 URL /exam02 로 이동하기]</a></p>
	</c:when>
	<c:otherwise>
		<p>로그인 중이 아닙니다.</p>
		<p><a href="<c:url value='/manager/tag' />">[웹 요청 URL /manager/tag 로 이동하기]</a></p>
	</c:otherwise>
</c:choose>
</body>
</html>