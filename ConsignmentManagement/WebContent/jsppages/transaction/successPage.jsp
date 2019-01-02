<%@page import="com.consMang.common.security.ReraSecurity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.consMang.master.model.UserModel"%>
<%@page import="com.consMang.common.util.CommonConstants"%>
<%
UserModel user=(UserModel)session.getAttribute(CommonConstants.SES_USER_ATTR);

%>


<div class="breadcrumb">
	<span class="pull-right user_name">Welcome :<b><%=user.getUserName() %></b></span>
</div>


<!--News Ticker-->
<div class="container">
	<!--main container start here-->
	<div class="Main_containner">

		<!--Inner wrapper stsrt here-->
		<div class="inner_wrapper ">

			<%=ReraSecurity.writeToken(request) %>
				<h1>
					Your transaction successfully <span> processed.</span>
				</h1>

				<div class="border">
					<div class="orange"></div>
					<div class="black"></div>
				</div>
			<div class="form-group">
				<div class="col-md-12">
					<h1 style="text-align: center;color: green;"> ${msg} </h1>
				</div>
			</div>
			<!-- container end here-->

		</div>
	</div>
</div>
