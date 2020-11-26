<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>New Book</title>
</head>
<body>

<div align="center">
    <h1>Add book</h1>
    <form:form action="saveBook" modelAttribute="book">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Title:</td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td>Year:</td>
                <td><form:input path="year"/></td>
            </tr>
            <tr>
                <td>Publisher:</td>
                <td><form:input path="publisher"/></td>
            </tr>

            <tr>
                <td align="center"><input type="submit" value="Save book"></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
