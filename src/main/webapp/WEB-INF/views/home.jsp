<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<c:set var="islogin" value=""/>
<c:set var="isNotlogin" value="disabled"/>
  <!-- Page Content -->

<section class="notice">
  <div class="page-title">
        <div class="container">
            <h3>게시판</h3>
        </div>
    </div>

    <!-- board seach area -->
    <div id="board-search">
        <div class="container">
            <div class="search-window">
                <form action="">
                    <div class="search-wrap">
                        <label for="search" class="blind">공지사항 내용 검색</label>
                        <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">
                        <button type="submit" class="btn btn-dark">검색</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
   
  <!-- board list area -->
    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">제목</th>
                    <th scope="col" class="th-date">등록일</th>
                </tr>
                </thead>
                <tbody>
	                <c:forEach var="board" items="${boards.content}">
						<c:choose>
							<c:when test="${board.secret eq 1 }">
				                <tr>
				                    <td>${board.id }</td>
				                    <th>
				                      <a onclick="showDetail(${board.id}, ${board.secret}, ${board.password})"><img id="card-img" src="/images/secret.png"/>${board.title }</a>
				                      <p>테스트</p>
				                    </th>
				                    <td>${board.createTime}</td>
				                </tr>
				
				            </c:when>
				            <c:otherwise>
				            	<tr>
				                    <td>${board.id }</td>
				                    <th>
				                      <a onclick="showDetail(${board.id}, ${board.secret}, ${board.password})" >${board.title }</a>
				                      <p>테스트</p>
				                    </th>
				                    <td>${board.createTime}</td>
				                </tr>
				            </c:otherwise>    
	                	</c:choose>
					</c:forEach>
                </tbody>
            </table>
            <button id="btn-write" class="btn btn-dark m-2 ${principal.username eq null ? isNotlogin : islogin}">글쓰기</button>
    	</div>
    </div>
</section>  
  
    
<script src="/js/board.js"></script>
<%@ include file="layout/footer.jsp" %>
