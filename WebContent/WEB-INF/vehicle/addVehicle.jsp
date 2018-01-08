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
<h2>Add Vehicle</h2>

<form action="<c:url value = '/addvehicle'/>" method="post"><br>
<label> Select Client <select name="user_id"> 
        <c:forEach items="${users}" var="user">
        <option value="${user.id}">${user.firstName} ${user.lastName}</option>
</c:forEach></select></label><br> 
<label> Brand <input type="text" name="brand" placeholder="Brand"/></label><br>
<label> Model <input type="text" name="model" placeholder="Model"/></label><br>
<label> Plate number <input type="text" name="plate_number" placeholder="Plate number"/></label><br>
<label> Production date <input type="date" name="production_date" placeholder="Production date"/></label><br>
<label> Service date <input type="date" name="production_date" placeholder="Service date"/></label><br>
<input type="submit"/>
</form>

</body>
</html>