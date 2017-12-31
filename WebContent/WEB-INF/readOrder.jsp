<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car Workshop</title>
</head>
<body>
<h2>List of Orders</h2>
<p> ${empty bug ? "" : bug}</p>

<a href="<c:url value = '/addorder'/>">Add Order</a>
	<table>
		<tr>
			<td>Worker id</td>
			<td>Vehicle id</td>
			<td>Status</td>
			<td>Problem description</td>
			<td>Receive date</td>
			<td>Planned start date</td>
			<td>Start date</td>
			<td>Repair description</td>
			<td>Man hours</td>
			<td>Worker hour cost</td>
			<td>User cost</td>
			<td>Parts cost</td>
			<td colspan="2">Action</td>
		</tr>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.workerid}</td>
				<td>${order.vehicleid}</td>
				<td>${order.status}</td>
				<td>${order.problemdescription}</td>
				<td>${order.receivedate}</td>
				<td>${order.plannedstartdate}</td>
				<td>${order.startdate}</td>
				<td>${order.repairdescription}</td>
				<td>${order.manhours}</td>
				<td>${order.workerhourcost}</td>
				<td>${order.usercost}</td>
				<td>${order.partscost}</td>
				<td><a href="<c:url value='/editorder?id=${order.id}'/>">Edit</a></td>
				<td><a href="<c:url value='/deleteorder?id=${order.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>