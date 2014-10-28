<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>User</title>
<%@include file="imports.jsp"%>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container">

		<div class="page-header">
			<h1>User</h1>
		</div>

		<form method="POST"
			action="${pageContext.request.contextPath}/updateUser">
			<h4>Update User</h4>
			<input type="hidden" name="userId" value="${user.userId}">
			<div class="form-group">
				<input class="form-control" type="text" name="username"
					placeholder="Username" value="${user.username}">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="firstname"
					placeholder="Firstname" value="${user.firstname}">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="lastname"
					placeholder="Lastname" value="${user.lastname}">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="age" placeholder="Age"
					value="${user.age}">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="email"
					placeholder="Email" value="${user.email}">
			</div>
			<button type="submit" class="btn btn-warning">Update</button>
		</form>

		<form method="POST" action="${pageContext.request.contextPath}/deleteUser">
			<input type="hidden" name="userId" value="${user.userId}">
			<button type="submit" class="btn btn-danger">Delete</button>
		</form>


	</div>

</body>
</html>
