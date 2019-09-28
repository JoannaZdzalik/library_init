package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String lastName;

    @Column(name = "last_name", nullable = false)
    private String firstName;

    @Column(name = "birth_place", nullable = false)
    private String birthPlace;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
