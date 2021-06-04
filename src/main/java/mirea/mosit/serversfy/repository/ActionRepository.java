package mirea.mosit.serversfy.repository;

import mirea.mosit.serversfy.entity.Action;
import mirea.mosit.serversfy.entity.Rele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    @Query(value = "select * from sensor_action", nativeQuery = true)
    List<Action> allActions();

//    @Query(value = "insert into sensor_action values (3, 2, '00:23:55', '00:24:55')", nativeQuery = true)
//    List<Action> addDataAction(String id, String );

}
