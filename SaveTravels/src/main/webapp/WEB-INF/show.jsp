<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
</head>
<body>
<h1>Expense Details :</h1>
<h2>Expense Name : ${expense.expenseName}</h2>
<h2>Expense Description :${expense.description} </h2>
<h2>Vendor : ${expense.vendor}</h2>
<h2>Amount spent: <span>$</span>${expense.amount}</h2>
<a href="/">go back</a>
</body>
</html>