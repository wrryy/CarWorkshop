<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value = '/addorder'/>" method="post"><br>
<input type="number" name="workerid"  placeholder="worker id"/><br>
<input type="number" name="vehicleid"  placeholder="vehicle id"/><br>

<select name ="status">
  <option value="Received">Received</option>
  <option value="Cost_accepted">Cost accepted</option>
  <option value="In_repair">In repair</option>
  <option value="Ready_to_go">Ready to go</option>
  <option value="Finished">Finished</option>
  <option value="Resignation">Resignation</option>
</select><br>
<input type="text" name="problemdescription" placeholder="problem description"/><br>
<input type="date" name="receivedate" placeholder="receive date"/><br>
<input type="date" name="plannedstartdate"  placeholder="planned start date"/><br>
<input type="date" name="startdate" placeholder="start date"/><br>
<input type="text" name="repairdescription"  placeholder="repair description"/><br>
<input step="0.01" type="number" name="manhours"  placeholder="man hours"/><br>
<input step="0.01" type="number" name="workerhourcost"  placeholder="worker hour cost"/><br>
<input step="0.01" type="number" name="usercost"  placeholder="user cost"/><br>
<input step="0.01" type="number" name="partscost" placeholder="parts cost"/><br>
<input type="submit"/>
</form>

</body>
</html>