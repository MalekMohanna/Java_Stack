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
<h1>Welcome ${user.username}</h1>
<a href="/projects/new">new project</a>
<h1>Available Projects</h1>
<table>
<tr>
<th>Project</th>
<th>Team lead</th>
<th>Due Date</th>
<th>Actions</th>
</tr>
<c:forEach var="project" items="${availableP}">
<c:choose>
<c:when test="${user.id != project.teamLeader.id}">
<tr>
<td><a href="/projects/${project.id}"> ${project.projectTitle}</a></td>
<td>${project.teamLeader.username}</td>
<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
<td><a href="/jointeam/${user.id}/${project.id}">Join Team</a></td>
</tr>
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>
</c:forEach>
</table>

<table>
<tr>
<th>Project</th>
<th>Team lead</th>
<th>Due Date</th>
<th>Actions</th>
</tr>
<c:forEach var="project" items="${userprojects}">
<tr>
<td><a href="/projects/${project.id}"> ${project.projectTitle}</a></td>
<td>${project.teamLeader.username}</td>
<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
<td><a href="/leaveteam/${user.id}/${project.id}">Leave team</a></td>
</tr>
</c:forEach>
<c:forEach var="project" items="${leader}">
<tr>
<td><a href="/projects/${project.id}"> ${project.projectTitle}</a></td>
<td>${project.teamLeader.username}</td>
<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM dd"/></td>
<td><a href="/projects/edit/${project.id}">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>