
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid">
	<!--Nav-->
	<div class="row">
		<nav class="navbar navbar-default navbar-static-top">
			<div class=" container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">

						<li><a href="dashboard" style="border-right: 0px;">Dashboard</a></li>
						<li><a href="addNewProduct" style="border-right: 0px;">Add New Product</a></li>
						<li><a href="createProfile" style="border-right: 0px;">Create New Profile</a></li>
						<!-- <li class="dropdown">
							<a style="border-right: 0px;" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
								Manage Users<span class="caret"></span>
							</a>							
							<ul class="dropdown-menu">
								<li><a href="manageUsers?ststus=ACTIVE" style="border-right: 0px;">Active Users </a></li>
								<li><a href="manageUsers?ststus=INACTIVE" style="border-right: 0px;">Inactive Users </a></li>
								<li><a href="newUserForm" style="border-right: 0px;">Create New User </a></li>								
							</ul>
						</li> -->
						
						<li><a href="<%=request.getContextPath()%>/logout" style="border-right: 0px;">Logout</a></li>


					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
	</div>
</div>