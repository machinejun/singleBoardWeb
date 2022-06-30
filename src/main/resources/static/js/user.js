function saveUser(){
	alert("savebutton 클릭")
	let data = {
		username: $("#username").val(),
		password: $("#password").val(),
		email: $("#email").val()
	}
	
	console.log(data);
	if(data.username.length < 1){
		alert("username은 한글자 이상이어야 합니다.");
		return;
	}else if(data.password.length < 5){
		alert("password는 5글자 이상이어야 합니다");
		return;
	}
	
	if(data.email.includes("@") == false){
		alert("email 형식에 맞지 않습니다");
		return;
	}
	
	$.ajax({
		type: "POST",
		url: "/api/user/joinProc",
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(data),
		dataType: "json"	
	}).done(function(response) {
		console.log(response);
	}).fail(function(err) {
		console.log(err);
	})

	
}
