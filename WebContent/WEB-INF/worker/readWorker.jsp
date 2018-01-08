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

<a href="<c:url value = '/addworker'/>" class="btn btn-default">Add Employee</a>
	<table class="table table-hover">
		<tr>
			<td>First name</td>
            <td>Last name</td>
			<td>Address</td>
			<td>Phone</td>
			<td>Hour cost</td>
			<td>Note</td>
			<td colspan="3">Action</td>
		</tr>
		<c:forEach items="${orders}" var="worker">
			<tr>
				<td>${worker.firstName}</td>
                <td>${worker.lastName}</td>
				<td>${worker.address}</td>
				<td>${worker.phone}</td>
				<td>${worker.hourCost}</td>
				<td>${worker.note}</td>
				<td><a href="<c:url value='/editworker?id=${worker.id}'/>" class="btn btn-default">Edit</a></td>
				<td><a href="<c:url value='/deleteworker?id=${worker.id}'/>" class="btn btn-default">Delete</a></td>
				<td><a href="<c:url value='/getorderbyworker?vid=${worker.id}'/>" class="btn btn-default">View Employees orders</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>