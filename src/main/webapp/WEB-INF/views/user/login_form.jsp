<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

	<div class="main-container justify-content-center">
		<h1>Login Page</h1>
		<div class="main-wrap">
			<form action="/auth/loginProc" method="post">
			<section class="login-input-section-wrap">
				<div class="login-input-wrap">	
					<input placeholder="Username" name="username" type="text"></input>
				</div>
				<div class="login-input-wrap password-wrap">	
					<input placeholder="Password" name="password" type="password"></input>
				</div>
				<div class="login-button-wrap">
					<button type ="submit" id="btn-login">로그인</button>
					<br/>
					<a  id="btn-kakao" href="https://kauth.kakao.com/oauth/authorize?client_id=69bb289e289679807d6c1b04006eb7ca&redirect_uri=http://localhost:9090/oauth/kakao/callback&response_type=code" ><img src="/images/kakao_btn_large.png" width="470" height="48"></img></a>
				</div>
				<br/><br/>
			</section>
			</form>
		</div>
	</div>

<%@ include file="../layout/footer.jsp" %>