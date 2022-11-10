<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>

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
	<div class="container-fluid">
		<div class="container mt-4">
			<h1>Welcome,
			<c:choose>
				<c:when test="${!user.equals(null)}">${user.username}!</c:when>
				<c:otherwise>Guest!</c:otherwise>
			</c:choose></h1>
			<c:if test="${user.equals(null)}"><a href="/" class="nav-link">Login/Register</a></c:if>
			<c:if test="${!user.equals(null)}"><a href="/logout" class="nav-link">Logout</a></c:if>
		</div>
	</div>

</body>
</html>