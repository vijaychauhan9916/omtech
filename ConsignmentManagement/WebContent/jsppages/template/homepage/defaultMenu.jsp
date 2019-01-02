
<%@page import="com.consMang.common.util.CommonConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 	MENU STARTED -->
	<!--Nav-->
	<style>
.alertPr {
    padding: 40px;
    background-color: #b8f31a;
    color: white;
      border-radius: 50%;
    display: inline-block;
       height: 265px;
    width: 265px;
   position: fixed;
   left: 50;
   bottom: 20;
}

.closebtnPr {
    margin-left: 15px;
    color: white;
    font-weight: bold;
    float: right;
    font-size: 22px;
    line-height: 20px;
    cursor: pointer;
    transition: 0.3s;
}

.closebtnPr:hover {
    color: black;
}
</style>
	
	<div class="row">
		<nav class="navbar navbar-default navbar-static-top">
			<div class="container-fluid">
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
					
						<li class="dropdown">
							<a href="<%=request.getContextPath()%>/loginPage">LOGIN</a>
						</li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
	</div>
<!-- 	MENU ENDED -->
	