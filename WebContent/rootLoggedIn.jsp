<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/style.css"%></style>
<title>PPS Trade Site</title>
</head>
<body>

<div class="tagtable center">
    <ul class="tabs">
		<li><a href="userLoggedIn.jsp">Account</a></li>
        <li><a href="depositsPage.jsp">Deposits</a></li>
        <li><a href="withdrawalsPage.jsp">Withdrawals</a></li>
        <li><a href="PPSBoughtPage.jsp">PPS Purchases</a></li>
        <li><a href="PPSSoldPage.jsp">PPS Sales</a></li>
        <li><a href="PPSTransfersPage.jsp">PPS Transfers</a></li>   
        <li class="liRight"><a>PPS TRADE SITE</a></li>       
    </ul>
</div>


	<h1 align="center">Root User Session</h1>
	
	<h4 align="center">
<%
if(session != null)
{
	if(session.getAttribute("currentEmail") != null)
	{
		String currentUser = (String) session.getAttribute("currentEmail");
		String currentPassword = (String) session.getAttribute("currentPassword");
		out.println("Current User: ");
		out.print(currentUser);
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
}
%>
</h4>
<div align="center"><form method = "post" action="logout"><button type="submit" id="logout" value="logout">Logout</button></form></div>

		<br>
		<h2 align="center">== Account Actions ==</h2>
	
	
	<center>
		<form action="initialize" method="post">
			<button type="submit" id="initialize" value="initialize">Initalize Database</button>
		</form>
		<br>
	</center>

</body>
</html>