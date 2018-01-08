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
<h2>Add Order</h2>

<form action="<c:url value = '/addorder'/>" method="post" ><br>
<label> Select Employee <select name="worker_id">
 <c:forEach items="${workers}" var="emp">
        <option value="${emp.id}">${emp.firstName} ${emp.lastName}</option>
</c:forEach></select></label><br> 
<label> Select Vehicle <select name="vehicle_id">
 <c:forEach items="${vehicles}" var="veh">
        <option value="${veh.id}">${veh.plateNumber} ${veh.brand} ${veh.model}</option>
</c:forEach></select></label><br> 
<label> Repair Status <select name ="status">
  <option value="Received">Received</option>
  <option value="Cost_accepted">Cost accepted</option>
  <option value="In_repair">In repair</option>
  <option value="Finished">Finished</option>
  <option value="Resignation">Resignation</option>
</select></label><br>
<label> Problem description  <input type="text" name="problem_description" class="form-control" placeholder="problem description"/></label><br>
<label> Receive date <input type="date" name="receive_date" placeholder="receive date"/></label><br>
<label> Start date <input type="date" name="start_date" placeholder="start date"/></label><br>
<label> Finish date <input type="date" name="planned_start_date"  placeholder="finish date"/></label><br>
<label> Repair description <input type="text" name="repair_description" class="form-control" placeholder="repair description"/></label><br>
<label> Man hours <input step="0.01" type="number" min="0" name="man_hours"  placeholder="man hours"/></label><br>
<label> User cost <input step="0.01" type="number" min="0" name="user_cost"  placeholder="user cost"/></label><br>
<label> Parts cost <input step="0.01" type="number" min="0"name="parts_cost" placeholder="parts cost"/></label><br>
<input type="submit"/>
</form>

</body>
</html>