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
<title>Book</title>

<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- <script type="text/javascript" src="/js/script.js"></script> -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>${book.title}</h1>
	<a href="/home">back to the shelves</a>
	<p>${book.user.username} read ${book.title} by ${book.getAuthor()}</p>
	<h2>Here are ${book.user.username}'s thoughts:</h2>
	<h1>${book.thoughts}</h1>
	<c:choose>
		<c:when test="${userId == book.user.id}">
			<form method="post" action="/deletebook">
				<input type="hidden" name="_method" value="delete"> <input
					type="hidden" name="bookID" value="${book.id}"> <input
					type="submit" value="delete">
			</form>
			<br />
			<form:form action="/book/${book.id}" method="post"
				modelAttribute="book">
				<input type="hidden" name="_method" value="put">
				<div>
					<form:label path="title">Title:</form:label>
					<form:errors path="title" />
					<form:input path="title" />
				</div>
				<div>
					<form:label path="Author">Author:</form:label>
					<form:errors path="Author" />
					<form:input path="Author" />
				</div>
				<div>
					<form:label path="thoughts">Thoughts:</form:label>
					<form:errors path="thoughts" />
					<form:input path="thoughts" />
				</div>
				<input type="submit" value="Edit">

			</form:form>
		</c:when>
		<c:otherwise>
			<h1>You didnt post the book</h1>
			<br />
		</c:otherwise>
	</c:choose>
</body>
</html>