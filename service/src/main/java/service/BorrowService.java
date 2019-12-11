package service;

import model.Book;
import model.Borrow;
import model.Borrower;

import java.time.LocalDate;

public class BorrowService {

    private Borrow setUpBorrow(Borrower borrower, Book book) {
        Borrow borrow = new Borrow();
        borrow.setBorrower(borrower);
        borrow.setBook(book);
        borrow.setBorrowDate(LocalDate.now());
        return borrow;
    }
}
