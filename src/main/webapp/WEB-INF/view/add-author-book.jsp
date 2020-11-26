<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>

<html>
<head>
    <title>Add authors to book</title>
</head>
<body>


<table border="1" cellpadding="5">
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Publisher</th>
    </tr>

    <tr>
        <td>${book.title}</td>
        <td>${book.year}</td>
        <td>${book.publisher}</td>
    </tr>
</table>

<h3> Authors:</h3>

<ul>
    <c:forEach var="author" items="${book.authors}" varStatus="stat">
        <li>
                ${author.name}
            <td><a href="deleteAuthor/${author.id}">Delete author</a></td>
        </li>
    </c:forEach>
</ul>


<td>
    <form action="addAuthorToBook/${book.id}">
        <input type="text" name="authorName" placeholder="Enter author's name"/>
        <input type="submit" value="Add author"/>
    </form>
</td>

<br><br>
<button type="button"><a href="<c:url value="/book/listBooks" />">Go back to book list </a></button>


</body>
</html>