package mirea.mosit.serversfy.repository;

import mirea.mosit.serversfy.entity.Observed;
import mirea.mosit.serversfy.entity.Rele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ObservedRepository extends JpaRepository<Observed, Integer> {

    @Query(value = "select * from observed", nativeQuery = true)
    List<Observed> allObserveds();

    @Query(value = "select observed.id, observed.name, observed.address, observed.phone, observed.zone_1_s, observed.zone_1_f, observed.zone_2_s, observed.zone_2_f, observed.person_id, observed.url from observed inner join auth on observed.person_id = auth.person_id\n" +
            "where auth.login = :login", nativeQuery = true)
    List<Observed> getDataObserved(@Param("login") String login);

    @Query(value = "select url from observed inner join auth on observed.person_id = auth.person_id\n" +
            "            where auth.login = :login", nativeQuery = true)
    String getUrlByLogin(@Param("login") String login);


}

