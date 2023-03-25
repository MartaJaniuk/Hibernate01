<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book</title>

    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

<h3>Add author</h3>

<form:form method="post" modelAttribute="author">

    <div>
    FirstName: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/>
    </div>

    <div>
    LastName: <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/>
    </div>

    <input type="submit" value="Add author">
</form:form>

</body>
</html>