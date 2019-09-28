package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "borrower")
@AllArgsConstructor
@NoArgsConstructor

public class Borrower implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrower")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String lastName;

    @Column(name = "last_name", nullable = false)
    private String firstName;

    @OneToOne
    @JoinColumn(name = "borrower_details_id")
    private BorrowerDetails details;

    @OneToMany(mappedBy = "borrower")
    private List<Borrow> borrows;
}
