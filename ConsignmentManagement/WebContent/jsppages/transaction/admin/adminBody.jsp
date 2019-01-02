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
<div style="height:300px;">
	<div class="container">

		<!--main container start here-->
		<div class="Main_containner">
			<div class="breadcrumb">
				Dashboard<span class="pull-right user_name">Welcome :<b><%=user.getUserName() %></b></span>
			</div>
			<div class="inner_wrapper">
				
			<%=ReraSecurity.writeToken(request) %>
				<h1>
					Welcome to  <span> Consignment Management System.</span>
				</h1>

				<div class="border">
					<div class="orange"></div>
					<div class="black"></div>
				</div>
			</div>
		</div>
	</div>
</div>