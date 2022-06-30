<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">Junic blog</h1>
        <div class="list-group">
          <a href="/board/write" class="list-group-item">글쓰기</a>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
		<br/><br/>
        <div class="row">

          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">게시판 제목</a>
                </h4>
                <h5>조회수: </h5>     
              </div>
              <div class="card-footer">
                <p class="card-text">createTime: </p>
              </div>
            </div>
          </div>
          
          
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

<%@ include file="layout/footer.jsp" %>
