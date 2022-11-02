<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style2.css" />
</head>
<body>
	<div class="main-container">
		<h1>Here's Your Omikuji!</h1>
		<div class="txt">
			<h2>In ${data.number} years, you will live in ${data.city} with
				${data.person} as your roommate, ${data.hobby} for a living. The
				next time you see ${data.living}, you will have good luck. Also,
				${data.mytext}</h2>
		</div>
		    <a href="/" class="btn btn-primary stretched-link">Go back</a>
	</div>
</body>
</html>