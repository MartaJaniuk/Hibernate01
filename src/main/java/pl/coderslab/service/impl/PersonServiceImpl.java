package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PersonService;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    public void update(Person person) {
        personDao.update(person);
    }

    @Override
    public Person findById(Long id) {
        return personDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        personDao.deleteById(id);
    }

}
