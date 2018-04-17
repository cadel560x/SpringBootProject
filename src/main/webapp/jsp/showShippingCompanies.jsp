<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Ships</title>
	</head>
	<body>
		<h1>Ships</h1>
		<table border="1">
			<tr>
				<th>Name</th><th>Home Port</th><th>Balance</th><th>Ships</th>
			</tr>
			<c:forEach items="${shippingCompanies}" var="shippingCompany">
				<tr>
					<td>${shippingCompany.name}</td><td>${shippingCompany.homePort}</td><td>${shippingCompany.balance}</td>
					<td>
						<ul>
							<c:forEach items="${shippingCompany.ships}" var="ship">
								<li>${ship.name}, ${ship.metres} (mtrs), ${ship.cost}</li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/">Home</a>
	</body>
</html>