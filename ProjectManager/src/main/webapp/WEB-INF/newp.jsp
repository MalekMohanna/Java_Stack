<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New project</title>

<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- <script type="text/javascript" src="/js/script.js"></script> -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row mt-3">
		<div class="col-5 ms-auto me-2">
		<a href="/dashboard">dashboard</a>
			<h1>Create project</h1>
			<form:form action="/createproject" modelAttribute="project" method="POST"
				class="p-3">
				<div class="form-floating mb-3">
					<form:input type="text" path="projectTitle" class="form-control"
						placeholder="Project Title" />
					<form:label path="projectTitle" class="form-label">Project Title</form:label>
				</div>
				<div>
					<form:errors path="projectTitle" />
				</div>
				<div class="form-floating mb-3">
					<form:input type="text" path="descreption" class="form-control"
						placeholder="Descreption" />
					<form:label path="descreption" class="form-label">Descreption</form:label>
				</div>
				<div>
					<form:errors path="descreption" />
				</div>
				<div class="form-floating mb-3">
					<form:input type="date" path="dueDate" class="form-control"
						placeholder="Due Date" />
					<form:label path="dueDate" class="form-label">Due Date</form:label>
				</div>
				<div>
					<form:errors path="dueDate" />
				</div>
				<input type="submit" value="Create" class="btn btn-sm btn-success" />
			</form:form>
		</div>
</body>
</html>