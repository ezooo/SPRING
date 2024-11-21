<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/spBookmarket/resources/css/bootstrap.min.css"></link>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
<h3>RESTful 웹 서비스</h3>
<button onclick="test()" type="button">실행하기</button>
</body>
<script>
var obj = {"name":"kim", "age":20};
function test()
{
	$.ajax
	(
		{
			url : "<c:url value="/test" />",
			type : "post",
			data : JSON.stringify(obj),
			dataType : "json",
			contentType : "application/json",
			success : function(data)
						{
							alert("성공");
						},
			error : function(errorThrown)
						{
							alert("실패");
						}	
		}		
	);	
}
</script>
</html>