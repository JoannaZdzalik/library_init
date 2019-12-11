package controller;

import exception.ItemNotFoundException;
import model.Book;
import model.BookType;
import service.AuthorService;
import service.BookService;
import service.BorrowerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/ViewDetailsServlet")


public class ViewDetailsServlet extends HttpServlet {

    BookService bookService = new BookService();
    BorrowerService borrowerService = new BorrowerService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.valueOf(request.getParameter("bookId"));
//        try {
            request.setAttribute("book", bookService.find(bookId));
          //  request.setAttribute("borrowers", borrowerService.findAll());
//        } catch (ItemNotFoundException e) {
//            e.printStackTrace();
//        }
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}
