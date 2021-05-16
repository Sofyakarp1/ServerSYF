package mirea.mosit.serversfy.repository;

import mirea.mosit.serversfy.entity.Rele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReleRepository extends JpaRepository<Rele, Integer> {
    //List<Rele> findAllByName(String indicator);

    @Query(value = "select * from sensor_rele", nativeQuery = true)
    List<Rele> allRele();
}
