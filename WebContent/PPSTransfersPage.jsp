<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/style.css"%></style>
<title>Deposit History</title>
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

<h1 align="center"> PPS Transfer History </h1>
	<form action="displayPPSTransfered" method="post">
			<div class="pad" align="center"><button type="submit" id="displayPPSTransfered" value="submit">Display</button></div>
	</form>

	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Transfers</h2></caption>
            
            <c:forEach var="listTransferPPS" items="${listTransferPPS}">
                <tr>
                    <td><c:out value="${listTransferPPS.id}" /></td>
                    <td><c:out value="${listTransferPPS.transfering_user_email}" /></td>
					<td><c:out value="${listTransferPPS.receiving_user_email}" /></td>
                    <td><c:out value="${listTransferPPS.transfer_date}" /></td>
                    <td>$<c:out value="${listTransferPPS.number_pps_transfered}" /></td>
                          	
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>


</body>
</html>