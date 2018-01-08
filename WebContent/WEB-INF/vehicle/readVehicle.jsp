<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Car Workshop</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h2>${empty rm ? "" : rm}</h2>
<p> ${empty bug ? "" : bug}</p>

<a href="<c:url value = '/addvehicle'/>" class="btn btn-default">Add Vehicle</a>
	<table class="table table-hover">
		<tr>
			<td>Clients ID</td>
			<td>Plate number</td>
			<td>Model</td>
			<td>Brand</td>
			<td>Production date</td>
			<td>Service date</td>
			<td colspan="3">Action</td>
		</tr>
		<c:forEach items="${orders}" var="vehicle">
			<tr>
				<td>${vehicle.userId}</td>
				<td>${vehicle.plateNumber}</td>
				<td>${vehicle.model}</td>
				<td>${vehicle.brand}</td>
				<td>${vehicle.productionDate}</td>
				<td>${vehicle.serviceDate}</td>
				<td><a href="<c:url value='/editvehicle?id=${vehicle.id}'/>" class="btn btn-default">Edit</a></td>
				<td><a href="<c:url value='/deletevehicle?id=${vehicle.id}'/>" class="btn btn-default">Delete</a></td>
				<td><a href="<c:url value='/getorderbyvehicle?vid=${vehicle.id}'/>" class="btn btn-default">View repair details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>