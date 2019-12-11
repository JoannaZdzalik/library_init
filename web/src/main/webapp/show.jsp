<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/header.jspf"/>
<p></p>

<div class="jumbotron">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">

                <table class="table">
                    <tbody>
                    <tr>
                        <td>
                            <figure class="figure"><img src="images/autor.png" class="figure-img img-fluid rounded" height="30" width="30"></figure>
                        </td>
                        <td>Autor</td>
                    </tr>
                    <tr>
                        <td>
                            <figure class="figure"><img src="images/release.png" class="figure-img img-fluid rounded" height="30" width="30"></figure>
                        </td>
                        <td>Data</td>
                    </tr>
                    <tr>

                        <td>
                            <figure class="figure"><img src="images/kategoria.jpg" class="figure-img img-fluid rounded" height="30" width="30"></figure>
                        </td>
                        <td>Kategoria</td>
                    </tr>
                    <tr>
                        <td>
                            <figure class="figure"><img src="images/isbn.png" class="figure-img img-fluid rounded" height="30" width="30"></figure>

                        </td>
                        <td>isbn</td>
                    </tr>
                    <tr>
                        <td>
                            <figure class="figure"><img src="images/strony.png" class="figure-img img-fluid rounded" height="30" width="30"></figure>
                        </td>
                        <td>strony</td>
                    </tr>
                    </tbody>
                </table>


            </div>
            <div class="col-sm-6">

                <p>tu wstawić ifa czy wypozyczona czy nie</p>
                <h2>${requestScope.book.title}</h2>
                <p>summary</p>

                <button type="submit" class="btn btn-primary">Borrow</button>
                <a class="btn btn-danger btn" href="/HomeServlet" role="button">Go back to book list</a>

            </div>
            <div class="col-sm-3">
                <figure class="figure">
                    <img src="images/books.gif"
                         class="figure-img img-fluid rounded">
                </figure>
            </div>
        </div>
    </div>
</div>


<%@ include file="/WEB-INF/fragments/footer.jspf" %>
</body>
</html>
