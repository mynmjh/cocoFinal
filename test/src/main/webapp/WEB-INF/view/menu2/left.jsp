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

<%-- <div class="list-group">
       <div class="list-group-item lefthead"><i></i> 커뮤니티</div>
       <a href="<%=cp%>/guest/guest" class="list-group-item">방명록</a>
       <a href="<%=cp%>/bbs/list" class="list-group-item">게시판</a>
       <a href="#" class="list-group-item">포토갤러리</a>
       <a href="#" class="list-group-item">자료실</a>
       <a href="#" class="list-group-item">채팅</a>
       <a href="#" class="list-group-item">블로그</a>
</div> --%>

	  <!--MAIN NAVIGATION-->
  <nav id="mainnav-container">
      <div id="mainnav">
          <!--Menu-->
          <div id="mainnav-menu-wrap">
              <div class="nano">
                  <div class="nano-content">
                      <ul id="mainnav-menu" class="list-group">
                           <li class="list-header">커뮤니티</li>
                          <!--Menu list item-->
                          <li>
                              <a href="<%=cp%>/bbs/list">
                              <i class="fa fa-home"></i>
                              <span class="menu-title">게시판</span>
                              <i class="arrow"></i>
                              </a>
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/bbs/list"><i class="fa fa-caret-right"></i> 자유 게시판</a></li>
                                  <li><a href="<%=cp%>/photo/list"><i class="fa fa-caret-right"></i> 자유 갤러리</a></li>
                              </ul>
                          </li>
                            <li class="list-divider"></li>
                          <li>
                              <a href="<%=cp%>/survey/list">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">설문조사</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/survey/list"><i class="fa fa-caret-right"></i> 진행중 설문조사</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 종료된 설문조사</a></li>
                              </ul>
                          </li>
                            <li class="list-divider"></li>
                          <li>
                              <a href="<%=cp%>/addr/list">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">주소록</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/addr/list"><i class="fa fa-caret-right"></i> 조직도</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 개인 주소록</a></li>
                              </ul>
                          </li>
                            <li class="list-divider"></li>
                           <li>
                              <a href="<%=cp%>/club/list">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">동호회</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              <ul class="collapse">
                                  <li><a href="<%=cp%>/club/list"><i class="fa fa-caret-right"></i> 동호회 목록</a></li>
                                  <li><a href="<%=cp%>/"><i class="fa fa-caret-right"></i> 내 동호회</a></li>
                              </ul>
                          </li>
                            <li class="list-divider"></li>
                          
                          
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

