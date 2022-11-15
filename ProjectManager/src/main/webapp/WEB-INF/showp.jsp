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
<title>Update project</title>

<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- <script type="text/javascript" src="/js/script.js"></script> -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Project details</h1>
<h2>Project : ${project.projectTitle }</h2>
<h2>Project : ${project.descreption }</h2>
<h3><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></h3>
<c:choose>
<c:when test="${user.id == project.teamLeader.id }">
<form:form action="/deletepro" method="post">
<input type="hidden" name="_method" value="delete">
<input type="hidden" name="proId" value="${project.id}">
<input type="submit" value="delete">
</form:form>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>
<a href="/projects/${project.id}/tasks">see tasks</a>
<a href="/dashboard">back to dashboard</a>
</body>
</html>