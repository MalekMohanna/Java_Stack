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
		<div class="container mx-auto mt-4">
			<h3><c:out value="${language.name}" /></h3>
			<h4><c:out value="${language.creator}" /></h4>
			<h4><c:out value="${language.currentVersion}" /></h4>
		</div>
		<div class="container mx-auto mt-3">
			<a href="/languages/<c:out value="${language.id}" />/edit" class="btn btn-sm btn-success">Edit</a>
			<a href="/languages" class="btn btn-sm btn-secondary ms-2">Home</a>
			<form action="/languages/${language.id}" method="post" style="display: inline-block;">
    			<input type="hidden" name="_method" value="delete">
    			<input type="submit" value="Delete" class="btn btn-sm btn-danger">
			</form>
		</div>
	</div>

</body>
</html>