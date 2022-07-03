function checkEmptyUserData(){
	let data = {
		username: $("#username").val(),
		password: $("#password").val(),
		email: $("#email").val()
	}
	
	if(data.username == ""){
		alert("아이디가 비어있습니다.")
		return false;
	}else if(data.password == ""){
		alert("비밀번호가 비어있습니다.")
		return false;
	}
}

