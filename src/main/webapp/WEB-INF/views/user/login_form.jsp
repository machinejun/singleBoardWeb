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
					<button type ="submit" id="btn-login">Sign in</button>
					<button id="btn-kakao">Sign in</button>
				</div>
				<br/><br/>
			</section>
			</form>
		</div>
	</div>

<%@ include file="../layout/footer.jsp" %>