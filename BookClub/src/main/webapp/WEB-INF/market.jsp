<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="book" items="${booksun}">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td>${book.getAuthor()}</td>
				<td>${book.user.username}</td>
				<td>
				<c:choose>
				<c:when test="${userId == book.user.id}">
							<form method="post" action="/deletebook">
				<input type="hidden" name="_method" value="delete"> <input
					type="hidden" name="bookID" value="${book.id}"> <input
					type="submit" value="delete">
			</form>
			
				</c:when>
					<c:otherwise>
					<form action="/borrowbook" method="post">
						<input type="hidden" name="bookId" value="${book.id}"> <input
							type="submit" value="Borrow">
					</form>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h1>Borrowed books</h1>
	<table>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="book" items="${borrowed}">
			<tr>
				<td>${book.id}</td>
				<td>${book.title}</td>
				<td>${book.getAuthor()}</td>
				<td>${book.user.username}</td>
				<td><td><form action="/unborrowbook" method="post">
						<input type="hidden" name="bookId" value="${book.id}">
<input type="submit" value="Return">
</form>

</td></td>
				
</tr>
</c:forEach>
</table>
</body>
</html>