<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String cp=request.getContextPath();
%>

<script type="text/javascript">
$(function(){
	var idx="${subMenu}";
	if(!idx) idx=1;
	var subMenu=$(".list-group-item")[idx];
	$(subMenu).addClass("active");
});
</script>
<%-- 
<div class="list-group">
       <div class="list-group-item lefthead"><i></i> 고객센터</div>
       <a href="<%=cp%>/faq/faq" class="list-group-item">자주하는 질문</a>
       <a href="<%=cp%>/notice/list" class="list-group-item">공지사항</a>
       <a href="#" class="list-group-item">질문과 답변</a>
       <a href="#" class="list-group-item">이벤트</a>
       <a href="#" class="list-group-item">설문조사</a>
</div> --%>

	  <!--MAIN NAVIGATION-->
  <nav id="mainnav-container">
      <div id="mainnav">
          <!--Menu-->
          <div id="mainnav-menu-wrap">
              <div class="nano">
                  <div class="nano-content">
                      <ul id="mainnav-menu" class="list-group">
                          <!--Category name-->
                          <li class="list-header">업무지원</li>
                          <!--Menu list item-->
                          <li>
                              <a href="<%=cp%>/notice/list">
                              <i class="fa fa-home"></i>
                              <span class="menu-title">공지사항</span>
                              <i class="arrow"></i>
                              </a>
                          </li>
                            <li class="list-divider"></li>
                          <li>
                              <a href="<%=cp%>/mail/list">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">메일함</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 메일 보내기</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 예약 발송</a></li>
                                  <li><a href="<%=cp%>/mail/list"><i class="fa fa-caret-right"></i> 받은 메일함</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 보낸 메일함 </a></li>
                                   <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 중요 메일함 </a></li>
                                    <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 스팸 메일함</a></li>
                                     <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 휴지통</a></li>
                              </ul>
                          </li>
                            <li class="list-divider"></li>
                          <li>
                              <a href="<%=cp%>/msg/list">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">쪽지함</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 쪽지 보내기</a></li>
                                  <li><a href="<%=cp%>/msg/list"><i class="fa fa-caret-right"></i> 받은 쪽지함</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 보낸 쪽지함</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 중요 쪽지함 </a></li>
                                   <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 휴지통 </a></li>
                              </ul>
                          </li>
                            <li class="list-divider"></li>
                           <li>
                              <a href="<%=cp%>/docu/list">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">문서 관리</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/docu/list"><i class="fa fa-caret-right"></i> 회사 문서함</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 개인 문서함</a></li>
                              </ul>
                          </li>
                            <li class="list-divider"></li>
                           <li>
                              <a href="<%=cp%>/sign/list">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">전자결재</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 결재문서 작성</a></li>
                                  <li><a href="<%=cp%>/sign/list"><i class="fa fa-caret-right"></i> 결재할 문서</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 결재완료 문서</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 상신중 문서 </a></li>
                                   <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 상신완료 문서 </a></li>
                              </ul>
                          </li>
                            <li class="list-divider"></li>
                           <li>
                              <a href="<%=cp%>/attend/list">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">근태관리</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/attend/list"><i class="fa fa-caret-right"></i> 내 근태현황</a></li>
                              </ul>
                          </li>
                          <li class="list-divider"></li>
                          <!--Category name-->
                          
                      </ul>
                      <!--Widget-->
                      <div class="mainnav-widget">
                          <!-- Show the button on collapsed navigation -->
                          <div class="show-small">
                              <a href="#" data-toggle="menu-widget" data-target="#demo-wg-server">
                              <i class="fa fa-desktop"></i>
                              </a>
                          </div>
  
                      </div>
                      <!--End widget-->
                  </div>
              </div>
          </div>
          <!--End menu-->
      </div>
  </nav>
  <!--END MAIN NAVIGATION-->
