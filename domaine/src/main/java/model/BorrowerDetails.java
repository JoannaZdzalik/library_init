package model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "borrowerDetails")
@AllArgsConstructor
@NoArgsConstructor

public class BorrowerDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_borrower_details")
    private Long id;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String phone;

    @OneToOne(mappedBy = "details")
    private Borrower borrower;
}
