<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	Register
	<a href="loginpage">Login here</a>
	<div class="container-fluid">
		<div class="col align-self-center">
			<form action="addEmp" method="post">
				<div class="form-group">
					<label for="ename">EmployeeName</label><input type="text"
						class="form-control" name="txtename" id="ename"
						placeholder="Enter emp name">
				</div>
				<div class="form-group">
					<label for="email">Email address</label><input type="email"
						name="txtemail" class="form-control" id="email"
						placeholder="enter email">
				</div>
				<div class="form-group">
					<label for="pass">Password</label><input type="password"
						name="txtpass" class="form-control" id="pass">
				</div>
				<div class="form-group">
					<label for="gender">Gender</label><input type="text"
						name="txtgender" class="form-control" id="gender">
				</div>
					<div class="form-group">
					<button type="submit" class="btn btn-primary" >Add Employee</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>