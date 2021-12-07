<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Common Users</title>

</head>
<body>






<div align="center">

    <h2>Common User</h2>
	<h3>Select Users to Compare</h3>

	<div class="common">
		<div class="common">
			<select name="users" id="users">
			  <option value="saab">evan@gmail.com</option>
			  <option value="mercedes">Ghanu@gmail.com</option>
			  <option value="audi">john@gmail.com</option>
 			  <option value="audi">mihir@yahoo.com</option>
 			  <option value="audi">mike@gmail.com</option>
 			  <option value="audi">smit@gmail.com</option>
 			  <option value="audi">Tej@aol.com</option>
 			  <option value="audi">tenisee@yahoo.com</option>
 			  <option value="audi">trott@hotmail.com</option>
 			  <option value="audi">varun@gmail.com</option>
			</select>
		</div>
		
		<br>
		
		<div class="common">
			<select name="users" id="users">
			  <option value="saab">evan@gmail.com</option>
			  <option value="mercedes">Ghanu@gmail.com</option>
			  <option value="audi">john@gmail.com</option>
 			  <option value="audi">mihir@yahoo.com</option>
 			  <option value="audi">mike@gmail.com</option>
 			  <option value="audi">smit@gmail.com</option>
 			  <option value="audi">Tej@aol.com</option>
 			  <option value="audi">tenisee@yahoo.com</option>
 			  <option value="audi">trott@hotmail.com</option>
 			  <option value="audi">varun@gmail.com</option>
			</select>
		</div>		
	</div>	
	
	<br>
	<br>
	
		<div class="pad"><button type="button" onclick="javascript:Display()">Display</button></div>
	
	<script type="text/javascript">

		console.log("test")

	/* 	const targetDiv = document.getElementById("cmDisplay");
	 */	
		Display = function Display() {
		  if (document.getElementById("cmDisplay").style.display == "none") {
			  document.getElementById("cmDisplay").style.display = "block";
		  } else {
			  document.getElementById("cmDisplay").style.display = "none";
		  }
		};
	</script>
	
	
	<br>
	
	<div id="cmDisplay" style="display:none">
		<table border="1" width="70%" align="center">
            <tr>
                	<th>Common User</th>	
			</tr>
            <c:forEach var="listCommonUsers" items="${listCommonUsers}">
                <tr>
                    <td><c:out value="${listCommonUsers.followed_user_email}" /></td>
                </tr>
           	</c:forEach>     	
        </table>
	</div>	
	</div>

</body>
</html>