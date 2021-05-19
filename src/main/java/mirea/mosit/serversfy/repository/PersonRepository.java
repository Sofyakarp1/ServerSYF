package mirea.mosit.serversfy.repository;

import mirea.mosit.serversfy.entity.Person;
import mirea.mosit.serversfy.entity.Rele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "select * from person", nativeQuery = true)
    List<Person> allPersons();

    @Query(value = "select person.id, name, person.address, " +
            "person.phone from person inner join auth on person.id = auth.person_id\n" +
            "where auth.login= :login", nativeQuery = true)
    List<Person> getPersonByLogin(@Param("login") String login);

}
