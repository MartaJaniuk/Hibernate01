package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.PersonService;

import java.util.Objects;

@RestController
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //create person
    @PostMapping(path="/person")
    void save (@RequestParam String login, @RequestParam String password, @RequestParam String email){
        final Person person = new Person();

        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);

        personService.save(person);
    }


    //edycja
    @PutMapping(path="person/{id}")
    public void update(@PathVariable Long id, @RequestParam String login, @RequestParam String email, @RequestParam String password ){
        Person person = personService.findById(id);

        if(Objects.nonNull(person)){
            person.setLogin(login);
            person.setEmail(email);
            person.setPassword(password);
            personService.update(person);
        }
    }

    //get person by id
    @GetMapping(path="/person/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id){
        final Person person = personService.findById(id);
        return Objects.nonNull(person) ? person.toString() : "Nie znaleziono autora o podanym id " + id;
    }

    //delete person by id
    @DeleteMapping(path="person/{id}")
    void deleteById(@PathVariable Long id){personService.deleteById(id);
    }


}
