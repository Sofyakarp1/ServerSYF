package mirea.mosit.serversfy.repository;

import mirea.mosit.serversfy.entity.Action;
import mirea.mosit.serversfy.entity.Rele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Integer> {
    @Query(value = "select * from sensor_action", nativeQuery = true)
    List<Action> allActions();
}
