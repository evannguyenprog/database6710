<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Popular Users</title>
</head>
<body>

<table border="1" width="70%" align="center">
            <caption><h2>Popular Users</h2></caption>
            <tr>
                	<th>Email</th>
                	
			</tr>
            
            <c:forEach var="listPopularUsers" items="${listPopularUsers}">
                
                <tr>
                    <td><c:out value="${listPopularUsers.followed_user_email}" /></td>
                </tr>
           	</c:forEach>
           	           	
        </table>
         	
	</div>

</body>
</html>