package pl.coderslab.service.impl;

import org.springframework.stereotype.Service;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PersonDetailsService;
import pl.coderslab.service.PersonService;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final PersonDetailsService personDetailsService;

    public PersonServiceImpl(PersonDao personDao, PersonDetailsService personDetailsService) {

        this.personDao = personDao;
        this.personDetailsService = personDetailsService;
    }

    @Override
    public void save(Person person) {

        PersonDetails personDetails = new PersonDetails();
        personDetails.setStreet("Leśna");
        personDetails.setCity("Warszawa");
        personDetails.setFirstName("Jan");
        personDetails.setLastName("Kowalski");
        personDetails.setStreetNumber(8L);
      //  personDetails.setPerson(person);

        personDetailsService.save(personDetails);

        person.setPersonDetails(personDetails);
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
