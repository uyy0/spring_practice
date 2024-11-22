function addToCart(action){
	document.addForm.action=action;
	document.addForm.submit();
	alert("도서가 장바구니에 추가되었습니다!");
}

function removeFromCart(action){
	console.log("js실행됨");
	document.removeForm.action=action;
	console.log("action실행됨");
	console.log(action);
	document.removeForm.submit();
	console.log("submit실행됨");
	// 요청 완료 후 리로드
    setTimeout(function() {
        window.location.reload();
        console.log("reload 실행됨");
    }, 100); // 0.1초 후에 리로드
}

function clearCart(){
	document.clearForm.submit();
	setTimeout(function() {
	    window.location.reload();
	    console.log("reload 실행됨");
	}, 100); // 0.1초 후에 리로드
}