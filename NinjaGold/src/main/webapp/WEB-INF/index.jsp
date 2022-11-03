<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
    <div class="main-container">
        <header>
            <p>Your Gold:</p>
            <div class="gold-amount">${total_gold}</div>
            <form action="/clear" method="post">
                <input type="submit" value="Reset">
            </form>
        </header>
        <main>
            <section>
                <h1>Farm</h1>
                <p>(earns 10-20 gold)</p>
                <form action="/process_money" method="POST">
                    <input type="submit" value="Find Gold!">
                    <input type="hidden" name="where" value="farm">
                </form>
            </section>
            <section>
                <h1>Cave</h1>
                <p>(earns 10-20 gold)</p>
                <form action="/process_money" method="POST">
                    <input type="submit" value="Find Gold!">
                    <input type="hidden" name="where" value="cave">
                </form>
            </section>
            <section>
                <h1>House</h1>
                <p>(earns 10-20 gold)</p>
                <form action="/process_money" method="POST">
                    <input type="submit" value="Find Gold!">
                    <input type="hidden" name="where" value="house">
                </form>
            </section>
            <section>
                <h1>Quest</h1>
                <p>(earns 0-50 gold)</p>
                <form action="/process_money" method="POST">
                    <input type="submit" value="Find Gold!">
                    <input type="hidden" name="where" value="quest">
                </form>
            </section>
        </main>
        <footer>
            <h2>Activities</h2>
            <div class="log">
                <div class="log-box">
<c:forEach var="line" items="${log}">
<c:out value="${line}" escapeXml="false"></c:out>
</c:forEach>
                </div>
            </div>
        </footer>
    </div>
</body>
</html>