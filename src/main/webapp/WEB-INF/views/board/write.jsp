<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<br/>
<div class="container">
	<h1 id="pTranMsg" class="info-txt text-center">게시글 작성</h1>
	<input type="hidden" id="userId" value="${principal.id}"></input>
	<div class="container">
		<div class="container">
			<span for="indvdlNm">제목</span><input class ="form-control" type="text" id="title" name="title" maxlength="150"/>
		</div>
		<br/>
		<br>
		<div id="dl_tel" class="container">
			<label for="moblPhon">내용</label><!-- 181023_접근성 수정 추가 -->
			<div class="bg-white"><textarea type="text" id="content" name="moblPhon" maxlength="11" class="summernote"></textarea></div>
		</div>		
	</div>
	<div class="container">
		<div class="container">
			<br/>
			<span> 비밀글 check →</span>
			<input type="checkbox" id="secret-check" name="moblAgree" class="m-2">
		</div>
		<div class="container" id="write-password-box" type="hidden">
			<br/>
			<span>비밀번호</span><input type="password" id="write-password" name="write-password" class="form-control">
			<br/>
		</div>		
	</div>
	<button type="button" class="btn btn-dark m-4" onclick="writeBoard()"><span>글 작성</span></button>
</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>