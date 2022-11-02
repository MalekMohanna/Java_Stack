<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form id="myform" action="/process" method="post">
		<div>
			<label class="form-label" for="num">Pick any number from 5 to
				25</label> <input class="form-control" type="number" id="quantity"
				name="num" min="5" max="25">
		</div>
		<div>
			<label class="form-label" for="city">Enter the name of a city</label>
			<input class="form-control" type="text" name="city" />
		</div>
		<div>
			<label class="form-label" for="person">Enter the name of a
				real person</label> <input class="form-control" type="text" name="person" />
		</div>
		<div>
			<label class="form-label" for="hobby">Enter professional
				endeavor or hobby:</label> <input class="form-control" type="text"
				name="hobby" />
		</div>
		<div>
			<label class="form-label" for="living">Enter any type of
				living thing:</label> <input class="form-control" type="text" name="living" />
		</div>
		<div>
			<label class="form-label" for="mytext">Say something nice to
				someone:</label> <input class="form-control" type="text" cols="5" rows="10"
				name="mytext" />
		</div>
		<h2>Send and show a friend:</h2>
		<button type="Submit">Send</button>
	</form>
</body>
</html>