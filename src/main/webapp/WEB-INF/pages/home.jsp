<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>
Home
<a href="registerpage" >add employee</a>
${NOTIFICATION}
<table class="table table-hover"
		style="text-align: center; margin-left: auto; margin-right: auto;"
		border="1" width="50%">
		<tr>
			<th>Emp ID</th>
			<th>Ename</th>
			<th>Email</th>
			<th>Gender</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach var="row" items="${allemp}">
			<tr>
				<td><c:out value="${row.eid}" /></td>
				<td><c:out value="${row.ename}" /></td>
				<td><c:out value="${row.email}" /></td>
				<td><c:out value="${row.gender}" /></td>
				<td><a
					href="edit?eid=${row.eid}">Edit</a></td>
				<td><a
					href="delete?eid=${row.eid}">Delete</a></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>