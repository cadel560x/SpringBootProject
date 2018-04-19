<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Shipping Company</title>
		<style type="text/css">
			label{
			    display:inline-block;
			    width:100px;
			    margin-bottom:5px;
			}
		</style>
	</head>
	<body>
		<h1>Add Shipping Company</h1>
		<form:form modelAttribute="shippingCompany">
			<label for="name">Company Name: </label>
			<form:input path="name" name="name"></form:input><form:errors path="name"></form:errors><br>
			<label for="home-port">Home Port: </label>
			<form:input path="homePort" name="home-port"></form:input><form:errors path="homePort"></form:errors><br>
			<label for="balance">Balance: </label>
			<form:input path="balance" name="balance"></form:input><form:errors path="balance"></form:errors><br>
			
			<input type="submit" value="Add">
		</form:form>
		<a href="/">Home</a>
	</body>
</html>