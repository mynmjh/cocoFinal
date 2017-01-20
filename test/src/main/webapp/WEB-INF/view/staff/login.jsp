<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
   String cp = request.getContextPath();
%>



<%-- <div class="bodyFrame">
    <form class="form-signin" name="loginForm" method="post">
        <h2 class="form-signin-heading">Log In</h2>
        <label for="userId" id="lblUserId" class="lbl">아이디</label>
        <input type="text" id="userId" name="userId" class="form-control loginTF" autofocus="autofocus"
                  onfocus="document.getElementById('lblUserId').style.display='none';"
	              onblur="bgLabel(this, 'lblUserId');">
        <label for="userPwd" id="lblUserPwd" class="lbl">패스워드</label>
        <input type="password" id="userPwd" name="userPwd" class="form-control loginTF"
                  onfocus="document.getElementById('lblUserPwd').style.display='none';"
	              onblur="bgLabel(this, 'lblUserPwd');">
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="sendLogin();">로그인 <span class="glyphicon glyphicon-ok"></span></button>
        
        <div style="margin-top:10px; text-align: center;">
            <button type="button" class="btn btn-link" onclick="location.href='<%=cp%>/member/member';">회원가입</button>
            <button type="button" class="btn btn-link">아이디찾기</button>
            <button type="button" class="btn btn-link">패스워드찾기</button>
        </div>
        
        <div style="margin-top:10px; text-align: center;">${message}</div>
    </form>
</div> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
<script type="text/javascript">

	function bgLabel(ob, id) {
		    if(!ob.value) {
			    document.getElementById(id).style.display="";
		    } else {
			    document.getElementById(id).style.display="none";
		    }
	}
	
	function sendLogin()
	{
	        var f = document.loginForm;
	
	    	var str = f.s_num.value;
	        if(!str)
	        {
	            f.s_num.focus();
	            
	            return false;
	        }
	
	        str = f.password.value;
	        if(!str)
	        {
	            f.password.focus();
	            return false;
	        }
	
	        f.action = "<%=cp%>/staff/login";
	        f.submit();
	}
</script>
       <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> Login Page | SensationApp - Responsive admin template.</title>
        <link rel="shortcut icon" href="<%=cp %>/res2/img/favicon.ico">
        <link href="http://fonts.googleapis.com/css?family=Roboto+Slab:400,300,100,700" rel="stylesheet">
        <link href="http://fonts.googleapis.com/css?family=Roboto:500,400italic,100,700italic,300,700,500italic,400" rel="stylesheet">
        <link href="<%=cp %>/res2/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=cp %>/res2/css/style.css" rel="stylesheet">
        <link href="<%=cp %>/res2/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="<%=cp %>/res2/plugins/switchery/switchery.min.css" rel="stylesheet">
        <link href="<%=cp %>/res2/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">
        <link href="<%=cp %>/res2/css/demo/jasmine.css" rel="stylesheet">
        <link href="<%=cp %>/res2/plugins/pace/pace.min.css" rel="stylesheet">
        <script src="<%=cp %>/res2/plugins/pace/pace.min.js"></script>

</head>
<body>
<form name="loginForm" method="post">
 <div id="container" class="cls-container">
            <!-- LOGIN FORM -->
            <div class="lock-wrapper">
                <div class="panel lock-box">
                    <div class="center"> <img alt="" src="<%=cp %>/res2/img/user.png" class="img-circle"/> </div>
                    <h4> 안녕하세요!</h4>
                    <p class="text-center">로그인 해주세요</p>
                    <div class="row">
                      
                            <div class="form-group col-md-12 col-sm-12 col-xs-12">
                                <div class="text-left">
                                    <label class="text-muted">ID</label>
                                    <input id="s_num" name="s_num" type="text" placeholder="사원번호를 입력해주세요" class="form-control" required />
                                </div>
                                <div class="text-left">
                                    <label for="signupInputPassword" class="text-muted">Password</label>
                                    <input id="password" name="password" type="password" placeholder="패스워드를 입력해주세요" class="form-control lock-input" required />
                                </div>
                                <div class="pull-left pad-btm">
                                    <label class="form-checkbox form-icon form-text">
                                    <input type="checkbox"> Remember Me
                                    </label>
                                </div>
                                <button type="submit" class="btn btn-block btn-primary" onclick="sendLogin();">
                               		로그인
                                </button>
                            </div>
                       
                    </div>
                </div>
            </div>
        </div>
</form>
 <script src="js/jquery-2.1.1.min.js"></script>
 <script src="js/bootstrap.min.js"></script>
 <script src="plugins/fast-click/fastclick.min.js"></script>
 <script src="js/scripts.js"></script>
 <script src="plugins/switchery/switchery.min.js"></script>
 <script src="plugins/bootstrap-select/bootstrap-select.min.js"></script>
 <script src="js/demo/jasmine.js"></script>
</body>
</html>

