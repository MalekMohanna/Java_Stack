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

	<title>hello world</title>

</head>

<body>
<table>
<tr><td>Products</td><td>Categories</td></tr>
<tr><td>
<ul>
       
        <c:forEach var="product" items="${products}">
        <li><a href="/product/${product.id}"><c:out value="${product.name}"></c:out></a></li>
    	</c:forEach>
   
</ul>
</td>
<td>
<ul>
       
        <c:forEach var="cat" items="${categories}">
        <li><a href="/categories/${cat.id}"><c:out value="${cat.name}"></c:out> </a></li>
    	</c:forEach>
   
</ul>
</td>
</tr>
</table>
</body>
</html>