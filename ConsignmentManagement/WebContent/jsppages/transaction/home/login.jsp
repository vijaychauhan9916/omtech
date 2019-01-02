<%@page import="com.consMang.common.security.ReraSecurity"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script>
function loginUser(){
var unam=	$('#loginIdfld').val();
var upass=	$('#passwordfld').val();
if(unam==''){
	alert('Pease enter login Id.');
	$('#loginIdfld').focus();
	return false;
}
if(upass==''){
	alert('Pease enter password.');
	$('#passwordfld').focus();
	return false;	
}
$('#uloginId').val( Base64.encode(unam));
$('#upassword').val( Base64.encode(upass));
$('#loginIdfld').val('');
$('#passwordfld').val('');
$('#loginFormID').submit();
}
function handle(e) {
	var key = e.keyCode || e.which;
	if (key == 13) {
		loginUser();
	}
}
</script>


<!--News Ticker-->
<div class="container mar_top_20">




	
	
	
<div class="col-md-6 col-md-offset-3">	
	

<!--main container start here-->
<div class="Main_containner">

<!--Inner wrapper stsrt here-->
<div class="inner_wrapper">



<h1><span>Login</span></h1>
<div class="drop_shadow"></div>

${ERROR_MSG}

<form:form class="form-horizontal login" method="post" action="userLogin"  id="loginFormID" name="loginForm" autocomplete="off" >
<input type="hidden" name="loginId" id="uloginId" />
<input type="hidden" name="password" id="upassword" />

<%=ReraSecurity.writeToken(request) %>
  <div class="form-group  has-feedback ">
    <label for="inputEmail3" class="col-sm-3 control-label">Login Id</label>
  <div class="col-sm-9">
      <span class="glyphicon glyphicon-user form-control-feedback"></span>
      <input type="text" class="form-control" name="loginIdfld" id="loginIdfld" autocomplete="off" placeholder="Please Enter Your Login Id"  onkeypress="handle(event)" autofocus>
     
    </div>
  </div>
  <div class="form-group has-feedback">
    <label for="inputPassword3" class="col-sm-3 control-label">Password </label>
    <div class="col-sm-9">
     <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      <input type="password" class="form-control" name="passwordfld" id="passwordfld" autocomplete="new-password" placeholder="Please Enter Your Password" onkeypress="handle(event)">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-3 col-sm-9">
      <input name="btn1" class="btn-style" value="Login" type="button" onclick="loginUser();" />
      &nbsp;&nbsp;&nbsp;&nbsp;    <a href="forgetPasswordBForm">Forgot your password?</a>
    </div>
  </div>
</form:form>
<br>
<br>



	<div class="clearfix"></div>
<!--search list main end here-->	
</div>

</div>


<!--inner container end here-->
	</div>


	</div>



<!-- container end here-->
