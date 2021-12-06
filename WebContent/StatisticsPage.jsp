<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Statistics</title>
</head>
<body>



     <div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Total number of Deposits </h2></caption>
            
            <c:forEach var="listTotalDeposits" items="${listTotalDeposits}">
                <tr>
                    <td><c:out value="${listTotalDeposits.deposit_amount}" /></td>
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>
	
	
	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Total number of Withdraws </h2></caption>
            
            <c:forEach var="listTotalWithdraws" items="${listTotalWithdraws}">
                <tr>
                    <td><c:out value="${listTotalWithdraws.withdraw_amount}" /></td>
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>
	
	
	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Total number of Buys of PPS </h2></caption>
            
            <c:forEach var="listTotalBuyPPS" items="${listTotalBuyPPS}">
                <tr>
                    <td><c:out value="${listTotalBuyPPS.number_pps_bought}" /></td>
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>
	
	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Total number of Sells of PPS </h2></caption>
            
            <c:forEach var="listTotalSellPPS" items="${listTotalSellPPS}">
                <tr>
                    <td><c:out value="${listTotalSellPPS.number_pps_sold}" /></td>
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>
	
	
	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Total number of Transfers of PPS </h2></caption>
            
            <c:forEach var="listTotalTransferPPS" items="${listTotalTransferPPS}">
                <tr>
                    <td><c:out value="${listTotalTransferPPS.number_pps_transfered}" /></td>
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>
	
</body>
</html>