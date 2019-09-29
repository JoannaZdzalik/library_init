package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {

    private Long id;

    private String title;

    private LocalDate releaseDate;


}
