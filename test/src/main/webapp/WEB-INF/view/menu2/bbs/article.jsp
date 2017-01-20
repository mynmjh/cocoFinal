<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
   String cp = request.getContextPath();
%>

<style type="text/css">
.bbs-article .table {
    margin-top: 15px;
}
.bbs-article .table thead tr,  .bbs-article .table tbody tr {
    height: 30px;
}
.bbs-article .table thead tr th, .bbs-article .table tbody tr td {
    font-weight: normal;
    border-top: none;
    border-bottom: none;
}
.bbs-article .table thead tr {
    border-top: #d5d5d5 solid 1px;
    border-bottom: #dfdfdf solid 1px;
} 
.bbs-article .table tbody tr {
    border-bottom: #dfdfdf solid 1px;
}
.bbs-article .table i {
    background: #424951;
    display: inline-block;
    margin: 0 7px 0 7px;
    position: relative;
    top: 2px;
    width: 1px;
    height: 13px;    
}
</style>

<script>
//댓글 리스트
$(function(){
	listPage(1);
});

function listPage(page) {
	var url="<%=cp%>/bbs/listReply";
	var num="${dto.num}";
	$.post(url, {num:num, pageNo:page}, function(data){
		$("#listReply").html(data);
	});
}

function login() {
	location.href="<%=cp%>/member/login";
}///////////////////////////

//댓글 추가
function sendReply() {
	var uid="${sessionScope.member.userId}";
	if(! uid) {
		login();
		return false;
	}

	var num="${dto.num}"; // 해당 게시물 번호
	var content=$.trim($("#content").val());
	if(! content ) {
		alert("내용을 입력하세요 !!! ");
		$("#content").focus();
		return;
	}
	
	var query="num="+num;
	query+="&content="+content;
	
	$.ajax({
		type:"POST"
		,url:"<%=cp%>/bbs/insertReply"
		,data:query
		,dataType:"json"
		,success:function(data) {
			$("#content").val("");
			
			var state=data.state;
			if(state=="true") {
				listPage(1);
			} else if(state=="false") {
				alert("댓글을 등록하지 못했습니다. !!!");
			} else if(state=="loginFail") {
				login();
			}
		}
		,error:function(e) {
			alert(e.responseText);
		}
	});
}

//댓글 삭제
function deleteReply(replyNum, page, userId) {
	var uid="${sessionScope.member.userId}";
	if(! uid) {
		login();
		return;
	}
	
	if(confirm("게시물을 삭제하시겠습니까 ? ")) {	
		var url="<%=cp%>/bbs/deleteReply";
		$.post(url, {replyNum:replyNum, userId:userId}, function(data){
		        var state=data.state;

				if(state=="loginFail") {
					login();
				} else {
					listPage(page);
				}
		}, "json");
	}
}
////////////////

//삭제
function deleteBoard() {
	<c:if test="${sessionScope.staff.s_num==dto.s_num}"> //sessionScope.staff.userId=='admin' || 
	  var num = "${dto.num}";
	  var page = "${page}";
	  var params = "num="+num+"&page="+page+"&uid=${dto.s_num}";
	  var url = "<%=cp%>/bbs/delete?" + params;

	  if(confirm("위 자료를 삭제 하시 겠습니까 ? "))
	  	location.href=url;
	</c:if>    
	<c:if test="${sessionScope.staff.s_num!=dto.s_num}">
	  alert("게시물을 삭제할 수  없습니다.");
	</c:if>
}

function updateBoard() {
	<c:if test="${sessionScope.staff.s_num==dto.s_num}">
	  var num = "${dto.num}";
	  var page = "${page}";
	  var params = "num="+num+"&page="+page;
	  var url = "<%=cp%>/bbs/update?" + params;

	  location.href=url;
	</c:if>

	<c:if test="${sessionScope.staff.s_num!=dto.s_num}">
	 alert("게시물을 수정할 수  없습니다.");
	</c:if>
}
</script>

<div class="bodyFrame2">
    <div class="body-title">
          <h3><span class="glyphicon glyphicon-book"></span> 게시판 </h3>
    </div>
    
    <div class="alert alert-info">
        <i class="glyphicon glyphicon-info-sign"></i> 회원과 자유로이 토론할 수 있는 공간입니다.
    </div>
    
    <div class="table-responsive" style="clear: both;">
        <div class="bbs-article">
            <table class="table">
                 <thead>
                     <tr>
                         <th colspan="2" style="text-align: center;">
                                ${dto.subject}
                         </th>
                     </tr>
                <thead>
                 <tbody>
                     <tr>
                         <td style="text-align: left;">
                             이름 : ${dto.name}
                         </td>
                         <td style="text-align: right;">
                          ${dto.created}<i></i>조회 ${dto.hitCount}
                         </td>
                     </tr>
                     <tr>
                         <td colspan="2" style="height: 230px;">
                              ${dto.content}
                         </td>
                     </tr>
                         <tr>
                         <td colspan="2">
                              <span style="display: inline-block; min-width: 45px;">이전글</span> :
                          <c:if test="${not empty preReadDto }">
                                  <a href="<%=cp%>/bbs/article?${params}&num=${preReadDto.num}">${preReadDto.subject}</a>
                              </c:if>				
                         </td>
                     </tr>
                     <tr>
                         <td colspan="2" style="border-bottom: #d5d5d5 solid 1px;">
                              <span style="display: inline-block; min-width: 45px;">다음글</span> :
                          <c:if test="${not empty nextReadDto }">
                                  <a href="<%=cp%>/bbs/article?${params}&num=${nextReadDto.num}">${nextReadDto.subject}</a>
                              </c:if>
                         </td>
                     </tr>                                          
                </tbody>
                <tfoot>
                	<tr>
                		<td>
<c:if test="${sessionScope.staff.s_num==dto.s_num}">
                		    <button type="button" class="btn btn-default btn-sm wbtn" onclick="updateBoard();">수정</button>
</c:if>
<c:if test="${sessionScope.staff.s_num==dto.s_num}">	                		    
                		    <button type="button" class="btn btn-default btn-sm wbtn" onclick="deleteBoard();">삭제</button>
</c:if>                		    
                		</td>
                		<td align="right">
                		    <button type="button" class="btn btn-default btn-sm wbtn" onclick="javascript:location.href='<%=cp%>/bbs/list?${params}';"> 목록으로 </button>
                		</td>
                	</tr>
                </tfoot>
            </table>

       </div>
      
   </div>
</div>