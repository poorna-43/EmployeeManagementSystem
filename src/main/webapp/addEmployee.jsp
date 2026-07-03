<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Add Employee</title>
<link rel="stylesheet" href="css/style.css">

</head>

<body>
<div class="container">

<h2>Add Employee</h2>

<hr>

<form action="register" method="post">

Name

<input
type="text"
name="empName"
required>

<br><br>

Department

<input
type="text"
name="department"
required>

<br><br>

Salary

<input
type="number"
name="salary"
required>

<br><br>

<input
type="submit"
value="Save Employee">

</form>

<br>

<a class="btn" href="dashboard.jsp">

Back to Dashboard

</a>
</div>

</body>

</html>