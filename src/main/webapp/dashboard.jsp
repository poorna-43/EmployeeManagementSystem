<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Dashboard</title>

<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

<h1>Employee Management System</h1>

<p>Welcome,<b>${sessionScope.username}</b></p>

<hr>

<a class="btn" href="addEmployee.jsp">Add Employee</a>

<a class="btn" href="employees">View Employees</a>

<a class="btn" href="logout">Logout</a>

</div>

</body>

</html>