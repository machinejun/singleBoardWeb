<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
	<div class="main-container justify-content-center">
		<h1>Join Page</h1>
		<div class="main-wrap">
			<section class="login-input-section-wrap">
				<div class="login-input-wrap">	
					<input id="username" placeholder="Username" type="text"></input>
				</div>
				<br/>
				<div class="login-input-wrap password-wrap">	
					<input id="password" placeholder="Password" type="password"></input>
				</div>
				<div class="login-input-wrap">	
					<input id="email" placeholder="Email" type="email"></input>
				</div>
				<div class="login-button-wrap">
					<button onclick="saveUser()" id="btn-join">Save</button>
				</div>
				<br/><br/>
			</section>
		</div>
	</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>