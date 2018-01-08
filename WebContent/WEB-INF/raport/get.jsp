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
<h2>Choose date range to generate raport</h2>

<form action="<c:url value = '/home'/>" method="post" ><br>
<label> From date <input type="date" name="from" /></label><br>
<label> To date <input type="date" name="to"  /></label><br>
<label> Raport: Employees Worked Hours <input type="radio" name="rap" value ="Raport 1"></label><br>
<label> Raport: Income <input type="radio" name="rap" value ="Raport 2"/></label><br>
<input type="submit" value="Generate">
</form>

</body>
</html>