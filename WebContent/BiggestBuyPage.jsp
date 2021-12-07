<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biggest Buy</title>
</head>
<body>

<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Biggest Buy</h2></caption>
            <tr>
                	<th>Email</th>
                	<th>Amount</th>
                	<th>Date</th>
                	
			</tr>
            
            <c:forEach var="listBiggestBuy" items="${listBiggestBuy}">
                
                <tr>
                    <td><c:out value="${listBiggestBuy.user_email}" /></td>
					<td><c:out value="${listBiggestBuy.number_pps_bought}" /></td>
                  	<td><c:out value="${listBiggestBuy.pps_bought_date}" /></td>
                  
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>

</body>
</html>