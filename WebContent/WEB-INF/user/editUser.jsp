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
<h2>Edit Client</h2>

<form action="<c:url value = '/edituser'/>" method="post"><br>
<input type="hidden" name="id" value="${order.id}"/><br>
<input type="text" name="first_name" value="${user.firstName}" placeholder="First name"/><br>
<input type="text" name="last_name" value="${user.lastName}" placeholder="Last name"/><br>
<input type="email" name="email" value="${user.email}" placeholder="Email"/><br>
<input type="date" name="birth_date" value="${user.birthDate}" placeholder="Birth date"/><br>
<input type="submit"/>
</form>

</body>
</html>