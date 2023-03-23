package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//
//
@Entity
@Table(name="authors")
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

//    @OneToMany(mappedBy = "publisher",fetch=FetchType.EAGER ) // że nie jest lazy, automatycznie wczytują sie książki
//    private List<Book> books = new ArrayList<>();

}
