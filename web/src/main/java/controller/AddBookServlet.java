package controller;

import dtos.BookDto;
import inputValidations.Validations;
import model.Author;
import model.Book;
import model.BookType;
import service.AuthorService;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

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

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setSummary(summary);
        newBook.setCategory(category);
        newBook.setIsbn(isbn);
        newBook.setPages(pages);
        newBook.setReleaseDate(releaseDate);

        if (!Validations.validateISBN(isbn) || !Validations.validatePages(pages)) {
            response.sendRedirect("/inputError.jsp");
            return;
        }
        bookService.create(newBook, authorId);
        response.sendRedirect("/HomeServlet");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", BookType.values());
        request.setAttribute("authors", authorService.findAll());
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }
}


