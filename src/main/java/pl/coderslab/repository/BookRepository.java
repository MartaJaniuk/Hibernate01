package pl.coderslab.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {


    //nadpisujemy, żeby w pobieraniu książek pobierało nam publisherów i autorów
    @Override
    @EntityGraph(attributePaths = {"publisher", "authors"}) //wygenruje automatycznie złączenie
    //@Query("select distinct b from Book b left join fetch b.publisher left join fetch b.authors")
    List<Book> findAll();

    @Override
    @EntityGraph(attributePaths = {"publisher", "authors"}) //wygenruje automatycznie złączenie, do edycji
    Optional<Book> findById(Long id);


}
