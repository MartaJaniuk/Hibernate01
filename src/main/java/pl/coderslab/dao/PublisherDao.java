package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findById(Long id){
        return entityManager.find(Publisher.class, id);
    }

    public void deleteById(Long id) {
        Publisher publisher = findById(id);
        entityManager.remove(entityManager.contains(publisher)? publisher : entityManager.merge(publisher));
    }
}
