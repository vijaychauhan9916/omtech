<%@page import="com.consMang.common.security.ReraSecurity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
       <%@page import="com.consMang.common.util.CommonConstants"%>
  
<%@page import="com.consMang.master.model.UserModel"%>
<%
UserModel user=(UserModel)session.getAttribute(CommonConstants.SES_USER_ATTR);

%>

<script>
function checkUserType(sel){
	var val=sel.value;
	if(val!='0' && val!='CHIEFAUTHORITY' && val!='REGISTRY'){
		if(val=='OPERATOR'){
		$('#authDIV').show();
		$('#ofcDIV').show();
		$('#zoneDIV').hide();
		$('#distDIV').hide();
		$('#authorityTypeID').val('0');
		$('#userZone').val('0');
		$('#userDist').val('0');
		}else{
			$('#zoneDIV').show();
			$('#authDIV').hide();
			$('#ofcDIV').hide();
			$('#distDIV').hide();
			$('#authorityTypeID').val('0');
			$('#userZone').val('0');
			$('#userDist').val('0');
		}
	}else{
		$('#zoneDIV').hide();
		$('#authDIV').hide();
		$('#ofcDIV').hide();
		$('#distDIV').hide();
		$('#authorityTypeID').val('0');
		$('#userZone').val('0');
		$('#userDist').val('0');
	}
	
	
}

function checkAuthType(sel){
	var val=sel.value;
	if(val=='Others' ){
		$('#distDIV').show();
	}
	else{
		$('#distDIV').hide();
		$('#userDist').val('0');
	}
}

</script>
    

    
    <div class="breadcrumb">Home /Edit User<span class="pull-right user_name">Welcome :<b><%=user.getUserName() %></b></span></div>


<!--News Ticker-->
<div class="container">
<!--main container start here-->
<div class="Main_containner">

<!--Inner wrapper stsrt here-->
<div class="inner_wrapper ">

<form:form class="form-horizontal" autocomplete="off" action="updateUser"  modelAttribute="userModel" method="post" name="updateUser-form" id="updateUser-form">
 <%=ReraSecurity.writeToken(request) %>
 <form:hidden path="userId" />
     <div class="col-md-12">
     <h1>Edit User <span> Form</span></h1>
  
    <div class="border"><div class="orange"></div><div class="black"></div></div>
	 </div>
 
  	
		
					<div class="form-group">
					
						<label class="col-sm-3 control-label">User Name<sup>*</sup></label>

						<div class="col-sm-3">
							<form:input path="userName"
								id="userName" cssClass="form-control input-sm requiredValFld" />
								<span class='requiredValFldMsg'> Please enter User Name.</span>
						</div>
						<label for="inputEmail3" class="col-sm-2 control-label">Email ID<sup>*</sup></label>
						<div class="col-sm-3">
<form:input path="emailId"
								id="emailId" cssClass="form-control input-sm emailValFld requiredValFld" />
								<span class='requiredValFldMsg'> Please enter emailId.</span>
						</div>


					</div>
					
					
					<div class="form-group row">
						
						<label class="col-sm-3 control-label">Mobile No<sup>*</sup></label>

						<div class="col-sm-3">
							<form:input path="mobileNo"
								id="mobileNo" cssClass="form-control input-sm mobileValFld requiredValFld" maxlength="10"/>
								<span class='requiredValFldMsg'> Please enter mobile no.</span>
						</div>
						<label class="col-sm-2 control-label">Designation<sup>*</sup></label>

						<div class="col-sm-3">
							<form:input path="designation"
								id="designation" cssClass="form-control input-sm requiredValFld" />
								<span class='requiredValFldMsg'> Please enter designation.</span>
						</div>
					</div>														
				
					<div class="form-group">
						
						<label class="col-sm-3 control-label">Login Id<sup>*</sup></label>

						<div class="col-sm-3">
							<form:input path="loginId" readonly="true"
								id="loginId" cssClass="form-control input-sm requiredValFld" />
								<span class='requiredValFldMsg'> Please enter login Id.</span>
						</div>
						<label for="inputEmail3" class="col-sm-2 control-label">User Type<sup>*</sup></label>
						<div class="col-sm-3">

							<form:select path="userType" class="form-control" onchange="checkUserType(this);">
								<form:option value="OPERATOR" label="Operator" />
								<form:option value="AUTHORITY" label="Authority" />
								<form:option value="CHIEFAUTHORITY" label="Chief Authority" />
								<form:option value="FINANCE" label="Finance" />
								<form:option value="REGISTRY" label="Registery" />
								<form:option value="GUJRERA_VIEW" label="Gujrera View" />

							</form:select>
								
						</div>


					</div>																	
			
							<div class="form-group">
					<c:if test="${userModel.userType=='AUTHORITY' }">
