<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Update Employee</title>

<link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="container">

<div class="topbar">

<a href="dashboard.jsp">Dashboard</a>

|

<a href="employees">View Employees</a>

|

<a href="logout">Logout</a>

</div>

<hr>

<h2>Update Employee</h2>

<form action="updateEmployee" method="post">

<input
type="hidden"
name="id"
value="${employee.empId}">

<label>Name</label>

<input
type="text"
name="empName"
value="${employee.empName}"
required>

<label>Department</label>

<input
type="text"
name="department"
value="${employee.department}"
required>

<label>Salary</label>

<input
type="number"
step="0.01"
name="salary"
value="${employee.salary}"
required>

<input
type="submit"
value="Update Employee">

</form>

</div>

</body>
</html>