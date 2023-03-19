<%--
  Created by IntelliJ IDEA.
  User: marta
  Date: 19.03.2023
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    <form:input path="firstName"/>
    <form:input path="lastName" />
    <form:radiobutton path="gender"/>
    <form:select path="country"/>
    <form:input path="notes"/>
    <form:checkbox path="mailingList"/>
    <form:select path="programmingSkills" multiple="true"/>
    <form:checkboxes path="hobbies" items="${hobbies}"/>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
