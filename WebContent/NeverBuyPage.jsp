<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Never Buy PPS Users</title>
</head>
<body>



	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Never Bought PPS Users </h2></caption>
            
            <c:forEach var="listNeverBuyUsers" items="${listNeverBuyUsers}">
                <tr>
                    <td><c:out value="${listNeverBuyUsers.receiving_user_email}" /></td>
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>
</body>
</html>