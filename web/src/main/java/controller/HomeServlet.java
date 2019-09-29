package controller;

import dtos.BookDto;
import model.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {

    BookService bookService = new BookService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Action action = Action.valueOf(request.getParameter("action")); //action to zwykly enum
        Long bookId = Long.valueOf(request.getParameter("bookId"));

        switch (action) {
            case ADD:
                response.sendRedirect("/AddBookServlet");
                break;
            case EDIT:
                response.sendRedirect("/EditBookServlet?bookId=" + bookId);
            case SHOW:
                response.sendRedirect("/ViewDetailsServlet?bookID="+ bookId);
            case DELETE:
                bookService.delete(bookId);
                response.sendRedirect("/HomeServlet");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        request.setAttribute("books", books);
        request.getRequestDispatcher("home.jsp").forward(request, response); //zapisujemy na poziome żądania
        //requestdispatcher zachowuje obiekt request, a z sendRedirect byśmy tracili
    }
}
