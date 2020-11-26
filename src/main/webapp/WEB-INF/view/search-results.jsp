<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Search results</title>
</head>
<body>

<h1>Search results:</h1>


<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Year</th>
        <th>Publisher</th>
        <th>Authors</th>
        <th>Add/remove author</th>
        <th>Edit book</th>
        <th>Remove book</th>
    </tr>

    <c:forEach var="book" items="${books}" varStatus="index">
        <tr>
            <td>${index.count}</td>
            <td>${book.title}</td>
            <td>${book.year}</td>
            <td>${book.publisher}</td>

            <td><c:forEach var="author" items="${book.authors}" varStatus="stat">
                <c:if test="${!stat.last}"> ${author.name}, </c:if>
                <c:if test="${stat.last}"> ${author.name} </c:if>
            </c:forEach>
            </td>

            <td><a href="addAuthors/${book.id}">Add authors this book</a></td>
            <td><a href="editBook/${book.id}">Edit this book</a></td>
            <td><a href="deleteBook/${book.id}">Remove this book</a></td>
        </tr>
    </c:forEach>
</table>

<button type="button"><a href="<c:url value="/book/listBooks" />">Go back to book list </a></button>

</body>
</html>
