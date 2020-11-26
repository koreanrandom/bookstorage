<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Edit Book</title>
</head>
<body>

<div align="center>">
    <h2>Edit book</h2>

    <form:form action="saveEditedBook" modelAttribute="book">

        <table border="0" cellpadding="10">
            <tr>
                <td>Database ID:</td>
                <td>${book.id}
                    <form:hidden path="id"/></td>
            </tr>
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
                <td><input type="submit" value="Save book"></td>
            </tr>
        </table>
    </form:form>

</div>
</body>
</html>
