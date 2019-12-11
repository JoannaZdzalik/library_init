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
    private String pages;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column
    @Basic(fetch = FetchType.LAZY)
    private String summary;

    @Column(length = 2000)
    private String title;

    @Column
    @Transient
    private String borrowerName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;

    public Boolean isBorrow() {
        return borrow;
    }

}
