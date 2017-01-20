<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
   String cp = request.getContextPath();
%>

<header id="navbar">
    <div id="navbar-container" class="boxed">
        <!--Brand logo & name-->
        <div class="navbar-header">
            <a href="<%=cp%>/main" class="navbar-brand">
                <i class="fa fa-cube brand-icon"></i>
                <div class="brand-title">
                    <span class="brand-text">KH 그룹웨어</span>
                </div>
            </a>
        </div>
        <!--End brand logo & name-->
        <!--Navbar Dropdown-->
        <div class="navbar-content clearfix">
            <ul class="nav navbar-top-links pull-left">
                <!--Navigation toogle button-->
                <li class="tgl-menu-btn">
                    <a class="mainnav-toggle" href="#"> <i class="fa fa-navicon fa-lg"></i> </a>
                </li>
                <!--End Navigation toogle button-->
                
                <!--Profile toogle button-->
                  <!--  <li id="profilebtn" class="hidden-xs">
                      <a href="JavaScript:void(0);"> <i class="fa fa-user fa-lg"></i> </a>
                   </li> -->
                <!--End Profile toogle button-->

                <!--Messages Dropdown-->
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle"> <i class="fa fa-envelope fa-lg"></i> <span class="badge badge-header badge-warning">9</span> 
                    </a>
                    <!--Message dropdown menu-->
                    <div class="dropdown-menu dropdown-menu-md with-arrow">
                        <div class="pad-all bord-btm">
                           <div class="h4 text-muted text-thin mar-no">3개의 메시지가 있습니다.</div>
                        </div>
                        <div class="nano scrollable">
                            <div class="nano-content">
                                <ul class="head-list">
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <img src="<%=cp%>/res2/img/av2.png" alt="Profile Picture" class="img-circle img-sm"> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">준휘가 메세지를 보냈습니다.</div>
                                                <small class="text-muted">15분 전</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <img src="<%=cp%>/res2/img/av4.png" alt="Profile Picture" class="img-circle img-sm"> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">기현이가 메세지를 보냈습니다.</div>
                                                <small class="text-muted">30분 전</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <img src="<%=cp%>/res2/img/av3.png" alt="Profile Picture" class="img-circle img-sm"> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">재식이가 메세지를 보냈습니다.</div>
                                                <small class="text-muted">40분 전</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <img src="<%=cp%>/res2/img/av6.png" alt="Profile Picture" class="img-circle img-sm"> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">재환이가 메세지를 보냈습니다.</div>
                                                <small class="text-muted">5시간 전</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <img src="<%=cp%>/res2/img/av4.png" alt="Profile Picture" class="img-circle img-sm"> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">기현이가 메세지를 보냈습니다.</div>
                                                <small class="text-muted">어제</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <img src="<%=cp%>/res2/img/av3.png" alt="Profile Picture" class="img-circle img-sm"> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">준휘가 메세지를 보냈습니다.</div>
                                                <small class="text-muted">어제</small> 
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!--Dropdown footer-->
                        <div class="pad-all bord-top">
                            <a href="#" class="btn-link text-dark box-block"> <i class="fa fa-angle-right fa-lg pull-right"></i>모든 메세지 보기 </a>
                        </div>
                    </div>
                </li>
                <!--End message dropdown-->
                
                <!--Notification dropdown-->
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle"> <i class="fa fa-bell fa-lg"></i> <span class="badge badge-header badge-danger">5</span> </a>
                    <!--Notification dropdown menu-->
                    <div class="dropdown-menu dropdown-menu-md with-arrow">
                        <div class="pad-all bord-btm">
                          <div class="h4 text-muted text-thin mar-no"> 알림 </div>
                        </div>
                        <div class="nano scrollable">
                            <div class="nano-content">
                                <ul class="head-list">
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <span class="icon-wrap icon-circle bg-primary"> <i class="fa fa-comment fa-lg"></i> </span> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">New comments waiting approval</div>
                                                <small class="text-muted">15 minutes ago</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <span class="badge badge-success pull-right">90%</span>
                                            <div class="media-left"> <span class="icon-wrap icon-circle bg-danger"> <i class="fa fa-hdd-o fa-lg"></i> </span> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">HDD is full</div>
                                                <small class="text-muted">50 minutes ago</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <span class="icon-wrap icon-circle bg-info"> <i class="fa fa-file-word-o fa-lg"></i> </span> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">Write a news article</div>
                                                <small class="text-muted">Last Update 8 hours ago</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <span class="label label-danger pull-right">New</span>
                                            <div class="media-left"> <span class="icon-wrap icon-circle bg-purple"> <i class="fa fa-comment fa-lg"></i> </span> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">Comment Sorting</div>
                                                <small class="text-muted">Last Update 8 hours ago</small> 
                                            </div>
                                        </a>
                                    </li>
                                    <!-- Dropdown list-->
                                    <li>
                                        <a href="#" class="media">
                                            <div class="media-left"> <span class="icon-wrap icon-circle bg-success"> <i class="fa fa-user fa-lg"></i> </span> </div>
                                            <div class="media-body">
                                                <div class="text-nowrap">New User Registered</div>
                                                <small class="text-muted">4 minutes ago</small> 
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <!--Dropdown footer-->
                        <div class="pad-all bord-top">
                            <a href="#" class="btn-link text-dark box-block"> <i class="fa fa-angle-right fa-lg pull-right"></i>Show All Notifications </a>
                        </div>
                    </div>
                </li>
                <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                <!--End notifications dropdown-->
            </ul>
            <ul class="nav navbar-top-links pull-right">

                <!--Fullscreen toogle button-->
                  <li class="hidden-xs" id="toggleFullscreen">
                    <a class="icon icon-fullscreen" data-toggle="fullscreen" href="#" role="button">
                       <span class="sr-only">Toggle fullscreen</span>
                    </a>
                  </li>
                <!--End Fullscreen toogle button-->

 
                <!--User dropdown-->
                <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                <li id="dropdown-user" class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle text-right">
                        <span class="pull-right"></span>
                        <div class="username hidden-xs">업무지원</div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right with-arrow">
                        <!-- User dropdown menu -->
                        <ul class="head-list">
                            <li>
                                <a href="<%=cp%>/notice/list"> <i class="fa fa-user fa-fw fa-lg"></i> 공지사항 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/mail/list">  <i class="fa fa-envelope fa-fw fa-lg"></i> 메일함 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/msg/list">  <i class="fa fa-gear fa-fw fa-lg"></i> 쪽지함 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/docu/list"> <i class="fa fa-sign-out fa-fw"></i> 문서관리 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/sign/list"> <i class="fa fa-sign-out fa-fw"></i> 전자결재 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/attend/list"> <i class="fa fa-sign-out fa-fw"></i> 근태관리 </a>
                            </li>
                        </ul>
                    </div>
                </li>
                 <li id="dropdown-user" class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle text-right">
                        <span class="pull-right"></span>
                        <div class="username hidden-xs">커뮤니티</div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right with-arrow">
                        <!-- User dropdown menu -->
                        <ul class="head-list">
                            <li>
                                <a href="<%=cp%>/bbs/list"> <i class="fa fa-user fa-fw fa-lg"></i> 게시판 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/survey/list">  <i class="fa fa-envelope fa-fw fa-lg"></i> 설문조사 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/club/list">  <i class="fa fa-gear fa-fw fa-lg"></i> 동호회 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/addr/list"> <i class="fa fa-sign-out fa-fw"></i> 주소록 </a>
                            </li>
                        </ul>
                    </div>
                </li>
                 <li id="dropdown-user" class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle text-right">
                        <span class="pull-right"></span>
                        <div class="username hidden-xs">협업지원</div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right with-arrow">
                        <!-- User dropdown menu -->
                        <ul class="head-list">
                            <li>
                                <a href="<%=cp%>/cal/com_cal"> <i class="fa fa-user fa-fw fa-lg"></i> 일정관리 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/reserve/list">  <i class="fa fa-envelope fa-fw fa-lg"></i> 공용설비</a>
                            </li>
                            <li>
                                <a href="<%=cp%>/work/list">  <i class="fa fa-gear fa-fw fa-lg"></i> 업무관리 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/webhd/list"> <i class="fa fa-sign-out fa-fw"></i> 웹하드 </a>
                            </li>
                        </ul>
                    </div>
                </li>
                <li id="dropdown-user" class="dropdown">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle text-right">
                        <span class="pull-right"> <img class="img-circle img-user media-object" src="<%=cp%>/res2/img/av1.png" alt="Profile Picture"> </span>
                        <div class="username hidden-xs">${sessionScope.staff.name} 님</div>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right with-arrow">
                        <!-- User dropdown menu -->
                        <ul class="head-list">
                            <li>
                                <a href="<%=cp%>/mypage/info"> <i class="fa fa-user fa-fw fa-lg"></i> 정보수정 </a>
                            </li>
                            <li>
                                <a href="<%=cp%>/set/main">  <i class="fa fa-gear fa-fw fa-lg"></i> 환경설정 </a>
                            </li>
                            <li>
                                <a href="#"> <i class="fa fa-sign-out fa-fw"></i> 로그아웃 </a>
                            </li>
                        </ul>
                    </div>
                </li>
                <!--End user dropdown-->
               
                <!--Navigation toogle button-->
                <li class="hidden-xs">
                    <a id="demo-toggle-aside" href="#">
                    <i class="fa fa-navicon fa-lg"></i>
                    </a>
                </li>
                <!--End Navigation toogle button-->
            </ul>
        </div>
        <!--End Navbar Dropdown-->
    </div>
</header>