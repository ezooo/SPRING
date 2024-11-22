function addToCart(action)
{
	console.log("addToCart 함수 호출됨");
	document.addForm.action = action;
	document.addForm.submit();
	alert("도서가 장바구니에 추가되었습니다!");
}

function removeToCart(action)
{
	console.log("removeToCart 함수 호출됨");
	document.removeForm.action = action;
	document.removeForm.submit();
	setTimeout
	(
		function(){window.location.reload();}, 200
	);
}

function clearCart()
{
	console.log("clearCart 함수 호출됨");
	document.clearForm.submit();
	//window.location.reload();
	setTimeout
		(
			function(){window.location.reload();}, 200
		);
}