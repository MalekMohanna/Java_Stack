<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
</head>
<body>
	<h1>All Books</h1>
	<table class="table table-dark table-hover" id="mytable">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>Number of Pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
			<tr>
			<td>${book.id}</td>
			<td><a href="/books/${book.id}">${book.title}</a></td>
			<td>${book.language}</td>
			<td>${book.numberOfPages}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>