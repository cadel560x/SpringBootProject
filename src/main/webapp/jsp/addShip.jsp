<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Ships</title>
	</head>
	<body>
		<h1>Add Ship</h1>
		<form:form modelAttribute="ship">
			<label for="name">Ship Name: </label>
			<form:input path="name" name="name"></form:input><form:errors path="name"></form:errors><br>
			<label for="passengers">Passengers: </label>
			<form:input path="passengers" name="passengers"><form:errors path="passengers"></form:errors></form:input><br>
			<label for="cost">Cost: </label>
			<form:input path="cost" name="cost"></form:input><form:errors path="cost"></form:errors><br>
			<label for="metres">Metres: </label>
			<form:input path="metres" name="metres"></form:input><form:errors path="metres"></form:errors><br>
			
			<input type="submit" value="Add">
		</form:form>
		<a href="/">Home</a>
	</body>
</html>