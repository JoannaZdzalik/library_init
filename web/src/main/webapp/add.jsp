<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jspf"/>

<form action="/AddBookServlet" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Title</label>
            <input type="text" class="form-control" name="title" id="title" placeholder="Title">
        </div>
        <div class="form-group col-md-6">
            <label>Category</label>
            <select id="category" class="form-control" name="category">
                <c:forEach var="category" items="${requestScope.categories}">
                    <option>${category}</option>
                </c:forEach>
            </select>
        </div>


        <div class="form-group col-md-6">
            <label>Author</label>
            <select class="form-control" name="authorId">
                <c:forEach var="author" items="${requestScope.authors}">
                    <option value="${author.id}">${author.firstName} ${author.lastName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-6">
            <label>Pages</label>
            <input type="text" class="form-control"  name="pages" id="pages">
        </div>



    </div>
    <div class="form-row">
    <div class="form-group col-md-6">
        <label >ISBN</label>
        <input type="text" class="form-control" name="isbn" id="isbn" placeholder="ISBN">
    </div>
    <div class="form-group col-md-6">
        <label>Release</label>
        <input type="date" class="form-control"  name="releaseDate" id="releaseDate">
    </div>
    </div>

    <div class="form-group">
        <label>Summary</label>
        <input type="text" class="form-control"  name="summary "id="summary">
    </div>
<p></p>
    <button type="submit" class="btn btn-outline-success">Add</button>
    <a class="btn btn-outline-secondary" href="/HomeServlet" role="button">Cancel</a>

</form>

<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
