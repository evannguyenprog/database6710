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
	
	
	<center>
		<form action="frequentBuyers" method="post">
			<button type="submit" id="frequentBuyers" value="frequentBuyers"><a>Display Frequent Buyers</a></button>
		</form>
		<br>
	</center>
	
	
	<center>
		<form action="displayBiggestBuy" method="post">
			<button type="submit" id="displayBiggestBuy" value="displayBiggestBuy">Display Biggest Buy</button>
		</form>
		<br>
	</center>
	
	
	<center>
		<form action="displayBiggestBuyers" method="post">
			<button type="submit" id="displayBiggestBuyers" value="displayBiggestBuyers">Display Biggest Buyers</button>
		</form>
		<br>
	</center>
	
	
	<center>
		<form action="displayPopularUsers" method="post">
			<button type="submit" id="displayPopularUsers" value="displayPopularUsers">Display Popular Users</button>
		</form>
		<br>
	</center>
	
	
	<center>
		<form action="displayCommonUsers" method="post">
			<button type="submit" id="displayCommonUsers" value="displayCommonUsers">Display Common Users</button>
		</form>
		<br>
	</center>
	
	
	<center>
		<form action="displayNeverBuyUsers" method="post">
			<button type="submit" id="displayNeverBuyUsers" value="displayNeverBuyUsers">Display Never Buy Users</button>
		</form>
		<br>
	</center>
	
	<center>
		<form action="displayNeverSellUsers" method="post">
			<button type="submit" id="displayNeverSellUsers" value="displayNeverSellUsers">Display Never Sell Users</button>
		</form>
		<br>
	</center>
	
	
	<center>
		<form action="displayLuckyUsers" method="post">
			<button type="submit" id="displayLuckyUsers" value="displayLuckyUsers">Display Lucky Users</button>
		</form>
		<br>
	</center>
	
	<center>
		<form action="displayInactiveUsers" method="post">
			<button type="submit" id="displayInactiveUsers" value="displayInactiveUsers">Display Inactive Users</button>
		</form>
		<br>
	</center>
	
	<center>
		<form action="displayStatistics" method="post">
			<button type="submit" id="displayStatistics" value="displayStatistics">Display Statistics</button>
		</form>
		<br>
	</center>
	
	
	
	
	
</div>

</body>
</html>