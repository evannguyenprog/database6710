<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="dao.UsersDao" %>

<!DOCTYPE html>

<html>

<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>PPS Trade Site</title>

</head>


<body>
	
	<h2 align="center">User Login</h1>
	
	<form method="post" action="login">
		<center>
			<table border="10" width="30%" cellpadding="4" bgcolor="white">
				<thead>
					<tr>
						<th colspan="2">Login</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Email</td>
						<td><input type="text"name="email" required/></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" required/></td>
					</tr>
					<tr>
						<th colspan="2"><button type="submit" id="login" value="login">Login</button></th>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="index.jsp">Register a new account</a></td>
					</tr>
			</table>
		</center>
	</form>
									
</body>

</html>