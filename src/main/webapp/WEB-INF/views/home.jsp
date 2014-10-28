<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring Template App</title>
<%@include file="imports.jsp"%>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container">

		<div class="page-header">
			<h1>Spring MVC Hibernate Template</h1>
			<p class="lead">This app also uses mysql and bootstrap.</p>
		</div>

		<table class="table table-striped">
			<tr>
				<th>Action</th>
				<th>User ID</th>
				<th>Username</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Age</th>
				<th>Email</th>
			</tr>

			<c:forEach items="${userList}" var="user" varStatus="ps">
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/user/${user.username}"><button
								type="submit" class="btn btn-default">Open</button></a></td>
					<td><c:out value="${user.userId}" /></td>
					<td><c:out value="${user.username}" /></td>
					<td><c:out value="${user.firstname}" /></td>
					<td><c:out value="${user.lastname}" /></td>
					<td><c:out value="${user.age}" /></td>
					<td><c:out value="${user.email}" /></td>
				</tr>
			</c:forEach>
		</table>

		<form class="form col-md-4" method="POST"
			action="${pageContext.request.contextPath}/createUser">
			<h4>Create User</h4>
			<div class="form-group">
				<input class="form-control" type="text" name="username"
					placeholder="Username">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="firstname"
					placeholder="Firstname">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="lastname"
					placeholder="Lastname">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="age" placeholder="Age">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="email"
					placeholder="Email">
			</div>
			<button type="submit" class="btn btn-success">Submit</button>
		</form>


	</div>

</body>
</html>
