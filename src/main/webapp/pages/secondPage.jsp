<%@ page import="com.game.GameButtons" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Игра крестики-нолики</title>
</head>
<body>
<% GameButtons game = GameButtons.getInstance(); %>
<c:if test="${empty end}">
<table>
    <form id="go" action="${pageContext.request.contextPath}/game" method="get"></form>
    <tr>
        <% out.print(game.getButton(0,0));%>
        <% out.print(game.getButton(0,1));%>
        <% out.print(game.getButton(0,2));%>
    </tr>
    <tr>
        <% out.print(game.getButton(1,0));%>
        <% out.print(game.getButton(1,1));%>
        <% out.print(game.getButton(1,2));%>
    </tr>
    <tr>
        <% out.print(game.getButton(2,0));%>
        <% out.print(game.getButton(2,1));%>
        <% out.print(game.getButton(2,2));%>
    </tr>
</table>
</c:if>
<c:if test="${not empty end}">
    <h1>${end}</h1>
    <form method="post" action="${pageContext.request.contextPath}/game">
        <input type="submit" value="Играть снова">
    </form>
</c:if>
</body>
</html>
