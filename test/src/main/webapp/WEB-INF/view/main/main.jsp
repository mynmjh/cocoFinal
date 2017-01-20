<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String cp=request.getContextPath();
%>
<script type="text/javascript">

function sendGuest() {
	var f = document.talkForm;
	var str;
	
	str = f.content.value;
	if(!str) {
		alert("내용을 입력 해주세요^.^");
		f.content.focus();
		return;
	}
	
	f.action="<%=cp%>/talk/created";
	f.submit();
}
 
 function deleteTalk(num) {
	var url="<%=cp%>/talk/deleteTalk?num="+num;
	
	if(confirm("삭제 하시겠습니까 ?"))
		location.href=url;
}  
</script>

    <!--CONTENT CONTAINER-->
  <!--===================================================-->
<form name="talkForm">
<div id="content-container" style="padding-left: 550px; padding-right: 60px;">
    <div class="row">
       <div class="col-md-6">
           <div class="panel">
              <div class="panel-body np">
					<div
						style="height: 50px; line-height: 50px; border-bottom: 2px solid #DAD9FF;">
						<div
							style="width: 600px; height: 50px; line-height: 50px; margin: 5px auto;">
							<img src="<%=cp%>/res2/img/say.png" alt=""
								style="padding-left: 15px; padding-right: 6px;"> 
								<b style="font-size: 15pt;">오늘의 한마디</b>
						</div>
					</div>
					<!--Widget body-->
                 <div id="demo-chat-body" class="collapse in">
                     <div class="nano" style="height:500px">
                         <div class="nano-content pad-all">
								 <c:if test="${dataCount != 0}"> 
									<ul class="list-unstyled media-block">
										<!-- --------------------------------------------- -->
										 <c:forEach var="talk" items="${list}"> 
											<li class="mar-btm">
												<div class="media-left">
													<img src="<%=cp%>/res2/img/user.png"
														class="img-circle img-sm" alt="Profile Picture">
												</div>
												<div class="media-body pad-hor speech-left">
													<div class="speech" style="font-size: 9pt;">
														<a href="#" class="media-heading"><b>${talk.name}</b>&nbsp;&nbsp;(${talk.created})</a>
														<p>${talk.content}</p>
 							  <c:if test="${sessionScope.staff.s_num==talk.s_num}">	
				              | <a href="javascript:deleteTalk('${talk.num}');">삭제</a>
				           </c:if>  
													</div>
												</div>
											</li>
										 </c:forEach> 
									</ul>
								 </c:if> 
							</div>
                     </div>
                     <!--Widget footer-->
                     <div class="panel-footer">
                         <div class="row">
                             <div class="col-xs-9">
                                 <input type="text" name="content" id="content" required="required"
                                 	placeholder="오늘의 한마디를 써주세요~!" class="form-control chat-input">
                             </div>
                             <div class="col-xs-3">
                                 <button type="button" class="btn btn-primary btn-block" onclick="sendGuest();">등록</button>
                             </div>
                         </div>
                     </div>
                 </div>
                 <!--===================================================-->
              
              </div>
           </div>
        </div>
    </div>
</div>
</form>  
      <!--End page content-->
  <!--END CONTENT CONTAINER-->
  
