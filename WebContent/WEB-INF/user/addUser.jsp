<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Car Workshop</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<h2>Add Client</h2>

	<form action="<c:url value = '/adduser'/>" method="post">
		<br> <input type="text" name="first_name"
			placeholder="First name" /><br> <input type="text"
			name="last_name" placeholder="Last name" /><br> <input
			type="email" name="email" placeholder="Email" /><br> <input
			type="date" name="receivedate" placeholder="Birth date" /><br> <input
			type="submit" />
	</form>

</body>
</html>