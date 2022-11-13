<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>

	<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
	<!-- <script type="text/javascript" src="/js/script.js"></script> -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<h1>Welcome, ${user.username}</h1>
<p>Books from everyones shelves: </p>
<a href="/logout">logout</a>
<a href="/addbook">add a book to my shelf</a>
<table>
<tr>
<th>ID</th>
<th>Ttile</th>
<th>Author Name</th>
<th>Posted by</th>
</tr>
<c:forEach var="book" items="${allbooks}">
<tr>
<td>${book.id}</td>
<td><a href="/book/${book.id}">${book.title}</a></td>
<td>${book.getAuthor()}</td>
<td>${book.user.username}</td>
</tr>
</c:forEach>
</table>
</body>
</html>