<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404 | GujRERA</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta name="csrf-token" content="">

<%-- <link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/images/reralogo.jpg" /> --%>
<!--<base href="">-->

<!-- END :: Page Specific CSS -->
<style type="text/css">
body {
	background:
		url("<%=request.getContextPath()%>/resources/images/error_500.jpg")
		no-repeat center center fixed;
	background-size: cover;
	color: #aaa;
}

div.container {
	margin-top: 10%;
	margin-left: 20%;
	font-size: 18px;
}

h1 {
	font-size: 120px;
	margin-bottom: 40px;
}

button.btn_back {
	background-color: inherit;
	border: 1px solid #e7505a;
	border-radius: 4px;
	margin-top: 10px;
}

button.btn_back a {
	color: #e7505a;
	font-weight: bold;
}

button.btn_back:hover {
	background-color: #e7505a;
}

button.btn_back a:hover {
	color: #FFF;
}
</style>
</head>

<body>
	<div class="container">
		<h1>500</h1>
	   Invalid Request! Click Here  .
		<br>
		<button class="btn_back">
			 <a href="<%=request.getContextPath() %>/home"> Home Page</a>
		</button>
	</div>


</body>
</html>