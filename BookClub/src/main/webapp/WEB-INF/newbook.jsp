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
<title>Login&Regestration</title>

<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- <script type="text/javascript" src="/js/script.js"></script> -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<form:form action="/createbook" method="post" modelAttribute="book">
		<div>
			<form:label path="title">Title:</form:label>
			<form:errors path="title" />
			<form:input path="title"/>
		</div>
				<div>
			<form:label path="Author">Author:</form:label>
			<form:errors path="Author" />
			<form:input path="Author"/>
		</div>
				<div>
			<form:label path="thoughts">Thoughts:</form:label>
			<form:errors path="thoughts" />
			<form:input path="thoughts"/>
		</div>
		<input type="submit" value="Add">
	</form:form>
</body>
</html>