<!-- -------------------------------------------------------------------------------------- -->

  <!--ASIDE-->
  <aside id="aside-container">
      <div id="aside">
          <div class="nano">
              <div class="nano-content">
                  <!--Nav tabs-->
                  <ul class="nav nav-tabs nav-justified">
                      <li class="active">
                          <a href="#demo-asd-tab-1" data-toggle="tab"> <i class="fa fa-comments"></i> </a>
                      </li>
                      <li>
                          <a href="#demo-asd-tab-3" data-toggle="tab"> <i class="fa fa-wrench"></i> </a>
                      </li>
                  </ul>
                  <!--End nav tabs-->
                  <!-- Tabs Content Start-->
                  <div class="tab-content">
                      <!--First tab (Contact list)-->
                      <div class="tab-pane fade in active" id="demo-asd-tab-1">
                          <h4 class="pad-hor text-thin"> Online Members (7) </h4>
                          <div class="list-group bg-trans">
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av1.png" alt="" class="img-sm">
                                  <i class="on bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">John Knight</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av2.png" alt="" class="img-sm">
                                  <i class="on bottom text-light"></i>
                                  </div>
                                  <div class="inline-block pad-ver-5">
                                      <div class="text-small">Jose Knight</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av3.png" alt="" class="img-sm">
                                  <i class="on bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">Roy Banks</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av7.png" alt="" class="img-sm">
                                  <i class="on bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">Steven Jordan</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av4.png" alt="" class="img-sm">
                                  <i class="on bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">Scott Owens</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av5.png" alt="" class="img-sm">
                                  <i class="on bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">Melissa Hunt</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                          </div>
                          <hr>
                          <h4 class="pad-hor text-thin"> Busy Members (4) </h4>
                          <div class="list-group bg-trans">
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av1.png" alt="" class="img-sm">
                                  <i class="busy bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">John Knight</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av2.png" alt="" class="img-sm">
                                  <i class="busy bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">Jose Knight</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av3.png" alt="" class="img-sm">
                                  <i class="busy bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">Roy Banks</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av7.png" alt="" class="img-sm">
                                  <i class="busy bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">Steven Jordan</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                          </div>
                          <hr>
                          <h4 class="pad-hor text-thin"> Offline Members (4) </h4>
                          <div class="list-group bg-trans">
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av1.png" alt="" class="img-sm">
                                  <i class="off bottom text-light"></i>
                                  </div>
                                  <div class="inline-block pad-ver-5">
                                      <div class="text-small">John Knight</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av2.png" alt="" class="img-sm">
                                  <i class="off bottom text-light"></i>
                                  </div>
                                  <div class="inline-block pad-ver-5">
                                      <div class="text-small">Jose Knight</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av3.png" alt="" class="img-sm">
                                  <i class="off bottom text-light"></i>
                                  </div>
                                  <div class="inline-block pad-ver-5">
                                      <div class="text-small">Roy Banks</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                              <div class="list-group-item">
                                  <div class="pull-left avatar mar-rgt">
                                  <img src="<%=cp%>/res2/img/av7.png" alt="" class="img-sm">
                                  <i class="off bottom text-light"></i>
                                  </div>
                                  <div class="inline-block">
                                      <div class="text-small">Steven Jordan</div>
                                      <small class="text-mute">Available</small>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <!--End first tab (Contact list)-->
                      <!--Second tab (Settings)-->
                      <div class="tab-pane fade" id="demo-asd-tab-3">
                          <ul class="list-group bg-trans">
                              <li class="list-header">
                                  <h4 class="text-thin">Account Settings</h4>
                              </li>
                              <li class="list-group-item">
                                  <div class="pull-right">
                                      <input class="demo-switch" type="checkbox" checked>
                                  </div>
                                  <p>Show my personal status</p>
                                  <small class="text-muted">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</small> 
                              </li>
                              <li class="list-group-item">
                                  <div class="pull-right">
                                      <input class="demo-switch" type="checkbox" checked>
                                  </div>
                                  <p>Show offline contact</p>
                                  <small class="text-muted">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</small> 
                              </li>
                              <li class="list-group-item">
                                  <div class="pull-right">
                                      <input class="demo-switch" type="checkbox">
                                  </div>
                                  <p>Invisible mode </p>
                                  <small class="text-muted">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</small> 
                              </li>
                          </ul>
                          <hr>
                          <ul class="list-group bg-trans">
                              <li class="list-header">
                                  <h4 class="text-thin">Public Settings</h4>
                              </li>
                              <li class="list-group-item">
                                  <div class="pull-right">
                                      <input class="demo-switch" type="checkbox" checked>
                                  </div>
                                  Online status 
                              </li>
                              <li class="list-group-item">
                                  <div class="pull-right">
                                      <input class="demo-switch" type="checkbox">
                                  </div>
                                  Show offline contact 
                              </li>
                              <li class="list-group-item">
                                  <div class="pull-right">
                                      <input class="demo-switch" type="checkbox" checked>
                                  </div>
                                  Show my device icon 
                              </li>
                          </ul>
                          <hr>
                          <h4 class="pad-hor text-thin">Task Progress</h4>
                          <div class="pad-all">
                              <p>Upgrade Progress</p>
                              <div class="progress progress-sm">
                                  <div class="progress-bar progress-bar-success" style="width: 15%;"><span class="sr-only">15%</span></div>
                              </div>
                              <small class="text-muted">15% Completed</small> 
                          </div>
                          <div class="pad-hor">
                              <p>Database</p>
                              <div class="progress progress-sm">
                                  <div class="progress-bar progress-bar-danger" style="width: 75%;"><span class="sr-only">75%</span></div>
                              </div>
                              <small class="text-muted">17/23 Database</small> 
                          </div>
                      </div>
                      <!--Second tab (Settings)-->
                  </div>
                  <!-- Tabs Content End -->
              </div>
          </div>
      </div>
  </aside>
  <!--END ASIDE-->