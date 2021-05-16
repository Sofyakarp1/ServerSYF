package mirea.mosit.serversfy;

import mirea.mosit.serversfy.entity.Person;
import mirea.mosit.serversfy.entity.Rele;
import mirea.mosit.serversfy.service.ObservedService;
import mirea.mosit.serversfy.service.PersonService;
import mirea.mosit.serversfy.service.ReleService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.sql.Time;


@SpringBootApplication
public class ServerSfyApplication {

    @Autowired
    private ReleService releService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ObservedService observedService;

    public static void main(String[] args) {
        SpringApplication.run(ServerSfyApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods() throws ParseException {
        Rele rele = new Rele();
        Person person = new Person();
        person.setId(7);
        person.setName("Poli");
        person.setAddress("Mosscow");
        person.setPhone("999");
        //personService.createPerson(person);

        //personService.allPersons().forEach(it -> System.out.println(it));

        //System.out.println(personService.getPersonByLogin("sofya").get(0).toString());
        //
        long now = System.currentTimeMillis();
        Time sqlTime = new Time(now);
        System.out.println("currentTimeMillis: " + now);
        System.out.println("SqlTime          : " + sqlTime);
        System.out.println("SqlTime.getTime(): " + sqlTime.getTime());

        //System.out.println(observedService.getPassword("sofya"));
        //releService.createRele(rele);
        //releService.allRele().forEach(it -> System.out.println(it));
    }

}
