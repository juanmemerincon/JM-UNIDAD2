<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Items</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="ItemController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Name</th>
			 <th>Type</th>
			  <th>Maximum</th>
			  <th>Minimum</th>
			
		</tr>
		<c:forEach var="item" items="${items}">
		
		<tr>
			<td>
				<form action= "ItemController">
					<input type = "hidden" name = "id" value= "${item.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${item.id}</td>
			<td> ${item.name}</td>
			<td> ${item.type}</td>
			<td> ${item.maximum}</td>
			<td> ${item.minimum}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>

</body>
</html>