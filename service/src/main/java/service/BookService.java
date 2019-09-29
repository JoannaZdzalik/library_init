package service;

import dtos.BookDto;
import model.Author;
import model.Book;
import repository.AuthorRepository;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    BookRepository bookRepository = new BookRepository();
    AuthorRepository authorRepository = new AuthorRepository();

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public void create(Book newBook, long authorId) {
        Author author = authorRepository.read(authorId);
        newBook.setAuthor(author);
        bookRepository.create(newBook);
    }

    public void update(Book book){
        bookRepository.update(book);
    }


    public void delete(Long bookId) {
        bookRepository.delete(bookId);
    }

    public Book find(Long bookId) {
        return bookRepository.read(bookId);
    }
}
