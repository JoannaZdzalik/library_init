package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.BookType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {

    private Long id;

    @NotEmpty
    @Length(min = 2, max = 255)
    private String title;

    private LocalDate releaseDate;

    @NotEmpty
    @Length(max = 13)
    private String isbn;

    private String authorName;

    private BookType category;

    private String pages;

    private Boolean borrow;

    private String borrowerName;

    private String summary;

    @NotNull
    private Long authorId;

    private Long borrowId;

}
