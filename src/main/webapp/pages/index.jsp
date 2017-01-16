<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title>Игра крестики-нолики</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<div>
    <span style="float: left">
        <a href="?lang=en">en</a>
        <a href="?lang=ru">ru</a>
    </span>
</div>
<div>
    <spring:message code="label.gamename" var="gamename"/>
    <h1>${gamename}</h1>
    <form method="post" action="${pageContext.request.contextPath}/game">
        <spring:message code="label.start" var="start"/>
        <input type="submit" value="${start}">
    </form>
</div>
</body>
</html>
