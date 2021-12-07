<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biggest Buyer</title>
</head>
<body>

<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Biggest Buyer</h2></caption>
            <tr>
                	<th>Email</th>
                	<th>Total PPS Bought</th>
                	
			</tr>
            
            <c:forEach var="listBiggestBuyer" items="${listBiggestBuyer}">
                
                <tr>
                    <td><c:out value="${listBiggestBuyer.user_email}" /></td>
 					<td><c:out value="${listBiggestBuyer.total_pps_bought}" /></td>
                 
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>

</body>
</html>