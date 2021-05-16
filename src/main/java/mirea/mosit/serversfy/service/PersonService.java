package mirea.mosit.serversfy.service;

import mirea.mosit.serversfy.entity.Person;
import mirea.mosit.serversfy.repository.PersonRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void createPerson(Person person){
        personRepository.save(person);
    }

    public List<Person> allPersons(){
        return personRepository.allPersons();
    }

    public List<Person> getPersonByLogin(String login) {
        return personRepository.getPersonByLogin(login);
    }
}
