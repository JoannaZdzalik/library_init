package repository;

import model.Author;
import model.Book;
import model.BookType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest {


    public static void main(String[] args) {
        BookRepository repository = new BookRepository();


        Author author1 = new Author();
        author1.setFirstName("aaaaaaaaaaaaa");


        Book book = new Book();
        book.setAuthor(null);
        book.setIsbn("5151515");
        book.setCategory(BookType.DOCUMENTARY);
        book.setTitle("aaaa");
        book.setSummary("lorem ipsum");
        book.setReleaseDate(LocalDate.now());

        repository.create(book);



    }

}