<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo</title>
</head>
<body>
<h1>Ninjas in Dojo ${mydojo.name}</h1>
<table>
<tr>
<th>First name</th>
<th>Last name</th>
<th>Age</th>
</tr>

<c:forEach var="ninj" items="${mydojo.ninjas}">
<tr>
<td><c:out value="${ninj.firstName}"></c:out></td>
<td><c:out value="${ninj.lastName}"></c:out></td>
<td><c:out value="${ninj.age}"></c:out></td>
</c:forEach>
</tr>
</table>
</body>
</html>