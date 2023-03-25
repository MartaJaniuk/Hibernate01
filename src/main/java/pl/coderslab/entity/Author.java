package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authors")
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }

//    @OneToMany(mappedBy = "publisher",fetch=FetchType.EAGER ) // że nie jest lazy, automatycznie wczytują sie książki
//    private List<Book> books = new ArrayList<>();

}
