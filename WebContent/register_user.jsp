<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>

<html>

<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>PPS Trade Site</title>

</head>

<body>
<%-- <h4>
<%
if(session != null)
{
	if(session.getAttribute("currentEmail") != null)
	{
		String currentUser = (String) session.getAttribute("currentEmail");
		String currentPassword = (String) session.getAttribute("currentPassword");
		out.println("Current User: ");
		out.print(currentUser);
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
}
%>
</h4> --%>
<!-- <p align = 'right'><form method = "post" action="logout"><button type="submit" id="logout" value="logout">logout</button></form></p>
 -->
	<form method="post" action="register">
		<center>
			<table border="10" width="30%" cellpadding="4" bgcolor="white">
				
				<thead>
					<tr>
						<th colspan="2">Register Account</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>First Name</td>
						<td><input type="text" name="firstname" required/></td>
					</tr>
					<tr>
						<td>Last Name</td>
						<td><input type="text" name="lastname" required/></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email" required/></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" required/></td>
					</tr>
					<tr>
						<td>Confirm Password</td>
						<td><input type="password" name="password2" required/></td>
					</tr>
					<tr>
						<td>Birthdate</td>
						<td><input type="text" name="birthdate" required/></td>
					</tr>
					
					<th colspan="2">Address</th>
					
					<tr>
						<td>Street</td>
						<td><input type="text" name="street" required/></td>
					</tr>
					<tr>
						<td>City</td>
						<td><input type="text" name="city" required/></td>
					</tr>
					<tr>
						<td>State</td>
						<td><input type="text" name="state" required/></td>
					</tr>
					<tr>
						<td>Zipcode</td>
						<td><input type="text" name="zipcode" required/></td>
					</tr>
					<tr>
						<th colspan="2"><button type="submit" id="register" value="register">Submit</button></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><a href="login">Already Registered? Login Here</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>

</body>

</html>