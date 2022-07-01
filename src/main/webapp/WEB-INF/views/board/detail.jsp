<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
 <div id="board_read">
       <h2>title</h2>
           <div id="user_info" align=right>

            </div>

 
    <!-- 목록, 수정, 삭제 -->
 
       <div id="bo_ser">
             <ul>
                    <li><a href="#">[목록으로]</a></li>
                    <li><a href="#">[수정]</a></li>
                    <li><a href="#">[삭제]</a></li>
            </ul>
      </div>
 
  </div>
  <!--- 댓글 불러오기 -->
<div class="reply_view">
    <h3>댓글목록</h3>
        <div class="dap_lo">
            <div><b><?php echo $reply['name'];?></b></div>
            <div class="dap_to comt_edit"></div>
            <div class="rep_me dap_to"></div>
        </div>
 
    <!--- 댓글 입력 폼 -->
    <div class="dap_ins">
        <form action="" method="post">
            <input type="hidden" name="dat_user" id="dat_user" class="dat_user" size="15" placeholder="아이디" >
            <div style="margin-top:10px; ">
                <textarea name="content" class="reply_content" id="re_content" ></textarea>
                <button id="rep_bt" class="re_bt">댓글</button>
            </div>
        </form>
    </div>
</div><!--- 댓글 불러오기 끝 -->

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>