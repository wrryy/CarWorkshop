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
<h2>Employees worked time</h2>

	<table class="table table-hover">
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Worked Hours</td>
		</tr>
		<c:forEach items="${raport}" var="rap">
			<tr>
				<td>${rap.firstName}</td>
				<td>${rap.lastName}</td>
				<td>${rap.manHours}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>