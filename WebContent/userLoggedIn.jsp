<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>

<html>

<head>
	
	<meta charset="ISO-8859-1">
	<style><%@include file="/WEB-INF/css/style.css"%></style>
	<title>PPS Trading Site</title>

</head>

<body>

	<h2 align="center">Account Page</h2>

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
		<h3 align="center">== Account Actions ==</h3>
	<br>
	
	
	<center>
		<h3 align="center">Deposit Dollars</h3>
		<form action="depositDollars" method="post">
			<input type="number" step="0.01" name="depositDollarAmount" required/>
			<div class="pad"><button type="submit" id="depositDollars" value="submit">Deposit</button></div>
		</form>
		<br>
	</center>

<br>

	<center>
		<h3 align="center">Withdraw Dollars</h3>
		<form action="withdrawDollars" method="post">
			<input type="number" step="0.01" name="withdrawDollarAmount" required/>
			<div class="pad"><button type="submit" id="withdrawDollars" value="withdrawDollarAmount">Withdraw</button></div>
		</form>
		<br>
	</center>

<br>
	
	<center>
		<h3 align="center">Buy PPS</h3>
		<form action="buyPPS" method="post">
			<input type="number" step="0.01" name="buyPPSAmount" required/>
			<div class="pad"><button type="submit" id="buyPPS" value="buyPPSAmount">Buy</button></div>
		</form>
		<br>
	</center>

<br>
	
	<center>
		<h3 align="center">Sell PPS</h3>
		<form action="sellPPS" method="post">
			<input type="number" step="0.01" name="sellPPSAmount" required/>
			<div class="pad"><button type="submit" id="sellPPS" value="sellPPSAmount">Sell</button></div>
		</form>
		<br>
	</center>


</body>

</html>