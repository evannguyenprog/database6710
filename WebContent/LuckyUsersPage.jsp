<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lucky Users</title>
</head>
<body>



	<div align="center">

		<table border="1" width="70%" align="center">
            <caption><h2>Lucky Users </h2></caption>
            
            <c:forEach var="listLuckyUsers" items="${listLuckyUsers}">
                <tr>
                    <td><c:out value="${listLuckyUsers.followed_user_email}" /></td>
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>
</body>
</html>