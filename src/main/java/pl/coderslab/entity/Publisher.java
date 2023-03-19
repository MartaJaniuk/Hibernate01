package pl.coderslab.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="publishers")
@Getter
@Setter
@ToString(exclude="books") // żeby ToString się nie zapętlił w relacji dwukierunkowej
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "publisher",fetch=FetchType.EAGER ) // że nie jest lazy, automatycznie wczytują sie książki
    private List<Book> books = new ArrayList<>();
}
