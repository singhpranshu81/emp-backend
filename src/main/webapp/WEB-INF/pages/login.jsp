<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>Login page
<div class="container-fluid">
		<div class="col align-self-center">
			<form action="signin" method="post">
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
					<button type="submit" class="btn btn-primary" >Login</button>
				</div>
			</form>
			</div>
			</div>
</body>
</html>