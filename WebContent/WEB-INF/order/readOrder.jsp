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

<a href="<c:url value = '/addorder'/>" class="btn btn-default">Add Order</a>
	<table class="table table-hover">
		<tr>
			<td>Worker id</td>
			<td>Vehicle id</td>
			<td>Status</td>
			<td>Problem description</td>
			<td>Receive date</td>
			<td>Start date</td>
			<td>Finish date</td>
			<td>Repair description</td>
			<td>Man hours</td>
			<td>Employees hour cost</td>
			<td>User cost</td>
			<td>Parts cost</td>
			<td colspan="2">Action</td>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.workerId}</td>
				<td>${order.vehicleId}</td>
				<td>${order.status}</td>
				<td>${order.problemDescription}</td>
				<td>${order.receiveDate}</td>
				<td>${order.startDate}</td>
				<td>${order.plannedStartDate}</td>
				<td>${order.repairDescription}</td>
				<td>${order.manHours}</td>
				<td>${order.workerHourCost}</td>
				<td>${order.userCost}</td>
				<td>${order.partsCost}</td>
				<td><a href="<c:url value='/editorder?id=${order.id}'/>" class="btn btn-default">Edit</a></td>
				<td><a href="<c:url value='/deleteorder?id=${order.id}'/>" class="btn btn-default">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>