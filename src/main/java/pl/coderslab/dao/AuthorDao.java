package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public Author findById(Long id){
        return entityManager.find(Author.class, id);
    }

    public void deleteById(Long id) {
        Author author = findById(id);
        entityManager.remove(entityManager.contains(author)? author : entityManager.merge(author));
    }

}
