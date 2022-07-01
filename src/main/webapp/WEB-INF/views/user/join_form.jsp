<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<div class="main-container justify-content-center">
		<h1>Join Page</h1>
		<div class="main-wrap">
			<form action="/auth/joinProc" method="post" onSubmit="return checkEmptyUserData()">
			<section class="login-input-section-wrap">
				<div class="login-input-wrap">	
					<input id="username" placeholder="Username" name="username" type="text"></input>
				</div>
				<br/>
				<div class="login-input-wrap password-wrap">	
					<input id="password" placeholder="Password" name="password" type="password"></input>
				</div>
				<div class="login-input-wrap">	
					<input id="email" placeholder="Email" name="email" type="email"></input>
				</div>
				<div class="login-button-wrap">
					<button type="" id="btn-join">Save</button>
				</div>
				<br/><br/>
			</section>
			</form>
		</div>
	</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>