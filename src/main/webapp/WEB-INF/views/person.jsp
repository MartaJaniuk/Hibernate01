<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 19.03.2023
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="person">
    <form:input path="login" />
    <form:input path="password" />
    <form:input type="email" path="email" />
    <input type="submit" value="Wyślij">
</form:form>


</body>
</html>
