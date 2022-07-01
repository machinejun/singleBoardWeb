let isCheck = 0;

$(document).ready(function() {
	
	$("#write-password-box").hide();
	
	$('.summernote').summernote({
		placeholder: 'content',
        tabsize: 2,
        height: 200,	
	});
	
	$("#secret-check").bind("click", () => {
		showBox();
	});
	
	$("#btn-write").bind("click", () => {
		location.href="/board/write";
	});
});

function showBox() {
	if(isCheck == 0) {
		$("#write-password-box").show();
		isCheck = 1;
	}else{
		$("#write-password-box").hide();
		isCheck = 0;
	}		
	
}

function writeBoard(){
	let userId=$("#userId").val();
	
	let data={
		title: $("#title").val(),
		content: $("#content").val(),
		secret: isCheck == 1 ? 1 : 0,
		password: isCheck == 1 ? $("#write-password").val() : null 
	}
	console.log(data);
	
	$.ajax({
		type: "post",
		url:"/api/board/write/" + userId,
		contentType: "application/json; charset=utf-8",
		data: JSON.stringify(data),
		dataType:"json"
	}).done(function(response){
		if(response.status == 200){
			alert("게시글 작성 완료");
			location.href="/";
		}
	}).fail(function(){
		alert("게시글 작성 실패");
	})
	
}


function showDetail(id, secret, password){
	let inputPW = "";
	if(secret == 1){
		inputPW = prompt('비밀번호를 입력하세요', 'password');
		if(password != inputPW){
			alert("잘못된 비밀번호 입니다.")
			return;
		}
	}
	location.href=`/board/detail/${id}`
}