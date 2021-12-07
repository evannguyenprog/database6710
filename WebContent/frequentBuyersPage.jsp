<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Frequent Buyers</title>
</head>
<body>

	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Frequent Buyers</h2></caption>
            <tr>
                	<th>Email</th>
                	<th>Buys</th>
			</tr>
            
            <c:forEach var="listFrequentBuyers" items="${listFrequentBuyers}">
                
                <tr>
                    <td><c:out value="${listFrequentBuyers.user_email}" /></td>
<!-- 					<td>occ</td>
 --> 					<td><c:out value="${listFrequentBuyers.occurances}" /></td>
                    
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>

</body>
</html>