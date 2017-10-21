<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item Form</title>
</head>
<body>
	<form action="ItemController">
		<label>Name:</label><br>
		<input type = "text" name= "name" value = "${item.name}" /><br>
		
		<label>Type:</label><br>
		<input type = "text" name= "type" value = "${item.type}" /><br>
		
		<label>Maximum:</label><br>
		<input type = "text" name= "maximum" value = "${item.maximum}" /><br>
		
		<label>Minimum:</label><br>
		<input type = "text" name= "minimum" value = "${item.minimum}" /><br>
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>
