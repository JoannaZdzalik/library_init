<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Home</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jspf"/>
<p></p>
<div class="form-group">
    <form action="/HomeServlet" method="post">
        <table class="table table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">ISBN</th>
                <th scope="col">Author</th>
                <th scope="col">Type</th>
                <th scope="col">Release</th>
                <th scope="col">Pages</th>
                <th scope="col">Borrower</th>
                <th scope="col"></th>
            </tr>
            </thead>
            <tbody>
            <div class="form-group">
            <c:forEach var="book" items="${requestScope.books}" varStatus="loop">
                <tr>
                    <th scope="row">${loop.index+1}</th>
                    <td>${book.title}</td>
                    <td>${book.isbn}</td>
                    <td></td>
<%--                    <td>${book.author.firstName}</td>--%>
                    <td>${book.releaseDate}</td>
                    <td>${book.pages}</td>
<%--                    <td>${not empty book.borrowerName ? book.borrowerName : '-'}</td>--%>
                    <td><input class="form-check-input" type="radio" name="bookId" value="${book.id}" checked></td>
                </tr>
            </c:forEach>
            </div>
            </tbody>
        </table>

        <input type="submit" class="btn btn-outline-success" name="action" value="ADD">
        <input type="submit" class="btn btn-outline-warning" name="action" value="EDIT">
        <input type="submit" class="btn btn-outline-primary" name="action" value="SHOW">
        <input type="submit" class="btn btn-outline-danger" name="action" value="DELETE">
    </form>
    <p></p>

    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
</div>
</body>

</html>