<div id="zoneDIV" >
</c:if>
<c:if test="${userModel.userType!='AUTHORITY' }">
<div id="zoneDIV" style="display: none;">
</c:if>
							
						
						<label class="col-sm-3 control-label" >Zone<sup>*</sup></label>

						<div class="col-sm-3">
						<select name="zoneId" id="userZone" class="form-control requiredValFld" >
						<option value="0"> -- Select -- </option>
							<c:forEach items="${zoneList }" var="zn">
							<c:if test="${zn.zoneId==userModel.zone.zoneId }">
							<option value="${zn.zoneId }" selected="selected"> ${zn.zoneName } </option>
							</c:if>
							<c:if test="${zn.zoneId!=userModel.zone.zoneId }">
							<option value="${zn.zoneId }"> ${zn.zoneName } </option>
							</c:if>
							</c:forEach>
							</select>
								<span class='requiredValFldMsg'> Please enter zone.</span>
						</div>
						</div>
							
<c:if test="${userModel.userType=='OPERATOR' }">
<div id="authDIV" >
</c:if>
<c:if test="${userModel.userType!='OPERATOR' }">
<div id="authDIV" style="display: none;">
</c:if>
							
						<label for="inputEmail3" class="col-sm-3 control-label">Authority Type<sup>*</sup></label>
						<div class="col-sm-3">

							<form:select path="authorityType" id="authorityTypeID" class="form-control requiredValFld" onchange="checkAuthType(this);">
								<form:option value="0" label=" -- Select -- " />
								<form:option value="AUDA" label="AUDA" />
								<form:option value="SUDA" label="SUDA" />
								<form:option value="Others" label="Others" />

							</form:select>
								<span class='requiredValFldMsg'> Please select authority type.</span>
						</div>
						
<!-- Added By AJ -->
<c:if test="${userModel.userType=='OPERATOR' }">
<div id="ofcDIV">
</c:if>

<c:if test="${userModel.userType!='OPERATOR' }">
	<div id="ofcDIV" style="display: none;">
</c:if>

					<label class="col-sm-2 control-label" >Office<sup>*</sup></label>

					<div class="col-sm-3">
					<select name="officeId" id="userOffice" class="form-control requiredValFld" >
					<option value="0"> -- Select -- </option>
						<c:forEach items="${officeList }" var="ofc">
						
						<c:if test="${ofc.officeId==userModel.tpoOffice.officeId }">
							<option value="${ofc.officeId }" selected="selected"> ${ofc.officeName } </option>
							</c:if>
							<c:if test="${ofc.officeId!=userModel.tpoOffice.officeId }">
							<option value="${ofc.officeId }"> ${ofc.officeName } </option>
							</c:if>
						</c:forEach>
						</select>
							<span class='requiredValFldMsg'> Please select office.</span>
					</div>
				</div>
<!-- Added By AJ -->
						
						
						
						
</div>
<c:if test="${userModel.authorityType=='Others' }">
<div id="distDIV" >
</c:if>
<c:if test="${userModel.authorityType!='Others' }">
<div id="distDIV" style="display: none;">
</c:if>
<br><br>
	                     <label for="inputEmail3" class="col-sm-3 control-label">District<sup>*</sup></label>
						<div class="col-sm-3">
							<select class="form-control requiredValFld" name='districtId' id="userDist" >
						
							<option value='0'> --Select-- </option>
						<c:forEach items="${RERA_STATEUT.districtModelSet}" var="dst">
						<c:if test="${dst.districtId==userModel.district.districtId }">
						<option value='${dst.districtId }' selected="selected"> ${dst.districtName } </option>
						</c:if>
						<c:if test="${dst.districtId!=userModel.district.districtId }">
						<option value='${dst.districtId }'> ${dst.districtName } </option>
						</c:if>
						</c:forEach>
						</select>
						<span class='requiredValFldMsg'> Please select District.</span>
						</div>
			</div>		

					</div>																	
						
			
			
			
			
			
			
			
			
			
			
					<div class="form-group">
						
						<label class="col-sm-3 control-label">Status<sup>*</sup></label>

						<div class="col-sm-3">
							<form:select path="status" class="form-control">
								<form:option value="ACTIVE" label="Enable" />
								<form:option value="INACTIVE" label="Disable" />
								

							</form:select>
							
						</div>
						<label for="inputEmail3" class="col-sm-2 control-label"></label>
						<div class="col-sm-3">

							
						</div>


					</div>				
	
				
	<div class="form-group">		
				
				<div class="col-sm-3 col-md-offset-3">
				<input name="btn1" class="btn-style" value="Update User" type="button" onclick="updateUser()">
				</div>						
	</div>		
																								
																									
																										

			
			
		
</form:form>

<!-- container end here-->

</div>
</div>
</div>
    
    
    <script>
    function updateUser(){
    	var _frm=$('#updateUser-form');
    	if(validateForm(_frm)){
    		$(_frm).submit();
    	}
    }
    </script>
    