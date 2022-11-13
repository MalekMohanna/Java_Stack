<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>

	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<script type="text/javascript" src="/js/script.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid">
		<div class="container mx-auto mt-5">
			<div class="col-6 mx-auto">
				<div class="row align-items-center justify-contents-between mb-2">
					<span class="h2">Edit the Language:</span>
					<a href="/languages" class="btn btn-sm btn-secondary col-3">Home</a>
				</div>
				<form:form action="/languages" method="POST" modelAttribute="language" class="rounded bg-secondary p-4">
					<div class="input-group mb-3">
						<span class="input-group-text">Name:</span>
						<form:input type="text" path="name" class="form-control" />
					</div>
					<div><form:errors path="name" /></div>
					<div class="input-group mb-3">
						<span class="input-group-text">Creator:</span>
						<form:input type="text" path="creator" class="form-control" />
					</div>
					<div><form:errors path="creator" /></div>
					<div class="input-group mb-3">
						<span class="input-group-text">Version:</span>
						<form:input type="text" path="currentVersion" class="form-control" />
					</div>
					<div><form:errors path="currentVersion" /></div>
					<div class="text-end me-2">
						<input type="submit" value="Submit" class="btn btn-sm btn-light col-3" />
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>