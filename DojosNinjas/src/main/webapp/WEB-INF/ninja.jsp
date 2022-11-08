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
<title>Insert title here</title>
</head>
<body>
<h1>New Nija</h1>
	<form:form action="/newninja" method="post" modelAttribute="ninja">
		<div>
			<form:label path="dojo">Dojo :</form:label>
			<form:errors path="dojo" />
			<form:select path="dojo">
			<c:forEach var="dojo" items="${dojos}">
			<form:option value="${dojo.id}">${dojo.name}</form:option>
			</c:forEach>
			</form:select>
		</div>
				<div>
			<form:label path="firstName">First name :</form:label>
			<form:errors path="firstName" />
			<form:input path="firstName" />
		</div>
				<div>
			<form:label path="lastName">Last name :</form:label>
			<form:errors path="lastName" />
			<form:input path="lastName" />
		</div>
				<div>
			<form:label path="age">age :</form:label>
			<form:errors path="age" />
			<form:input path="age" />
		</div>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>