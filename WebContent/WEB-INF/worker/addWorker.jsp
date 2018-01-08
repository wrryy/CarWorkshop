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
<h2>Add Employee</h2>

<form action="<c:url value = '/addworker'/>" method="post"><br>
<label> First name <input type="text" name="first_name" placeholder="First name"/></label><br>
<label> Last name <input type="text" name="last_name" placeholder="Last name"/></label><br>
<label> Address <input type="text" name="address" placeholder="Address"/></label><br>
<label> Phone <input type="text" name="phone" placeholder="Phone"/></label><br>
<label> Hour cost <input type="number" min = "0" step="0.01" name="hour_cost" placeholder="Hour cost"/></label><br>
<label> Note <input type="text" name="note" placeholder="Note"/></label><br>
<input type="submit"/>
</form>

</body>
</html>