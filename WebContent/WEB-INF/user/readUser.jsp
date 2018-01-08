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
<h2>List of all Clients</h2>
<p> ${empty bug ? "" : bug}</p>

<a href="<c:url value = '/adduser'/>" class="btn btn-default">Add Client</a>
	<table class="table table-hover">
		<tr>
			<td>First name</td>
			<td>Last name</td>
			<td>Email</td>
			<td>Birth date</td>
			<td colspan="3">Action</td>
		</tr>
		<c:forEach items="${orders}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.birthDate}</td>
				<td><a href="<c:url value='/edituser?id=${user.id}'/>" class="btn btn-default">Edit</a></td>
				<td><a href="<c:url value='/deleteuser?id=${user.id}'/>" class="btn btn-default">Delete</a></td>
				<td><a href="<c:url value='/getvehiclebyuser?wid=${user.id}'/>" class="btn btn-default">View vehicles</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>