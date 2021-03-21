<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2>Add Alien:</h2>
	<form action="addAlien">
		<input type="text" name="aid">
		<input type="text" name="aname">
		<input type="text" name="tech">
		<input type="submit">
	</form>
	<br>
	<hr>
	<br>
	<h2>Get Alien by id:</h2>
	<form action="getAlien">
		<input type="text" name="aid">
		<input type="submit">
	</form>
	<br>
	<hr>
	<br>
	<h2>Update Alien:</h2>
	<form action="updateAlien">
		<input type="text" name="aid">
		<input type="text" name="aname">
		<input type="text" name="tech">
		<input type="submit">
	</form>
	<br>
	<hr>
	<br>
	<h2>Delete Alien by id:</h2>
	<form action="deleteAlien">
		<input type="text" name="aid">
		<input type="submit">
	</form>
	<br>
	
	
</body>
</html>