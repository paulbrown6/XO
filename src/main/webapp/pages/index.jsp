<%--
  Created by IntelliJ IDEA.
  User: Paul Brown
  Date: 09.01.2017
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<!-- обратите внимание на spring тэги -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Начать играть</title>
</head>
<body>
<h1>Крестики-нолики</h1>
<form method="post" action="${pageContext.request.contextPath}/game">
  <input type="submit" value="Начать игру">
</form>
</body>
</html>
