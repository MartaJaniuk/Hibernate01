package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public Book findById(Long id){

        return entityManager.find(Book.class, id);
        // własne query, żeby nie używać Hibernate.initialize

    }

    public List<Book> findAll(){
        Query query = entityManager.createQuery("select distinct b from Book b left join fetch b.publisher left join fetch b.authors"); //select * from books /left join fetch b.authors left join fetch b.publishers
        return query.getResultList();
    }

    //zobaczyć, jak na GIT, zeby działało też dla lazy
    public List<Book> findByRating(int rating) {
        Query query =  entityManager.createQuery("select b from Book b where b.rating=:rat");
        query.setParameter("rat", rating);
        return query.getResultList();
    }

    public void deleteById(Long id) {
        Book book = findById(id);
        entityManager.remove(entityManager.contains(book)? book: entityManager.merge(book));
    }

    public List<Book> findNotEmptyPublisher(){
        Query query = entityManager.createQuery("select b from Book b where b.publisher is not null");
        return query.getResultList();
    }

    public List<Book> findByPublisher(Publisher publisher){
        Query query = entityManager.createQuery("select b from Book b where b.publisher=:publisher");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

}
