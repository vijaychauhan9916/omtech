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
	Home /Add New Product<span class="pull-right user_name">Welcome :<b><%=user.getUserName() %></b></span>
</div>


<!--News Ticker-->
<div class="container">
	<!--main container start here-->
	<div class="Main_containner">

		<!--Inner wrapper stsrt here-->
		<div class="inner_wrapper ">

			<form:form cssClass="form-horizontal" action="saveNewProduct"
				modelAttribute="productMasterModel" method="post" name="createNewProduct-form"
				autocomplete="off" id="createNewProduct-form">
				<%=ReraSecurity.writeToken(request) %>
				<div class="col-md-12">
					<h1>
						Add New Product<span> Form</span>
					</h1>

					<div class="border">
						<div class="orange"></div>
						<div class="black"></div>
					</div>
				</div>



				<div class="form-group">

					<label class="col-sm-3 control-label">Product Name<sup>*</sup></label>

					<div class="col-sm-3">
						<form:input path="productName" id="productName"
							cssClass="form-control input-sm requiredValFld" />
						<span class='requiredValFldMsg'> Please enter product Name.</span>
					</div>
				</div>
				
				<div class="form-group">	
					<label class="col-sm-3 control-label">Product Number<sup>*</sup></label>

					<div class="col-sm-3">
						<form:input path="productCode" id="productCode"
							cssClass="form-control input-sm requiredValFld" />
						<span class='requiredValFldMsg'> Please enter product Number.</span>
					</div>
				</div>

				<div class="form-group">

					<label class="col-sm-3 control-label">Product Rate<sup>*</sup></label>

					<div class="col-sm-3">
						<form:input path="productRate" id="productRate"
							cssClass="form-control input-sm requiredValFld decimalValFld" />
						<span class='requiredValFldMsg'> Please enter product rate.</span>
					</div>

				</div>

				<div class="form-group">

					<div class="col-sm-3 col-md-offset-3" style="text-align: center;">
						<input name="btn1" class="btn-style" value="Add Product"
							type="button" onclick="addProduct()">
					</div>
				</div>

			</form:form>

			<!-- container end here-->

		</div>
	</div>
</div>

<script>
    function addProduct(){
    	var _frm=$('#createNewProduct-form');
    	if(validateForm(_frm)){
    		$(_frm).submit();
    	}
    }
    </script>
