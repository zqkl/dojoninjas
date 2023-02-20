<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <h1>New Ninja</h1>
    <div class="form-control">
        <form:form action="/ninjas" method="post" modelAttribute="ninja">
            <form:label path="dojo">Dojo:</form:label>
            <form:select path="dojo">
                <c:forEach var="dojo" items="${dojos}">
                    <form:option value="${dojo.id}">${dojo.name}</form:option>
                </c:forEach>
            </form:select>
            <form:label path="first">First Name:</form:label>
            <form:input path="first"></form:input>
            <form:label path="last">Last Name:</form:label>
            <form:input path="last"></form:input>
            <form:label path="age">Age:</form:label>
            <form:input path="age"></form:input>
            <input type="submit" value="create ninja">
        </form:form>
    </div>
</body>
</html>