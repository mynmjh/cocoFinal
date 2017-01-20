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
       <div class="list-group-item lefthead"><i></i> 마이페이지</div>
       <a href="<%=cp%>/mypage/info" class="list-group-item">정보확인</a>
       <a href="#" class="list-group-item">다이어리</a>
       <a href="#" class="list-group-item">일정관리</a>
       <a href="#" class="list-group-item">친구관리</a>
       <a href="#" class="list-group-item">쪽지</a>
       <a href="<%=cp%>/member/pwd" class="list-group-item">정보수정</a>
    <c:if test="${sessionScope.member.userId!='admin' }">
	    <a href="<%=cp%>/member/pwd?dropout" class="list-group-item">회원탈퇴</a>
	</c:if>        
</div>
 --%>
 
	  <!--MAIN NAVIGATION-->
  <nav id="mainnav-container">
      <div id="mainnav">
          <!--Menu-->
          <div id="mainnav-menu-wrap">
              <div class="nano">
                  <div class="nano-content">
                      <ul id="mainnav-menu" class="list-group">
                          <!--Category name-->
                          <li class="list-header">마이페이지</li>
                          <!--Menu list item-->
                          <li>
                              <a href="<%=cp%>/mypage/info">
                              <i class="fa fa-home"></i>
                              <span class="menu-title">정보수정</span>
                              <i class="arrow"></i>
                              </a>
                          </li>
                            <li class="list-divider"></li>
                          <li>
                              <a href="<%=cp%>/set/main">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">환경설정</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                             
                          </li>
                            <li class="list-divider"></li>
                          <li>
                              <a href="#">
                              <i class="fa fa-shopping-cart"></i>
                              <span class="menu-title">로그아웃</span>
                              <i class="arrow"></i>
                              </a>
                              <!--Submenu-->
                              
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
