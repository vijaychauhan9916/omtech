<%@page import="com.consMang.common.util.CommonConstants"%>
<%
HttpSession sss= request.getSession();
sss.getAttribute(CommonConstants.SES_USER_ATTR);
String str=request.getParameter("hit_number");
%>
Found <%=str %> 
