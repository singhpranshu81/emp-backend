<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	Edit
	<div class="container-fluid">
		<div class="col align-self-center">
			<form action="updateEmp" method="post">
				<div class="form-group">
					<label for="eid">EmployeeID</label><input type="text"
						class="form-control" value="${param.eid}" name="eid" id="eid"
						readonly="readonly">
				</div>
				<div class="form-group">
					<label for="ename">EmployeeName</label><input type="text"
						class="form-control" name="ename" value="${param.ename}"
						id="ename">
				</div>
				<div class="form-group">
					<label for="email">Email address</label><input type="email"
						name="email" class="form-control" value="${param.email}"
						id="email">
				</div>
				<div class="form-group">
					<label for="gender">Gender</label><input type="text" name="gender"
						value="${param.gender}" class="form-control" id="gender">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Update
						Employee</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>