<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
<div class="container">

<h2>Employee Management System</h2>

<h3>Login</h3>
<p style="color:red;">${error}</p>
<form action="login" method="post">

Username :
<input type="text" name="username" required>

<br><br>

Password :
<input type="password" name="password" required>

<br><br>

<input type="submit" value="Login">

</form>
</div>
</body>
</html>