<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenses</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<h1>Save Travels</h1>
	<table class="table table-dark table-hover">
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
		</tr>
		<c:forEach var="exp" items="${travels}">
			<tr>
				<td>${exp.expenseName}</td>
				<td>${exp.vendor}</td>
				<td>${exp.amount}</td>
			</tr>
		</c:forEach>
	</table>
	<h1>Add an expense :</h1>
	<form:form action="/process" method="post" modelAttribute="expense">
		<p>
			<form:label path="expenseName">Expense Name</form:label>
			<form:errors path="expenseName" />
			<form:input path="expenseName" />
		</p>
		<p>
			<form:label path="vendor">Vendor</form:label>
			<form:errors path="vendor" />
			<form:input path="vendor" />
		</p>
		<p>
			<form:label path="amount">amount</form:label>
			<form:errors path="amount" />
			<form:input path="amount" />
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:errors path="description" />
			<form:input path="description" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>