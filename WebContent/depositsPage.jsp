<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/style.css"%></style>
<title>Deposit History</title>

	<script type="text/javascript">
        function displayDeposits() {
            alert('ok');
        }
        window.onload = displayDeposits;
	</script>

</head>
<body>

<!-- <form method="post" action="displayDeposits"></form>
 -->
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


<h1 align="center"> Deposit History </h1>


<%

	


%>

</body>
</html>