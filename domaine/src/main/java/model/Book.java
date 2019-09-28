package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long id;


    @Column
    private boolean borrow;

    @Column
    @Enumerated(EnumType.STRING)
    private BookType category;

    @Column
    private String isbn;

    @Column
    private Long pages;

    @Column
    private LocalDate releaseDate;

    @Column
    @Basic(fetch = FetchType.LAZY)
    private String summary;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;


}
