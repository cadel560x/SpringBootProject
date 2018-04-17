<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Orders</title>
	</head>
	<body>
		<h1>Orders</h1>
		<table border="1">
			<tr>
				<th>Order Number</th><th>Shipping Company Name</th><th>Ship Name</th><th>Order Date</th>
			</tr>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.oid}</td><td>${order.shippingCompany.name}</td><td>${order.ship.name}</td><td>${order.date}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/">Home</a>
	</body>
</html>