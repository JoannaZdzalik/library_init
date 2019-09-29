package controller;

import inputValidations.Validations;
import model.Book;
import model.BookType;
import service.AuthorService;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {

    BookService bookService = new BookService();
    AuthorService authorService = new AuthorService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookType category = BookType.valueOf(request.getParameter("category"));
        String isbn = request.getParameter("isbn");
        String pages = request.getParameter("pages");
        LocalDate releaseDate = LocalDate.parse(request.getParameter("releaseDate"));
        String summary = request.getParameter("summary");
        String title = request.getParameter("title");
        long authorId = Long.parseLong(request.getParameter("authorId"));
        long bookId = Long.parseLong(request.getParameter("bookId"));

        Book book = new Book();
        book.setId(bookId);
        book.setReleaseDate(releaseDate);
        book.setPages(pages);
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setSummary(summary);


        if (!Validations.validateISBN(isbn) || !Validations.validatePages(pages)) {
            response.sendRedirect("/inputError.jsp");
            return;
        }
        bookService.update(book);
        response.sendRedirect("/HomeServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.valueOf(request.getParameter("bookId"));
        Book book = bookService.find(bookId);

        request.setAttribute("categories", BookType.values());
        request.setAttribute("authors", authorService.findAll());
        request.setAttribute("book", book);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
}
//w gecie musimy jeszcze pobrać książkę(bookId)

//idziemy z id do bazy dancyh

//getBook po id (uzyskujemy go z homeServlet. ten bookId przekazukemy do editServlet
//request.setattribute (nazwa, book)
//redirect to edti jsp