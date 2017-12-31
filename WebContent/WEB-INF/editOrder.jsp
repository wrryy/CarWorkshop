<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>

<form action="<c:url value = '/editorder'/>" method="post"><br>
<input type="hidden" name="id" value="${order.id}"/><br>
<label><input type="number" name="workerid" value="${order.workerid}" placeholder="worker id"/><br>
<input type="number" name="vehicleid" value="${order.vehicleid}" placeholder="vehicle id"/><br>
<input type="text" name="status" value="${order.status}" placeholder="status"/><br>
<select name ="status" value="${order.status}" >
  <option value="Received">Received</option>
  <option value="Cost_accepted">Cost accepted</option>
  <option value="In_repair">In repair</option>
  <option value="Ready_to_go">Ready to go</option>
  <option value="Finished">Finished</option>
  <option value="Resignation">Resignation</option>
</select><br>
<input type="text" name="problemdescription" value="${order.problemdescription}" placeholder="problem description"/><br>
<input type="date" name="receivedate" value="${order.receivedate}" placeholder="receive date"/><br>
<input type="date" name="plannedstartdate" value="${order.plannedstartdate}" placeholder="planned start date"/><br>
<input type="date" name="startdate" value="${order.startdate}" placeholder="start date"/><br>
<input type="date" name="repairdescription" value="${order.repairdescription}" placeholder="repair description"/><br>
<input step="0.01" type="number" name="manhours" value="${order.manhours}" placeholder="man hours"/><br>
<input step="0.01" type="number" name="workerhourcost" value="${order.workerhourcost}" placeholder="worker hour cost"/><br>
<input step="0.01" type="number" name="usercost" value="${order.usercost}" placeholder="user cost"/><br>
<input step="0.01" type="number" name="partscost" value="${order.partscost}" placeholder="parts cost"/><br>
<input type="submit"/>
</form>
</body>
</html>