<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
  <tbody>
  <tr>
  <th>Name</th>
  <th>Price</th>
  </tr>
      <c:forEach var="frute" items="${fruits}">
      <tr>
      <td><c:out value="${frute.getName()}"></c:out></td>
      <td><c:out value="${frute.getPrice()}"></c:out></td>
      </tr>
    </c:forEach>

  </tbody>
</table>
</body>
</html>