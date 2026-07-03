<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>

<title>Employees</title>
<link rel="stylesheet" href="css/style.css">

</head>

<body>
<div class="topbar">

<a href="dashboard.jsp">Dashboard</a>

|

<a href="addEmployee.jsp">Add Employee</a>

|

<a href="logout">Logout</a>

</div>

<form class="search-form" action="searchEmployee" method="get" style="margin-bottom:20px;">

<input
type="text"
name="keyword"
placeholder="Search by Employee Name"
required>

<input
type="submit"
value="Search">

<a class="btn" href="employees">Show All</a>

</form>

<hr>
<h2>Employee List</h2>
<c:if test="${message=='added'}">
    <p style="color:green;"><b>Employee Added Successfully</b></p>
</c:if>

<c:if test="${message=='updated'}">
    <p style="color:green;"><b>Employee Updated Successfully</b></p>
</c:if>

<c:if test="${message=='deleted'}">
    <p style="color:red;"><b>Employee Deleted Successfully</b></p>
</c:if>
<hr>

<table border="1">

<tr>

<th>ID</th>

<th>Name</th>

<th>Department</th>

<th>Salary</th>
<th>Action</th>

</tr>

<c:forEach var="emp" items="${employees}">

<tr>

<td>${emp.empId}</td>

<td>${emp.empName}</td>

<td>${emp.department}</td>

<td>${emp.salary}</td>
<td>
<a href="editEmployee?id=${emp.empId}">Edit</a>
|
<a href="deleteEmployee?id=${emp.empId}" onclick="return confirm('Delete this employee?');">Delete</a>
</td>

</tr>

</c:forEach>

</table>

</body>

</html>