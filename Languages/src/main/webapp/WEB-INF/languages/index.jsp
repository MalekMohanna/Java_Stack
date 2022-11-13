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
			<h1 class="display-5">Languages:</h1>
			<table class="table table-striped border border-rounded">
				<thead class="table-warning">
					<tr>
						<th>Name</th>
						<th>Creator</th>
						<th>Version</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!languages.isEmpty()}">
						<c:forEach var="language" items="${languages}">
							<tr class="align-middle">
								<td><a href="/languages/<c:out value="${language.id}" />" class="nav-link"><c:out value="${language.name}" /></a></td>
								<td><c:out value="${language.creator}" /></td>
								<td><c:out value="${language.currentVersion}" /></td>
								<td>
									<a href="/languages/<c:out value="${language.id}" />/edit" class="btn btn-sm btn-success w-25">Edit</a>
									<form action="/languages/${language.id}" method="post" >
    									<input type="hidden" name="_method" value="delete">
    									<input type="submit" value="Delete" class="btn btn-sm btn-danger ms-2">
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="container mx-auto mt-5">
			<div class="col-6 mx-auto">
				<h2>Add a Language:</h2>
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