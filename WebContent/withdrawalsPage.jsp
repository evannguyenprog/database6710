<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/style.css"%></style>
<title>Withdrawal History</title>

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


<!-- <script type="text/javascript">
	function displayDeposit()
	{
		var xmlHttp = new XMLHttpRequest();
	    xmlHttp.open( "GET", "displayDeposits", true ); // false for synchronous request
	    xmlHttp.send( null );
	    return xmlHttp.responseText;
	}
    window.onload = displayDeposit();
    console.log(xmlHttp.responseText);
    //console.log(depositList.toString());
</script> -->

<h1 align="center"> Withdrawal History </h1>
	<form action="displayWithdrawals" method="post">
			<div class="pad" align="center"><button type="submit" id="displayWithdrawals" value="submit">Display</button></div>
	</form>

	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Withdrawals</h2></caption>
            
            <c:forEach var="withdrawalList" items="${withdrawalList}">
                <tr>
                    <td><c:out value="${withdrawalList.withdraw_id}" /></td>
                    <td><c:out value="${withdrawalList.user_email}" /></td>
                    <td>$<c:out value="${withdrawalList.withdraw_amount}" /></td>
                    <td><c:out value="${withdrawalList.withdrawal_date}" /></td>
                          	
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>

</body>
</html>