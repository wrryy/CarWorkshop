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
<h2>Edit Employee</h2>

<form action="<c:url value = '/editworker'/>" method="post"><br>
<input type="hidden" name="id" value="${worker.id}"/><br>
<label> First name <input type="text" name="first_name" value="${worker.firstName}" placeholder="First name"/></label><br>
<label> Last name <input type="text" name="last_name" value="${worker.lastName}" placeholder="Last name"/></label><br>
<label> Address <input type="text" name="address" value="${worker.address}" placeholder="Address"/></label><br>
<label> Phone <input type="text" name="phone" value="${worker.phone}" placeholder="Phone"/></label><br>
<label> Hour cost <input type="number" min = "0" name="hour_cost" step="0.01" value="${worker.hourCost}" placeholder="Hour cost"/></label><br>
<label> Note <input type="text" name="note" value="${worker.note}" placeholder="Note"/></label><br>
<input type="submit"/>
</form>

</body>
</html>