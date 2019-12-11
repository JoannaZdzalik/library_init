package service;

import model.Author;
import model.Book;
import repository.AuthorRepository;
import repository.BookRepository;

import java.util.List;

public class BookService {

    BookRepository bookRepository = new BookRepository();
    AuthorRepository authorRepository = new AuthorRepository();

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void create(Book newBook, long authorId) {
        Author author = authorRepository.read(authorId);
        newBook.setAuthor(author);
        bookRepository.create(newBook);
    }

    public void update(Book book, long authorId) {
        Author author = authorRepository.read(authorId);
        book.setAuthor(author);
        bookRepository.update(book);
    }


    public void delete(Long bookId) {
        bookRepository.delete(bookId);
    }

    public Book find(Long bookId) {
        return bookRepository.read(bookId);
    }

//    private String findCurrentBorrower(Book book) {
//        String borrowerName = null;
//        if (book.isBorrow()) {
//            Optional<Borrower> borrower = book.getBorrows().stream()
//                    .max(Comparator.comparing(Borrow::getId))
//                    .map(Borrow::getBorrower);
////            if (borrower.isPresent()) {
////                borrowerName = borrower.get().getDisplayName();
////            }
//
//        }
//        return borrowerName;
//    }
//
////    private Long findCurrentBorrowId(Book book){
////        Long borrowId=null;
////        if(book.isBorrow()){
////            Optional<Long> currentBorrowId = book.getBorrows().stream()
////
////        }
////    }
}
