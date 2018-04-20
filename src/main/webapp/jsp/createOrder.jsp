<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Order</title>
		<style type="text/css">
			label{
			    display:inline-block;
			    width:135px;
			    margin-bottom:5px;
			}
		</style>
	</head>
	<body>
		<h1>New Order</h1>
		<form:form modelAttribute="orderInfo">
			<label>Ship Name: 
				<form:select path="ship" items="${shipList}"/>
			</label><br>
			<label>Shipping Company: 
				<form:select path="shippingCompany" items="${shippingCompanyList}" />
			</label><br>
			
			<input type="submit" value="Order Ship">
		</form:form>
		<a href="/">Home</a>
	</body>
</html>