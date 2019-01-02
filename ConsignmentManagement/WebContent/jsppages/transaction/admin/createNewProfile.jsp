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


<div class="breadcrumb">
	Home /Create New Profile<span class="pull-right user_name">Welcome :<b><%=user.getUserName() %></b></span>
</div>


<!--News Ticker-->
<div class="container">
	<!--main container start here-->
	<div class="Main_containner">

		<!--Inner wrapper stsrt here-->
		<div class="inner_wrapper ">

			<form:form cssClass="form-horizontal" action="saveNewProduct"
				modelAttribute="userProfileModel" method="post" name="createNewProfile-form"
				autocomplete="off" id="createNewProfile-form">
				<%=ReraSecurity.writeToken(request) %>
				<div class="col-md-12">
					<h1>
						Create New Profile<span> Form</span>
					</h1>

					<div class="border">
						<div class="orange"></div>
						<div class="black"></div>
					</div>
				</div>



				<div class="form-group">

					<label class="col-sm-3 control-label">Name<sup>*</sup></label>

					<div class="col-sm-3">
						<form:input path="name" id="name"
							cssClass="form-control input-sm requiredValFld" />
						<span class='requiredValFldMsg'> Please enter Name.</span>
					</div>
					
					<label for="inputEmail3" class="col-sm-2 control-label">Type Of Profile<sup>*</sup></label>
					<div class="col-sm-3">
						<select  name="userType" class="form-control requiredValFld" >
					         <option value='0'> --Select-- </option>
					         <option value='<%=CommonConstants.UserProfileType.CONSIGNEE%>'><%=CommonConstants.UserProfileType.CONSIGNEE%></option>
					         <option value='<%=CommonConstants.UserProfileType.RECEIVER%>'><%=CommonConstants.UserProfileType.RECEIVER%></option>
					    	</select>	
							<span class='requiredValFldMsg'> Please enter Type Of Profile.</span>
					</div>
					
				</div>
				

				<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">State/UT<sup>*</sup></label>
						<div class="col-sm-3">
							<select	name="bankStateUtId"
								class="form-control requiredValFld" id="bnkStateUtId"  onchange="reloadChildDropdown(this)">
									<option value='0'> --Select-- </option>
                                     <c:forEach  items="${stateUtList}" var="st">
								           <option value='${st.stateUtId}'> ${st.stateUtName} </option>
					           </c:forEach>
							</select>
							<span class='requiredValFldMsg'> Please select State.</span>
						</div>

						<label for="inputEmail3" class="col-sm-2 control-label">District<sup>*</sup></label>
						<div class="col-sm-3">
							<select name="districtId" id="District-bnkStateUtId" class="form-control requiredValFld">
								<option value="0" > --Select-- </option>
							</select>
								<span class='requiredValFldMsg'> Please select District.</span>
						</div>
					</div>
				
				<div class="form-group">

					<div class="col-sm-6 col-md-offset-3" style="text-align: center;">
						<input name="btn1" class="btn-style" value="Create Profile"
							type="button" onclick="createProfile()">
					</div>
				</div>

			</form:form>

			<!-- container end here-->

		</div>
	</div>
</div>

<script>
    function createProfile(){
    	var _frm=$('#createNewProfile-form');
    	if(validateForm(_frm)){
    		$(_frm).submit();
    	}
    }
    </script>
