<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Name: ${product.name }</p>
<p>Description: ${product.description }</p>

  <h1> h1: <c:forEach var="cat" items="${product.categories}">
        <p><c:out value="${cat.name}"></c:out></p>
    	</c:forEach></h1>    
    	
    	
 <form:form action="/product/addcat" method="post" modelAttribute="cp"> 
 <input type="hidden" name="productId" value="${product.id}">
  <form:select path="category">
        <c:forEach var="cat" items="${categories}">
        <form:option value="${cat.id}"><c:out value="${cat.name}"></c:out></form:option>
    	</c:forEach>
        </form:select>
        <input type="submit" value="Send">
</form:form>
</body>
</html>